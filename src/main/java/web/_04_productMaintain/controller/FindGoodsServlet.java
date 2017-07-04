package web._04_productMaintain.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import web._04_productMaintain.model.GoodsBean;
import web._04_productMaintain.model.GoodsServiceDAO_JDBC;

//@WebServlet("/FindGoodsServlet")
@WebServlet("/web/_04_productMaintain/controller/FindGoodsServlet")
public class FindGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pk = request.getParameter("pk");
		
		try {
			GoodsServiceDAO_JDBC gs = new GoodsServiceDAO_JDBC();
			GoodsBean gb = gs.getGoodsByGoodsno(pk);

			if(gb!=null){
				long deadlineValue = gb.getDeadline();
				Date date = new Date(deadlineValue);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String deadlinestring = sdf.format(date);
//				System.out.println(deadlinestring);
				gb.setDeadlinestring(deadlinestring);
				
				request.setAttribute("bean", gb);
			}

			
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
            
		RequestDispatcher rd = request.getRequestDispatcher("/web/test/_04_productMaintain/GoodsUpdate.jsp");
		rd.forward(request, response);
		
		
		return;
	}
}
