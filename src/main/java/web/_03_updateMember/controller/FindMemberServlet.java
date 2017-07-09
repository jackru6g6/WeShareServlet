package web._03_updateMember.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import web._01_register.model.Main_FOR_JSON_Bean;
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
		String type = request.getParameter("type");
		System.out.println("type="+type);
		String INDID = "";
		HttpSession session = request.getSession(false);
		// 紀錄目前請求的RequestURI,以便使用者登入成功後能夠回到原本的畫面
		String requestURI = request.getRequestURI();
		// System.out.println("requestURI=" + requestURI);
		// 如果session物件不存在
		if (session == null || session.isNew()) {
			// 請使用者登入
			response.sendRedirect(response.encodeRedirectURL("/Demo/_02_login/login.jsp"));
			// response.sendRedirect(response.encodeRedirectURL("/web/test/Demo/_02_login/login.jsp"));

			return;
		}
		session.setAttribute("requestURI", requestURI);
		// 此時session物件存在，讀取session物件內的LoginOK
		// 以檢查使用者是否登入。
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		if (mb == null) {
			response.sendRedirect(response.encodeRedirectURL("/Demo/_02_login/login.jsp"));
			// response.sendRedirect(response.encodeRedirectURL("/web/test/Demo/_02_login/login.jsp"));

			return;
		}
		INDID = mb.getIndid();
		System.out.println("session INDID=" + INDID);
		String pk = INDID;
		Main_FOR_JSON_Bean mfjb = new Main_FOR_JSON_Bean();
		Gson gson = new Gson();
		try {
			RegisterServiceDAO rs = new RegisterServiceDAO_JDBC();
			List<Object> obj = rs.populateMember(pk);
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
				mfjb.setUsertype(mb1.getUsertype());
				mfjb.setPostdate(mb1.getPostdate());
				mfjb.setIndid(mb1.getIndid());
				mfjb.setIndname(mb1.getIndname());
				mfjb.setIndphone(mb1.getIndphone());
				mfjb.setIndemail(mb1.getIndemail());
				mfjb.setIndaddress(mb1.getIndaddress());
				mfjb.setIndfilename(mb1.getIndfilename());

				request.setAttribute("ind", mb1);
			}
			if (ob != null) {
				request.setAttribute("org", ob);
				mfjb.setUpdatetime(ob.getUpdatetime());
				mfjb.setIntro(ob.getIntro());
				mfjb.setLeader(ob.getLeader());
				mfjb.setOrgtypes(ob.getOrgtypes());
				mfjb.setRegisterno(ob.getRegisterno());
				mfjb.setRaiseno(ob.getRaiseno());
				mfjb.setOrgfilename(ob.getOrgfilename());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String mfjb_json = gson.toJson(mfjb);
		if (type == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/web/member_update.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("[type]="+type);
		}
		return;
	}
}
