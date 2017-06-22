package web._00_init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class sql_Common {
	Connection con;
	Statement stmt;

	public sql_Common() {
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
	}
	// -------------------------------------------------------------------------------------<DROP>

	static String DROP_TABLE_IND = "DROP TABLE IF EXISTS ind";
	static String DROP_TABLE_ORG = "DROP TABLE IF EXISTS org";
	static String DROP_TABLE_MSG = "DROP TABLE IF EXISTS msg";
	static String DROP_TABLE_DEAL = "DROP TABLE IF EXISTS deal";
	static String DROP_TABLE_GOODS = "DROP TABLE IF EXISTS goods";
	static String DROP_TABLE_FEEDBACK = "DROP TABLE IF EXISTS feedback";
	// -------------------------------------------------------------------------------------<CREATE>
	static String CREATE_TABLE_IND = "Create Table ind(usertype int,"
			+ "postdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP," + "indid varchar(50) NOT NULL Primary Key,"
			+ "indpassword varchar(50) NOT NULL," + "indname varchar(20) NOT NULL," + "indphone varchar(10),"
			+ "indemail varchar(50)," + "indaddress varchar(100)," + "indimage MEDIUMBLOB," + "indfilename varchar(20)"
			+ ") CHARACTER SET utf8 COLLATE utf8_general_ci";

	static String CREATE_TABLE_ORG = "Create Table org (" + "indid varchar(50) NOT NULL, "
			+ "updatetime timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP," + "intro varchar(500) NOT NULL, "
			+ "leader varchar(500) NOT NULL, " + "orgtypes varchar(500) NOT NULL, " + "registerno varchar(500), "
			+ "raiseno varchar(500), " + "orgimage MEDIUMBLOB, " + "orgfilename varchar(20), "
			+ "FOREIGN KEY(indid) REFERENCES ind (indid) " + ") CHARACTER SET utf8 COLLATE utf8_general_ci";

	static String CREATE_TABLE_GOODS = "Create Table goods ( goodsno int(7) NOT NULL Auto_Increment Primary Key,"
			+ "goodsstatus int(1),updatetime timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP, "
			+ "indid varchar(50) NOT NULL, goodstypes varchar(10), goodsname varchar(10), "
			+ "goodsloc varchar(10), goodsnote varchar(200), qty int(3) UNSIGNED, goodsshipway int(1), "
			+ "deadline int(14), goodsimage MEDIUMBLOB, goodsfilename varchar(20), FOREIGN KEY(indid) REFERENCES ind (indid)"
			+ ") CHARACTER SET utf8 COLLATE utf8_general_ci";

	static String CREATE_TABLE_DEAL = "Create Table deal (" + "dealno int(7) NOT NULL Auto_Increment Primary Key, "
			+ "postdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, " + "sourceid varchar(50) NOT NULL, "
			+ "endid varchar(50) NOT NULL, " + "dealstatus int(1), " + "endshipway varchar(5), "
			+ "dealqty int(3) UNSIGNED, " + "shipdate int(14), " + "shipno int(20), " + "dealimage MEDIUMBLOB, "
			+ "dealfilename varchar(20), " + "FOREIGN KEY(sourceid) REFERENCES ind (indid), "
			+ "FOREIGN KEY(endid) REFERENCES ind (indid) " + ") CHARACTER SET utf8 COLLATE utf8_general_ci";

	static String CREATE_TABLE_FEEDBACK = "Create Table feedback(" + "dealno int(7) NOT NULL, "
			+ "postdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, " + "fbsourceid varchar(50) NOT NULL, "
			+ "fbendid varchar(50) NOT NULL, " + "fbtext varchar(200) NOT NULL, " + "fbscore int(2) NOT NULL, "
			+ "fbimage MEDIUMBLOB, " + "fbfilename varchar(20), " + "FOREIGN KEY(dealno) REFERENCES deal (dealno), "
			+ "FOREIGN KEY(fbsourceid) REFERENCES ind (indid), " + "FOREIGN KEY(fbendid) REFERENCES ind (indid) "
			+ ") CHARACTER SET utf8 COLLATE utf8_general_ci";

	static String CREATE_TABLE_MSG = "Create Table msg (" + "msgno int(7) NOT NULL Auto_Increment Primary Key, "
			+ "msgstatus int(2) NOT NULL, " + "postdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, "
			+ "msgsourceid varchar(50) NOT NULL, " + "msgendid varchar(50) NOT NULL, " + "msgtext varchar(200), "
			+ "msgimage MEDIUMBLOB, " + "msgfilename varchar(20)," + "FOREIGN KEY(msgsourceid) REFERENCES ind (indid), "
			+ "FOREIGN KEY(msgendid) REFERENCES ind (indid) " + ") CHARACTER SET utf8 COLLATE utf8_general_ci";

	// -------------------------------------------------------------------------------------<INSERT>
	static String INSERT_TABLE_IND = "INSERT INTO ind values(?,?,?,?,?,?,?,?,?,?)";
}
