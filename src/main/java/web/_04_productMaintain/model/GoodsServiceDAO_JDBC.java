package web._04_productMaintain.model;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.naming.*;
import javax.sql.*;

import web._00_init.GlobalService;
import web._00_init.*;
import web._02_login.model.*;

public class GoodsServiceDAO_JDBC implements GoodsServiceDAO,Serializable {
	
	private static final long serialVersionUID = 1L;
	private DataSource ds = null;

	public GoodsServiceDAO_JDBC() throws NamingException, SQLException {
		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
	}	
	
	//取得所有物資資料
	public List<GoodsBean> getGoods() throws SQLException{
		List<GoodsBean> list = new ArrayList<>();
		Connection con = ds.getConnection();
		try {
			String sql = "SELECT g.goodsno, g.goodsstatus, g.updatetime, g.indid, g.goodstype, "
					+ "g.goodsname, g.goodsloc, g.goodsnote, g.qty, g.goodsshipway,g.deadline,"
					+ "g.goodsimage,g.goodsfilename,i.indname,gt.goodsname,l.localname"
					+ " FROM goods g JOIN ind i ON g.indid = i.indid"
					+ " INNER JOIN goodstype gt ON g.goodstype = gt.goodstypeno"
					+ " INNER JOIN LOCAL l ON g.goodsloc = l.localno";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();			
			while (rs.next()) {
				GoodsBean bean = new GoodsBean();
				bean.setGoodsno(rs.getInt(1));
				bean.setGoodsstatus(rs.getInt(2));
				bean.setUpdatetime(rs.getTimestamp(3));
				bean.setIndid(rs.getString(4));
				bean.setGoodstype(rs.getInt(5));
				bean.setGoodsname(rs.getString(6));
				bean.setGoodsloc(rs.getInt(7));
				bean.setGoodsnote(rs.getString(8));
				bean.setQty(rs.getInt(9));
				bean.setGoodsshipway(rs.getInt(10));
				bean.setDeadline(rs.getLong(11));
				bean.setGoodsimage(rs.getBlob(12));
				bean.setGoodsfilename(rs.getString(13));				
				bean.setIndname_TEMP(rs.getString(14));
				bean.setGoodsname_TEMP(rs.getString(15));
				bean.setLocalname_TEMP(rs.getString(16));
				list.add(bean);
		
			}
		} finally {
			con.close();
		}
		return list;
		
	}
	
	//透過需求類別搜尋物資資料
	public List<GoodsBean> getGoodsByGoodsStatus(String goodsstatus)throws SQLException{
		List<GoodsBean> list = new ArrayList<>();
		Connection con = ds.getConnection();
		try {
			String sql = "SELECT g.goodsno, g.goodsstatus, g.updatetime, g.indid, g.goodstype, "
					+ "g.goodsname, g.goodsloc, g.goodsnote, g.qty, g.goodsshipway,g.deadline,"
					+ "g.goodsimage,g.goodsfilename,i.indname,gt.goodsname,l.localname"
					+ " FROM goods g JOIN ind i ON g.indid = i.indid"
					+ " INNER JOIN goodstype gt ON g.goodstype = gt.goodstypeno"
					+ " INNER JOIN LOCAL l ON g.goodsloc = l.localno"
					+ " WHERE goodsstatus = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, goodsstatus);
			ResultSet rs = stmt.executeQuery();			
			while (rs.next()) {
				// 建立一個新的GoodsBean物件
				GoodsBean bean = new GoodsBean();
				// 將此紀錄內的資料放入GoodsBean物件
				bean.setGoodsno(rs.getInt(1));
				bean.setGoodsstatus(rs.getInt(2));
				bean.setUpdatetime(rs.getTimestamp(3));
				bean.setIndid(rs.getString(4));
				bean.setGoodstype(rs.getInt(5));
				bean.setGoodsname(rs.getString(6));
				bean.setGoodsloc(rs.getInt(7));
				bean.setGoodsnote(rs.getString(8));
				bean.setQty(rs.getInt(9));
				bean.setGoodsshipway(rs.getInt(10));
				bean.setDeadline(rs.getLong(11));
				bean.setGoodsimage(rs.getBlob(12));
				bean.setGoodsfilename(rs.getString(13));				
				bean.setIndname_TEMP(rs.getString(14));
				bean.setGoodsname_TEMP(rs.getString(15));
				bean.setLocalname_TEMP(rs.getString(16));
				// 最後將GoodsBean物件放入大的容器內
				list.add(bean);
			
			}
		} finally {
			con.close();
		}
		return list;
		
	}
	
