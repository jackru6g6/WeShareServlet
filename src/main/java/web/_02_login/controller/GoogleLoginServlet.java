package web._02_login.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import web._00_init.GlobalService;
import web._01_register.model.MemberBean;
import web._02_login.model.GoogleLoginBean;
import web._02_login.model.LoginServiceDB;
import web._02_login.model.OAuth_DeCode;

@WebServlet("/web/_02_login/controller/GoogleLogin.do")
public class GoogleLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		checkLogin(request, response);
	}

	public void checkLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession();
		// 取出推薦網頁URI
		String requestURI = (String) session.getAttribute("requestURI");
		String rm = request.getParameter("rememberMe");

		request.setAttribute("ErrorMsgKey", errorMsgMap);
		response.setContentType("text/html");
		String idToken = request.getParameter("id_token");
		GoogleLoginBean GLB = GoogleAPI(idToken);
		LoginServiceDB lsdb;
		try {
			lsdb = new LoginServiceDB();
			String password = GlobalService.getMD5Endocing(GlobalService.encryptString(GLB.getUserPassword()));
			MemberBean mb = lsdb.checkPassword(GLB.getUserId(), password);
			if (mb != null) {
				// OK, 將mb物件放入Session範圍內，識別字串為"LoginOK"
				session.setAttribute("LoginOK", mb);
			} else {
				session.setAttribute("FINDGLB", GLB);
				System.out.println("首次使用contextPath=" + contextPath);
				errorMsgMap.put("LoginFIRST", "首次使用");
				response.sendRedirect(contextPath + "/_01_register/OAuthregister.jsp");
				return;
			}
		} catch (NamingException e) {
			errorMsgMap.put("LoginError", "LoginServlet->NamingException:" + e.getMessage());
		} catch (SQLException e) {
			errorMsgMap.put("LoginError", "LoginServlet->SQLException:" + e.getMessage());
			e.printStackTrace();
		}
		// 5.依照 Business Logic 運算結果來挑選適當的畫面
		// 如果 errorMsgMap 是空的，表示沒有任何錯誤，交棒給下一棒
		if (errorMsgMap.isEmpty()) {
			// 此時不要用下面兩個敘述，因為網址列的URL不會改變
			// RequestDispatcher rd = request.getRequestDispatcher("...");
			// rd.forward(request, response);
			if (requestURI != null) {
				requestURI = (requestURI.length() == 0 ? request.getContextPath() : requestURI);
				response.sendRedirect(response.encodeRedirectURL(requestURI));
				return;
			} else {
				response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
				return;
			}
		} else {
			// 如果errorMsgMap不是空的，表示有錯誤，交棒給login.jsp
			// RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("/web/login.jsp");
			rd.forward(request, response);
			return;
		}

	}

	public GoogleLoginBean GoogleAPI(String idToken) {
		GoogleLoginBean GLB = new GoogleLoginBean();
		try {
			GoogleIdToken.Payload payLoad = OAuth_DeCode.getPayload_From_ID_Token(idToken);
			GLB.setId((String) payLoad.getSubject());
			GLB.setName((String) payLoad.get("name"));
			GLB.setPictureUrl((String) payLoad.get("picture"));
			GLB.setLocale((String) payLoad.get("locale"));
			GLB.setFamilyName((String) payLoad.get("family_name"));
			GLB.setGivenName((String) payLoad.get("given_name"));
			GLB.setEmail((String) payLoad.getEmail());
			GLB.setUserId(GLB.getEmail() + "|Google");
			GLB.setUserPassword(GLB.getId() + "|Google");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return GLB;
	}
}
