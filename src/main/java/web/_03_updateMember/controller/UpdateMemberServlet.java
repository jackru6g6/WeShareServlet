package web._03_updateMember.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import web._01_register.model.MemberBean;
import web._01_register.model.OrgBean;
import web._01_register.model.RegisterServiceDAO;
import web._01_register.model.RegisterServiceDAO_JDBC;
import web._03_updateMember.model.JSON_In_Up_Bean;
import web._03_updateMember.model.MB_ORG_ErrorBean;

//@WebServlet("/ch04/ex02/updateMember.do")
//@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
//		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)
// @WebServlet("/updateMember.do")
@WebServlet("/web/_03_updateMember/controller/updateMember")
public class UpdateMemberServlet extends HttpServlet {
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
		Gson gson = new Gson();
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
		String usertype = null;
		String indName = null;
		String indPhone = null;
		String indEmail = null;
		String indAddress = null;
		String intro = null;
		String leader = null;
		String orgtypes = null;
		String registerno = null;
		String raiseno = null;
		String website = null;
		byte[] ind_image = null;
		byte[] org_image = null;
		boolean Insert_ind_IMG = true;
		boolean Insert_org_IMG = true;
		if (Ans.equals("TRUE")) {
			try (BufferedReader br = request.getReader();) {
				StringBuffer jsonIn = new StringBuffer();
				String line = "";
				while ((line = br.readLine()) != null) {
					jsonIn.append(line);
				}
				System.out.println("JSON size=" + jsonIn.length());
				JsonObject jsonObject = gson.fromJson(jsonIn.toString(), JsonObject.class);
				usertype = jsonObject.get("usertype").getAsString();
				if (usertype.equals("2")) {
					intro = jsonObject.get("intro").getAsString();
					leader = jsonObject.get("leader").getAsString();
					orgtypes = jsonObject.get("orgtypes").getAsString();
					registerno = jsonObject.get("registerno").getAsString();
					raiseno = jsonObject.get("raiseno").getAsString();
					website = jsonObject.get("website").getAsString();
				}
				indName = jsonObject.get("indName").getAsString();
				indPhone = jsonObject.get("indPhone").getAsString();
				indEmail = jsonObject.get("indEmail").getAsString();
				indAddress = jsonObject.get("indAddress").getAsString();

				try {
					String indimage = jsonObject.get("indimage").getAsString();
					ind_image = Base64.getMimeDecoder().decode(indimage.split(",")[1]);
				} catch (Exception e) {
					Insert_ind_IMG = false;
				}
				try {
					String indimage = jsonObject.get("orgimage").getAsString();
					org_image = Base64.getMimeDecoder().decode(indimage.split(",")[1]);
				} catch (Exception e) {
					Insert_org_IMG = false;
				}
			} catch (Exception e1) {
				Ans = "FALSE";
				jiub.setMessage("Json Decode ERROR");
				e1.printStackTrace();
			}
		}
		// String usertype = request.getParameter("usertype");
		// String indName = request.getParameter("indName");
		// String indPhone = request.getParameter("indPhone");
		// String indEmail = request.getParameter("indEmail");
		// String indAddress = request.getParameter("indAddress");
		// String intro = request.getParameter("intro");
		// String leader = request.getParameter("leader");
		// String orgtypes = request.getParameter("orgtypes");
		// String registerno = request.getParameter("registerno");
		// String raiseno = request.getParameter("raiseno");
		// String website = request.getParameter("website");
		System.out.println("usertype=" + usertype);
		System.out.println("indName=" + indName);
		System.out.println("indPhone=" + indPhone);
		System.out.println("indEmail=" + indEmail);
		System.out.println("indAddress=" + indAddress);
		System.out.println("intro=" + intro);
		System.out.println("leader=" + leader);
		System.out.println("orgtypes=" + orgtypes);
		System.out.println("registerno=" + registerno);
		System.out.println("raiseno=" + raiseno);
		System.out.println("website=" + website);
		MB_ORG_ErrorBean moeb = new MB_ORG_ErrorBean();
		if (Ans.equals("TRUE")) {
			if (usertype == null || usertype.trim().length() == 0) {
				moeb.setErrUserType("帳號類別錯誤");
				Ans = "FALSE";
			} else {
				if (usertype.equals("2")) {
					if (intro == null || intro.trim().length() == 0) {
						moeb.setErrorIntro("簡介欄必須輸入");
						Ans = "FALSE";
					}
					if (leader == null || leader.trim().length() == 0) {
						moeb.setErrorLeader("負責人欄必須輸入");
						Ans = "FALSE";
					}
					if (orgtypes == null || orgtypes.trim().length() == 0) {
						moeb.setErrorOrgtypes("類型欄必須輸入");
						Ans = "FALSE";
					}
					if (registerno == null || registerno.trim().length() == 0) {
						moeb.setErrorRegisterno("立案核准欄必須輸入");
						Ans = "FALSE";
					}
					if (raiseno == null || raiseno.trim().length() == 0) {
						moeb.setErrorRaiseno("勸募許可欄必須輸入");
						Ans = "FALSE";
					}
					if (website == null || website.trim().length() == 0) {
						moeb.setErrorWebsite("網址必須輸入");
						Ans = "FALSE";
					}
				}
				if (indName == null || indName.trim().length() == 0) {
					moeb.setErrorName("姓名欄必須輸入");
					Ans = "FALSE";
				}
				if (indAddress == null || indAddress.trim().length() == 0) {
					moeb.setErrorAddr("地址欄必須輸入");
					Ans = "FALSE";
				}
				if (indEmail == null || indEmail.trim().length() == 0) {
					moeb.setErrorEmail("電子郵件欄必須輸入");
					Ans = "FALSE";
				}
				if (indPhone == null || indPhone.trim().length() == 0) {
					moeb.setErrorTel("電話號碼欄必須輸入");
					Ans = "FALSE";
				}

			}
			if (!Ans.equals("TRUE")) {
				jiub.setMoeb(moeb);
			}
		}

