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
import web._05_deal.model.DEAL_ErrorBean;
import web._05_deal.model.DealDAO;
import web._05_deal.model.JSON_In_Up_Bean;

//@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
//		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)
@WebServlet("/web/_05_deal/controller/InsertDEAL")
public class InsertDEALServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertDEALServlet() {
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
		String Type = "INSERT";
		String Ans = "TRUE";
		JSON_In_Up_Bean jiub = new JSON_In_Up_Bean();

		try {
			HttpSession session = request.getSession(false);
			MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
			INDID = mb.getIndid();
			System.out.println("session INDID=" + INDID);
		} catch (Exception e) {
			Ans = "FALSE";
			jiub.setMessage("Session Not Found");
		}
		String GOODSNO = request.getParameter("GOODSNO");
		String DEALQTY = request.getParameter("DEALQTY");
		String ENDSHIPWAY = request.getParameter("ENDSHIPWAY");
		String DEALNOTE = request.getParameter("DEALNOTE");
		System.out.println("GOODSNO=" + GOODSNO);
		System.out.println("DEALQTY=" + DEALQTY);
		System.out.println("GOODSTYPE=" + ENDSHIPWAY);
		System.out.println("DEALNOTE=" + DEALNOTE);
		DEAL_ErrorBean dealeb = new DEAL_ErrorBean();
		if (Ans.equals("TRUE")) {
			if (GOODSNO == null || GOODSNO.trim().length() == 0) {
				dealeb.setErrorGOODSNO("物資編號不可為空值");
				Ans = "FALSE";
			}
			if (DEALQTY == null || DEALQTY.trim().length() == 0) {
				dealeb.setErrorDEALQTY("數量不可為空值");
				Ans = "FALSE";
			}
			if (ENDSHIPWAY == null || ENDSHIPWAY.trim().length() == 0) {
				dealeb.setErroENDSHIPWAY("交易方式不可為空值");
				Ans = "FALSE";
			}
			if (!Ans.equals("TRUE")) {
				jiub.setDealb(dealeb);
			}
		}

		if (Ans.equals("TRUE")) {
			String SQLAns = new DealDAO().Insert_DEAL(Integer.parseInt(GOODSNO), INDID, Integer.parseInt(DEALQTY),
					Integer.parseInt(ENDSHIPWAY), DEALNOTE);
			System.out.println("ans=" + SQLAns);
			if (!SQLAns.equals("TRUE")) {
				Ans = "FALSE";
				jiub.setMessage("SQL ERROR");
			}
		}
		jiub.setType(Type);
		jiub.setAns(Ans);
		Gson gson = new Gson();
		String jiub_json = gson.toJson(jiub);
		System.out.println(jiub_json);
		response.setContentType("application/json; charset=UTF8");
		try (PrintWriter out = response.getWriter();) {
			out.print(jiub_json);
		}
		return;
	}
}
