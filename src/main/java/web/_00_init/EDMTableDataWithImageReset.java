package web._00_init;

/*  
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class EDMTableDataWithImageReset {
	public static final String UTF8_BOM = "\uFEFF"; // 定義 UTF-8的BOM字元

	public static void main(String args[]) {
		System.out.println("test");
		Connection con;
		PreparedStatement pstmt;
		PreparedStatement pstmt1;
		Statement stmt;
		String dropString;
		String createString;
		String line = "";
		String sql = "";
		String sql1 = "";
		String encrypedString = "";
		try {
			// 連上後端的資料庫
			con = DriverManager.getConnection(GlobalService.DB_URLMySQL, GlobalService.USERID, GlobalService.PASSWORD);
			// 建立Statement物件，以便傳送SQL命令到後端的資料庫
			stmt = con.createStatement();

		} catch (SQLException e) {
			System.err.println("存取資料庫有關的例外：" + e.getMessage());
			e.printStackTrace();
			return;
		}
		// 定義刪除ind表格的SQL命令
		dropString = "DROP Table ind ";
		try {
			// 執行刪除ind表格的SQL命令
			stmt.executeUpdate(dropString);
			// 印出執行成功的訊息
			System.out.println("ind表格刪除成功");
		} catch (SQLException e) {
			System.err.println("刪除ind表格時發生例外: " + e.getMessage());
		}
		// 定義新建ind表格的SQL命令 NOT NULL Auto_Increment Primary Key
		createString = "Create Table ind " + "(usertype 	int, "
				+ " postdate		timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, "
				+ " indid    	varchar(50) NOT NULL Primary Key, " + " indpassword	varchar(50) NOT NULL, "
				+ " indname 		varchar(20) NOT NULL, " + " indphone 	varchar(10), "
				+ " indemail  	varchar(50), " + " indaddress	varchar(100), " + " indimage   	MEDIUMBLOB, "
				+ " indfilename  varchar(20) " + " ) CHARACTER SET utf8 COLLATE utf8_general_ci";
		try {
			// 執行新建ind表格的SQL命令
			stmt.executeUpdate(createString);
			// 印出執行成功的訊息
			System.out.println("ind表格產生成功");
			// 對ind表格新增三筆測試用紀錄
			sql1 = "insert into ind " + " (userType, postDate, indId, indPassword, indName, indPhone, indEmail, "
					+ " indAddress, indImage, indFileName) " + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt1 = con.prepareStatement(sql1);
			// Statement pstmt2 = con.createStatement();
			pstmt1.setInt(1, 1);
			java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
			pstmt1.setTimestamp(2, now);
			pstmt1.setString(3, "kitty");
			encrypedString = GlobalService.encryptString("123");
			pstmt1.setString(4, GlobalService.getMD5Endocing(encrypedString)); // 密碼都是
																				// 123
			pstmt1.setString(5, "凱蒂");
			pstmt1.setString(6, "0229625270");
			pstmt1.setString(7, "kitty@gmail.com");
			pstmt1.setString(8, "新北市板橋區中正路100號");
			// 讀取要寫入表格的圖片檔
			File imageFile = new File(
					"C:\\_JSP\\workspace\\weshare\\src\\main\\webapp\\images\\kittyabcde12345678901234567890.jpg");
			// File imageFile = new
			// File("webapps/images/kittyabcde12345678901234567890.jpg");
			long size = imageFile.length();
			InputStream is = new FileInputStream(imageFile);
			// 設定Image欄位
			pstmt1.setBlob(9, is, size);
			// 設定fileName欄位
			String fileName = imageFile.getName();
			// 調整檔名的字元數
			fileName = GlobalService.adjustFileName(fileName, GlobalService.IMAGE_FILENAME_LENGTH);
			pstmt1.setString(10, fileName);
			pstmt1.executeUpdate();

			// ......................
			// 印出資料新增成功的訊息
			System.out.println("ind 資料新增成功");
		} catch (SQLException e) {
			System.err.println("新建ind表格時發生例外: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("新建ind表格時發生IO例外: " + e.getMessage());
		}

		// 定義刪除org表格的SQL命令
		dropString = "DROP Table org ";
		try {
			// 執行刪除org表格的SQL命令
			stmt.executeUpdate(dropString);
			// 印出執行成功的訊息
			System.out.println("org表格刪除成功");
		} catch (SQLException e) {
			System.err.println("刪除org表格時發生例外: " + e.getMessage());
		}
		// 定義新建org表格的SQL命令 NOT NULL Auto_Increment Primary Key
		createString = "Create Table org " + "(indid 		varchar(50) NOT NULL, "
				+ " updatetime	timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, "
				+ " intro    	varchar(500) NOT NULL, " + " leader		varchar(500) NOT NULL, "
				+ " orgtypes 	varchar(500) NOT NULL, " + " registerno 	varchar(500), "
				+ " raiseno  	varchar(500), " + " orgimage   	MEDIUMBLOB, " + " orgfilename  varchar(20), "
				+ "FOREIGN KEY(indid) REFERENCES ind (indid)" + " ) CHARACTER SET utf8 COLLATE utf8_general_ci";
		try {
			// 執行新建org表格的SQL命令
			stmt.executeUpdate(createString);
			// 印出執行成功的訊息
			System.out.println("org表格產生成功");

		} catch (SQLException e) {
			System.err.println("新建org表格時發生例外: " + e.getMessage());
			e.printStackTrace();
		}

		// 定義刪除goods表格的SQL命令
		dropString = "DROP Table goods ";
		try {
			// 執行刪除goods表格的SQL命令
			stmt.executeUpdate(dropString);
			// 印出執行成功的訊息
			System.out.println("goods表格刪除成功");
		} catch (SQLException e) {
			System.err.println("刪除goods表格時發生例外: " + e.getMessage());
		}
		// 定義新建goods表格的SQL命令 NOT NULL Auto_Increment Primary Key
		createString = "Create Table goods " + "(goodsno 	int(7) NOT NULL Auto_Increment Primary Key, "
				+ " goodsstatus 	int(1), "
				+ " updatetime	timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, "
				+ " indid    	varchar(50) NOT NULL, " + " goodstypes	varchar(10) , " + " goodsname 	varchar(10) , "
				+ " goodsloc 	varchar(10), " + " goodsnote  	varchar(200), " + " qty			int(3) UNSIGNED, "
				+ " goodsshipway int(1), " + " deadline 	int(14), " + " goodsimage     MEDIUMBLOB, "
				+ " goodsfilename  varchar(20), " + "FOREIGN KEY(indid) REFERENCES ind (indid)"
				+ " ) CHARACTER SET utf8 COLLATE utf8_general_ci";
		try {
			// 執行新建goods表格的SQL命令
			stmt.executeUpdate(createString);
			// 印出執行成功的訊息
			System.out.println("goods表格產生成功");

		} catch (SQLException e) {
			System.err.println("新建goods表格時發生例外: " + e.getMessage());
			e.printStackTrace();
		}

		// 定義刪除deal表格的SQL命令
		dropString = "DROP Table deal ";
		try {
			// 執行刪除deal表格的SQL命令
			stmt.executeUpdate(dropString);
			// 印出執行成功的訊息
			System.out.println("deal表格刪除成功");
		} catch (SQLException e) {
			System.err.println("刪除deal表格時發生例外: " + e.getMessage());
		}
		// 定義新建deal表格的SQL命令 NOT NULL Auto_Increment Primary Key
		createString = "Create Table deal " + "(dealno 	int(7) NOT NULL Auto_Increment Primary Key, "
				+ " postdate		timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, "
				+ " sourceid    	varchar(50) NOT NULL, " + " endid    	varchar(50) NOT NULL, "
				+ " dealstatus 	int(1), " + " endshipway 	varchar(5), " + " dealqty		int(3) UNSIGNED, "
				+ " shipdate 	int(14), " + " shipno 		int(20), " + " dealimage     MEDIUMBLOB, "
				+ " dealfilename  varchar(20), " + "FOREIGN KEY(sourceid) REFERENCES ind (indid),"
				+ "FOREIGN KEY(endid) REFERENCES ind (indid)" + " ) CHARACTER SET utf8 COLLATE utf8_general_ci";
		try {
			// 執行新建deal表格的SQL命令
			stmt.executeUpdate(createString);
			// 印出執行成功的訊息
			System.out.println("deal表格產生成功");

		} catch (SQLException e) {
			System.err.println("新建deal表格時發生例外: " + e.getMessage());
			e.printStackTrace();
		}

		// 定義刪除feedback表格的SQL命令
		dropString = "DROP Table feedback ";
		try {
			// 執行刪除feedback表格的SQL命令
			stmt.executeUpdate(dropString);
			// 印出執行成功的訊息
			System.out.println("feedback表格刪除成功");
		} catch (SQLException e) {
			System.err.println("刪除feedback表格時發生例外: " + e.getMessage());
		}
		// 定義新建feedback表格的SQL命令 NOT NULL Auto_Increment Primary Key
		createString = "Create Table feedback " + "(dealno 	int(7) NOT NULL, "
				+ " postdate		timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, "
				+ " fbsourceid    	varchar(50) NOT NULL, " + " fbendid    	varchar(50) NOT NULL, "
				+ " fbtext    	varchar(200) NOT NULL, " + " fbscore 	int(2) NOT NULL, " + " fbimage     MEDIUMBLOB, "
				+ " fbfilename  varchar(20), " + "FOREIGN KEY(dealno) REFERENCES deal (dealno),"
				+ "FOREIGN KEY(fbsourceid) REFERENCES ind (indid)," + "FOREIGN KEY(fbendid) REFERENCES ind (indid)"
				+ " ) CHARACTER SET utf8 COLLATE utf8_general_ci";
		try {
			// 執行新建feedback表格的SQL命令
			stmt.executeUpdate(createString);
			// 印出執行成功的訊息
			System.out.println("feedback表格產生成功");

		} catch (SQLException e) {
			System.err.println("新建feedback表格時發生例外: " + e.getMessage());
			e.printStackTrace();
		}

		// 定義刪除msg表格的SQL命令
		dropString = "DROP Table msg ";
		try {
			// 執行刪除msg表格的SQL命令
			stmt.executeUpdate(dropString);
			// 印出執行成功的訊息
			System.out.println("msg表格刪除成功");
		} catch (SQLException e) {
			System.err.println("刪除msg表格時發生例外: " + e.getMessage());
		}
		// 定義新建msg表格的SQL命令 NOT NULL Auto_Increment Primary Key
		createString = "Create Table msg " + "(msgno 	int(7) NOT NULL Auto_Increment Primary Key, "
				+ " msgstatus 	int(2) NOT NULL, " + " postdate		timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, "
				+ " msgsourceid    	varchar(50) NOT NULL, " + " msgendid    	varchar(50) NOT NULL, "
				+ " msgtext    	varchar(200), " + " msgimage     MEDIUMBLOB, " + " msgfilename  varchar(20), "
				+ "FOREIGN KEY(msgsourceid) REFERENCES ind (indid)," + "FOREIGN KEY(msgendid) REFERENCES ind (indid)"
				+ " ) CHARACTER SET utf8 COLLATE utf8_general_ci";
		try {
			// 執行新建msg表格的SQL命令
			stmt.executeUpdate(createString);
			// 印出執行成功的訊息
			System.out.println("msg表格產生成功");

		} catch (SQLException e) {
			System.err.println("新建msg表格時發生例外: " + e.getMessage());
			e.printStackTrace();
		}

	}
}