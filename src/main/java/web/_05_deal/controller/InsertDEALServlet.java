package web._05_deal.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
		boolean Insert_IMG = true;
		JSON_In_Up_Bean jiub = new JSON_In_Up_Bean();
		Gson gson = new Gson();

		try {
			HttpSession session = request.getSession(false);
			MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
			INDID = mb.getIndid();
			System.out.println("session INDID=" + INDID);
		} catch (Exception e) {
			Ans = "FALSE";
			jiub.setMessage("Session Not Found");
		}
		String GOODSNO = null;
		String DEALQTY = null;
		String ENDSHIPWAY = null;
		String DEALNOTE = null;
		String DEALIMAGE = null;
		byte[] image = null;
		try (BufferedReader br = request.getReader();) {
			StringBuffer jsonIn = new StringBuffer();
			String line = "";
			while ((line = br.readLine()) != null) {
				jsonIn.append(line);
			}
			System.out.println("JSON size=" + jsonIn.length());
			JsonObject jsonObject = gson.fromJson(jsonIn.toString(), JsonObject.class);
			GOODSNO = jsonObject.get("GOODSNO").getAsString();
			DEALQTY = jsonObject.get("DEALQTY").getAsString();
			ENDSHIPWAY = jsonObject.get("ENDSHIPWAY").getAsString();
			DEALNOTE = jsonObject.get("DEALNOTE").getAsString();
			try {
				DEALIMAGE = jsonObject.get("DEALIMAGE").getAsString();
				image = Base64.getMimeDecoder().decode(DEALIMAGE.split(",")[1]);
			} catch (Exception e) {
				Insert_IMG = false;
			}

		} catch (Exception e1) {
			Ans = "FALSE";
			jiub.setMessage("Json Decode ERROR");
			e1.printStackTrace();
		}
		// String GOODSNO = request.getParameter("GOODSNO");
		// String DEALQTY = request.getParameter("DEALQTY");
		// String ENDSHIPWAY = request.getParameter("ENDSHIPWAY");
		// String DEALNOTE = request.getParameter("DEALNOTE");
		// BufferedReader br = request.getReader();
		// StringBuffer jsonIn = new StringBuffer();
		// String line = "";
		// while ((line = br.readLine()) != null) {
		// jsonIn.append(line);
		// }
		// System.out.println("JSON size=" + jsonIn.length());
		// JsonObject jsonObject = gson.fromJson(jsonIn.toString(),
		// JsonObject.class);
		// String GOODSNO = jsonObject.get("GOODSNO").getAsString();
		// String DEALQTY = jsonObject.get("DEALQTY").getAsString();
		// String ENDSHIPWAY = jsonObject.get("ENDSHIPWAY").getAsString();
		// String DEALNOTE = jsonObject.get("DEALNOTE").getAsString();
		// String transImg = jsonObject.get("DEALIMAGE").getAsString();
		// byte[] image =
		// Base64.getMimeDecoder().decode(transImg.split(",")[1]);
		// System.out.println("GOODSNO=" + GOODSNO);
		// System.out.println("DEALQTY=" + DEALQTY);
		// System.out.println("ENDSHIPWAY=" + ENDSHIPWAY);
		// System.out.println("transImg_size=" + image.length);

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
			String SQLAns;
			if (Insert_IMG) {
				SQLAns = new DealDAO().Insert_DEAL(Integer.parseInt(GOODSNO), INDID, Integer.parseInt(DEALQTY),
						Integer.parseInt(ENDSHIPWAY), DEALNOTE, new ByteArrayInputStream(image), image.length);
			} else {
				SQLAns = new DealDAO().Insert_DEAL(Integer.parseInt(GOODSNO), INDID, Integer.parseInt(DEALQTY),
						Integer.parseInt(ENDSHIPWAY), DEALNOTE, null, 0L);
			}

			System.out.println("ans=" + SQLAns);
			if (!SQLAns.equals("TRUE")) {
				Ans = "FALSE";
				jiub.setMessage("SQL ERROR");
			}
		}
		jiub.setType(Type);
		jiub.setAns(Ans);
		String jiub_json = gson.toJson(jiub);
		System.out.println(jiub_json);
		response.setContentType("application/json; charset=UTF8");
		try (PrintWriter out = response.getWriter();) {
			out.print(jiub_json);
		}
		return;
	}
}
