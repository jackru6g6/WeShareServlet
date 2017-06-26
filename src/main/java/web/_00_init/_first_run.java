package web._00_init;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import web._01_register.model.MemberBean;
import web._01_register.model.OrgBean;

public class _first_run {

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		try {
			// 連上後端的資料庫
			con = DriverManager.getConnection(GlobalService.DB_URLMySQL, GlobalService.USERID, GlobalService.PASSWORD);
			stmt = con.createStatement();
			DropTable(stmt);
			System.out.println("[初始化]表格刪除成功");
			CreateTable(stmt);
			System.out.println("[初始化]表格新建成功");
			CreateData(con);
			System.out.println("[初始化]資料新建成功");
			System.out.println("[初始化]完成");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}

	}

	public static void DropTable(Statement stmt) throws SQLException {
		stmt.executeUpdate(sql_Common.DROP_TABLE_GOODS);

		stmt.executeUpdate(sql_Common.DROP_TABLE_GOODSTYPE);
		stmt.executeUpdate(sql_Common.DROP_TABLE_LOCAL);

		stmt.executeUpdate(sql_Common.DROP_TABLE_MSG);
		stmt.executeUpdate(sql_Common.DROP_TABLE_FEEDBACK);
		stmt.executeUpdate(sql_Common.DROP_TABLE_DEAL);

		stmt.executeUpdate(sql_Common.DROP_TABLE_ORG);
		stmt.executeUpdate(sql_Common.DROP_TABLE_ORGTYPE);
		stmt.executeUpdate(sql_Common.DROP_TABLE_IND);
	}

	public static void CreateTable(Statement stmt) throws SQLException {
		stmt.executeUpdate(sql_Common.CREATE_TABLE_IND);
		stmt.executeUpdate(sql_Common.CREATE_TABLE_ORGTYPE);
		stmt.executeUpdate(sql_Common.CREATE_TABLE_ORG);
		stmt.executeUpdate(sql_Common.CREATE_TABLE_GOODSTYPE);
		stmt.executeUpdate(sql_Common.CREATE_TABLE_LOCAL);

		stmt.executeUpdate(sql_Common.CREATE_TABLE_GOODS);
		stmt.executeUpdate(sql_Common.CREATE_TABLE_DEAL);
		stmt.executeUpdate(sql_Common.CREATE_TABLE_FEEDBACK);
		stmt.executeUpdate(sql_Common.CREATE_TABLE_MSG);

	}

	public static void CreateData(Connection con) throws SQLException {
		MemberBean mb1 = new MemberBean(1, null, "kitty", "123", "凱蒂", "0229625270", "kitty@gmail.com", "新北市板橋區中正路100號",
				null, null);
		MemberBean mb2 = new MemberBean(2, null, "Google", "123", "谷哥大神", "0229625270", "Google@gmail.com",
				"台北市大安區xxx巷xxxx號", null, null);
		OrgBean ob2 = new OrgBean(mb2.getIndid(), null, "我是社福簡介", "社福負責人", 1, "立案核准", "勸募許可", null, null);
		MemberBean mb3 = new MemberBean(1, null, "micky", "123", "米奇", "0228825252", "micky@gmail.com", "米奇的家", null,
				null);
		ORGTYPE_DATA(con);
		IND_DATA(mb1, con);
		ORG_DATA(mb2, ob2, con);
		IND_DATA(mb3, con);
		LOCAL_DATA(con);
		GOODSTYPE(con);
	}

	public static void IND_DATA(MemberBean mb1, Connection con) throws SQLException {

		PreparedStatement pstmt1 = con.prepareStatement(sql_Common.INSERT_TABLE_IND);
		pstmt1.setInt(1, mb1.getUsertype());
		pstmt1.setTimestamp(2, mb1.getPostdate());
		pstmt1.setString(3, mb1.getIndid());
		pstmt1.setString(4, GlobalService.getMD5Endocing(GlobalService.encryptString(mb1.getIndpassword())));
		pstmt1.setString(5, mb1.getIndname());
		pstmt1.setString(6, mb1.getIndphone());
		pstmt1.setString(7, mb1.getIndemail());
		pstmt1.setString(8, mb1.getIndaddress());
		pstmt1.setBlob(9, mb1.getIndimage());
		pstmt1.setString(10, mb1.getIndfilename());
		pstmt1.executeUpdate();
	}

	public static void ORG_DATA(MemberBean mb2, OrgBean ob2, Connection con) throws SQLException {
		con.setAutoCommit(false);
		PreparedStatement pstmt1 = con.prepareStatement(sql_Common.INSERT_TABLE_IND);
		pstmt1.setInt(1, mb2.getUsertype());
		pstmt1.setTimestamp(2, mb2.getPostdate());
		pstmt1.setString(3, mb2.getIndid());
		pstmt1.setString(4, GlobalService.getMD5Endocing(GlobalService.encryptString(mb2.getIndpassword())));
		pstmt1.setString(5, mb2.getIndname());
		pstmt1.setString(6, mb2.getIndphone());
		pstmt1.setString(7, mb2.getIndemail());
		pstmt1.setString(8, mb2.getIndaddress());
		pstmt1.setBlob(9, mb2.getIndimage());
		pstmt1.setString(10, mb2.getIndfilename());
		pstmt1.executeUpdate();
		PreparedStatement pstmt2 = con.prepareStatement(sql_Common.INSERT_TABLE_ORG);
		pstmt2.setString(1, ob2.getIndid());
		pstmt2.setTimestamp(2, ob2.getUpdatetime());
		pstmt2.setString(3, ob2.getIntro());
		pstmt2.setString(4, ob2.getLeader());
		pstmt2.setInt(5, ob2.getOrgtypes());
		pstmt2.setString(6, ob2.getRegisterno());
		pstmt2.setString(7, ob2.getRaiseno());
		pstmt2.setBlob(8, mb2.getIndimage());
		pstmt2.setString(9, ob2.getOrgfilename());
		pstmt2.executeUpdate();
		con.setAutoCommit(true);
	}

	public static void ORGTYPE_DATA(Connection con) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(sql_Common.INSERT_TABLE_ORGTYPE);
		pstmt.setInt(1, Integer.parseInt("1"));
		pstmt.setString(2, "兒少福利");
		pstmt.executeUpdate();
		pstmt.setInt(1, Integer.parseInt("2"));
		pstmt.setString(2, "偏鄉教育");
		pstmt.executeUpdate();
		pstmt.setInt(1, Integer.parseInt("3"));
		pstmt.setString(2, "老人福利");
		pstmt.executeUpdate();
		pstmt.setInt(1, Integer.parseInt("4"));
		pstmt.setString(2, "身障福利");
		pstmt.executeUpdate();
		pstmt.setInt(1, Integer.parseInt("5"));
		pstmt.setString(2, "其他類型");
		pstmt.executeUpdate();

	};

	public static void LOCAL_DATA(Connection con) throws SQLException {

		try (// java 7.0 提共自動關閉的資源
				BufferedReader bf = new BufferedReader(
						new InputStreamReader(new FileInputStream("src//main//java//web//local.txt"), "UTF8"));) {
			String Read_line = "";

			while ((Read_line = bf.readLine()) != null) {
				String[] sa = Read_line.split("\\|");

				try {
					PreparedStatement pstmt = con.prepareStatement(sql_Common.INSERT_TABLE_LOCAL);
					pstmt.setInt(1, Integer.parseInt(sa[1]));
					pstmt.setString(2, sa[0]);
					pstmt.executeUpdate();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	};

	public static void GOODSTYPE(Connection con) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(sql_Common.INSERT_TABLE_GOODSTYPE);
		pstmt.setString(1, "乾貨食品");
		pstmt.executeUpdate();
		pstmt.setString(1, "服飾配件");
		pstmt.executeUpdate();
		pstmt.setString(1, "生活用品");
		pstmt.executeUpdate();
		pstmt.setString(1, "家電機器");
		pstmt.executeUpdate();
		pstmt.setString(1, "其他類型");
		pstmt.executeUpdate();
	}
}

// MYSQL
//
// DROP DATABASE WESHARE;
// CREATE DATABASE WESHARE;
//
//
