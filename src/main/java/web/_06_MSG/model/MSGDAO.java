package web._06_MSG.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web._00_init.GlobalService;

public class MSGDAO {

	private DataSource ds = null;
	String result = "null";

	public MSGDAO() {
		Context ctx = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String Insert_MSG(MSGBean msgb, InputStream image, long imagesize) {
		String ans = "FALSE";
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("INSERT INTO MSG VALUE(null,'2',null,?,?,?,?,?,check_roomNo(?,?))");) {
			pstmt.setString(1, msgb.getMSGSOURCEID());
			pstmt.setString(2, msgb.getMSGENDID());
			pstmt.setString(3, msgb.getMSGTEXT());
			pstmt.setBinaryStream(4, image, imagesize);
			pstmt.setString(5, msgb.getMSGFILENAME());
			pstmt.setString(6, msgb.getMSGSOURCEID());
			pstmt.setString(7, msgb.getMSGENDID());
			pstmt.executeUpdate();
			ans = "TRUE";
		} catch (Exception e) {
			ans = "FALSE";
			// e.printStackTrace();
		}
		return ans;
	}

	public Collection<MSGBean> FindMSGByKey(String INDID) {
		Collection<MSGBean> coll = new ArrayList<MSGBean>();
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"SELECT * from msg where msgsourceid =? or msgendid=? GROUP BY ROOMNO DESC ORDER BY postdate DESC");) {
			pstmt.setString(1, INDID);
			pstmt.setString(2, INDID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MSGBean msgb = new MSGBean();
				msgb.setMSGNO(rs.getInt(1));
				msgb.setMSGSTATUS(rs.getInt(2));
				msgb.setPOSTDATE(rs.getTimestamp(3));
				msgb.setMSGSOURCEID(rs.getString(4));
				msgb.setMSGENDID(rs.getString(5));
				msgb.setMSGTEXT(rs.getString(6));
				msgb.setMSGIMAGE(rs.getBlob(7));
				msgb.setMSGFILENAME(rs.getString(8));
				msgb.setROOMNO(rs.getInt(9));
				coll.add(msgb);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coll;
	}

	public Collection<MSGBean> FindMSGByRoomNoKey(String INDID) {
		Collection<MSGBean> coll = new ArrayList<MSGBean>();
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * from msg where ROOMNO=? ORDER BY postdate ");) {
			pstmt.setString(1, INDID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MSGBean msgb = new MSGBean();
				msgb.setMSGNO(rs.getInt(1));
				msgb.setMSGSTATUS(rs.getInt(2));
				msgb.setPOSTDATE(rs.getTimestamp(3));
				msgb.setMSGSOURCEID(rs.getString(4));
				msgb.setMSGENDID(rs.getString(5));
				msgb.setMSGTEXT(rs.getString(6));
				msgb.setMSGIMAGE(rs.getBlob(7));
				msgb.setMSGFILENAME(rs.getString(8));
				msgb.setROOMNO(rs.getInt(9));
				coll.add(msgb);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coll;
	}

	public String READ_MSG(String key) {
		String ans = "FALSE";
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("UPDATE MSG SET MSGSTATUS=1 WHERE ROOMNO = ?");) {
			pstmt.setString(1, key);
			pstmt.executeUpdate();
			ans = "TRUE";
		} catch (Exception e) {
			ans = "FALSE";
			e.printStackTrace();
		}
		return ans;
	}

	// public String GET_ROOMMATE_BY_ROOMNO(String ROOMNO, String INDID) {
	// String ans = "FALSE";
	// String BUFFER1 = null;
	// String BUFFER2 = null;
	// try (Connection con = ds.getConnection();
	// PreparedStatement pstmt = con.prepareStatement("SELECT * FROM MSG_ROOM
	// WHERE ROOMNO=?");) {
	// pstmt.setString(1, ROOMNO);
	// ResultSet rs = pstmt.executeQuery();
	// while (rs.next()) {
	// BUFFER1 = rs.getString(1);
	// BUFFER2 = rs.getString(2);
	// }
	// rs.close();
	//
	// if (!BUFFER1.equals(null) || !BUFFER2.equals(null)) {
	// if (BUFFER1.equals(INDID)) {
	// ans = BUFFER2;
	// } else {
	// ans = BUFFER1;
	// }
	// } else {
	// ans = "FALSE";
	// }
	// } catch (Exception e) {
	// ans = "FALSE";
	// e.printStackTrace();
	// }
	// return ans;
	// }
}
