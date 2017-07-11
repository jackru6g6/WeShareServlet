package web._04_productMaintain.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import web._01_register.model.MemberBean;
import web._04_productMaintain.model.GoodsBean;
import web._04_productMaintain.model.GoodsServiceDAO_JDBC;
import web._04_productMaintain.model.JSON_Find_Bean;

//@WebServlet("/FindGoodsServlet")
@WebServlet("/web/_04_productMaintain/controller/FindGoodsServlet")
public class FindGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doFirst(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doFirst(request, response);
	}

	protected void doFirst(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		String INDID = "";
		String Type = "FIND";
		String Ans = "TRUE";
		String mfjb_json = "";
		JSON_Find_Bean mfjb = new JSON_Find_Bean();

		try {
			HttpSession session = request.getSession(false);
			MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
			INDID = mb.getIndid();
			System.out.println("session INDID=" + INDID);
		} catch (Exception e) {
			Ans = "FALSE";
			mfjb.setMessage("Session Not Found");
		}
		Gson gson = new Gson();
		String key = request.getParameter("key");

		if (Ans.equals("TRUE")) {
			if (key == null) {
				Ans = "FALSE";
				mfjb.setMessage("key not null");
			}
		}
		if (Ans.equals("TRUE")) {
			try {
				GoodsServiceDAO_JDBC gs = new GoodsServiceDAO_JDBC();
				GoodsBean gb = gs.getGoodsByGoodsno(key, INDID);
				if (gb == null) {
					Ans = "FALSE";
					mfjb.setMessage("SQL not Found");
				} else {
					mfjb.setGb(gb);
				}
			} catch (Exception e) {
				e.getMessage();
				Ans = "FALSE";
				mfjb.setMessage("SQL ERROR");
			}
		}
		mfjb.setType(Type);
		mfjb.setAns(Ans);
		mfjb_json = gson.toJson(mfjb);
		System.out.println(mfjb_json);
		response.setContentType("application/json; charset=UTF8");
		try (PrintWriter out = response.getWriter();) {
			out.print(mfjb_json);
		}
		return;
	}
}
