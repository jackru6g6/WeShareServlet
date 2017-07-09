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


@WebServlet("/_08_query/GoodsQuery.do")
public class GoodsQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsServiceDAO gs ;
		String goodsno =request.getParameter("goodsno");

		try {
			gs = new GoodsServiceDAO_JDBC();
			List<GoodsBean> list = gs.queryGoodsByGoodsno(goodsno);		
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
//					System.out.println(s);
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
