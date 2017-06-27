package web._03_updateMember.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import web._00_init.GlobalService;
import web._01_register.model.MemberBean;
import web._01_register.model.RegisterServiceDAO;
import web._01_register.model.RegisterServiceDAO_JDBC;
import web._02_login.model.LoginServiceDB;

@MultipartConfig(location = "", 
fileSizeThreshold = 5*1024 * 1024, 
maxFileSize = 1024 * 1024 * 500, 
maxRequestSize = 1024 * 1024 * 500 * 5)
@WebServlet("/updateMemberPassword.do")
public class UpdateMemberPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		HttpSession session = request.getSession();
		Map<String, String> errorMsg = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();

		request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息
		session.setAttribute("MsgOK", msgOK); // 顯示正常訊息

		
		String userId =  "";
		String password =  "";
		String newpassword =  "";
		String newpassword2 =  "";
		
		Collection<Part> parts = request.getParts(); // 取出HTTP multipart/ request內所有的parts
		GlobalService.exploreParts(parts, request);
		// 由parts != null來判斷此上傳資料是否為HTTP multipart request
		if (parts != null) { // 如果這是一個上傳資料的表單
			for (Part p : parts) {
				String fldName = p.getName();
				String value = request.getParameter(fldName);
				
				// 1. 讀取使用者輸入資料
				if (p.getContentType() == null) {
					if (fldName.equals("indid")) {
						userId = value;
					} else if (fldName.equals("indpassword")) {
						password = value;
					} else if (fldName.equalsIgnoreCase("newindpassword")) {
						newpassword = value;
					} else if (fldName.equalsIgnoreCase("newindpassword2")) {
						newpassword2 = value;
					}

				} 
			}
		}

		// 2. 進行必要的資料轉換

		// 3. 檢查使用者輸入資料
		// 如果 userId 欄位為空白，放一個錯誤訊息到 errorMsg 之內
		if (newpassword.trim().length() > 0 && newpassword2.trim().length() > 0) {
			if (!newpassword.trim().equals(newpassword2.trim())) {
				errorMsg.put("errorNewPassword2Empty", "密碼欄必須與確認欄一致");
				errorMsg.put("errorNewPasswordEmpty", "*");
			}
		}

		// 如果 password 欄位為空白，放一個錯誤訊息到 errorMsg 之內
		if (password == null || password.trim().length() == 0) {
			errorMsg.put("PasswordEmptyError", "舊密碼欄必須輸入");
		}
		if (newpassword == null || newpassword.trim().length() == 0) {
			errorMsg.put("PasswordEmptyError1", "密碼欄必須輸入");
		}
		if (newpassword2 == null || newpassword2.trim().length() == 0) {
			errorMsg.put("PasswordEmptyError2", "密碼確認欄必須輸入");
		}

		// 如果 errorMsgMap 不是空的，表示有錯誤，交棒給updateMember.jsp
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/_03_updateMember/updateMemberPassword.jsp");
//			RequestDispatcher rd = request.getRequestDispatcher("/_03_updateMember/updateMember.jsp");
			rd.forward(request, response);
			return;
		}

		// 4. 進行 Business Logic 運算
		// 將LoginServiceDB類別new為物件，存放物件參考的變數為 lsdb
		LoginServiceDB lsdb;
		try {
			lsdb = new LoginServiceDB();

			password = GlobalService.getMD5Endocing(GlobalService.encryptString(password));
			newpassword = GlobalService.getMD5Endocing(GlobalService.encryptString(newpassword));
			System.out.println("password=" + password);
			System.out.println("newpassword=" + newpassword);

			MemberBean mb = lsdb.checkPassword(userId, password);

			RegisterServiceDAO rs = new RegisterServiceDAO_JDBC();
			if (mb != null) {
				int n = rs.updateMemberPassword(mb, newpassword);
				System.out.println("n="+n+"密碼更新成功");
			} else {
				// NG, userid與密碼的組合錯誤，放一個錯誤訊息到 errorMsgMap 之內
				errorMsg.put("LoginError", "該密碼錯誤");
			}
		} catch (NamingException e) {
			errorMsg.put("LoginError", "LoginServlet->NamingException:" + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			errorMsg.put("LoginError", "LoginServlet->SQLException:" + e.getMessage());
			e.printStackTrace();
		}

		// 5.依照 Business Logic 運算結果來挑選適當的畫面
		// 如果 errorMsgMap 是空的，表示沒有任何錯誤，交棒給下一棒
		if (errorMsg.isEmpty()) {
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
			return;

		} else {
			// 如果errorMsgMap不是空的，表示有錯誤，交棒給updateMember.jsp
			RequestDispatcher rd = request.getRequestDispatcher("/_03_updateMember/updateMemberPassword.jsp");
//			RequestDispatcher rd = request.getRequestDispatcher("/_03_updateMember/updateMember.jsp");
			rd.forward(request, response);
			return;
		}

	}

}
