package web._05_deal.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import web._00_init.GlobalService;
import web._01_register.model.MemberBean;
import web._05_deal.model.DealDAO;

@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)
@WebServlet("/web/_05_deal/controller/InsertDEAL.do")
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
		Collection<Part> parts = request.getParts(); // 取出HTTP multipart
														// request內所有的parts
		String INDID = "";
		HttpSession session = request.getSession(false);
		// 紀錄目前請求的RequestURI,以便使用者登入成功後能夠回到原本的畫面
		String requestURI = request.getRequestURI();
		// System.out.println("requestURI=" + requestURI);
		// 如果session物件不存在
		if (session == null || session.isNew()) {
			// 請使用者登入
			response.sendRedirect(response.encodeRedirectURL("/Demo/_02_login/login.jsp"));
			return;
		}
		session.setAttribute("requestURI", requestURI);
		// 此時session物件存在，讀取session物件內的LoginOK
		// 以檢查使用者是否登入。
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		if (mb == null) {
			response.sendRedirect(response.encodeRedirectURL("/Demo/_02_login/login.jsp"));
			return;
		}
		INDID = mb.getIndid();
		System.out.println("session INDID=" + INDID);

		GlobalService.exploreParts(parts, request);
		String GOODSNO = null;
		String DEALQTY = null;
		String GOODSTYPE = null;
		String DEALNOTE = null;
		Map<String, String> errorMsg = new HashMap<String, String>();
		request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息

		if (parts != null) {
			for (Part p : parts) {
				String fldName = p.getName();// 取的鍵值
				String value = request.getParameter(fldName);// 取得值
				if (p.getContentType() == null) {
					if (fldName.equalsIgnoreCase("GOODSNO")) {
						GOODSNO = value;
					} else if (fldName.equalsIgnoreCase("DEALQTY")) {
						DEALQTY = value;
					} else if (fldName.equalsIgnoreCase("GOODSTYPE")) {
						GOODSTYPE = value;
					} else if (fldName.equalsIgnoreCase("DEALNOTE")) {
						DEALNOTE = value;
					}
				} else {
					System.out.println("getContentType !=null");
				}
			}
		}
		if (GOODSNO == null || GOODSNO.trim().length() == 0) {
			errorMsg.put("errorGOODSNO", "物資編號不可空白");
		}
		if (DEALQTY == null || DEALQTY.trim().length() == 0) {
			errorMsg.put("errorDEALQTY", "物資數量不可空白");
		}
		if (!errorMsg.isEmpty()) {
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
			// RequestDispatcher rd =
			// request.getRequestDispatcher("/_05_deal/addDEAL.jsp");

			RequestDispatcher rd = request.getRequestDispatcher("/web/test/_05_deal/addDEAL.jsp");
			rd.forward(request, response);
			return;
		}
		System.out.println("GOODSNO=" + GOODSNO);
		System.out.println("DEALQTY=" + DEALQTY);
		System.out.println("GOODSTYPE=" + GOODSTYPE);
		System.out.println("DEALNOTE=" + DEALNOTE);
		String ans = new DealDAO().Insert_DEAL(Integer.parseInt(GOODSNO), INDID, Integer.parseInt(DEALQTY),
				Integer.parseInt(GOODSTYPE), DEALNOTE);

		System.out.println("ans=" + ans);
		if (ans.equals("TRUE")) {
			response.sendRedirect("FindDEALByKey.do");
			return;
		} else {
			errorMsg.put("errorans", "交易失敗");
//			RequestDispatcher rd = request.getRequestDispatcher("/_05_deal/addDEAL.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("/web/test/_05_deal/addDEAL.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
