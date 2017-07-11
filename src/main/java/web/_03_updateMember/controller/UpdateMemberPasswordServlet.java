package web._03_updateMember.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import web._00_init.GlobalService;
import web._01_register.model.MemberBean;
import web._01_register.model.RegisterServiceDAO;
import web._01_register.model.RegisterServiceDAO_JDBC;
import web._02_login.model.LoginServiceDB;
import web._03_updateMember.model.JSON_In_Up_Bean;
import web._03_updateMember.model.MB_ORG_ErrorBean;

@WebServlet("/web/_03_updateMember/controller/updateMemberPassword")
public class UpdateMemberPasswordServlet extends HttpServlet {
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
		request.setCharacterEncoding("UTF-8");
		String INDID = "";
		String Type = "UPDATE";
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
		MB_ORG_ErrorBean moeb = new MB_ORG_ErrorBean();
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		String checknewpassword = request.getParameter("checknewpassword");
		if (Ans.equals("TRUE")) {
			if (oldpassword == null || oldpassword.trim().length() == 0) {
				moeb.setErroroldPassword("該欄位不為空值");
				Ans = "FALSE";
			}
			if (newpassword == null || newpassword.trim().length() == 0) {
				moeb.setErrornewPassword("該欄位不為空值");
				Ans = "FALSE";
			}
			if (checknewpassword == null || checknewpassword.trim().length() == 0) {
				moeb.setChecknewPassword("該欄位不為空值");
				Ans = "FALSE";
			}
			if (!Ans.equals("TRUE")) {
				jiub.setMoeb(moeb);
			}

		}
		if (Ans.equals("TRUE")) {
			if (!newpassword.equals(checknewpassword)) {
				moeb.setChecknewPassword("密碼欄必須與確認欄一致");
				Ans = "FALSE";
			}
		}
		if (Ans.equals("TRUE")) {
			try {
				LoginServiceDB lsdb;
				lsdb = new LoginServiceDB();

				oldpassword = GlobalService.getMD5Endocing(GlobalService.encryptString(oldpassword));
				newpassword = GlobalService.getMD5Endocing(GlobalService.encryptString(newpassword));
				System.out.println("password=" + oldpassword);
				System.out.println("newpassword=" + newpassword);
				MemberBean mb = lsdb.checkPassword(INDID, oldpassword);
				RegisterServiceDAO rs = new RegisterServiceDAO_JDBC();
				if (mb != null) {
					int n = rs.updateMemberPassword(mb, newpassword);
					System.out.println("n=" + n + "密碼更新成功");
				} else {
					Ans = "FALSE";
					jiub.setMessage("change not success");
				}
			} catch (Exception e) {
				e.printStackTrace();
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
