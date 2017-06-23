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

	    	String indFileName= "";
	    	String orgFileName= "";//
	    	
	    	String indId= "";
	    	String indPassword= "";
	    	String indPassword2= "";
	    	String indName= "";
	    	String indPhone= "";
	    	String indEmail= "";
	    	String indAddress= "";   
	    	
	    	String intro= "";
	    	String leader= "";
	    	String orgtypes0= "";
	    	int orgtypes= 0;
	    	String registerno= "";
	    	String raiseno= "";
	        
			long sizeInBytes = 0;
			InputStream is = null;
			long sizeInBytes2 = 0;//
			InputStream is2 = null;//
			
			
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
						} 
//						else if (fldName.equals("indpassword")) {
//							indPassword = value;
//						} 
//						else if (fldName.equalsIgnoreCase("indpassword2")) {
//							indPassword2 = value;
//						} 
						else if (fldName.equalsIgnoreCase("indname")) {
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
							orgtypes0 = value;  
						}else if (fldName.equalsIgnoreCase("registerno")) {
							registerno = value;  
						}else if (fldName.equalsIgnoreCase("raiseno")) {
							raiseno = value;  
						}
					}else {
						
						if (fldName.equalsIgnoreCase("file1")) {
							indFileName = GlobalService.getFileName(p); // 此為圖片檔的檔名
							indFileName = GlobalService.adjustFileName(indFileName, GlobalService.IMAGE_FILENAME_LENGTH);
							if (indFileName != null && indFileName.trim().length() > 0) {
								sizeInBytes = p.getSize();
								is = p.getInputStream();
							} else {
								// 代表會員表格未修改圖片檔
								sizeInBytes = -1; 
							}
						}else if(fldName.equalsIgnoreCase("file2")){
							orgFileName = GlobalService.getFileName(p); // 此為圖片檔的檔名
							orgFileName = GlobalService.adjustFileName(orgFileName, GlobalService.IMAGE_FILENAME_LENGTH);
							if (orgFileName != null && orgFileName.trim().length() > 0) {
								sizeInBytes2 = p.getSize();
								is2 = p.getInputStream();
							} else {
								// 代表社福表格未修改圖片檔
								sizeInBytes2 = -1; 
							}
						}

					} 

				}
				
				// 2. 進行必要的資料轉換
				
				if(userType==2){
					try {
						orgtypes = Integer.parseInt(orgtypes0.trim());
					} catch (NumberFormatException e) {
						errorMsg.put("errorFormat","社福類型格式錯誤，應該為整數");
					}
				}				

				
				// 3. 檢查使用者輸入資料

//				if (indPassword == null || indPassword.trim().length() == 0) {
//					errorMsg.put("errorPasswordEmpty","密碼欄必須輸入");
//				}
//				if (indPassword2 == null || indPassword2.trim().length() == 0) {
//					errorMsg.put("errorPassword2Empty","密碼確認欄必須輸入");
//				}
//				if (indPassword.trim().length() > 0 && indPassword2.trim().length() > 0){
//					if (!indPassword.trim().equals(indPassword2.trim())){
//						errorMsg.put("errorPassword2Empty","密碼欄必須與確認欄一致");
//						errorMsg.put("errorPasswordEmpty","*");
//					}			
//				}
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
					if (orgtypes0 == null || orgtypes0.trim().length() == 0) {
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
			
					
					if(userType==1){	
						
							MemberBean mem = new MemberBean(userType,indId,indPassword,indName,
								indPhone,indEmail,indAddress);								
							
							
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
												
							int n = rs.updateOrg(mem,ob,is,sizeInBytes,indFileName,is2,sizeInBytes2,orgFileName);
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

				// 5.依照 Business Logic 運算結果來挑選適當的畫面
				if (!errorMsg.isEmpty()) {
					// 導向原來輸入資料的畫面，這次會顯示錯誤訊息	
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

	}	
	
	
}
