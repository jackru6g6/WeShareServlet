package web._08_query.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;

import web._04_productMaintain.model.GoodsBean;
import web._04_productMaintain.model.GoodsServiceDAO;
import web._04_productMaintain.model.GoodsServiceDAO_JDBC;
import web._08_query.model.OrgServiceDAO;
import web._08_query.model.OrgServiceDAO_JDBC;


@WebServlet("/_08_query/OrgQuery.do")
public class OrgQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrgServiceDAO os;
		String type =request.getParameter("type");
		String value =request.getParameter("value");		
		
		//查詢所有社福團體
		if(type==null){
			try {
				os = new OrgServiceDAO_JDBC();
				List<Object> list = os.getOrg();
				
				Gson gson = new Gson();
				String s = gson.toJson(list);
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
			
		//透過關鍵字查詢社福團體	
		}else if(type.equalsIgnoreCase("keyword")){
			try {
				os = new OrgServiceDAO_JDBC();
				List<Object> list = os.getOrgByKeyword(value);
				
				Gson gson = new Gson();
				String s = gson.toJson(list);
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
			
		//透過社福類型查詢社福團體	
		}else if(type.equalsIgnoreCase("orgtypes")){
			try {
				os = new OrgServiceDAO_JDBC();
				List<Object> list = os.getOrgByOrgtypes(value);
				
				Gson gson = new Gson();
				String s = gson.toJson(list);
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
			
		//透過地區(縣市)查詢社福團體	
		}else if(type.equalsIgnoreCase("indaddress")){
			try {
				os = new OrgServiceDAO_JDBC();
				List<Object> list = os.getOrgByIndAddress(value);
				
				Gson gson = new Gson();
				String s = gson.toJson(list);
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
		
		//透過社福團體會員帳號查詢社福團體物資需求	
		}else if(type.equalsIgnoreCase("indid")){
			try {
				Date dateNow = new Date();
				long now = dateNow.getTime();		
				GoodsServiceDAO gs = new GoodsServiceDAO_JDBC();
				List<GoodsBean> list = gs.queryGoodsByIndId(value,now);
				List<GoodsBean> list2 = new ArrayList<>();
				
				for(int i=0;i<list.size();i++){
					GoodsBean gb = (GoodsBean)list.toArray()[i];					
					if(gb!=null){
						long deadlineValue = gb.getDeadline();
						Date date = new Date(deadlineValue);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String deadlinestring = sdf.format(date);
						gb.setDeadlinestring(deadlinestring);	
						
						Date updatetime = gb.getUpdatetime();
						String updatetimestring = sdf.format(updatetime);
						gb.setUpdatetime_TEMP(updatetimestring);
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
	//						System.out.println(s);
				}
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}					
		
		}		
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
