package web._01_register.controller;

import java.io.IOException;
import java.io.InputStream;
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

import app.user.MemberDAO;
import web._00_init.GlobalService;
import web._01_register.model.MemberBean;
import web._01_register.model.OrgBean;
import web._01_register.model.RegisterServiceDAO;
import web._01_register.model.RegisterServiceDAO_JDBC;
import web._02_login.model.GoogleLoginBean;

//MultipartConfig的屬性說明:
//location: 上傳之表單資料與檔案暫時存放在Server端之路徑，此路徑必須存在。
//fileSizeThreshold: 檔案的大小臨界值，超過此臨界值，上傳檔案會用存放在硬碟，
//否則存放在主記憶體。
//maxFileSize: 上傳單一檔案之長度限制，如果超過此數值，Web Container會丟出例外
//maxRequestSize: 上傳所有檔案之總長度限制，如果超過此數值，Web Container會丟出例外
@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)
@WebServlet("/_01_register/Google_Register.do")
public class OAuthRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OAuthRegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		insert_register(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		insert_register(request, response);

	}

	public void insert_register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession();
		GoogleLoginBean GLB = (GoogleLoginBean) session.getAttribute("FINDGLB");
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		// 註冊成功後將用response.sendRedirect()導向新的畫面，所以需要
		// session物件來存放共用資料。
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsg = new HashMap<String, String>();
		// 準備存放註冊成功之訊息的Map物件
		Map<String, String> msgOK = new HashMap<String, String>();
		Map<String, String> RM = new HashMap<String, String>();
		request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息
		request.setAttribute("RM", RM); // 記錄CHECKBOX按鈕
		session.setAttribute("MsgOK", msgOK); // 顯示正常訊息
		Collection<Part> parts = request.getParts(); // 取出HTTP multipart
		GlobalService.exploreParts(parts, request);
		String fileName = null;
		String ORGINF = null;
		String ORGLEADER = null;
		String ORGTYPES = null;
		String ORGREGISTERNO = null;
		String ORGRAISENO = null;
		String INDIDTYPE = null;
		String INDID = null;
		String INDPASSWORD = null;
		String INDNAME = null;
		Map<String, InputStream> image = new HashMap<String, InputStream>();
		Map<String, Long> imagesize = new HashMap<String, Long>();
		// 由parts != null來判斷此上傳資料是否為HTTP multipart request
		if (parts != null) { // 如果這是一個上傳資料的表單
			for (Part p : parts) {
				String fldName = p.getName();// 取的鍵值
				String value = request.getParameter(fldName);// 取得值
				// 1. 讀取使用者輸入資料
				if (p.getContentType() == null) {
					// ContentType()==null 純文字
					if (fldName.equalsIgnoreCase("INDIDTYPE")) {
						INDIDTYPE = value;
					} else if (fldName.equalsIgnoreCase("ORGINF")) {
						ORGINF = value;
					} else if (fldName.equalsIgnoreCase("ORGLEADER")) {
						ORGLEADER = value;
					} else if (fldName.equalsIgnoreCase("ORGTYPES")) {
						ORGTYPES = value;
					} else if (fldName.equalsIgnoreCase("ORGREGISTERNO")) {
						ORGREGISTERNO = value;
					} else if (fldName.equalsIgnoreCase("ORGRAISENO")) {
						ORGRAISENO = value;
					}

				} else {
					if (fldName.equalsIgnoreCase("ORGIMAGE")) {
						// ContentType()!= 檔案
						fileName = GlobalService.getFileName(p); // 此為圖片檔的檔名
						fileName = GlobalService.adjustFileName(fileName, 20);
						if (fileName != null && fileName.trim().length() > 0) {
							image.put("ORGIMAGE", p.getInputStream());
							imagesize.put("ORGIMAGE", p.getSize());
						}
					} else {
						image.put("ORGIMAGE", null);
						imagesize.put("ORGIMAGE", 0L);
					}

				}
			}
			/*
			 * 檢查使用者必填欄位，符合資料則放入bean
			 ********************************************************/
			if (INDIDTYPE.equals("INDIDTYPE_ORG")) {
				if (ORGINF == null || ORGINF.trim().length() == 0) {
					errorMsg.put("errorORGINF", "機構簡介必須輸入");
				}
				if (ORGLEADER == null || ORGLEADER.trim().length() == 0) {
					errorMsg.put("errorORGLEADER", "機構負責人必須輸入");
				}
				if (ORGTYPES == null || ORGTYPES.trim().length() == 0) {
					errorMsg.put("errorORGTYPES", "機構類型必須輸入");
				}
			}

		} else {
			errorMsg.put("errTitle", "此表單不是上傳檔案的表單");
		}
		int userType = 99;
		if (INDIDTYPE.equals("INDIDTYPE_ORG")) {
			// 記錄按鈕選項INDIDTYPE_ORG
			RM.put("INDIDTYPE_IND", "");
			RM.put("INDIDTYPE_ORG", " checked");
			userType = 2;
			;
		} else {
			// 記錄按鈕選項INDIDTYPE_ORG
			RM.put("INDIDTYPE_IND", " checked");
			RM.put("INDIDTYPE_ORG", "");
			userType = 1;
		}
		System.out.println("USER_ID=" + GLB.getUserId());
		System.out.println("USER_ID=" + GLB.getUserPassword());

		// mb.setORGINF(ORGINF);
		// mb.setORGLEADER(ORGLEADER);
		// mb.setORGTYPES(ORGTYPES);
		// mb.setORGREGISTERNO(ORGREGISTERNO);
		// mb.setORGRAISENO(ORGRAISENO);
		try {
			RegisterServiceDAO rs = new RegisterServiceDAO_JDBC();
			if (rs.idExists(GLB.getUserId())) {
				errorMsg.put("errorIDDup", "此代號已存在，請換新代號");
			} else {

				if (userType == 1) {

					MemberBean mem = new MemberBean(userType, GLB.getUserId(), GLB.getUserPassword(), GLB.getName(),
							null, GLB.getEmail(), null);

					// 將MemberBean mem立即寫入Database
					int n = rs.saveMember(mem, null, 0L, null);
					if (n == 1) {
						msgOK.put("InsertOK", "<Font color='red'>新增成功，請開始使用本系統</Font>");
						response.sendRedirect(contextPath + "/web/index.jsp");
						return;
					} else {
						errorMsg.put("errorIDDup", "新增此筆資料有誤(RegisterServlet)");
					}

				} else if (userType == 2) {

//					MemberBean mem = new MemberBean(userType, GLB.getUserId(), GLB.getUserPassword(), GLB.getName(),
//							null, GLB.getEmail(), null);
//					OrgBean ob = new OrgBean(GLB.getUserId(), ORGINF, ORGLEADER, ORGTYPES, ORGREGISTERNO, ORGRAISENO);
//
//					// 將MemberBean mem立即寫入Database
//					int n = rs.saveOrg(mem, ob, null, 0L, null, null, 0L, null);
//					if (n == 1) {
//						msgOK.put("InsertOK", "<Font color='red'>新增成功，請開始使用本系統</Font>");
//						response.sendRedirect(contextPath + "/web/index.jsp");
//						return;
//					} else {
//						errorMsg.put("errorIDDup", "新增此筆資料有誤(RegisterServlet)");
//					}
				} else {
					System.out.println("userType錯誤");
					errorMsg.put("errUserType", "userType錯誤");
				}
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
