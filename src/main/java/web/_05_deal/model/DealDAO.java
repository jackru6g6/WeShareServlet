package web._05_deal.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web._00_init.GlobalService;

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

	public String Insert_DEAL(int GOODSNO, String SOURCEID, int DEALQTY, int ENDSHIPWAY) {
		String ans = "FALSE";
		try (Connection con = ds.getConnection();
				CallableStatement CS = con.prepareCall("{? = CALL insert_deal(?,?,?,?)}");) {
			CS.registerOutParameter(1, Types.VARCHAR);
			CS.setInt(2, GOODSNO);
			CS.setString(3, SOURCEID);
			CS.setInt(4, DEALQTY);
			CS.setInt(5, ENDSHIPWAY);
			CS.execute();
			ans = CS.getString(1);
		} catch (Exception e) {
			ans = "FALSE";
			e.printStackTrace();
		}
		return ans;
	}

	public String FindByKey_DEAL(String INDID) {
		String ans = "FALSE";
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM DEAL WHERE SOURCEID=? OR ENDID=?");) {
			pstmt.setString(1, INDID);
			pstmt.setString(2, INDID);

		} catch (Exception e) {
			ans = "FALSE";
			e.printStackTrace();
		}
		return ans;
	}
}