	//透過關鍵字搜尋物資資料
	public List<GoodsBean> getGoodsByKeyword(String keyword) throws SQLException{
		List<GoodsBean> list = new ArrayList<>();
		Connection con = ds.getConnection();
		try {
			String sql = "SELECT g.goodsno, g.goodsstatus, g.updatetime, g.indid, g.goodstype, "
					+ "g.goodsname, g.goodsloc, g.goodsnote, g.qty, g.goodsshipway,g.deadline,"
					+ "g.goodsimage,g.goodsfilename,i.indname,gt.goodsname,l.localname"
					+ " FROM goods g JOIN ind i ON g.indid = i.indid"
					+ " INNER JOIN goodstype gt ON g.goodstype = gt.goodstypeno"
					+ " INNER JOIN LOCAL l ON g.goodsloc = l.localno"
					+ " WHERE g.goodsname like ?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			ResultSet rs = stmt.executeQuery();			
			while (rs.next()) {
				GoodsBean bean = new GoodsBean();
				bean.setGoodsno(rs.getInt(1));
				bean.setGoodsstatus(rs.getInt(2));
				bean.setUpdatetime(rs.getTimestamp(3));
				bean.setIndid(rs.getString(4));
				bean.setGoodstype(rs.getInt(5));
				bean.setGoodsname(rs.getString(6));
				bean.setGoodsloc(rs.getInt(7));
				bean.setGoodsnote(rs.getString(8));
				bean.setQty(rs.getInt(9));
				bean.setGoodsshipway(rs.getInt(10));
				bean.setDeadline(rs.getLong(11));
				bean.setGoodsimage(rs.getBlob(12));
				bean.setGoodsfilename(rs.getString(13));				
				bean.setIndname_TEMP(rs.getString(14));
				bean.setGoodsname_TEMP(rs.getString(15));
				bean.setLocalname_TEMP(rs.getString(16));
				list.add(bean);

			}
		} finally {
			con.close();
		}
		return list;
		
	}
	
	//透過需求地區搜尋物資資料
	public List<GoodsBean> getGoodsByGoodsLoc(String goodsloc) throws SQLException{
		List<GoodsBean> list = new ArrayList<>();
		Connection con = ds.getConnection();
		try {
			String sql = "SELECT g.goodsno, g.goodsstatus, g.updatetime, g.indid, g.goodstype, "
					+ "g.goodsname, g.goodsloc, g.goodsnote, g.qty, g.goodsshipway,g.deadline,"
					+ "g.goodsimage,g.goodsfilename,i.indname,gt.goodsname,l.localname"
					+ " FROM goods g JOIN ind i ON g.indid = i.indid"
					+ " INNER JOIN goodstype gt ON g.goodstype = gt.goodstypeno"
					+ " INNER JOIN LOCAL l ON g.goodsloc = l.localno"
					+ " WHERE g.goodsloc = ?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, goodsloc);
			ResultSet rs = stmt.executeQuery();			
			while (rs.next()) {
				GoodsBean bean = new GoodsBean();
				bean.setGoodsno(rs.getInt(1));
				bean.setGoodsstatus(rs.getInt(2));
				bean.setUpdatetime(rs.getTimestamp(3));
				bean.setIndid(rs.getString(4));
				bean.setGoodstype(rs.getInt(5));
				bean.setGoodsname(rs.getString(6));
				bean.setGoodsloc(rs.getInt(7));
				bean.setGoodsnote(rs.getString(8));
				bean.setQty(rs.getInt(9));
				bean.setGoodsshipway(rs.getInt(10));
				bean.setDeadline(rs.getLong(11));
				bean.setGoodsimage(rs.getBlob(12));
				bean.setGoodsfilename(rs.getString(13));				
				bean.setIndname_TEMP(rs.getString(14));
				bean.setGoodsname_TEMP(rs.getString(15));
				bean.setLocalname_TEMP(rs.getString(16));
				list.add(bean);

			}
		} finally {
			con.close();
		}
		return list;
		
	}
	
