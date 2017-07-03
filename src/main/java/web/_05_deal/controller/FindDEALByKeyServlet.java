package web._05_deal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web._01_register.model.MemberBean;

@WebServlet("/web/_05_DEAL/controller/FindDEALByKey.do")
public class FindDEALByKeyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindDEALByKeyServlet() {
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
		String INDID = "";
		HttpSession session = request.getSession(false);
		// 紀錄目前請求的RequestURI,以便使用者登入成功後能夠回到原本的畫面
		String requestURI = request.getRequestURI();
		// System.out.println("requestURI=" + requestURI);
		// 如果session物件不存在
		if (session == null || session.isNew()) {
			// 請使用者登入
			response.sendRedirect(response.encodeRedirectURL("/Demo/_02_login/login.jsp"));
			return;
		}
		session.setAttribute("requestURI", requestURI);
		// 此時session物件存在，讀取session物件內的LoginOK
		// 以檢查使用者是否登入。
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		if (mb == null) {
			response.sendRedirect(response.encodeRedirectURL("/Demo/_02_login/login.jsp"));
			return;
		}
		INDID = mb.getIndid();
		System.out.println("session INDID=" + INDID);
	}

}