		if (Ans.equals("TRUE")) {
			try {
				RegisterServiceDAO rs = new RegisterServiceDAO_JDBC();
				if (usertype.equals("1")) {
					int n = 0;
					MemberBean mem = new MemberBean(Integer.parseInt(usertype), INDID, null, indName, indPhone,
							indEmail, indAddress);
					if (Insert_ind_IMG) {
						n = rs.updateMember(mem, new ByteArrayInputStream(ind_image), ind_image.length,
								String.valueOf(new Date().getTime()));
					} else {
						n = rs.updateMember(mem, null, 0L, null);

					}
					// updateMember(MemberBean mb, InputStream is,long
					// size,String filename)
					// int n = rs.updateMember(mem, null, 0L, null);
					if (n != 1) {
						Ans = "FALSE";
					}
				} else if (usertype.equals("2")) {
					MemberBean mem = new MemberBean(Integer.parseInt(usertype), INDID, null, indName, indPhone,
							indEmail, indAddress);
					OrgBean ob = new OrgBean(INDID, intro, leader, Integer.parseInt(orgtypes), registerno, raiseno,
							website);
					// updateOrg(MemberBean mb,OrgBean ob, InputStream is,long
					// size, String filename, InputStream is2,long size2, String
					// filename2)
					int n = 0;
					if (Insert_org_IMG) {
						n = rs.updateOrg(mem, ob, new ByteArrayInputStream(ind_image), ind_image.length,
								String.valueOf(new Date().getTime()), new ByteArrayInputStream(org_image),
								org_image.length, String.valueOf(new Date().getTime()));

					} else {
						n = rs.updateOrg(mem, ob, null, 0L, null, null, 0L, null);

					}

					// n = rs.updateOrg(mem, ob, null, 0L, null, null, 0L,
					// null);
					if (n != 1) {
						Ans = "FALSE";
					}
				} else {
					Ans = "FALSE";
					jiub.setMessage("usertype not found[" + usertype + "]");
				}
			} catch (Exception e) {
				Ans = "FALSE";
				e.printStackTrace();
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
		// 2. 進行必要的資料轉換

		// if (userType == 2) {
		// try {
		// orgtypes = Integer.parseInt(orgtypes0.trim());
		// } catch (NumberFormatException e) {
		// errorMsg.put("errorFormat", "社福類型格式錯誤，應該為整數");
		// }
		// }
		//
		// if (indName == null || indName.trim().length() == 0) {
		// errorMsg.put("errorName", "姓名欄必須輸入");
		// }
		// if (indAddress == null || indAddress.trim().length() == 0) {
		// errorMsg.put("errorAddr", "地址欄必須輸入");
		// }
		// if (indEmail == null || indEmail.trim().length() == 0) {
		// errorMsg.put("errorEmail", "電子郵件欄必須輸入");
		// }
		// if (indPhone == null || indPhone.trim().length() == 0) {
		// errorMsg.put("errorTel", "電話號碼欄必須輸入");
		// }
		//
		// if (userType == 2) {
		// if (intro == null || intro.trim().length() == 0) {
		// errorMsg.put("errorIntro", "簡介欄必須輸入");
		// }
		// if (leader == null || leader.trim().length() == 0) {
		// errorMsg.put("errorLeader", "負責人欄必須輸入");
		// }
		// if (orgtypes0 == null || orgtypes0.trim().length() == 0) {
		// errorMsg.put("errorOrgtypes", "類型欄必須輸入");
		// }
		// if (registerno == null || registerno.trim().length() == 0) {
		// errorMsg.put("errorRegisterno", "立案核准欄必須輸入");
		// }
		// if (raiseno == null || raiseno.trim().length() == 0) {
		// errorMsg.put("errorRaiseno", "勸募許可欄必須輸入");
		// }
		// }
		//
		// } else {
		// errorMsg.put("errTitle", "此表單不是上傳檔案的表單");
		// }
		// // 如果有錯誤
		// if (!errorMsg.isEmpty()) {
		// // 導向原來輸入資料的畫面，這次會顯示錯誤訊息
		//
		// RequestDispatcher rd =
		// request.getRequestDispatcher("/web/test/_03_updateMember/updateMember.jsp");
		// rd.forward(request, response);
		// return;
		// }
		// try {
		// // 4. 進行Business Logic運算
		// // RegisterServiceFile類別的功能：
		// // 1.檢查帳號是否已經存在
		// // 2.儲存會員的資料
		// RegisterServiceDAO rs = new RegisterServiceDAO_JDBC();
		//
		// if (userType == 1) {
		//
		// MemberBean mem = new MemberBean(userType, indId, indPassword,
		// indName, indPhone, indEmail, indAddress);
		//
		// int n = rs.updateMember(mem, is, sizeInBytes, indFileName);
		// if (n == 1) {
		// msgOK.put("InsertOK", "<Font color='red'>新增成功，請開始使用本系統</Font>");
		// response.sendRedirect("FindMemberServlet");
		// return;
		// } else {
		// errorMsg.put("errorIDDup", "新增此筆資料有誤(RegisterServlet)");
		// }
		//
		// } else if (userType == 2) {
		//
		// MemberBean mem = new MemberBean(userType, indId, indPassword,
		// indName, indPhone, indEmail, indAddress);
		// OrgBean ob = new OrgBean(indId, intro, leader, orgtypes, registerno,
		// raiseno);
		//
		// int n = rs.updateOrg(mem, ob, is, sizeInBytes, indFileName, is2,
		// sizeInBytes2, orgFileName);
		// if (n == 1) {
		// msgOK.put("InsertOK", "<Font color='red'>新增成功，請開始使用本系統</Font>");
		// response.sendRedirect("FindMemberServlet");
		// return;
		// } else {
		// errorMsg.put("errorIDDup", "新增此筆資料有誤(RegisterServlet)");
		// }
		// } else {
		// System.out.println("userType錯誤");
		// errorMsg.put("errUserType", "userType錯誤");
		// }
		//
		// // 5.依照 Business Logic 運算結果來挑選適當的畫面
		// if (!errorMsg.isEmpty()) {
		// // 導向原來輸入資料的畫面，這次會顯示錯誤訊息
		// RequestDispatcher rd =
		// request.getRequestDispatcher("/web/test/_03_updateMember/updateMember.jsp");
		// rd.forward(request, response);
		// return;
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// errorMsg.put("errorIDDup", e.getMessage());
		// RequestDispatcher rd =
		// request.getRequestDispatcher("/web/test/_03_updateMember/updateMember.jsp");
		// rd.forward(request, response);
		// }
		//
	}

}
