package web._03_updateMember.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
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
import javax.sql.rowset.serial.SerialBlob;

import web._00_init.GlobalService;
import web._01_register.model.MemberBean;
import web._01_register.model.OrgBean;
import web._01_register.model.RegisterServiceDAO;
import web._01_register.model.RegisterServiceDAO_JDBC;


//import ch04.ex01.model.IMemberDAO;
//import ch04.ex01.model.Member;
//import ch04.ex01.model.MemberJDBC_DAO;

//@WebServlet("/ch04/ex02/updateMember.do")
@MultipartConfig(location = "", 
fileSizeThreshold = 5*1024 * 1024, 
maxFileSize = 1024 * 1024 * 500, 
maxRequestSize = 1024 * 1024 * 500 * 5)
@WebServlet("/updateMember.do")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		HttpSession session = request.getSession();
		
		Map<String, String> errorMsg = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();
		
		 request.setAttribute("MsgMap", errorMsg);  //顯示錯誤訊息
	     session.setAttribute("MsgOK", msgOK);      //顯示正常訊息
	     
	     
	     MemberBean mb= (MemberBean)session.getAttribute("LoginOK");

	     
	     int userType = Integer.valueOf(request.getParameter("usertype"));
	    	//Timestamp postDate;
	    	//Blob indImage;
	    	String indFileName= "";
	    	
	    	String indId= "";
	    	String indPassword= "";
	    	String indPassword2= "";
	    	String indName= "";
	    	String indPhone= "";
	    	String indEmail= "";
	    	String indAddress= "";   
	    	
	    	String intro= "";
	    	String leader= "";
	    	String orgtypes= "";
	    	String registerno= "";
	    	String raiseno= "";
	        
			long sizeInBytes = 0;
			InputStream is = null;
			
			
			Collection<Part> parts = request.getParts(); // 取出HTTP multipart request內所有的parts
			GlobalService.exploreParts(parts, request);
			// 由parts != null來判斷此上傳資料是否為HTTP multipart request
			if (parts != null) {   // 如果這是一個上傳資料的表單				
				for (Part p : parts) {   
					String fldName = p.getName();
					String value = request.getParameter(fldName);
									
					// 1. 讀取使用者輸入資料
					if (p.getContentType() == null) {
						if (fldName.equals("indid")) {
							indId = value;
						} else if (fldName.equals("indpassword")) {
							indPassword = value;
						} else if (fldName.equalsIgnoreCase("indpassword2")) {
							indPassword2 = value;
						} else if (fldName.equalsIgnoreCase("indname")) {
							indName = value;
						} else if (fldName.equalsIgnoreCase("indemail")) {
							indEmail = value;
						} else if (fldName.equalsIgnoreCase("indaddress")) {
							indAddress = value;  
						} else if (fldName.equalsIgnoreCase("indphone")) {
							indPhone = value;
						} else if (fldName.equalsIgnoreCase("intro")) {
							intro = value;  
						}else if (fldName.equalsIgnoreCase("leader")) {
							leader = value;  
						}else if (fldName.equalsIgnoreCase("orgtypes")) {
							orgtypes = value;  
						}else if (fldName.equalsIgnoreCase("registerno")) {
							registerno = value;  
						}else if (fldName.equalsIgnoreCase("raiseno")) {
							raiseno = value;  
						}
					}else {
						indFileName = GlobalService.getFileName(p); // 此為圖片檔的檔名
						indFileName = GlobalService.adjustFileName(indFileName, GlobalService.IMAGE_FILENAME_LENGTH);
						if (indFileName != null && indFileName.trim().length() > 0) {
							sizeInBytes = p.getSize();
							is = p.getInputStream();
						} else {
							// 代表未修改圖片檔
							sizeInBytes = -1; 
						}
					} 

				}
				
				// 2. 進行必要的資料轉換
				
				// 3. 檢查使用者輸入資料

				if (indPassword == null || indPassword.trim().length() == 0) {
					errorMsg.put("errorPasswordEmpty","密碼欄必須輸入");
				}
				if (indPassword2 == null || indPassword2.trim().length() == 0) {
					errorMsg.put("errorPassword2Empty","密碼確認欄必須輸入");
				}
				if (indPassword.trim().length() > 0 && indPassword2.trim().length() > 0){
					if (!indPassword.trim().equals(indPassword2.trim())){
						errorMsg.put("errorPassword2Empty","密碼欄必須與確認欄一致");
						errorMsg.put("errorPasswordEmpty","*");
					}			
				}
				if (indName == null || indName.trim().length() == 0) {
					errorMsg.put("errorName","姓名欄必須輸入");
				}
				if (indAddress == null || indAddress.trim().length() == 0) {
					errorMsg.put("errorAddr","地址欄必須輸入");
				}
				if (indEmail == null || indEmail.trim().length() == 0) {
					errorMsg.put("errorEmail","電子郵件欄必須輸入");
				}
				if (indPhone == null || indPhone.trim().length() == 0) {
					errorMsg.put("errorTel","電話號碼欄必須輸入");
				}
				
				
				
				if(userType==2){
					if (intro == null || intro.trim().length() == 0) {
						errorMsg.put("errorIntro","簡介欄必須輸入");
					}
					if (leader == null || leader.trim().length() == 0) {
						errorMsg.put("errorLeader","負責人欄必須輸入");
					}
					if (orgtypes == null || orgtypes.trim().length() == 0) {
						errorMsg.put("errorOrgtypes","類型欄必須輸入");
					}
					if (registerno == null || registerno.trim().length() == 0) {
						errorMsg.put("errorRegisterno","立案核准欄必須輸入");
					}
					if (raiseno == null || raiseno.trim().length() == 0) {
						errorMsg.put("errorRaiseno","勸募許可欄必須輸入");
					}
				}
				
				
				
			} else {
					errorMsg.put("errTitle", "此表單不是上傳檔案的表單");
			}
				// 如果有錯誤
				if (!errorMsg.isEmpty()) {
					// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
					
					
					RequestDispatcher rd = request.getRequestDispatcher("/_03_updateMember/updateMember.jsp");
					rd.forward(request, response);
					return;
				}
				try {
				// 4. 進行Business Logic運算
				// RegisterServiceFile類別的功能：
				// 1.檢查帳號是否已經存在
				// 2.儲存會員的資料 
				RegisterServiceDAO rs = new RegisterServiceDAO_JDBC();  
//				if (rs.idExists(indId)) {
//					errorMsg.put("errorIDDup","此代號已存在，請換新代號");
//				} else {				
					
					if(userType==1){	
						
							MemberBean mem = new MemberBean(userType,indId,indPassword,indName,
								indPhone,indEmail,indAddress);								
							// 將MemberBean mem立即寫入Database
							
							
//							if ( sizeInBytes != -1 ){
//								byte[] b = new byte[(int)sizeInBytes];
//								is.read(b);
//								Blob blob = new SerialBlob(b);
//								mem.setIndImage(blob);
//							} else {
//								// 準備讀取BookBean物件
//								mem.setIndImage(mb.getIndImage());
//							}
							
							
							int n = rs.updateMember(mem, is, sizeInBytes, indFileName);
							if ( n == 1) {
								msgOK.put("InsertOK","<Font color='red'>新增成功，請開始使用本系統</Font>");
								response.sendRedirect("index.jsp");
								return;
							} else {
								errorMsg.put("errorIDDup","新增此筆資料有誤(RegisterServlet)");
							}
						
					}else if(userType==2){
						
							MemberBean mem = new MemberBean(userType,indId,indPassword,indName,
								indPhone,indEmail,indAddress);	
							OrgBean ob= new OrgBean(indId, intro, leader, orgtypes, registerno, raiseno);
												
							int n = rs.updateOrg(mem,ob,is,sizeInBytes,indFileName);
							if ( n == 1) {
								msgOK.put("InsertOK","<Font color='red'>新增成功，請開始使用本系統</Font>");
								response.sendRedirect("index.jsp");
								return;
							} else {
								errorMsg.put("errorIDDup","新增此筆資料有誤(RegisterServlet)");
							}	
					}else{
						System.out.println("userType錯誤");
						errorMsg.put("errUserType", "userType錯誤");
					}
					
					
					
					
					
					
					

//				}
				// 5.依照 Business Logic 運算結果來挑選適當的畫面
				if (!errorMsg.isEmpty()) {
					// 導向原來輸入資料的畫面，這次會顯示錯誤訊息	
//					RequestDispatcher rd = request.getRequestDispatcher("register.jsp");//   ../index.jsp
					RequestDispatcher rd = request.getRequestDispatcher("/_03_updateMember/updateMember.jsp");
					rd.forward(request, response);
					return;
				}		
			} catch (Exception e) {
				e.printStackTrace();
				errorMsg.put("errorIDDup", e.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("/_03_updateMember/updateMember.jsp");
				rd.forward(request, response);
			}		

				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
		
//		String modify = request.getParameter("finalDecision");
//		String pk = request.getParameter("pk");
		
//		int ipk = Integer.parseInt(pk);
//		IMemberDAO dao = new MemberHBN_DAO();
//		IMemberDAO dao = new MemberJDBC_DAO();
//		int count = 0 ;
//		
//		if (modify.equalsIgnoreCase("DELETE")) {
////			count = dao.deleteMember(ipk);
//			if (count == 1){
//				hsession.setAttribute("modify", "刪除成功");
//			} else {
//				hsession.setAttribute("modify", "刪除時發生異常");
//			}
//			//System.out.println("Delete, count=" + count);
//		} else if (modify.equalsIgnoreCase("UPDATE")) {
//			String userId = request.getParameter("userId");
//			String password = request.getParameter("pswd");
//			String name = request.getParameter("userName");
//			String mail = request.getParameter("eMail");
//			String tel = request.getParameter("tel");
//			String expericnceStr = request.getParameter("experience");
			
			// 2. 進行必要的資料轉換
//			int experience = 0;
//			try {
//				experience = Integer.parseInt(expericnceStr.trim());
//			} catch (NumberFormatException e) {
//				errorMsg.put("experience", "使用Java經驗格式錯誤，應該為整數");
//			}
			// 3. 檢查使用者輸入資料
//			if (userId == null || userId.trim().length() == 0) {
//				errorMsg.put("userId", "帳號欄必須輸入");
//			}
//			if (password == null || password.trim().length() == 0) {
//				errorMsg.put("pswd", "密碼欄必須輸入");
//			}
//			if (name == null || name.trim().length() == 0) {
//				errorMsg.put("userName", "姓名欄必須輸入");
//			}
//			if (mail == null || mail.trim().length() == 0) {
//				errorMsg.put("eMail", "EMail欄必須輸入");
//			}
//			if (tel == null || tel.trim().length() == 0) {
//				errorMsg.put("tel", "電話號碼欄必須輸入");
//			}
//			if (experience < 0) {
//				errorMsg.put("experience", "使用Java經驗應該為正整數或 0 ");
//			}
//			if (!errorMsg.isEmpty()) {
//				RequestDispatcher rd = request.getRequestDispatcher("/ch04/ex02/updateMember.jsp");
//				rd.forward(request, response);
//				return;
//			}
			
//			Member m = new Member(userId, password, name, mail, tel, experience);
//			m.setPk(ipk);
//			count = dao.updateMember(m);

//		if (count == 1){
//				hsession.setAttribute("modify", "修改成功");
//			} else {
//				hsession.setAttribute("modify", "修改時發生異常");
//			}
//		} 		
//		response.sendRedirect(request.getContextPath() + "/ch04/ex02/queryAllMembers.do");
	}	
	
	
}
