package web._07_Feedback.controller;

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
import web._07_Feedback.model.FeedbackBean;
import web._07_Feedback.model.FeedbackDAO;
import web._07_Feedback.model.Feedback_ErrorBean;
import web._07_Feedback.model.JSON_In_Up_Bean;

@WebServlet("/web/_07_Feedback/controller/InsertFeedback")
public class InsertFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertFeedbackServlet() {
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
		String DEALNO = request.getParameter("DEALNO");
		String FBSOURCEID = request.getParameter("FBSOURCEID");
		String FBENDID = request.getParameter("FBENDID");
		String FBTEXT = request.getParameter("FBTEXT");
		String FBSCORE = request.getParameter("FBSCORE");
		// System.out.println("DEALNO=" + DEALNO);
		// System.out.println("FBSOURCEID=" + FBSOURCEID);
		// System.out.println("FBENDID=" + FBENDID);
		// System.out.println("FBTEXT=" + FBTEXT);
		// System.out.println("FBSCORE=" + FBSCORE);
		Feedback_ErrorBean fdbe = new Feedback_ErrorBean();
		if (Ans.equals("TRUE")) {
			if (DEALNO == null || DEALNO.trim().length() == 0) {
				fdbe.setERRORDEALNO("物資編號不可為空值");
				Ans = "FALSE";
			}
			if (FBSOURCEID == null || FBSOURCEID.trim().length() == 0) {
				fdbe.setERRORFBSOURCEID("給評者不可為空值");
				Ans = "FALSE";
			}
			if (FBENDID == null || FBENDID.trim().length() == 0) {
				fdbe.setERRORFBENDID("被評者不可為空值");
				Ans = "FALSE";
			}
			if (FBSCORE == null || FBSCORE.trim().length() == 0) {
				fdbe.setERRORFBSCORE("評價分數不可為空值");
				Ans = "FALSE";
			}
			if (!Ans.equals("TRUE")) {
				jiub.setFdbeb(fdbe);
			}
		}
		if (Ans.equals("TRUE")) {

			FeedbackBean fb = new FeedbackBean(DEALNO, null, FBSOURCEID, FBENDID, FBTEXT, Integer.parseInt(FBSCORE),
					null, null);
			String SQLAns = new FeedbackDAO().Insert_FB(fb, INDID, null, 0L);
			System.out.println("SQLAns=" + SQLAns);
			String buf[] = SQLAns.split("\\|");
			if (!buf[0].equals("TRUE")) {
				Ans = "FALSE";
				jiub.setMessage(buf[1]);
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
