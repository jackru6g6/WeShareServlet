package app.deal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import app.goods.GoodsBean;
import app.goods.GoodsDAO;
import app.main.ImageUtil;
import web._00_init.GlobalService;

@SuppressWarnings("serial")
@WebServlet("/DealServlet")
public class DealServlet extends HttpServlet {
	private final static String CONTENT_TYPE = "text/html; charset=UTF-8";

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		BufferedReader br = request.getReader();
		StringBuffer jsonIn = new StringBuffer();
		String line = null;
		while ((line = br.readLine()) != null) {// 讀client端送的json
			jsonIn.append(line);
		}
		JsonObject jsonObject = gson.fromJson(jsonIn.toString(), JsonObject.class);
		// UserDao userDAO = new UserDAO();
		DealDAO deDAO = new DealDAO();
		String action = jsonObject.get("action").getAsString();
		System.out.println("action: " + action);

		if (action.equals("getNotDeal")) {
			String account = jsonObject.get("user").getAsString();
			List<DealBean> deals = deDAO.getNotDeal(account, 0);
			// List<DealBean> dealss = new ArrayList<>();
			// int i=0;
			// System.out.println("帳號account: " + account);
			for (DealBean pop : deals) {
				// System.out.println("dNO" + pop.getDealNo() + ", dName" +
				// pop.getGoodsName());
				pop.setGoodsImage(null);
				// dealss.add(i, pop);
				// i++;
			}
			writeText(response, gson.toJson(deals));
		} else if (action.equals("getDealing")) {
			String account = jsonObject.get("user").getAsString();
			List<DealBean> deals = deDAO.getStatus(account, 1);
			for (DealBean pop : deals) {
				pop.setGoodsImage(null);
			}
			writeText(response, gson.toJson(deals));
		} else if (action.equals("getAllFb")) {
			String account = jsonObject.get("account").getAsString();
			List<FeedbackBean> fbs = deDAO.getAllFb(account);
			for (FeedbackBean pop : fbs) {
				System.out.println("來源" + pop.getFbSourceId() + ", 內容" + pop.getFbText());
				pop.setFbImage(null);
			}
			writeText(response, gson.toJson(fbs));
		} else if (action.equals("getDealed")) {
			String account = jsonObject.get("user").getAsString();
			List<DealBean> deals = deDAO.getStatus(account, 2);
			for (DealBean pop : deals) {
				pop.setGoodsImage(null);
			}
			writeText(response, gson.toJson(deals));
		}
		if (action.equals("getOne")) {
			// String account = jsonObject.get("account").getAsString();
			// String talkTo = jsonObject.get("talkTo").getAsString();
			// List<DealBean> msg = mgDAO.getOne(account, talkTo);
			// System.out.println("帳號account: " + account);
			// for (DealBean pop : msg) {
			// System.out.println("MsgSource：" + pop.getMsgSourceId() + ",
			// MsgEndId：" + pop.getMsgEndId()
			// + ", MsgText：" + pop.getMsgText() + ", roomNo：" +
			// pop.getRoomNo());
			// }
			// writeText(response, gson.toJson(msg));
		} else if (action.equals("getImage")) {
			String dealNo = jsonObject.get("dealNo").getAsString();
			int dealNon = Integer.valueOf(dealNo);
			OutputStream os = response.getOutputStream();
			// account = jsonObject.get("account").getAsString();
			int imageSize = jsonObject.get("imageSize").getAsInt();
			System.out.println("dealNo=" + dealNon + ", imageSize=" + imageSize);
			byte[] image = deDAO.getImage(dealNon);
			if (image != null) {
				image = ImageUtil.shrink(image, imageSize);// ImageUtil縮圖
				response.setContentType("image/jpeg");
				response.setContentType("image/png");
				// 只要送一張圖，就不用轉json，指定他傳送的型態，如果要用json就要用Base64
				// // encode才能傳送
				response.setContentLength(image.length);// 輸出圖的長度
				System.out.println(image);
			} else {
				System.out.println("沒收到喔~");
			}
			os.write(image);// 送到client端
		} else if (action.equals("getFbImage")) {
			String fbNo = jsonObject.get("fbNo").getAsString();
			int fbNon = Integer.valueOf(fbNo);
			OutputStream os = response.getOutputStream();
			// account = jsonObject.get("account").getAsString();
			int imageSize = jsonObject.get("imageSize").getAsInt();
			System.out.println("dealNo=" + fbNon + ", imageSize=" + imageSize);
			byte[] image = deDAO.getFbImage(fbNon);
			if (image != null) {
				image = ImageUtil.shrink(image, imageSize);// ImageUtil縮圖
				response.setContentType("image/jpeg");
				response.setContentType("image/png");
				// 只要送一張圖，就不用轉json，指定他傳送的型態，如果要用json就要用Base64
				// // encode才能傳送
				response.setContentLength(image.length);// 輸出圖的長度
				System.out.println(image);
			} else {
				System.out.println("沒收到喔~");
			}
			os.write(image);// 送到client端
		} else if (action.equals("newDeal")) {
			String dealJson = jsonObject.get("deal").getAsString();
			DealBean deal = gson.fromJson(dealJson, DealBean.class);

			String goodsNo = jsonObject.get("goodsNo").getAsString();
			int goodsNoo = Integer.valueOf(goodsNo);
			String imageBase64 = jsonObject.get("imageBase64").getAsString();
			byte[] image = null;
			image = Base64.getMimeDecoder().decode(imageBase64);

			GoodsDAO gdDAO = new GoodsDAO();

			int count = 0;
			int countt = 0;
			try {
				Blob blob = new SerialBlob(image);
				blob = new SerialBlob(image);
				System.out.println("有給圖片");
				deal.setGoodsImage(blob);

				// user.setImage(blob);
				// String name = msg.getMsgSourceId();
				System.out.println("Goods狀態=" + deal.getGoodsStatus());

				int i = deDAO.getMaxNo();
				deal.setDealNo(i + 1);
				System.out.println("i + 1＝" + (i + 1));
				count = deDAO.save(deal);

				GoodsBean changeGood = gdDAO.getGoodsBean(goodsNoo);
				if (changeGood.getQty() - deal.getDealQty() == 0) {
					countt = gdDAO.delete(goodsNoo);
				} else {
					changeGood.setQty(changeGood.getQty() - deal.getDealQty());
					countt = gdDAO.update(changeGood);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			writeText(response, String.valueOf(count));
		} else if (action.equals("acceptDeal")) {
			int count = 0;
			try {
				String dealNo = jsonObject.get("dealNo").getAsString();
				int dealNon = Integer.valueOf(dealNo);
				DealBean deal = deDAO.getDealBean(dealNon);
				System.out.println("dealNo=" + deal.getDealNo() + ", dealName=" + deal.getGoodsName());
				if (deal.getEndShipWay() == 0) {
					// deal.setDealStatus(2);
					deal.setDealStatus(1);
				} else if (deal.getEndShipWay() == 1) {
					deal.setDealStatus(1);
				}
				count = deDAO.update(deal);
			} catch (Exception e) {
				e.printStackTrace();
			}
			writeText(response, String.valueOf(count));
		} else if (action.equals("refuseDeal")) {
			int count = 0;
			try {
				String dealNo = jsonObject.get("dealNo").getAsString();
				int dealNon = Integer.valueOf(dealNo);
				DealBean deal = deDAO.getDealBean(dealNon);
				deal.setDealStatus(3);
				System.out.println("dealNo=" + deal.getDealNo() + ", dealName=" + deal.getGoodsName() + ", dealStatus="
						+ deal.getDealStatus());
				count = deDAO.update(deal);
			} catch (Exception e) {
				e.printStackTrace();
			}
			writeText(response, String.valueOf(count));
		} else if (action.equals("sendDealContext")) {
			int count = 0;
			try {
				String dealNo = jsonObject.get("dealNo").getAsString();
				int dealNon = Integer.valueOf(dealNo);
				String shipNo = jsonObject.get("shipNo").getAsString();
				DealBean deal = deDAO.getDealBean(dealNon);
				System.out.println("dealNo=" + deal.getDealNo() + ", dealName=" + deal.getGoodsName());
				deal.setShipNo(shipNo);
				Timestamp ts = new Timestamp(new java.util.Date().getTime());
				deal.setShipDate(ts);
				deal.setDealStatus(2);
				// deal.set
				count = deDAO.update(deal);
			} catch (Exception e) {
				e.printStackTrace();
			}
			writeText(response, String.valueOf(count));
		} else if (action.equals("snedFeedback")) {
			int count = 0;
			try {
				String feedbackJson = jsonObject.get("fb").getAsString();
				FeedbackBean feedback = gson.fromJson(feedbackJson, FeedbackBean.class);

				String imageBase64 = jsonObject.get("imageBase64").getAsString();
				System.out.println("imageBase64=" + imageBase64);
				if (feedback.getFbFileName() == null) {
					feedback.setFbImage(null);
				} else {
					byte[] image = null;
					image = Base64.getMimeDecoder().decode(imageBase64);
					Blob blob = null;
					blob = new SerialBlob(image);
					feedback.setFbImage(blob);
				}
				Timestamp ts = new Timestamp(new java.util.Date().getTime());
				feedback.setPostDate(ts);
				count = deDAO.saveFeedback(feedback);
			} catch (Exception e) {
				e.printStackTrace();
			}
			writeText(response, String.valueOf(count));
		} else if (action.equals("checkFbExist")) {
			int count = 0;
			boolean checkFb = false;
			List<FeedbackBean> listFb = null;
			try {
				String fb = jsonObject.get("fbNo").getAsString();
				int fbNo = Integer.valueOf(fb);
				checkFb = deDAO.isFbExists(fbNo);
				if (checkFb == true) {
					count = 1;
					System.out.println("No=" + fb + "存在");
				} else if (checkFb == false) {
					count = -1;
					System.out.println("No=" + fb + "不存在");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			writeText(response, String.valueOf(count));
		} else if (action.equals("getFeedback")) {
			int count = 0;
			boolean checkFb = false;
			List<FeedbackBean> listFb = null;
			try {
				String fb = jsonObject.get("fbNo").getAsString();
				int fbNo = Integer.valueOf(fb);
				listFb = deDAO.getFb(fbNo);
				for (FeedbackBean pop : listFb) {
					pop.setFbImage(null);
					System.out.println("DealNo=" + pop.getDealNo() + ", FbText=" + pop.getFbText());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			writeText(response, gson.toJson(listFb));
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// UserDAO userDAO = new UserDAO();
		// List<User> user = userDAO.getAll();
		// writeText(response, new Gson().toJson(spots));
	}

	private void writeText(HttpServletResponse response, String outText) throws IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		// System.out.println("outText: " + outText);
		out.print(outText);
	}
}