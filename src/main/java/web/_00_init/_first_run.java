package web._00_init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import web._01_register.model.MemberBean;

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
			e.printStackTrace();
			return;
		}

	}

	public static void DropTable(Statement stmt) throws SQLException {
		stmt.executeUpdate(sql_Common.DROP_TABLE_MSG);
		stmt.executeUpdate(sql_Common.DROP_TABLE_FEEDBACK);
		stmt.executeUpdate(sql_Common.DROP_TABLE_DEAL);
		stmt.executeUpdate(sql_Common.DROP_TABLE_GOODS);
		stmt.executeUpdate(sql_Common.DROP_TABLE_ORG);
		stmt.executeUpdate(sql_Common.DROP_TABLE_IND);
	}

	public static void CreateTable(Statement stmt) throws SQLException {
		stmt.executeUpdate(sql_Common.CREATE_TABLE_IND);
		stmt.executeUpdate(sql_Common.CREATE_TABLE_ORG);
		stmt.executeUpdate(sql_Common.CREATE_TABLE_GOODS);
		stmt.executeUpdate(sql_Common.CREATE_TABLE_DEAL);
		stmt.executeUpdate(sql_Common.DROP_TABLE_FEEDBACK);
		stmt.executeUpdate(sql_Common.CREATE_TABLE_MSG);
	}

	public static void CreateData(Connection con) throws SQLException {
		MemberBean mb1 = new MemberBean(1, null, "kitty", "123", "凱蒂", "0229625270", "kitty@gmail.com", "新北市板橋區中正路100號",
				null, null);
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

		// PreparedStatement pstmt2 =
		// con.prepareStatement(sql_Common.CREATE_TABLE_ORG);
		// PreparedStatement pstmt3 =
		// con.prepareStatement(sql_Common.CREATE_TABLE_GOODS);
		// PreparedStatement pstmt4 =
		// con.prepareStatement(sql_Common.CREATE_TABLE_DEAL);
		// PreparedStatement pstmt5 =
		// con.prepareStatement(sql_Common.DROP_TABLE_FEEDBACK);
		// PreparedStatement pstmt6 =
		// con.prepareStatement(sql_Common.CREATE_TABLE_MSG);
	}

}
