package web._03_updateMember.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import ch04.ex01.model.IMemberDAO;
//import ch04.ex01.model.Member;
//import ch04.ex01.model.MemberJDBC_DAO;

@WebServlet("/ch04/ex02/queryAllMembers.do")
public class QueryAllMembers_JDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//IMemberDAO dao = new MemberHBN_DAO();
//		IMemberDAO dao = new MemberJDBC_DAO();
//		Collection<Member> coll = dao.getAllMembers();
//		request.setAttribute("AllMembers", coll);
		RequestDispatcher rd = request
				.getRequestDispatcher("showAllMembersJDBC.jsp");
		rd.forward(request, response);
		return;
	}
}
