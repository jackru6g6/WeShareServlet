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


import com.google.gson.Gson;

import web._04_productMaintain.model.GoodsBean;
import web._04_productMaintain.model.GoodsServiceDAO;
import web._04_productMaintain.model.GoodsServiceDAO_JDBC;


@WebServlet("/_08_query/Query.do")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsServiceDAO gs ;
		String type =request.getParameter("type");
		String value =request.getParameter("value");
		
		String goodsstatus =request.getParameter("goodsstatus");

		//許願池
		if(goodsstatus.equalsIgnoreCase("1")){
			if(type==null){
				try {
					gs = new GoodsServiceDAO_JDBC();
					List<GoodsBean> list = gs.getGoods(goodsstatus);		
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
//							System.out.println(s);
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
					List<GoodsBean> list = gs.getGoodsByUserType(goodsstatus,intValue);		
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
//							System.out.println(s);
					}
					
				} catch (NamingException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else if(type.equalsIgnoreCase("goodstype")){
				try {
					gs = new GoodsServiceDAO_JDBC();
					List<GoodsBean> list = gs.getGoodsByGoodsType(goodsstatus,value);
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
//							System.out.println(s);
					}
				} catch (NamingException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else if(type.equalsIgnoreCase("goodsloc")){
				try {
					gs = new GoodsServiceDAO_JDBC();
					List<GoodsBean> list = gs.getGoodsByGoodsLoc(goodsstatus,value);
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
//							System.out.println(s);
					}
				} catch (NamingException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else if(type.equalsIgnoreCase("keyword")){
				try {
					gs = new GoodsServiceDAO_JDBC();
					List<GoodsBean> list = gs.getGoodsByKeyword(goodsstatus,value);
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
//							System.out.println(s);
					}
				} catch (NamingException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			
		//送愛心	
		}else if(goodsstatus.equalsIgnoreCase("2")){			
			if(type==null){
				try {
					gs = new GoodsServiceDAO_JDBC();
					List<GoodsBean> list = gs.getGoods(goodsstatus);		
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
//							System.out.println(s);
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
					List<GoodsBean> list = gs.getGoodsByUserType(goodsstatus,intValue);		
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
//							System.out.println(s);
					}
					
				} catch (NamingException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else if(type.equalsIgnoreCase("goodstype")){
				try {
					gs = new GoodsServiceDAO_JDBC();
					List<GoodsBean> list = gs.getGoodsByGoodsType(goodsstatus,value);
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
//							System.out.println(s);
					}
				} catch (NamingException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else if(type.equalsIgnoreCase("goodsloc")){
				try {
					gs = new GoodsServiceDAO_JDBC();
					List<GoodsBean> list = gs.getGoodsByGoodsLoc(goodsstatus,value);
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
//							System.out.println(s);
					}
				} catch (NamingException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else if(type.equalsIgnoreCase("keyword")){
				try {
					gs = new GoodsServiceDAO_JDBC();
					List<GoodsBean> list = gs.getGoodsByKeyword(goodsstatus,value);
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
//							System.out.println(s);
					}
				} catch (NamingException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
			
		//以物易物	
		}else if(goodsstatus.equalsIgnoreCase("3")){			
			if(type==null){
				try {
					gs = new GoodsServiceDAO_JDBC();
					List<GoodsBean> list = gs.getGoods(goodsstatus);		
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
//							System.out.println(s);
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
					List<GoodsBean> list = gs.getGoodsByUserType(goodsstatus,intValue);		
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
//							System.out.println(s);
					}
					
				} catch (NamingException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else if(type.equalsIgnoreCase("goodstype")){
				try {
					gs = new GoodsServiceDAO_JDBC();
					List<GoodsBean> list = gs.getGoodsByGoodsType(goodsstatus,value);
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
//							System.out.println(s);
					}
				} catch (NamingException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else if(type.equalsIgnoreCase("goodsloc")){
				try {
					gs = new GoodsServiceDAO_JDBC();
					List<GoodsBean> list = gs.getGoodsByGoodsLoc(goodsstatus,value);
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
//							System.out.println(s);
					}
				} catch (NamingException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else if(type.equalsIgnoreCase("keyword")){
				try {
					gs = new GoodsServiceDAO_JDBC();
					List<GoodsBean> list = gs.getGoodsByKeyword(goodsstatus,value);
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
//							System.out.println(s);
					}
				} catch (NamingException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}				
		}		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
