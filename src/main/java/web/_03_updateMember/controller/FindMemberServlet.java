package web._03_updateMember.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import web._01_register.model.JSON_Find_Bean;
import web._01_register.model.MemberBean;
import web._01_register.model.OrgBean;
import web._01_register.model.RegisterServiceDAO;
import web._01_register.model.RegisterServiceDAO_JDBC;

@WebServlet("/web/_03_updateMember/controller/FindMemberServlet")
// @WebServlet("/FindMemberServlet")
// @WebServlet("/ch04/ex02/FindMemberServlet")
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
		if (Ans.equals("TRUE")) {
			try {
				RegisterServiceDAO rs = new RegisterServiceDAO_JDBC();
				List<Object> obj = rs.populateMember(INDID);
				Iterator<Object> it = obj.iterator();
				MemberBean mb1 = null;
				OrgBean ob = null;
				while (it.hasNext()) {
					Object object = it.next();
					if (object instanceof MemberBean) {
						mb1 = (MemberBean) object;
					} else if (object instanceof OrgBean) {
						ob = (OrgBean) object;
					} else {
						System.out.println("obj轉型失敗");
					}
				}
				if (mb1 != null) {

					mfjb.setMb(mb1);
					request.setAttribute("ind", mb1);
				}
				if (ob != null) {
					mfjb.setOb(ob);
					request.setAttribute("org", ob);
				}
			} catch (Exception e) {
				e.printStackTrace();
				Ans = "FALSE";
			}
		} else {

		}
		mfjb.setType(Type);
		mfjb.setAns(Ans);
		mfjb_json = gson.toJson(mfjb);
		System.out.println("mfjb_json" + mfjb_json);
		response.setContentType("application/json; charset=UTF8");
		try (PrintWriter out = response.getWriter();) {
			out.print(mfjb_json);
		}
		return;
	}
}
