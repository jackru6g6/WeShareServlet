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

	static String DROP_TABLE_GOODSTYPE = "DROP TABLE IF EXISTS goodstype";
	static String DROP_TABLE_LOCAL = "DROP TABLE IF EXISTS local";
	static String DROP_TABLE_ORGTYPE = "DROP TABLE IF EXISTS orgtype";
	// -------------------------------------------------------------------------------------<CREATE>
	static String CREATE_TABLE_IND = "Create Table ind(usertype int,"
			+ "postdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP," + "indid varchar(50) NOT NULL Primary Key,"
			+ "indpassword varchar(50) NOT NULL," + "indname varchar(20) NOT NULL," + "indphone varchar(10),"
			+ "indemail varchar(50)," + "indaddress varchar(100)," + "indimage MEDIUMBLOB," + "indfilename varchar(20)"
			+ ") CHARACTER SET utf8 COLLATE utf8_general_ci";

	static String CREATE_TABLE_ORG = "Create Table org (" + "indid varchar(50) NOT NULL, "
			+ "updatetime timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP," + "intro varchar(500) NOT NULL, "
			+ "leader varchar(500) NOT NULL, " + "orgtypes int NOT NULL, " + "registerno varchar(500), "
			+ "raiseno varchar(500), " + "orgimage MEDIUMBLOB, " + "orgfilename varchar(20), "
			+ "FOREIGN KEY(indid) REFERENCES ind (indid), " + "FOREIGN KEY(orgtypes) REFERENCES orgtype (orgno) "
			+ ") CHARACTER SET utf8 COLLATE utf8_general_ci";

	static String CREATE_TABLE_GOODS = "Create Table goods ( goodsno int(7) NOT NULL Auto_Increment Primary Key,"
			+ "goodsstatus int(1),updatetime timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP, "
			+ "indid varchar(50) NOT NULL, goodstype int(7), goodsname varchar(10), "
			+ "goodsloc int(7), goodsnote varchar(200), qty int(3) UNSIGNED, goodsshipway int(1), "
			+ "deadline int(14), goodsimage MEDIUMBLOB, goodsfilename varchar(20), FOREIGN KEY(indid) REFERENCES ind (indid),"
			+ "FOREIGN KEY(goodstype) REFERENCES goodstype (goodstypeno), "
			+ "FOREIGN KEY(goodsloc) REFERENCES local (localno) " + ") CHARACTER SET utf8 COLLATE utf8_general_ci";

	static String CREATE_TABLE_GOODSTYPE = "Create Table goodstype ("
			+ "goodstypeno int(7) NOT NULL Auto_Increment Primary Key, " + "goodsname varchar(50) "
			+ ") CHARACTER SET utf8 COLLATE utf8_general_ci";

	static String CREATE_TABLE_LOCAL = "Create Table local (" + "localno int(7) NOT NULL Auto_Increment Primary Key, "
			+ "localname varchar(50) " + ") CHARACTER SET utf8 COLLATE utf8_general_ci";

	static String CREATE_TABLE_ORGTYPE = "Create Table orgtype (" + "orgno int(7) NOT NULL Auto_Increment Primary Key, "
			+ "orgname varchar(50) " + ") CHARACTER SET utf8 COLLATE utf8_general_ci";

	static String CREATE_TABLE_DEAL = "Create Table deal (" + "dealno int(7) NOT NULL Auto_Increment Primary Key, "
			+ "postdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, " + "sourceid varchar(50) NOT NULL, "
			+ "endid varchar(50) NOT NULL, " + "dealstatus int(1), " + "endshipway varchar(5), "
			+ "dealqty int(3) UNSIGNED, " + "shipdate int(14), " + "shipno int(20), " + "dealimage MEDIUMBLOB, "
			+ "dealfilename varchar(20), " + "goodsname varchar(20) NOT NULL," + "qty int(3) UNSIGNED NOT NULL,"
			+ "goodsimage MEDIUMBLOB," + "goodsimagename varchar(10)," + "goodstype varchar(10) NOT NULL,"
			+ "loc varchar(10) NOT NULL," + "goodsnote varchar(200)," + "FOREIGN KEY(sourceid) REFERENCES ind (indid), "
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
	static String INSERT_TABLE_IND = "INSERT INTO ind VALUE(?,?,?,?,?,?,?,?,?,?)";
	static String INSERT_TABLE_ORG = "INSERT INTO org VALUE(?,?,?,?,?,?,?,?,?)";
	static String INSERT_TABLE_ORGTYPE = "INSERT INTO orgtype VALUE(?,?)";
	static String INSERT_TABLE_LOCAL = "INSERT INTO local VALUE(?,?)";

}
