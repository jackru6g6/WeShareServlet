package web._00_init;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//本類別會依據傳入的書籍編號(BookID)讀取eBook表格內CoverImage欄位內的圖片，
//然後傳回給提出請求的瀏覽器
@WebServlet("/_00_init/getImage")
public class GetImageFromDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ImageBean ib = new ImageBean();
		InputStream is = null;
		OutputStream os = null;
		String mimeType = "text/jpg";
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		ib = getImage(id, type);
		if (ib.FileName.equals("FALSE")) {
			System.out.println("878787");
			is = getServletContext().getResourceAsStream("/images/user.png");
		} else {
			System.out.println("OK");
			mimeType = getServletContext().getMimeType(ib.FileName);
			is = ib.getIs();
		}
		response.setContentType(mimeType);

		// 設定輸出資料的型態
		// 取得能寫出非文字資料的OutputStream物件
		os = response.getOutputStream();
		int count = 0;
		byte[] bytes = new byte[8192];
		while ((count = is.read(bytes)) != -1) {
			os.write(bytes, 0, count);
		}
		os.close();
		System.out.println("[get_Image]end");

	}

	public ImageBean getImage(String id, String type) {
		ImageBean ib = new ImageBean();
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {

			Context context = new InitialContext();
			// 透過JNDI取得DataSource物件
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/BookDataSQLver");
			conn = ds.getConnection();
			if (type.equals("MEMBER")) {
				pstmt = conn.prepareStatement("SELECT indFileName, indImage from ind where indId = ?");
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();

			} else if (type.equals("ORG")) {
				pstmt = conn.prepareStatement("SELECT orgFileName, orgImage from org where indId = ?");
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
			} else {
				System.out.println("type not found:" + type);
			}
			ib.setFileName("FALSE");
			if (rs.next()) {
				if (rs.getString(1) == "") {
					ib.setFileName("FALSE");

				} else {
					ib.setFileName(rs.getString(1));

				}
				ib.setIs(rs.getBinaryStream(2));
			}
			 conn.close();
			System.out.println("[SQL]Ans=" + ib.getFileName());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		return ib;
	}
}