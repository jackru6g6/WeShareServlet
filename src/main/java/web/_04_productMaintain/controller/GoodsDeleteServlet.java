package web._04_productMaintain.controller;

import java.io.IOException;
import java.lang.reflect.Member;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web._01_register.model.MemberBean;
import web._04_productMaintain.model.GoodsServiceDAO;
import web._04_productMaintain.model.GoodsServiceDAO_JDBC;


@WebServlet("/GoodsDelete.do")
public class GoodsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	HttpSession session = request.getSession();
        	MemberBean mb = (MemberBean)session.getAttribute("LoginOK");
        	
        	String goodsno0 = request.getParameter("pk");
        	int goodsno = Integer.parseInt(goodsno0);
        	GoodsServiceDAO gs = new GoodsServiceDAO_JDBC();        	
			int n = gs.deleteGoods(goodsno);
			
			if (n == 1) {
				session.setAttribute("GoodsDeleteMsg", "物資編號(" + goodsno + ")刪除成功");
			} else {
				session.setAttribute("GoodsDeleteMsg", "物資編號(" + goodsno + ")刪除失敗");
			}
			response.sendRedirect("DisplayPageProducts?pk="+mb.getIndid());
			return;
			
		} catch (NamingException e) {
			throw new ServletException(e);
		} catch (SQLException e) {
			throw new ServletException(e);
		}
        
	}

}
