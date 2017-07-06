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
	static String DROP_TABLE_MSG_ROOM = "DROP TABLE IF EXISTS msg_room";
	static String DROP_TABLE_DEAL = "DROP TABLE IF EXISTS deal";
	static String DROP_TABLE_GOODS = "DROP TABLE IF EXISTS goods";
	static String DROP_TABLE_FEEDBACK = "DROP TABLE IF EXISTS feedback";

	static String DROP_TABLE_GOODSTYPE = "DROP TABLE IF EXISTS goodstype";
	static String DROP_TABLE_LOCAL = "DROP TABLE IF EXISTS local";
	static String DROP_TABLE_ORGTYPE = "DROP TABLE IF EXISTS orgtype";
	static String DROP_FUNCTION_INSERT_DEAL = "DROP FUNCTION IF EXISTS insert_deal";
	static String DROP_FUNCTION_CHECK_ROOMNO = "DROP FUNCTION IF EXISTS check_roomNo";
	static String DROP_FUNCTION_INSERT_MSG = "DROP FUNCTION IF EXISTS insert_MSG";
	static String DROP_PROCEDURE_INSERT_MSG = "DROP PROCEDURE IF EXISTS insert_MSG";
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
			+ "deadline bigint, goodsimage MEDIUMBLOB, goodsfilename varchar(20), FOREIGN KEY(indid) REFERENCES ind (indid),"
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
			+ "endid varchar(50) NOT NULL, " + "dealstatus int(1), " + "endshipway INT(7), "
			+ "dealqty int(3) UNSIGNED, " + "shipdate timestamp ON UPDATE CURRENT_TIMESTAMP, " + "shipno int(20),"
			+ "DEALNOTE VARCHAR(200), " + "dealimage MEDIUMBLOB, " + "dealfilename varchar(20), "
			+ "goodsname varchar(20) NOT NULL," + "goodsimage MEDIUMBLOB," + "goodsimagename varchar(50),"
			+ "goodstype varchar(10) NOT NULL," + "loc INT NOT NULL," + "goodsnote varchar(200),"
			+ "FOREIGN KEY(sourceid) REFERENCES ind (indid), " + "FOREIGN KEY(endid) REFERENCES ind (indid) "
			+ ") CHARACTER SET utf8 COLLATE utf8_general_ci";

	static String CREATE_TABLE_FEEDBACK = "Create Table feedback(" + "dealno int(7) NOT NULL, "
			+ "postdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, " + "fbsourceid varchar(50) NOT NULL, "
			+ "fbendid varchar(50) NOT NULL, " + "fbtext varchar(200) NOT NULL, " + "fbscore int(2) NOT NULL, "
			+ "fbimage MEDIUMBLOB, " + "fbfilename varchar(20), " + "FOREIGN KEY(dealno) REFERENCES deal (dealno), "
			+ "FOREIGN KEY(fbsourceid) REFERENCES ind (indid), " + "FOREIGN KEY(fbendid) REFERENCES ind (indid) "
			+ ") CHARACTER SET utf8 COLLATE utf8_general_ci";

	static String CREATE_TABLE_MSG = "Create Table msg (" + "msgno int(7) NOT NULL Auto_Increment Primary Key, "
			+ "msgstatus int(2) NOT NULL, " + "postdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, "
			+ "msgsourceid varchar(50) NOT NULL, " + "msgendid varchar(50) NOT NULL, " + "msgtext varchar(200), "
			+ "msgimage MEDIUMBLOB, " + "msgfilename varchar(20)," + "roomNo int(7),"
			+ "FOREIGN KEY(msgsourceid) REFERENCES ind (indid), " + "FOREIGN KEY(msgendid) REFERENCES ind (indid),"
			+ "FOREIGN KEY(roomNo) REFERENCES msg_room (roomNo) " + ") CHARACTER SET utf8 COLLATE utf8_general_ci";

	static String CREATE_TABLE_MSG_ROOM = "CREATE TABLE msg_room("
			+ "roomNo int(7) NOT NULL Auto_Increment Primary Key," + "INDID1 VARCHAR(50),"
			+ "INDID2 VARCHAR(50),LASTMSGNO INT(7),FOREIGN KEY(INDID1) REFERENCES ind (indid),FOREIGN KEY(INDID2) REFERENCES ind (indid)"
			+ ") CHARACTER SET utf8 COLLATE utf8_general_ci";

	static String CREATE_FUNCTION_INSERT_DEAL = "CREATE FUNCTION insert_deal(USER_goodsno int,USER_INDID varchar(50),"
			+ "USER_QTY int,USER_ENDSHIPWAY int,USER_DEALNO VARCHAR(200))RETURNS VARCHAR(10)BEGIN DECLARE function_qty INT DEFAULT 0;"
			+ "DECLARE function_goodstypes INT DEFAULT 0;" + "DECLARE function_goodsname VARCHAR(10) DEFAULT '';"
			+ "DECLARE function_goodsloc INT DEFAULT 0;" + "DECLARE function_goodsnote VARCHAR(200) DEFAULT '';"
			+ "DECLARE function_indid VARCHAR(50) DEFAULT '';" + "DECLARE function_goodsimage MEDIUMBLOB;"
			+ "DECLARE result VARCHAR(10) DEFAULT '';"
			+ "SELECT QTY INTO function_qty FROM GOODS WHERE GOODSNO=USER_goodsno;"
			+ "SELECT GOODSNAME INTO function_goodsname FROM GOODS WHERE GOODSNO=USER_goodsno;"
			+ "SELECT GOODSTYPE INTO function_goodstypes FROM GOODS WHERE GOODSNO=USER_goodsno;"
			+ "SELECT GOODSLOC INTO function_goodsloc FROM GOODS WHERE GOODSNO=USER_goodsno;"
			+ "SELECT GOODSNOTE INTO function_goodsnote FROM GOODS WHERE GOODSNO=USER_goodsno;"
			+ "SELECT INDID INTO function_indid FROM GOODS WHERE GOODSNO=USER_goodsno;"
			+ "SELECT GOODSIMAGE INTO function_goodsimage FROM GOODS WHERE GOODSNO=USER_goodsno;"
			+ "IF function_qty >= USER_QTY THEN INSERT INTO DEAL VALUE(NULL,NULL,function_indid,"
			+ "USER_INDID,0,USER_ENDSHIPWAY,USER_QTY,NULL,NULL,USER_DEALNO,NULL,NULL,function_goodsname,"
			+ "function_goodsimage,CONCAT(USER_goodsno,CONCAT('_',UNIX_TIMESTAMP(NOW()))),function_goodstypes,"
			+ "function_goodsloc,function_goodsnote);"
			+ "UPDATE goods SET qty=(qty-USER_QTY) WHERE GOODSNO=USER_goodsno;SET result = 'OK';ELSE SET result = 'FLASE';"
			+ "END IF;RETURN result;END;";

	static String CREATE_FUNCTION_CHECK_ROOMNO = "CREATE FUNCTION check_roomNo(function_indid1 varchar(50),function_indid2 varchar(50))RETURNS int(7) BEGIN "
			+ "DECLARE result int(7) DEFAULT 0;DECLARE ans int(7) DEFAULT 0;"
			+ "SELECT COUNT(roomNo) INTO ans FROM MSG_ROOM WHERE (INDID1 = function_indid1 AND INDID2 = function_indid2)OR(INDID1 = function_indid2 AND INDID2 = function_indid1);"
			+ "IF ans = 0 THEN INSERT INTO msg_room VALUE(null,function_indid1,function_indid2,null);"
			+ "SELECT roomNo INTO result FROM MSG_ROOM WHERE (INDID1 = function_indid1 AND INDID2 = function_indid2)OR(INDID1 = function_indid2 AND INDID2 = function_indid1); ELSE "
			+ "SELECT roomNo INTO result FROM MSG_ROOM WHERE (INDID1 = function_indid1 AND INDID2 = function_indid2)OR(INDID1 = function_indid2 AND INDID2 = function_indid1); END IF;"
			+ "RETURN result;END;";

	static String CREATE_FUNCTION_INSERT_MSG = "CREATE FUNCTION insert_MSG(USER_MSGSOURCEID VARCHAR(50),USER_MSGENDID VARCHAR(50),USER_MSGTEXT VARCHAR(200),USER_MSGIMAGE MEDIUMBLOB,USER_MSGIMAGEFILENAME VARCHAR(50))"
			+ "RETURNS VARCHAR(10) BEGIN DECLARE result VARCHAR(10) DEFAULT '';INSERT INTO MSG VALUE(null,'2',null,USER_MSGSOURCEID,USER_MSGENDID,USER_MSGTEXT,USER_MSGIMAGE,USER_MSGIMAGEFILENAME,"
			+ "check_roomNo(USER_MSGSOURCEID,USER_MSGENDID));SET result = 'TRUE';UPDATE MSG_ROOM SET LASTMSGNO=LAST_INSERT_ID() WHERE ROOMNO = check_roomNo(USER_MSGSOURCEID,USER_MSGENDID);RETURN result;END;";
	static String CREATE_PROCEDURE_INSERT_MSG = "CREATE PROCEDURE insert_MSG(IN USER_MSGSOURCEID VARCHAR(50),IN USER_MSGENDID VARCHAR(50),IN USER_MSGTEXT VARCHAR(200),IN USER_MSGIMAGE MEDIUMBLOB,IN USER_MSGIMAGEFILENAME VARCHAR(50))"
			+ "BEGIN INSERT INTO MSG VALUE(null,'2',null,USER_MSGSOURCEID,USER_MSGENDID,USER_MSGTEXT,USER_MSGIMAGE,USER_MSGIMAGEFILENAME,check_roomNo(USER_MSGSOURCEID,USER_MSGENDID));"
			+ "UPDATE MSG_ROOM SET LASTMSGNO=LAST_INSERT_ID() WHERE ROOMNO = check_roomNo(USER_MSGSOURCEID,USER_MSGENDID);END;";
	// -------------------------------------------------------------------------------------<INSERT>
	static String INSERT_TABLE_IND = "INSERT INTO ind VALUE(?,?,?,?,?,?,?,?,?,?)";
	static String INSERT_TABLE_ORG = "INSERT INTO org VALUE(?,?,?,?,?,?,?,?,?)";
	static String INSERT_TABLE_ORGTYPE = "INSERT INTO orgtype VALUE(?,?)";
	static String INSERT_TABLE_LOCAL = "INSERT INTO local VALUE(?,?)";
	static String INSERT_TABLE_GOODSTYPE = "INSERT INTO goodstype VALUE(null,?)";
	static String INSERT_TABLE_GOODS = "INSERT INTO goods VALUE(null,?,null,?,?,?,?,?,?,?,?,null,null)";
	// static String INSERT_TABLE_MSG = "INSERT INTO MSG
	// VALUE(null,2,null,?,?,?,null,?,check_roomNo(?,?))";
	static String CALL_FUNCTION_INSERT_DEAL = "{? = CALL insert_deal(?,?,?,?,?)}";
	static String CALL_FUNCTION_INSERT_MSG = "{? =CALL insert_MSG(?,?,?,?,?)}";

}
