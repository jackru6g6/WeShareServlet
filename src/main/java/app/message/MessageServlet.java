package app.message;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
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

import app.main.ImageUtil;
import app.user.MemberBean;
import web._00_init.GlobalService;

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
			List<MessageBean> msg = mgDAO.get(account);
			System.out.println("帳號account: " + account);
			for (MessageBean pop : msg) {
				System.out.println("MsgSource：" + pop.getMsgSourceId() + ", MsgEndId：" + pop.getMsgEndId()
						+ ", MsgText：" + pop.getMsgText() + ", roomNo：" + pop.getRoomNo());
			}
			writeText(response, gson.toJson(msg));
		}
		if (action.equals("getOne")) {
			String account = jsonObject.get("account").getAsString();
			String talkTo = jsonObject.get("talkTo").getAsString();
			List<MessageBean> msg = mgDAO.getOne(account, talkTo);
			System.out.println("帳號account: " + account);
			for (MessageBean pop : msg) {
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
				// 只要送一張圖，就不用轉json，指定他傳送的型態，如果要用json就要用Base64
				// // encode才能傳送
				response.setContentLength(image.length);// 輸出圖的長度
				System.out.println(image);
			} else {
				System.out.println("沒收到喔~");
			}
			os.write(image);// 送到client端
		} else if (action.equals("sendMsg")) {
			String msgJson = jsonObject.get("msg").getAsString();
			MessageBean msg = gson.fromJson(msgJson, MessageBean.class);
			int count = 0;
			try {
				// Blob imageBlob = new SerialBlob(image);
				// blob = new SerialBlob(image);
				// System.out.println("有給圖片");
				// user.setImage(imageBlob);

				// user.setImage(blob);
				//String name = msg.getMsgSourceId();
				int i = mgDAO.getMaxNo();
				msg.setMsgNo(i+1);
				count = mgDAO.save(msg);

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