package web._07_Feedback.model;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web._00_init.GlobalService;
import web._00_init.sql_Common;
import web._05_deal.model.DEALBean;

public class FeedbackDAO {
	private DataSource ds = null;
	String result = "null";

	public FeedbackDAO() {
		Context ctx = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String Insert_FB(FeedbackBean fb, String INDID, InputStream image, long imagesize) {
		String ans = "FALSE";
		try (Connection con = ds.getConnection();
				CallableStatement cs = con.prepareCall("{? =CALL INSERT_FEEDBACK(?,?,?,?,?,?,?)}");) {
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setString(2, fb.getDEALNO());
			cs.setString(3, fb.getFBSOURCEID());
			cs.setString(4, fb.getFBENDID());
			cs.setString(5, fb.getFBTEXT());
			cs.setInt(6, fb.getFBSCORE());
			cs.setBinaryStream(7, image, imagesize);
			cs.setString(8, fb.getFBFILENAME());
			cs.execute();
			ans = cs.getString(1);
		} catch (Exception e) {
			ans = "FALSE";
			e.printStackTrace();
		}
		return ans;
	}

	public FeedbackBean FindFBbyDEALNO(int dealno) {
		FeedbackBean fdbb = new FeedbackBean();
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("SELECT f1.*,COUNT(*) FROM FEEDBACK AS f1 WHERE dealno=? ;");) {
			pstmt.setInt(1, dealno);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				fdbb.setDEALNO(String.valueOf(rs.getInt(1)));
				fdbb.setPOSTDATE(rs.getTimestamp(2));
				fdbb.setFBSOURCEID(rs.getString(3));
				fdbb.setFBENDID(rs.getString(4));
				fdbb.setFBTEXT(rs.getString(5));
				fdbb.setFBSCORE(rs.getInt(6));
				fdbb.setFBFILENAME(rs.getString(7));
				fdbb.setAns(rs.getInt(9));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fdbb;
	}

	public Collection<FeedbackBean> FindByINDID(String INDID) {
		Collection<FeedbackBean> coll = new ArrayList<FeedbackBean>();
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("SELECT * FROM FEEDBACK WHERE ( fbendid=? OR fbsourceid=?)");) {
			pstmt.setString(1, INDID);
			pstmt.setString(2, INDID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				FeedbackBean fdbb = new FeedbackBean();
				fdbb.setDEALNO(String.valueOf(rs.getInt(1)));
				fdbb.setPOSTDATE(rs.getTimestamp(2));
				fdbb.setFBSOURCEID(rs.getString(3));
				fdbb.setFBENDID(rs.getString(4));
				fdbb.setFBTEXT(rs.getString(5));
				fdbb.setFBSCORE(rs.getInt(6));
				fdbb.setFBFILENAME(rs.getString(7));
				coll.add(fdbb);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coll;
	}

	public Collection<FeedbackBean> FindByINDID_NOT_SESSION(String INDID) {
		Collection<FeedbackBean> coll = new ArrayList<FeedbackBean>();
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"SELECT fbsourceid,fbtext,fbscore,postdate,fbfilename FROM FEEDBACK WHERE fbendid=? ORDER BY POSTDATE DESC;");) {
			pstmt.setString(1, INDID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				FeedbackBean fdbb = new FeedbackBean();
				fdbb.setFBSOURCEID(rs.getString(1));
				fdbb.setFBTEXT(rs.getString(2));
				fdbb.setFBSCORE(rs.getInt(3));
				fdbb.setPOSTDATE(rs.getTimestamp(4));
				fdbb.setFBFILENAME(rs.getString(5));
				coll.add(fdbb);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coll;
	}
}
