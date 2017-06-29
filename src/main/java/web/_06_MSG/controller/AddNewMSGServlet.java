package web._06_MSG.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import web._00_init.GlobalService;
import web._02_login.model.GoogleLoginBean;
import web._06_MSG.model.MSGBean;
import web._06_MSG.model.MSGDAO;

@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)
@WebServlet("/web/_06_MSG/controller/AddNewMSG.do")
public class AddNewMSGServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddNewMSGServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		do_First(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		do_First(request, response);
	}

	public void do_First(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String INDID = "kitty";
		// Cookie[] cookies = request.getCookies();
		// if (cookies != null) {
		// for (int i = 0; i < cookies.length; i++) {
		// Cookie cookie = cookies[i];
		// if (cookie.getName().equals("user"))
		// INDID = URLDecoder.decode(cookie.getValue(), "UTF-8");
		// }
		// }
		System.out.println("[add new msg]cookie INDID=" + INDID);

		String contextPath = request.getContextPath();
		HttpSession session = request.getSession();
		GoogleLoginBean GLB = (GoogleLoginBean) session.getAttribute("FINDGLB");
		Map<String, String> errorMsg = new HashMap<String, String>();
		// 準備存放註冊成功之訊息的Map物件
		Map<String, String> msgOK = new HashMap<String, String>();
		Map<String, String> RM = new HashMap<String, String>();
		request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息
		request.setAttribute("RM", RM); // 記錄CHECKBOX按鈕
		session.setAttribute("MsgOK", msgOK); // 顯示正常訊息
		String MSGENDID = null;
		String MSGTEXT = null;
		String String = null;
		String FileName = "";

		long sizeInBytes = 0;
		InputStream is = null;
		System.out.println("contextPath=" + contextPath);
		Collection<Part> parts = request.getParts(); // 取出HTTP multipart
		// request內所有的parts
		GlobalService.exploreParts(parts, request);
		if (parts != null) { // 如果這是一個上傳資料的表單
			for (Part p : parts) {
				String fldName = p.getName();// 取的鍵值
				String value = request.getParameter(fldName);// 取得值
				// 1. 讀取使用者輸入資料
				if (p.getContentType() == null) {
					if (fldName.equalsIgnoreCase("MSGENDID")) {
						MSGENDID = value;
					}
					if (fldName.equalsIgnoreCase("MSGTEXT")) {
						MSGTEXT = value;
					}
				} else {
					FileName = GlobalService.getFileName(p); // 此為圖片檔的檔名
					FileName = GlobalService.adjustFileName(FileName, GlobalService.IMAGE_FILENAME_LENGTH);
					if (FileName != null && FileName.trim().length() > 0) {
						sizeInBytes = p.getSize();
						is = p.getInputStream();
					} else {

					}
				}
			}

		} else {
			errorMsg.put("errTitle", "此表單不是上傳檔案的表單");
		}
		if (MSGENDID == null || MSGENDID.trim().length() == 0) {
			errorMsg.put("errorMSGENDID", "帳號欄必須輸入");
		}
		if (MSGENDID.toUpperCase().equals(INDID.toUpperCase())) {
			errorMsg.put("errorMSGENDID", "收件者不可是本人");
		}
		if (MSGTEXT == null || MSGTEXT.trim().length() == 0) {
			errorMsg.put("errorMSGTEXT", "訊息欄必須輸入");
		}
		if (!errorMsg.isEmpty()) {
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
			RequestDispatcher rd = request.getRequestDispatcher("/_06_MSG/AddNewMSG.jsp");
			rd.forward(request, response);
			return;
		} else {
			MSGBean msgb = new MSGBean(INDID, MSGENDID, MSGTEXT, FileName);
			String ans = new MSGDAO().Insert_MSG(msgb, is, sizeInBytes);
			System.out.println("ANS=" + ans);
			if (ans != "TRUE") {
				errorMsg.put("errorAns", "新增失敗");
			}
		}

		if (!errorMsg.isEmpty()) {
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
			RequestDispatcher rd = request.getRequestDispatcher("/_06_MSG/AddNewMSG.jsp");
			rd.forward(request, response);
			return;
		}
		response.sendRedirect("FindMSGByKey.do");
		return;
	}

}
