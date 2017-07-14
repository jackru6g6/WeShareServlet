package app.message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.ArrayList;
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

import app.deal.FeedbackBean;
import app.main.ImageUtil;

@SuppressWarnings("serial")
@WebServlet("/MsgServlet")
public class MessageServlet extends HttpServlet {
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
		MessageDAO mgDAO = new MessageDAO();
		String action = jsonObject.get("action").getAsString();
		System.out.println("action: " + action);

		if (action.equals("getAll")) {
			String account = jsonObject.get("account").getAsString();
			List<MsgRoomBean> msgRoom = mgDAO.get(account);
			List<MessageBean> msg = new ArrayList<>();
			System.out.println("帳號account: " + account);
			// for (MessageBean pop : msg) {
			// System.out.println("MsgSource：" + pop.getMsgSourceId() + ",
			// MsgEndId：" + pop.getMsgEndId()
			// + ", MsgText：" + pop.getMsgText() + ", roomNo：" +
			// pop.getRoomNo());
			// }
			for (MsgRoomBean pop : msgRoom) {
				System.out.println("pop.getLastMsgNo=" + pop.getLastMsgNo());
				MessageBean mm = mgDAO.getMessageBean(pop.getLastMsgNo());
				mm.setMsgImage(null);
				System.out.println("text" + mm.getMsgText());
				msg.add(mm);
			}
			writeText(response, gson.toJson(msg));
		} else if (action.equals("getOne")) {
			String account = jsonObject.get("account").getAsString();
			String talkTo = jsonObject.get("talkTo").getAsString();
			List<MessageBean> msg = mgDAO.getOne(account, talkTo);
			System.out.println("帳號account: " + account);
			for (MessageBean pop1 : msg) {
				pop1.setMsgStatus(1);
				mgDAO.updateMsg(pop1);
			}
			for (MessageBean pop : msg) {
				pop.setMsgImage(null);
				System.out.println("MsgSource：" + pop.getMsgSourceId() + ", MsgEndId：" + pop.getMsgEndId()
						+ ", MsgText：" + pop.getMsgText() + ", roomNo：" + pop.getRoomNo());
			}
			writeText(response, gson.toJson(msg));
		} else if (action.equals("getImage")) {
			String account = jsonObject.get("account").getAsString();
			OutputStream os = response.getOutputStream();
			// account = jsonObject.get("account").getAsString();
			int imageSize = jsonObject.get("imageSize").getAsInt();
			System.out.println("account=" + account + ", imageSize=" + imageSize);
			byte[] image = mgDAO.getImage(account);
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
		} else if (action.equals("getMsgImage")) {
			String msgNo = jsonObject.get("msgNo").getAsString();
			int msgNon = Integer.valueOf(msgNo);
			OutputStream os = response.getOutputStream();
			// account = jsonObject.get("account").getAsString();
			int imageSize = jsonObject.get("imageSize").getAsInt();
			System.out.println("dealNo=" + msgNon + ", imageSize=" + imageSize);
			byte[] image = mgDAO.getMsgImage(msgNon);
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
		} else if (action.equals("sendMsgFirst")) {
			String msgJson = jsonObject.get("msg").getAsString();
			MessageBean msg = gson.fromJson(msgJson, MessageBean.class);
			int count = 0;
			try {
				// Blob imageBlob = new SerialBlob(image);
				// blob = new SerialBlob(image);
				// System.out.println("有給圖片");
				// user.setImage(imageBlob);

				// user.setImage(blob);
				// String name = msg.getMsgSourceId();
				int i = mgDAO.getMaxNo();
				msg.setMsgNo(i + 1);
				count = mgDAO.save(msg);

			} catch (Exception e) {
				e.printStackTrace();
			}
			writeText(response, String.valueOf(count));
		} else if (action.equals("sendMsg")) {
			String msgJson = jsonObject.get("msg").getAsString();
			MessageBean msg = gson.fromJson(msgJson, MessageBean.class);
			String imageBase64 = jsonObject.get("imageBase64").getAsString();
			System.out.println("imageBase64=" + imageBase64);
			int count = 0;
			try {
				// Blob imageBlob = new SerialBlob(image);
				// blob = new SerialBlob(image);
				// System.out.println("有給圖片");
				// user.setImage(imageBlob);

				// user.setImage(blob);
				// String name = msg.getMsgSourceId();
				Timestamp ts = new Timestamp(new java.util.Date().getTime());
				msg.setPostDate(ts);
				if (msg.getMsgFileName() == null) {
					msg.setMsgImage(null);
				} else {
					byte[] image = null;
					image = Base64.getMimeDecoder().decode(imageBase64);
					Blob blob = null;
					blob = new SerialBlob(image);
					msg.setMsgImage(blob);
				}

				System.out.println("帳號1 =" + msg.getMsgSourceId() + ", 帳號2=" + msg.getMsgEndId());
				boolean roomCheck = mgDAO.checkRoomNo(msg.getMsgSourceId(), msg.getMsgEndId());
				System.out.println("roomCheck=" + roomCheck);
				if (roomCheck == true) {
					List<MsgRoomBean> list = mgDAO.getRoomNo(msg.getMsgSourceId(), msg.getMsgEndId());

					int i = mgDAO.getMaxNo();
					int NewMsgNo = i + 1;
					System.out.println("NewMsgNo=" + NewMsgNo);
					msg.setMsgNo(NewMsgNo);

					System.out.println("list.get(0).getRoomNo()=" + list.get(0).getRoomNo());
					msg.setRoomNo(list.get(0).getRoomNo());

					count = mgDAO.save(msg);

					list.get(0).setLastMsgNo(NewMsgNo);

					System.out.println("roomNo=" + list.get(0).getRoomNo() + ", 1=" + list.get(0).getIndid1() + ", 2="
							+ list.get(0).getIndid2() + ", Last" + list.get(0).getLastMsgNo());

					mgDAO.updateRoom(list.get(0));
				} else {
					System.out.println("else錯誤");
				}

				// int i = mgDAO.getMaxNo();
				// msg.setMsgNo(i + 1);
				// count = mgDAO.save(msg);

			} catch (Exception e) {
				e.printStackTrace();
			}
			writeText(response, String.valueOf(count));
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