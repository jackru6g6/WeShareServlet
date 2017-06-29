package web._06_MSG.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web._06_MSG.model.MSGBean;
import web._06_MSG.model.MSGDAO;

@WebServlet("/web/_06_MSG/controller/FindMSGByKey.do")
public class FindMSGByKeyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindMSGByKeyServlet() {
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
		System.out.println("cookie INDID=" + INDID);

		Collection<MSGBean> coll = new MSGDAO().FindMSGByKey(INDID);
		System.out.println(INDID + "一共有" + coll.size() + "筆訊息");
		if (coll.size() != 0) {
			request.setAttribute("MSG_DATA", coll);
		} else {
			request.setAttribute("MSG_DATA", null);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/_06_MSG/DisplayMSG.jsp");
		rd.forward(request, response);
		return;
	};

}
