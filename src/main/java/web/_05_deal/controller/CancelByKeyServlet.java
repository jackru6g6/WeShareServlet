package web._05_deal.controller;

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
import web._05_deal.model.DealDAO;
import web._05_deal.model.JSON_In_Up_Bean;

@WebServlet("/web/_05_deal/controller/CancelByKey")
public class CancelByKeyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CancelByKeyServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		do_First(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		do_First(request, response);
	}

	public void do_First(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		String INDID = "";
		String Type = "UPDATE";
		String Ans = "TRUE";
		String jiub_json = "";
		JSON_In_Up_Bean jiub = new JSON_In_Up_Bean();
		String key = request.getParameter("key");
		try {
			HttpSession session = request.getSession(false);
			MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
			INDID = mb.getIndid();
			System.out.println("session INDID=" + INDID);
		} catch (Exception e) {
			Ans = "FALSE";
			jiub.setMessage("Session Not Found");
		}
		Gson gson = new Gson();
		if (Ans.equals("TRUE")) {
			if (key == null) {
				Ans = "FALSE";
				jiub.setMessage("key not null");
			}
		}
		if (Ans.equals("TRUE")) {
			System.out.println("KEY=" + key);
			String SQLAns = new DealDAO().CANCEL_DEAL(key, INDID);
			System.out.println("SQLAns=" + Ans);
			if (!SQLAns.equals("TRUE")) {
				Ans = "FALSE";
				jiub.setMessage("SQL ERROR");
			}
		}
		jiub.setType(Type);
		jiub.setAns(Ans);
		jiub_json = gson.toJson(jiub);
		System.out.println(jiub_json);
		response.setContentType("application/json; charset=UTF8");
		try (PrintWriter out = response.getWriter();) {
			out.print(jiub_json);
		}
		return;

	}

}
