package web._06_MSG.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web._06_MSG.model.MSGDAO;

@WebServlet("/web/_06_MSG/controller/ChangeMSGstatus.do")

public class ChangeMSGstatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangeMSGstatusServlet() {
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
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		String key = request.getParameter("key");
		System.out.println("KEY=" + key);
		String Ans = new MSGDAO().READ_MSG(key);
		System.out.println("Ans=" + Ans);

		response.sendRedirect("FindMSGByRoomNo.do?key="+key);
		return;
	}

}
