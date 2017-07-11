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
import web._04_productMaintain.model.GoodsServiceDAO_JDBC;
import web._04_productMaintain.model.JSON_Find_Bean;

@WebServlet("/web/_04_productMaintain/controller/GoodsDelete")
// @MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize
// = 1024 * 1024 * 500, maxRequestSize = 1024 * 1024 * 500 * 5)
public class GoodsDeleteServlet extends HttpServlet {
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
		String Type = "DROP";
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
				int n = new GoodsServiceDAO_JDBC().deleteGoods(Integer.parseInt(key), INDID);
				if (n != 1) {
					Ans = "FALSE";
					mfjb.setMessage("SQL ERROR");
				}
			} catch (Exception e) {
				Ans = "FALSE";
				mfjb.setMessage("SQL ERROR");
				e.printStackTrace();
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
