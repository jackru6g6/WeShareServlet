package app.goods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import app.main.ImageUtil;
import app.user.MemberBean;
import web._00_init.GlobalService;

@SuppressWarnings("serial")
@WebServlet("/GoodsServlet")
public class GoodsServlet extends HttpServlet {
	private final static String CONTENT_TYPE = "text/html; charset=UTF-8";

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		BufferedReader br = request.getReader();
		StringBuffer jsonIn = new StringBuffer();
		String line = null;
		while ((line = br.readLine()) != null) {
			jsonIn.append(line);
		}

		JsonObject jsonObject = gson.fromJson(jsonIn.toString(), JsonObject.class);
		GoodsDAO gDAO = new GoodsDAO();
		String action = jsonObject.get("action").getAsString();

		System.out.println("------1action: " + action);
		// String userId = jsonObject.get("user").getAsString();
		// System.out.println("userId: " + userId);
		
		//取物資資料(資料庫)
		if (action.equals("getAll")) {
			String userId = jsonObject.get("user").getAsString();
			List<GoodsBean> goods = gDAO.getAll(userId);
			String user = jsonObject.get("user").getAsString();
			System.out.println("user" + user);
			writeText(response, gson.toJson(goods));
		}else if (action.equals("getSelfWish")) {
			String userId = jsonObject.get("user").getAsString();
			List<GoodsBean> goods = gDAO.getSelfWish(userId);
			String user = jsonObject.get("user").getAsString();
			System.out.println("user" + user);
			writeText(response, gson.toJson(goods));
		}else if (action.equals("getSelfGive")) {
			String userId = jsonObject.get("user").getAsString();
			List<GoodsBean> goods = gDAO.getSelfGive(userId);
			String user = jsonObject.get("user").getAsString();
			System.out.println("user" + user);
			writeText(response, gson.toJson(goods));	
		}else if (action.equals("getSelfChange")) {
			String userId = jsonObject.get("user").getAsString();
			List<GoodsBean> goods = gDAO.getSelfChange(userId);
			String user = jsonObject.get("user").getAsString();
			System.out.println("user" + user);
			writeText(response, gson.toJson(goods));	
	
			//取圖
		} else if (action.equals("getImage")) {
			OutputStream os = response.getOutputStream();
			int gid = jsonObject.get("gId").getAsInt();
			int imageSize = jsonObject.get("imageSize").getAsInt();
			byte[] image = gDAO.getImage(gid);
			if (image != null) {
				image = ImageUtil.shrink(image, imageSize);
				response.setContentType("image/jpeg");
				response.setContentType("image/png");
				response.setContentLength(image.length);
				System.out.println(image);
			} else {
				System.out.println("沒收到喔~");
			}
			os.write(image);

			//新增
		} else if (action.equals("goodsInsert")) {
			String goodsJson = jsonObject.get("goods").getAsString();
			GoodsBean goods = gson.fromJson(goodsJson, GoodsBean.class);
			String imageBase64 = jsonObject.get("imageBase64").getAsString();
			byte[] image = Base64.getMimeDecoder().decode(imageBase64);
			int count = 0;
			boolean check;
			Blob blob = null;
			try {
				blob = new SerialBlob(image);
				goods.setGoodsImage(blob);
				count = gDAO.save(goods);

			} catch (SerialException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			writeText(response, String.valueOf(count));
		
			//修改
		} else if (action.equals("goodsUpdate")) {
			String goodJson = jsonObject.get("goods").getAsString();
			GoodsBean good = gson.fromJson(goodJson, GoodsBean.class);// 轉為Spot物件
			String imageBase64 = jsonObject.get("imageBase64").getAsString();
			byte[] image = null;
			image = Base64.getMimeDecoder().decode(imageBase64);
			int count = 0;
			boolean check;
			Blob blob = null;
			byte[] imagea = new byte[0];
			try {
				blob = new SerialBlob(image);
				good.setGoodsImage(blob);
				count = gDAO.update(good);
			} catch (Exception e) {
				e.printStackTrace();
			}
			writeText(response, String.valueOf(count));
			
		//刪除
		} else if (action.equals("goodsDelete")) {
			String goodJson = jsonObject.get("goods").getAsString();
			GoodsBean good = gson.fromJson(goodJson, GoodsBean.class);
			System.out.println(good.getGoodsNo());
			int count = gDAO.delete(good.getGoodsNo());
			writeText(response, String.valueOf(count));
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GoodsDAOForList goodsDAO = new GoodsDaoMysqlImpl();

		// GoodsDAO gDAO = new GoodsDAO();
		// List<GoodsBean> gList = gDAO.getAll("jack");
		//
		// writeText(response, new Gson().toJson(gList));
	}

	private void writeText(HttpServletResponse response, String outText) throws IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		// System.out.println("outText: " + outText);
		out.print(outText);
	}
}
