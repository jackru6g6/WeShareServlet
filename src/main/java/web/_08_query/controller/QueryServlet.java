package web._08_query.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;

import web._01_register.model.OrgBean;
import web._04_productMaintain.model.GoodsBean;
import web._04_productMaintain.model.GoodsServiceDAO;
import web._04_productMaintain.model.GoodsServiceDAO_JDBC;
import web._08_query.model.OrgServiceDAO;
import web._08_query.model.OrgServiceDAO_JDBC;


@WebServlet("/_08_query/Query.do")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsServiceDAO gs ;	
		OrgServiceDAO os;
		String type =request.getParameter("type");
		String value =request.getParameter("value");
		
		
		if(type==null){
			try {
				gs = new GoodsServiceDAO_JDBC();
				List<GoodsBean> list = gs.getGoods();		
				List<GoodsBean> list2 = new ArrayList<>();
				
				for(int i=0;i<list.size();i++){
					GoodsBean gb = (GoodsBean)list.toArray()[i];					
					if(gb!=null){
						long deadlineValue = gb.getDeadline();
						Date date = new Date(deadlineValue);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String deadlinestring = sdf.format(date);
						gb.setDeadlinestring(deadlinestring);						
					}
					list2.add(gb);
				}				
				
				Gson gson = new Gson();
				String s = gson.toJson(list2);
				response.setContentType("application/json; charset=UTF8");
				try(
						PrintWriter out = response.getWriter();					
					){
					out.print(s);
//					System.out.println(s);
				}
				
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else if(type.equalsIgnoreCase("usertype")){
			try {
				gs = new GoodsServiceDAO_JDBC();
				int intValue = Integer.parseInt(value);
				List<GoodsBean> list = gs.getGoodsByUserType(intValue);		
				List<GoodsBean> list2 = new ArrayList<>();
				
				for(int i=0;i<list.size();i++){
					GoodsBean gb = (GoodsBean)list.toArray()[i];					
					if(gb!=null){
						long deadlineValue = gb.getDeadline();
						Date date = new Date(deadlineValue);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String deadlinestring = sdf.format(date);
						gb.setDeadlinestring(deadlinestring);						
					}
					list2.add(gb);
				}				
				
				Gson gson = new Gson();
				String s = gson.toJson(list2);
				response.setContentType("application/json; charset=UTF8");
				try(
						PrintWriter out = response.getWriter();					
					){
					out.print(s);
//					System.out.println(s);
				}
				
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			
		}else if(type.equalsIgnoreCase("goodstype")){
			try {
				gs = new GoodsServiceDAO_JDBC();
				List<GoodsBean> list = gs.getGoodsByGoodsType(value);
				List<GoodsBean> list2 = new ArrayList<>();
				
				for(int i=0;i<list.size();i++){
					GoodsBean gb = (GoodsBean)list.toArray()[i];					
					if(gb!=null){
						long deadlineValue = gb.getDeadline();
						Date date = new Date(deadlineValue);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String deadlinestring = sdf.format(date);
						gb.setDeadlinestring(deadlinestring);						
					}
					list2.add(gb);
				}				
				
				Gson gson = new Gson();
				String s = gson.toJson(list2);
				response.setContentType("application/json; charset=UTF8");
				try(
						PrintWriter out = response.getWriter();					
					){
					out.print(s);
//					System.out.println(s);
				}
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else if(type.equalsIgnoreCase("goodsloc")){
			try {
				gs = new GoodsServiceDAO_JDBC();
				List<GoodsBean> list = gs.getGoodsByGoodsLoc(value);
				List<GoodsBean> list2 = new ArrayList<>();
				
				for(int i=0;i<list.size();i++){
					GoodsBean gb = (GoodsBean)list.toArray()[i];					
					if(gb!=null){
						long deadlineValue = gb.getDeadline();
						Date date = new Date(deadlineValue);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String deadlinestring = sdf.format(date);
						gb.setDeadlinestring(deadlinestring);						
					}
					list2.add(gb);
				}				
				
				Gson gson = new Gson();
				String s = gson.toJson(list2);
				response.setContentType("application/json; charset=UTF8");
				try(
						PrintWriter out = response.getWriter();					
					){
					out.print(s);
//					System.out.println(s);
				}
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(type.equalsIgnoreCase("keyword")){
			try {
				gs = new GoodsServiceDAO_JDBC();
				List<GoodsBean> list = gs.getGoodsByKeyword(value);
				List<GoodsBean> list2 = new ArrayList<>();
				
				for(int i=0;i<list.size();i++){
					GoodsBean gb = (GoodsBean)list.toArray()[i];					
					if(gb!=null){
						long deadlineValue = gb.getDeadline();
						Date date = new Date(deadlineValue);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String deadlinestring = sdf.format(date);
						gb.setDeadlinestring(deadlinestring);						
					}
					list2.add(gb);
				}				
				
				Gson gson = new Gson();
				String s = gson.toJson(list2);
				response.setContentType("application/json; charset=UTF8");
				try(
						PrintWriter out = response.getWriter();					
					){
					out.print(s);
//					System.out.println(s);
				}
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(type.equalsIgnoreCase("goodsstatus")){
			try {
				gs = new GoodsServiceDAO_JDBC();
				List<GoodsBean> list = gs.getGoodsByGoodsStatus(value);
				List<GoodsBean> list2 = new ArrayList<>();
				
				for(int i=0;i<list.size();i++){
					GoodsBean gb = (GoodsBean)list.toArray()[i];					
					if(gb!=null){
						long deadlineValue = gb.getDeadline();
						Date date = new Date(deadlineValue);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String deadlinestring = sdf.format(date);
						gb.setDeadlinestring(deadlinestring);						
					}
					list2.add(gb);
				}				
				
				Gson gson = new Gson();
				String s = gson.toJson(list2);
				response.setContentType("application/json; charset=UTF8");
				try(
						PrintWriter out = response.getWriter();					
					){
					out.print(s);
//					System.out.println(s);
				}
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//		else if(type.equalsIgnoreCase("org")){
//			try {
//				os = new OrgServiceDAO_JDBC();
//				List<OrgBean> list = os.getOrg();
//				
//				Gson gson = new Gson();
//				String s = gson.toJson(list);
//				response.setContentType("application/json; charset=UTF8");
//				try(
//						PrintWriter out = response.getWriter();					
//					){
//					out.print(s);
////					System.out.println(s);
//				}
//			} catch (NamingException e) {
//				e.printStackTrace();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}	
		
		
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
