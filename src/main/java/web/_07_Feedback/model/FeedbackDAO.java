package web._07_Feedback.model;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web._00_init.GlobalService;

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
				CallableStatement cs = con.prepareCall("SELECT INSERT_FEEDBACK(?,?,?,?,?,?,?)");) {
			// cs.registerOutParameter(1, Types.VARCHAR);
			cs.setString(1, fb.getDEALNO());
			cs.setString(2, fb.getFBSOURCEID());
			cs.setString(3, fb.getFBENDID());
			cs.setString(4, fb.getFBTEXT());
			cs.setInt(5, fb.getFBSCORE());
			cs.setBinaryStream(6, image, imagesize);
			cs.setString(7, fb.getFBFILENAME());
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				ans = rs.getString(1);
			}
			System.out.println("[sql]ans=" + ans);
		} catch (Exception e) {
			ans = "FALSE";
			e.printStackTrace();
		}
		return ans;
	}
}
