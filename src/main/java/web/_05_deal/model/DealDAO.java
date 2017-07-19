package web._05_deal.model;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web._00_init.GlobalService;
import web._00_init.sql_Common;

public class DealDAO {

	private DataSource ds = null;
	String result = "null";

	public DealDAO() {
		Context ctx = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String agreen_DEAL(String key, String INDID) {
		String ans = "FALSE";
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"UPDATE DEAL SET DEALSTATUS=1 WHERE (DEALNO =? AND ((ENDID=? AND GOODSSTATUS=1)OR(SOURCEID=? AND GOODSSTATUS=2)) AND DEALSTATUS=0) ");) {
			pstmt.setString(1, key);
			pstmt.setString(2, INDID);
			pstmt.setString(3, INDID);
			int buf = pstmt.executeUpdate();
			if (buf == 1) {
				ans = "TRUE";
			}
		} catch (Exception e) {
			ans = "FALSE";
			e.printStackTrace();
		}
		return ans;
	}

	public String OK_DEAL(String SHIPNO, String key, String INDID) {
		String ans = "FALSE";
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"UPDATE DEAL SET DEALSTATUS=2, SHIPNO=? WHERE (DEALNO =? AND SOURCEID=? AND DEALSTATUS=1)");) {
			pstmt.setString(1, SHIPNO);
			pstmt.setString(2, key);
			pstmt.setString(3, INDID);
			pstmt.setString(3, INDID);
			int buf = pstmt.executeUpdate();
			if (buf == 1) {
				ans = "TRUE";
			}
		} catch (Exception e) {
			ans = "FALSE";
			e.printStackTrace();
		}
		return ans;
	}

	public String CANCEL_DEAL(String key, String INDID) {
		String ans = "FALSE";
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"UPDATE DEAL SET DEALSTATUS=3 WHERE (DEALNO =?) AND (SOURCEID=? OR ENDID=?) AND (DEALSTATUS NOT IN(2,3))");) {
			pstmt.setString(1, key);
			pstmt.setString(2, INDID);
			pstmt.setString(3, INDID);

			int buf = pstmt.executeUpdate();
			if (buf == 1) {
				ans = "TRUE";
			}
		} catch (Exception e) {
			ans = "FALSE";
			e.printStackTrace();
		}
		return ans;
	}

	public String Insert_DEAL(int GOODSNO, String SOURCEID, int DEALQTY, int ENDSHIPWAY, String DEALNOTE,
			InputStream is, long size) {
		String ans = "FALSE";
		try (Connection con = ds.getConnection();
				CallableStatement CS = con.prepareCall(sql_Common.CALL_FUNCTION_INSERT_DEAL);) {
			CS.registerOutParameter(1, Types.VARCHAR);
			CS.setInt(2, GOODSNO);
			CS.setString(3, SOURCEID);
			CS.setInt(4, DEALQTY);
			CS.setInt(5, ENDSHIPWAY);
			CS.setString(6, DEALNOTE);
			CS.setBinaryStream(7, is, size);
			if (is == null) {
				CS.setString(8, null);
			} else {
				CS.setString(8,
						String.valueOf(GOODSNO) + String.valueOf(DEALQTY) + String.valueOf(ENDSHIPWAY) + ".jpg");

			}
			CS.execute();
			ans = CS.getString(1);
		} catch (Exception e) {
			ans = "FALSE";
			e.printStackTrace();
		}
		return ans;
	}

	public Collection<DEALBean> FindByENDKey_DEAL(String INDID) {
		Collection<DEALBean> coll = new ArrayList<DEALBean>();
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"SELECT d.*,i.indname,i1.indname FROM DEAL AS d , ind AS i ,ind AS i1 WHERE (d.sourceid=i.indid)AND(d.endid=i1.indid)AND(SOURCEID=? OR ENDID=?) ORDER BY postdate DESC;");) {
			pstmt.setString(1, INDID);
			pstmt.setString(2, INDID);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				DEALBean dealb = new DEALBean();
				dealb.setDEALNO(rs.getInt(1));
				dealb.setPOSTDATE(rs.getTimestamp(2));
				dealb.setSOURCEID(rs.getString(3));
				dealb.setENDID(rs.getString(4));
				dealb.setDEALSTATUS(rs.getInt(5));
				dealb.setENDSHIPWAY(rs.getInt(6));
				dealb.setDEALQTY(rs.getInt(7));
				dealb.setSHIPDATE(rs.getTimestamp(8));
				dealb.setSHIPNO(rs.getString(9));
				dealb.setDEALNOTE(rs.getString(10));
				dealb.setGOODSNAME(rs.getString(13));
				dealb.setGOODSTYPES(rs.getInt(16));
				dealb.setGOODSLOC(rs.getInt(17));
				dealb.setGOODSNOTE(rs.getString(18));
				dealb.setSOURCENAME(rs.getString(19));
				dealb.setENDNAME(rs.getString(20));
				coll.add(dealb);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coll;
	}
}
