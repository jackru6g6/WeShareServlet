package web._04_productMaintain.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
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
import web._04_productMaintain.model.GoodsBean;
import web._04_productMaintain.model.GoodsServiceDAO;
import web._04_productMaintain.model.GoodsServiceDAO_JDBC;

@WebServlet("/web/_04_productMaintain/controller/GoodsInsert.do")
@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024 * 1024 * 500 * 5)
public class GoodsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> errorMsgs = new HashMap<String, String>();
		Map<String, String> successMsgs = new HashMap<String, String>();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		request.setAttribute("ErrMsg", errorMsgs);
		session.setAttribute("successMsg", successMsgs);
		try {
			String goodsno0 = "";
			String goodsstatus0 = ""; 
//			Timestamp updatetime;	
			String indid = "";
			String goodstype0  = "";
			String goodsname = "";
			String goodsloc0 = "";
			String goodsnote = "";
			String qty0 = "";
			String goodsshipway0 = "";
			String deadline0  = "";	
//			Blob goodsimage;				
			
			int goodsno = 0;
			int goodsstatus = 0;//(0:NULL 1:募資 2:捐贈 3:以物易物) 
			int goodstype = 0;//物品類別
			int goodsloc = 0;//需求地區
			int qty = 0;
			int goodsshipway = 0;//1.面交  2.物流  3.都可
			long deadline = 0;	//0:結束 1:募完為止   yyyy-MM-dd

			String goodsfilename = "";
			long sizeInBytes = 0;
			InputStream is = null;
			
			Collection<Part> parts = request.getParts();
			GlobalService.exploreParts(parts, request);

			// 由parts != null來判斷此上傳資料是否為HTTP multipart request
			if (parts != null) {   // 如果這是一個上傳資料的表單				
				for (Part p : parts) {
					String fldName = p.getName();
					String value = request.getParameter(fldName);
					
					// 1. 讀取使用者輸入資料
					if (p.getContentType() == null) {
						if (fldName.equalsIgnoreCase("goodsno")) {
							goodsno0 = value;
							goodsno0 = goodsno0.trim();
							if (goodsno0 == null
									|| goodsno0.trim().length() == 0) {
								errorMsgs.put("errgoodsno", "必須輸入物資編號");
							} else {
								try {// 2. 進行必要的資料轉換
									goodsno = Integer.parseInt(goodsno0.trim());
								} catch (NumberFormatException e) {
									errorMsgs.put("errgoodsno", "物資編號必須是數值");
								}
							}
							request.setAttribute("goodsno", goodsno0);	
							
						} else if (fldName.equalsIgnoreCase("goodsstatus")) {
							goodsstatus0 = value;
							goodsstatus0 = goodsstatus0.trim();
							if (goodsstatus0 == null
									|| goodsstatus0.trim().length() == 0) {
								errorMsgs.put("errgoodsstatus", "必須輸入需求類別");
							} else {
								try {// 2. 進行必要的資料轉換
									goodsstatus = Integer.parseInt(goodsstatus0.trim());
								} catch (NumberFormatException e) {
									errorMsgs.put("errgoodsstatus", "需求類別必須是數值");
								}
							}
							request.setAttribute("goodsstatus", goodsstatus0);	
							
						} else if (fldName.equalsIgnoreCase("indid")) {
							indid = value;
							if (indid == null || indid.trim().length() == 0) {
								errorMsgs.put("errindid", "必須輸入會員帳號");
							} else {
								request.setAttribute("indid", indid);
							}
						} else if (fldName.equalsIgnoreCase("goodstype")) {
							goodstype0 = value;
							goodstype0 = goodstype0.trim();
							if (goodstype0 == null
									|| goodstype0.trim().length() == 0) {
								errorMsgs.put("errgoodstype", "必須輸入物品類別");
							} else {
								try {// 2. 進行必要的資料轉換
									goodstype = Integer.parseInt(goodstype0.trim());
								} catch (NumberFormatException e) {
									errorMsgs.put("errgoodstype", "物品類別必須是數值");
								}
							}
							request.setAttribute("goodstype", goodstype0);	
							
						} else if (fldName.equalsIgnoreCase("goodsname")) {
							goodsname = value;
							if (goodsname == null || goodsname.trim().length() == 0) {
								errorMsgs.put("errgoodsname", "必須輸入需求名稱");
							} else {
								request.setAttribute("goodsname", goodsname);
							}	
						} else if (fldName.equalsIgnoreCase("goodsloc")) {
							goodsloc0 = value;
							goodsloc0 = goodsloc0.trim();
							if (goodsloc0 == null
									|| goodsloc0.trim().length() == 0) {
								errorMsgs.put("errgoodsloc", "必須輸入需求地區");
							} else {
								try {// 2. 進行必要的資料轉換
									goodsloc = Integer.parseInt(goodsloc0.trim());
								} catch (NumberFormatException e) {
									errorMsgs.put("errgoodsloc", "需求地區必須是數值");
								}
							}
							request.setAttribute("goodsloc", goodsloc0);	
							
						} else if (fldName.equalsIgnoreCase("goodsnote")) {
							goodsnote = value;
							if (goodsnote == null || goodsnote.trim().length() == 0) {
								errorMsgs.put("errgoodsnote", "必須輸入需求說明");
							} else {
								request.setAttribute("goodsnote", goodsnote);
							}
						} else if (fldName.equalsIgnoreCase("qty")) {
							qty0 = value;
							qty0 = qty0.trim();
							if (qty0 == null
									|| qty0.trim().length() == 0) {
								errorMsgs.put("errqty", "必須輸入需求數量");
							} else {
								try {// 2. 進行必要的資料轉換
									qty = Integer.parseInt(qty0.trim());
								} catch (NumberFormatException e) {
									errorMsgs.put("errqty", "需求數量必須是數值");
								}
							}
							request.setAttribute("qty", qty0);							

						} else if (fldName.equalsIgnoreCase("goodsshipway")) {
							goodsshipway0 = value;
							goodsshipway0 = goodsshipway0.trim();
							if (goodsshipway0 == null
									|| goodsshipway0.trim().length() == 0) {
								errorMsgs.put("errgoodsshipway", "必須輸入需求方式");
							} else {
								try {// 2. 進行必要的資料轉換
									goodsshipway = Integer.parseInt(goodsshipway0.trim());
								} catch (NumberFormatException e) {
									errorMsgs.put("errgoodsshipway", "需求方式必須是數值");
								}
							}
							request.setAttribute("goodsshipway", goodsshipway0);							
							
						} else if (fldName.equalsIgnoreCase("deadline")) {
							deadline0 = value;
							deadline0 = deadline0.trim();
							if (deadline0 == null
									|| deadline0.trim().length() == 0) {
								errorMsgs.put("errdeadline", "必須輸入截止時間");
							} else {
								try {// 2. 進行必要的資料轉換
									Date date = new Date();
									DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
									try {
										date = sdf.parse(deadline0);
									} catch (ParseException e) {
										e.printStackTrace();
									}
									deadline = date.getTime();
//									System.out.println("[String_Date]: " + date);
//									System.out.println("[Date_long]: " + deadline);
							
//									deadline = Integer.parseInt(deadline0.trim());
								} catch (NumberFormatException e) {
									errorMsgs.put("errdeadline", "截止時間必須是數值");
								}
							}
							request.setAttribute("deadline", deadline0);
						}

					} else {
						goodsfilename = GlobalService.getFileName(p); // 此為圖片檔的檔名
						goodsfilename = GlobalService.adjustFileName(goodsfilename, GlobalService.IMAGE_FILENAME_LENGTH);
						if (goodsfilename != null && goodsfilename.trim().length() > 0) {
							sizeInBytes = p.getSize();
							is = p.getInputStream();
						} else {
							errorMsgs.put("errPicture", "必須挑選圖片檔");
						}
					}
				}
			} else {
				errorMsgs.put("errTitle", "此表單不是上傳檔案的表單");
			}
			// 如果有錯誤==> 導向原來輸入資料的畫面，這次會顯示錯誤訊息
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/web/test/_04_productMaintain/GoodsInsert.jsp");
				rd.forward(request, response);
				return;
			}
			
			
			
			// 4. 進行Business Logic運算
			GoodsServiceDAO gs = new GoodsServiceDAO_JDBC();
			GoodsBean gb = new GoodsBean(goodsno, goodsstatus, indid, goodstype,
					goodsname, goodsloc, goodsnote, qty, goodsshipway, deadline);
			
			int n = gs.insertGoods(gb, is, sizeInBytes, goodsfilename);
			if ( n == 1) {
				successMsgs.put("InsertOK","<Font color='red'>新增成功，請開始使用本系統</Font>");
				System.out.println("資料新增成功1");
				response.sendRedirect("DisplayPageProducts");
				return;
			} else {
				errorMsgs.put("errorIDDup","新增此筆資料有誤(RegisterServlet)");
			}			
			
			successMsgs.put("success", "資料新增成功");
			System.out.println("資料新增成功2");
			response.sendRedirect(response.encodeRedirectURL("/web/test/_04_productMaintain/GoodsInsert.jsp"));
			return;
			
			// 5.依照 Business Logic 運算結果來挑選適當的畫面	
		} catch (Exception e) {
			e.printStackTrace();
			errorMsgs.put("Exception", e.getMessage());
			RequestDispatcher rd = request
					.getRequestDispatcher("/web/test/_04_productMaintain/GoodsInsert.jsp");
			rd.forward(request, response);
		}
	}

	public String getFileName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}
	public void exploreParts(Collection<Part> parts, HttpServletRequest req){
		try {
			for (Part part: parts){
				String name = part.getName();
				String contentType = part.getContentType();
				String value = "";
				long size = part.getSize(); // 上傳資料的大小，即上傳資料的位元組數
				InputStream is =part.getInputStream();
				if (contentType != null) {	// 表示該part為檔案
				   // 取出上傳檔案的檔名
				   String filename = getFileName(part);
				// 將上傳的檔案寫入到location屬性所指定的資料夾
				   part.write(filename);		
				} else {	// 表示該part為一般的欄位
				   // 將上傳的欄位資料寫入到location屬性所指定的資料夾，檔名為"part_"+ name
				   part.write("part_"+ name);	
				   value = req.getParameter(name);    
				}
				System.out.printf("%-15s %-15s %8d  %-20s \n", name, contentType, size, value);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}