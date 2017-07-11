package web._04_productMaintain.controller;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;

import web._00_init.GlobalService;
import web._01_register.model.MemberBean;
import web._04_productMaintain.model.GoodsBean;
import web._04_productMaintain.model.GoodsServiceDAO;
import web._04_productMaintain.model.GoodsServiceDAO_JDBC;
import web._04_productMaintain.model.Goods_ErrorBean;
import web._04_productMaintain.model.JSON_In_Up_Bean;

@WebServlet("/web/_04_productMaintain/controller/GoodsUpdate")
// @MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize
// = 1024 * 1024 * 500, maxRequestSize = 1024 * 1024 * 500 * 5)
public class GoodsUpdateServlet extends HttpServlet {
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
		String Type = "UPDATE";
		String Ans = "TRUE";
		String mfjb_json = "";
		JSON_In_Up_Bean jfb = new JSON_In_Up_Bean();

		try {
			HttpSession session = request.getSession(false);
			MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
			INDID = mb.getIndid();
			System.out.println("session INDID=" + INDID);
		} catch (Exception e) {
			Ans = "FALSE";
			jfb.setMessage("Session Not Found");
		}
		Gson gson = new Gson();
		String goodsno = request.getParameter("goodsno");
		String goodsstatus = request.getParameter("goodsstatus");
		String goodstype = request.getParameter("goodstype");
		String goodsname = request.getParameter("goodsname");
		String goodsloc = request.getParameter("goodsloc");
		String goodsnote = request.getParameter("goodsnote");
		String qty = request.getParameter("qty");
		String goodsshipway = request.getParameter("goodsshipway");
		String deadline = request.getParameter("deadline");
		// System.out.println("goodsno=" + goodsno);
		// System.out.println("goodsstatus=" + goodsstatus);
		// System.out.println("goodstype=" + goodstype);
		// System.out.println("goodsname=" + goodsname);
		// System.out.println("goodsloc=" + goodsloc);
		// System.out.println("goodsnote=" + goodsnote);
		// System.out.println("qty=" + qty);
		// System.out.println("goodsshipway=" + goodsshipway);
		// System.out.println("deadline=" + deadline);
		Long deadlineLong = null;

		if (Ans.equals("TRUE")) {
			Goods_ErrorBean geb = new Goods_ErrorBean();
			if (goodsno == null || goodsno.trim().length() == 0) {
				geb.setErrorgoodsno("物資編號不為空值");
				Ans = "FALSE";
			}
			if (goodsstatus == null || goodsstatus.trim().length() == 0) {
				geb.setErrorgoodsstatus("物資型態不為空值");
				Ans = "FALSE";
			}
			if (goodsstatus == null || goodsstatus.trim().length() == 0) {
				geb.setErrorgoodsstatus("物資型態不為空值");
				Ans = "FALSE";
			}
			if (goodstype == null || goodstype.trim().length() == 0) {
				geb.setErrorgoodstype("物資類別不為空值");
				Ans = "FALSE";
			}
			if (goodsname == null || goodsname.trim().length() == 0) {
				geb.setErrorgoodsname("物資名稱不為空值");
				Ans = "FALSE";
			}
			if (goodsloc == null || goodsloc.trim().length() == 0) {
				geb.setErrorgoodsstatus("物資所在地不為空值");
				Ans = "FALSE";
			}
			if (goodsnote == null || goodsnote.trim().length() == 0) {
				geb.setErrorgoodsnote("物資備註不為空值");
				Ans = "FALSE";
			}
			if (qty == null || qty.trim().length() == 0) {
				geb.setErrorqty("物資數量");
				Ans = "FALSE";
			}
			if (goodsshipway == null || goodsshipway.trim().length() == 0) {
				geb.setErrorgoodsshipway("物資交易方式不為空值");
				Ans = "FALSE";
			}
			if (deadline == null || deadline.trim().length() == 0) {
				geb.setErrordeadline("物資型態不為空值");
				Ans = "FALSE";
			}
			if (!Ans.equals("TRUE")) {
				jfb.setGeb(geb);
			}
		}
		if (Ans.equals("TRUE")) {
			try {
				deadlineLong = new SimpleDateFormat("yyyy-MM-dd").parse(deadline).getTime();
				System.out.println("deadlineLong" + deadlineLong.toString());
			} catch (Exception e) {
				Ans = "FALSE";
				jfb.setMessage("dateline Format[yyyy-MM-dd]");
			}
		}
		if (Ans.equals("TRUE")) {

			try {
				GoodsBean gb = new GoodsBean(Integer.parseInt(goodsno), Integer.parseInt(goodsstatus), INDID,
						Integer.parseInt(goodstype), goodsname, Integer.parseInt(goodsloc), goodsnote,
						Integer.parseInt(qty), Integer.parseInt(goodsshipway), deadlineLong);
				int n = new GoodsServiceDAO_JDBC().updateGoods(gb, INDID, null, 0L, null);
				if (n != 1) {
					Ans = "FALSE";
					jfb.setMessage("SQL ERROR");
				}
			} catch (Exception e) {
				Ans = "FALSE";
				jfb.setMessage("SQL ERROR");
				e.printStackTrace();
			}
		}
		jfb.setType(Type);
		jfb.setAns(Ans);
		mfjb_json = gson.toJson(jfb);
		System.out.println(mfjb_json);
		response.setContentType("application/json; charset=UTF8");
		try (PrintWriter out = response.getWriter();) {
			out.print(mfjb_json);
		}
		return;
	}
}
