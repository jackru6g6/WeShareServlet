package web._00_init;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import web._01_register.model.JSON_Find_Bean;
import web._01_register.model.MemberBean;
import web._01_register.model.RegisterServiceDAO_JDBC;

@WebServlet("/web/_00_intit/getNameByKey")
public class getNameByKeyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public getNameByKeyServlet() {
		super();
	}

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
		String Type = "FIND";
		String Ans = "TRUE";
		String mfjb_json = "";
		JSON_Find_Bean jiub = new JSON_Find_Bean();
//		try {
//			HttpSession session = request.getSession(false);
//			MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
//			INDID = mb.getIndid();
//			System.out.println("session INDID=" + INDID);
//		} catch (Exception e) {
//			Ans = "FALSE";
//			jiub.setMessage("Session Not Found");
//		}
		Gson gson = new Gson();

		String key = request.getParameter("key");

		if (Ans.equals("TRUE")) {
			if (key == null) {
				Ans = "FALSE";
				jiub.setMessage("key not null");
			}
		}

		if (Ans.equals("TRUE")) {
			try {
				String SQLAns = new RegisterServiceDAO_JDBC().GetNameByKey(key);
				String buf[] = SQLAns.split("\\|");
				if (buf[0].equals("FALSE")) {
					Ans = "FALSE";
					jiub.setMessage("Not Found");
				} else {

					jiub.setMessage(buf[1]);
				}
			} catch (Exception e) {
				Ans = "FALSE";
				jiub.setMessage("SQL ERROR");
				e.printStackTrace();
			}
		}
//		jiub.setType(Type);
//		jiub.setAns(Ans);
		mfjb_json = gson.toJson(jiub);
		System.out.println("mfjb_json" + mfjb_json);
		response.setContentType("application/json; charset=UTF8");
		try (PrintWriter out = response.getWriter();) {
			out.print(mfjb_json);
		}
		return;

	}
}