	//透過物品類別搜尋物資資料
	public List<GoodsBean> getGoodsByGoodsType(String goodstype) throws SQLException{
		List<GoodsBean> list = new ArrayList<>();
		Connection con = ds.getConnection();
		try {
			String sql = "SELECT g.goodsno, g.goodsstatus, g.updatetime, g.indid, g.goodstype, "
					+ "g.goodsname, g.goodsloc, g.goodsnote, g.qty, g.goodsshipway,g.deadline,"
					+ "g.goodsimage,g.goodsfilename,i.indname,gt.goodsname,l.localname"
					+ " FROM goods g JOIN ind i ON g.indid = i.indid"
					+ " INNER JOIN goodstype gt ON g.goodstype = gt.goodstypeno"
					+ " INNER JOIN LOCAL l ON g.goodsloc = l.localno"
					+ " WHERE g.goodstype = ?";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, goodstype);
			ResultSet rs = stmt.executeQuery();			
			while (rs.next()) {
				GoodsBean bean = new GoodsBean();
				bean.setGoodsno(rs.getInt(1));
				bean.setGoodsstatus(rs.getInt(2));
				bean.setUpdatetime(rs.getTimestamp(3));
				bean.setIndid(rs.getString(4));
				bean.setGoodstype(rs.getInt(5));
				bean.setGoodsname(rs.getString(6));
				bean.setGoodsloc(rs.getInt(7));
				bean.setGoodsnote(rs.getString(8));
				bean.setQty(rs.getInt(9));
				bean.setGoodsshipway(rs.getInt(10));
				bean.setDeadline(rs.getLong(11));
				bean.setGoodsimage(rs.getBlob(12));
				bean.setGoodsfilename(rs.getString(13));				
				bean.setIndname_TEMP(rs.getString(14));
				bean.setGoodsname_TEMP(rs.getString(15));
				bean.setLocalname_TEMP(rs.getString(16));
				list.add(bean);

			}
		} finally {
			con.close();
		}
		return list;
	}
	
	//透過帳號型態搜尋物資資料
	public List<GoodsBean> getGoodsByUserType(int usertype) throws SQLException{
		List<GoodsBean> list = new ArrayList<>();
		Connection con = ds.getConnection();
		try {
			String sql = "SELECT g.goodsno, g.goodsstatus, g.updatetime, g.indid, g.goodstype, "
					+ "g.goodsname, g.goodsloc, g.goodsnote, g.qty, g.goodsshipway,g.deadline,"
					+ "g.goodsimage,g.goodsfilename,i.indname,gt.goodsname,l.localname"
					+ " FROM goods g JOIN ind i ON g.indid = i.indid"
					+ " INNER JOIN goodstype gt ON g.goodstype = gt.goodstypeno"
					+ " INNER JOIN LOCAL l ON g.goodsloc = l.localno"
					+ " WHERE g.indid = i.indid and i.usertype = ?";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, usertype);
			ResultSet rs = stmt.executeQuery();			
			while (rs.next()) {
				GoodsBean bean = new GoodsBean();
				bean.setGoodsno(rs.getInt(1));
				bean.setGoodsstatus(rs.getInt(2));
				bean.setUpdatetime(rs.getTimestamp(3));
				bean.setIndid(rs.getString(4));
				bean.setGoodstype(rs.getInt(5));
				bean.setGoodsname(rs.getString(6));
				bean.setGoodsloc(rs.getInt(7));
				bean.setGoodsnote(rs.getString(8));
				bean.setQty(rs.getInt(9));
				bean.setGoodsshipway(rs.getInt(10));
				bean.setDeadline(rs.getLong(11));
				bean.setGoodsimage(rs.getBlob(12));
				bean.setGoodsfilename(rs.getString(13));				
				bean.setIndname_TEMP(rs.getString(14));
				bean.setGoodsname_TEMP(rs.getString(15));
				bean.setLocalname_TEMP(rs.getString(16));
				list.add(bean);

			}
		} finally {
			con.close();
		}
		return list;
	}
	
	
	
	
	
	
	
	//利用會員帳號(indid) + 截止日之前 ==> 找到該會員現存的所有物資箱紀錄
	public List<GoodsBean> getGoodsByIndId(String indid,long now) throws SQLException {
		List<GoodsBean> list = new ArrayList<>();
		Connection con = ds.getConnection();
		try {
			String sql = "Select * from goods where indid = ? and deadline > ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, indid);
			stmt.setLong(2, now);
			ResultSet rs = stmt.executeQuery();			
			while (rs.next()) {
				// 建立一個新的GoodsBean物件
				GoodsBean bean = new GoodsBean();
				// 將此紀錄內的資料放入GoodsBean物件
				bean.setGoodsno(rs.getInt(1));
				bean.setGoodsstatus(rs.getInt(2));
				bean.setUpdatetime(rs.getTimestamp(3));
				bean.setIndid(rs.getString(4));
				bean.setGoodstype(rs.getInt(5));
				bean.setGoodsname(rs.getString(6));
				bean.setGoodsloc(rs.getInt(7));
				bean.setGoodsnote(rs.getString(8));
				bean.setQty(rs.getInt(9));
				bean.setGoodsshipway(rs.getInt(10));
				bean.setDeadline(rs.getLong(11));
				bean.setGoodsimage(rs.getBlob(12));
				bean.setGoodsfilename(rs.getString(13));
				// 最後將GoodsBean物件放入大的容器內
				list.add(bean);
			}
		} finally {
			con.close();
		}
		return list;
	}
	
	
	//利用物資編號(goodsno)找到該筆物資資訊
	public GoodsBean getGoodsByGoodsno(String goodsno) throws SQLException {
		Connection con = ds.getConnection();
		GoodsBean bean = null;
		try {
			String sql = "Select * from goods where goodsno = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, goodsno);
			ResultSet rs = stmt.executeQuery();	
			while (rs.next()) {
				// 建立一個新的GoodsBean物件
				bean = new GoodsBean();
				// 將此紀錄內的資料放入GoodsBean物件
				bean.setGoodsno(rs.getInt(1));
				bean.setGoodsstatus(rs.getInt(2));
				bean.setUpdatetime(rs.getTimestamp(3));
				bean.setIndid(rs.getString(4));
				bean.setGoodstype(rs.getInt(5));
				bean.setGoodsname(rs.getString(6));
				bean.setGoodsloc(rs.getInt(7));
				bean.setGoodsnote(rs.getString(8));
				bean.setQty(rs.getInt(9));
				bean.setGoodsshipway(rs.getInt(10));
				bean.setDeadline(rs.getLong(11));
				bean.setGoodsimage(rs.getBlob(12));
				bean.setGoodsfilename(rs.getString(13));

			}
		} finally {
			con.close();
		}
		return bean;
	}

	
	// 依goodsno來刪除單筆物資記錄
	public int deleteGoods(int goodsno) throws SQLException {
		int n = 0;

		PreparedStatement pStmt = null;
		Connection connection = null;
		String deleteString = "DELETE FROM goods WHERE goodsno = ?";
		try {
			connection = ds.getConnection();
			pStmt = connection.prepareStatement(deleteString);
			pStmt.setInt(1, goodsno);
			n = pStmt.executeUpdate();
		} finally {
			if (pStmt != null) {
				try {
					pStmt.close();
				} catch(SQLException e){
				   e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return n;
	}

	
	// 修改物資箱==>修改一筆記錄==> 修改圖片
	public int updateGoods(GoodsBean bean, InputStream is, long sizeInBytes, String filename) throws SQLException {
		int n = 0;
		PreparedStatement pStmt = null;
		Connection connection = null;
		String updateString = 
		"UPDATE goods SET goodsstatus=?,  updatetime=?,  goodstype=?, goodsname=?, "
		+ " goodsloc=?, goodsnote=?, qty=?, goodsshipway=?, deadline=?, goodsimage = ?, goodsfilename=? WHERE goodsno = ?";
		if (sizeInBytes == -1) { // 不修改圖片
			n = updateGoods2(bean);
			return n;
		}
		try {
			connection = ds.getConnection();
			pStmt = connection.prepareStatement(updateString);
			pStmt.clearParameters();
			pStmt.setInt(1, bean.getGoodsstatus());
			java.sql.Timestamp now2 = new java.sql.Timestamp(System.currentTimeMillis());
	        pStmt.setTimestamp(2, now2);
			pStmt.setInt(3, bean.getGoodstype());
			pStmt.setString(4, bean.getGoodsname());
			pStmt.setInt(5, bean.getGoodsloc());
			pStmt.setString(6, bean.getGoodsnote());
			pStmt.setInt(7, bean.getQty());
			pStmt.setInt(8, bean.getGoodsshipway());
			pStmt.setLong(9, bean.getDeadline());
			pStmt.setBinaryStream(10, is, sizeInBytes);
			pStmt.setString(11, filename);
			pStmt.setInt(12, bean.getGoodsno());
			n = pStmt.executeUpdate();
		} finally {			
			if (pStmt != null) {
				try {
					pStmt.close();
				} catch(SQLException e){
				   e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return n;
	}
	

	// 修改物資箱==>修改一筆記錄==> 不修改圖片
	public int updateGoods2(GoodsBean bean) throws SQLException {
		int n = 0;
		String updateString = 
				"UPDATE goods SET goodsstatus=?,  updatetime=?,  goodstype=?, goodsname=?, "
		+ " goodsloc=?, goodsnote=?, qty=?, goodsshipway=?, deadline=? WHERE goodsno = ?";

		PreparedStatement pStmt = null;
		Connection connection = null;
		try {
			connection = ds.getConnection();
			pStmt = connection.prepareStatement(updateString);
			pStmt.clearParameters();
			pStmt.setInt(1, bean.getGoodsstatus());
			java.sql.Timestamp now2 = new java.sql.Timestamp(System.currentTimeMillis());
	        pStmt.setTimestamp(2, now2);
			pStmt.setInt(3, bean.getGoodstype());
			pStmt.setString(4, bean.getGoodsname());
			pStmt.setInt(5, bean.getGoodsloc());
			pStmt.setString(6, bean.getGoodsnote());
			pStmt.setInt(7, bean.getQty());
			pStmt.setInt(8, bean.getGoodsshipway());
			pStmt.setLong(9, bean.getDeadline());
			pStmt.setInt(10, bean.getGoodsno());
			n = pStmt.executeUpdate();
		} finally {
			if (pStmt != null) {
				try {
					pStmt.close();
				} catch(SQLException e){
				   e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return n;
	}
	
	//新增物資箱
	synchronized public int insertGoods(GoodsBean gb, InputStream is,
			long size, String filename) throws SQLException{
		PreparedStatement pstmt1 = null;
		Connection conn = ds.getConnection();
		int r = 0;
		try {
			String sql1 = "insert into goods " +
			  		" (goodsno, goodsstatus, updatetime, indid, goodstype, goodsname, goodsloc, " +
			  		" goodsnote, qty, goodsshipway,deadline,goodsimage,goodsfilename) " +
			  		" values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";			
		
			pstmt1 = conn.prepareStatement(sql1);
		
	        pstmt1.setInt(1, gb.getGoodsno());
	        pstmt1.setInt(2, gb.getGoodsstatus());
	        java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
	        pstmt1.setTimestamp(3, now);	        
	        pstmt1.setString(4, gb.getIndid());
	        pstmt1.setInt(5, gb.getGoodstype());
	        pstmt1.setString(6, gb.getGoodsname());
	        pstmt1.setInt(7, gb.getGoodsloc());
	        pstmt1.setString(8, gb.getGoodsnote());
	        pstmt1.setInt(9, gb.getQty());
	        pstmt1.setInt(10, gb.getGoodsshipway());
	        pstmt1.setLong(11, gb.getDeadline());
	       
	          // 設定Image欄位
			pstmt1.setBinaryStream(12, is, size);
			pstmt1.setString(13, filename);
			r = pstmt1.executeUpdate();
						
			
		} finally {
			// 關閉相關的物件
			if (pstmt1 != null) {
				try {
					pstmt1.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					System.err.println("關閉相關物件時發生例外: " + e);
				}
			}
		}
		return r;
	}
	
	
}