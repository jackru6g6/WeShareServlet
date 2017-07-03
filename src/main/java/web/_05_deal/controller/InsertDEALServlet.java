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
import javax.servlet.http.Part;

import web._00_init.GlobalService;
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
		GlobalService.exploreParts(parts, request);
		String GOODSNO = null;
		String DEALQTY = null;
		String GOODSTYPE = null;
		String INDID = "kitty";
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
					}
				} else {
					System.out.println("getContentType !=null");
				}
			}
		}
		System.out.println("GOODSNO=" + GOODSNO);
		System.out.println("DEALQTY=" + DEALQTY);
		System.out.println("GOODSTYPE=" + GOODSTYPE);
		String ans=new DealDAO().Insert_DEAL(Integer.parseInt(GOODSNO), INDID, Integer.parseInt(DEALQTY),Integer.parseInt(GOODSTYPE));

		System.out.println("ans=" + ans);
		if(!ans.equals("TRUE")){
			errorMsg.put("errorans", "交易失敗");
			RequestDispatcher rd = request.getRequestDispatcher("/_05_DEAL/demo_DEAL.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
