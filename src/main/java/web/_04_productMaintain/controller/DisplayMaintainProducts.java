package web._04_productMaintain.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import web._00_init.GlobalService;
import web._01_register.model.MemberBean;
import web._04_productMaintain.model.GoodsBean;
import web._04_productMaintain.model.GoodsServiceDAO_JDBC;

@WebServlet("/DisplayPageProducts")

public class DisplayMaintainProducts extends HttpServlet {
	          
	private static final long serialVersionUID = 1L;
	int pageNo = 1;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		
		doPost(request, response);		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pk = request.getParameter("pk");
        // 先取出session物件
		HttpSession session = request.getSession(false);
		// 紀錄目前請求的RequestURI,以便使用者登入成功後能夠回到原本的畫面
		String requestURI = request.getRequestURI();
		//System.out.println("requestURI=" + requestURI);
        // 如果session物件不存在
		if (session == null || session.isNew()) {
			 // 請使用者登入
			 response.sendRedirect(response.encodeRedirectURL ("/Demo/_02_login/login.jsp"));
			 return;
		}
		session.setAttribute("requestURI", requestURI);
		// 此時session物件存在，讀取session物件內的LoginOK
		// 以檢查使用者是否登入。
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		if (mb == null) {
			 response.sendRedirect(response.encodeRedirectURL ("/Demo/_02_login/login.jsp"));
			 return;
		}
//		// 本類別負責讀取資料庫內goods表格的紀錄，並能新增紀錄、修改紀錄、刪除記錄等
		GoodsServiceDAO_JDBC gs = null;
		
		// 將現在時刻轉換為long型態格式
			Date date = new Date();
			long now = date.getTime();		
		
		try {
			gs = new GoodsServiceDAO_JDBC();
		    Collection<GoodsBean> coll = gs.getGoodsByIndId(pk,now);
		    request.setAttribute("products_DPP", coll);
//		    交由GoodsMaintainList.jsp來顯示物資箱資料
		    RequestDispatcher rd = request.getRequestDispatcher("/_04_productMaintain/GoodsMaintainList.jsp");
		    rd.forward(request, response);
		    return;
		} catch (SQLException e) {
			throw new ServletException(e);
		} catch (NamingException e) {
			throw new ServletException(e);
		}
	}
}