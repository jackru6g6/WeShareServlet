package web._03_updateMember.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web._01_register.model.MemberBean;
import web._01_register.model.OrgBean;
import web._01_register.model.RegisterServiceDAO;
import web._01_register.model.RegisterServiceDAO_JDBC;

//import ch04.ex01.model.IMemberDAO;
//import ch04.ex01.model.Member;
//import ch04.ex01.model.MemberJDBC_DAO;

/*  
 * 本程式經由Hibernate來存取資料庫
 */
@WebServlet("/FindMemberServlet")
//@WebServlet("/ch04/ex02/FindMemberServlet")
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pk = request.getParameter("pk");
		
		try {
			RegisterServiceDAO rs = new RegisterServiceDAO_JDBC();
			List<Object> obj  = rs.populateMember(pk);
			Iterator<Object> it =  obj.iterator();
			MemberBean mb=null;
			OrgBean ob=null;
			while(it.hasNext()){
				Object object=it.next();
				if(object instanceof MemberBean){
					mb = (MemberBean)object;
				}else if (object instanceof OrgBean) {
					ob = (OrgBean)object;
				}else{
					System.out.println("obj轉型失敗");
				}
			}
			if(mb!=null){
				request.setAttribute("ind", mb);
			}
			if(ob!=null){
				request.setAttribute("org", ob);
			}
			
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
//		int ipk = Integer.parseInt(pk);
//		IMemberDAO  dao = new MemberJDBC_DAO();
		//MemberHBN_DAO  dao = new MemberHBN_DAO();
		// 可以是Session的get()或load()方法
//		Member member = dao.loadMember(ipk);
//		request.setAttribute("member", member);              
		RequestDispatcher rd = request.getRequestDispatcher("/_03_updateMember/updateMember.jsp");
		rd.forward(request, response);
		
		
//		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//		rd.forward(request, response);
//		try{
//		response.sendRedirect("/index.jsp");
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
		
		return;
	}
}
