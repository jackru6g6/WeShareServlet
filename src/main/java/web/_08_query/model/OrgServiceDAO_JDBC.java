package web._08_query.model;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.naming.*;
import javax.sql.*;

import web._00_init.*;
import web._01_register.model.MemberBean;
import web._01_register.model.OrgBean;
import web._02_login.model.*;
import web._04_productMaintain.model.GoodsBean;

public class OrgServiceDAO_JDBC implements OrgServiceDAO {
	private DataSource ds = null;

	public OrgServiceDAO_JDBC() throws NamingException, SQLException {
		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
	}	
	
		
	//透過地區查詢社福會員
	public List<Object> getOrgByIndAddress(String indaddress) throws SQLException {
		List<Object> obj = new ArrayList<>();
		String sql = 
				"SELECT i.usertype,i.postdate,i.indid,i.indpassword,i.indname,i.indphone,i.indemail,"
				+" i.indaddress, i.indimage, i.indfilename,o.indid,o.updatetime,"
				+ "o.intro,o.leader,o.orgtypes,o.registerno,o.raiseno,o.website, o.orgimage, o.orgfilename,ot.orgname "
				+" FROM ind i JOIN org o ON o.indid = i.indid "
				+" JOIN orgtype ot ON o.orgtypes = ot.orgno "
				+" WHERE i.indaddress like ?";			
			
		Connection connection = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			connection = ds.getConnection();
			pStmt = connection.prepareStatement(sql);
			pStmt.setString(1, "%" + indaddress + "%" );
			rs = pStmt.executeQuery();
			while (rs.next()) {				
				int userType = rs.getInt("userType");
				java.sql.Timestamp postDate = rs.getTimestamp("postDate");				
				String indId = rs.getString("indId").trim(); // 必須確定rs.getString("memberID")不是null才能.trim()
				String indPassword = rs.getString("indPassword").trim();				
				String indName = rs.getString("indName").trim();
				String indPhone = rs.getString("indPhone");
				String indEmail = rs.getString("indEmail");				
				String indAddress = rs.getString("indAddress");	
				Blob indImage = rs.getBlob("indImage");
				String indFileName = rs.getString("indFileName");			
				
				java.sql.Timestamp updatetime = rs.getTimestamp("updatetime");	
				String intro = rs.getString("INTRO");
				String leader = rs.getString("LEADER");
				int orgtypes = rs.getInt("ORGTYPES");
				String registerno = rs.getString("REGISTERNO");
				String raiseno = rs.getString("RAISENO");
				String website = rs.getString("website");
				Blob orgimage = rs.getBlob("orgImage");
				String orgfileName = rs.getString("orgFileName");
				String orgname = rs.getString("orgname");
				
				MemberBean mb = new MemberBean(userType, postDate, indId, indPassword, 
						indName, indPhone, indEmail, indAddress,indImage,indFileName);
				OrgBean ob = new OrgBean(indId,updatetime, intro, leader, orgtypes, 
						registerno, raiseno,website,orgimage,orgfileName,orgname);

				obj.add(mb);
				obj.add(ob);			
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
			return obj;
	}
	
	//透過社福類別查詢社福會員
	public List<Object> getOrgByOrgtypes(String orgtype) throws SQLException {
		List<Object> obj = new ArrayList<>();	
		String sql = 
				"SELECT i.usertype,i.postdate,i.indid,i.indpassword,i.indname,i.indphone,i.indemail,"
				+" i.indaddress, i.indimage, i.indfilename,o.indid,o.updatetime,"
				+ "o.intro,o.leader,o.orgtypes,o.registerno,o.raiseno,o.website, o.orgimage, o.orgfilename,ot.orgname "
				+" FROM ind i JOIN org o ON o.indid = i.indid "
				+" JOIN orgtype ot ON o.orgtypes = ot.orgno "
				+" WHERE o.orgtypes = ?";	
			
		Connection connection = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			connection = ds.getConnection();
			pStmt = connection.prepareStatement(sql);
			pStmt.setString(1, orgtype );
			rs = pStmt.executeQuery();
			while (rs.next()) {				
				int userType = rs.getInt("userType");
				java.sql.Timestamp postDate = rs.getTimestamp("postDate");				
				String indId = rs.getString("indId").trim(); 
				String indPassword = rs.getString("indPassword");				
				String indName = rs.getString("indName");
				String indPhone = rs.getString("indPhone");
				String indEmail = rs.getString("indEmail");				
				String indAddress = rs.getString("indAddress");	
				Blob indImage = rs.getBlob("indImage");
				String indFileName = rs.getString("indFileName");			
				
				java.sql.Timestamp updatetime = rs.getTimestamp("updatetime");	
				String intro = rs.getString("INTRO");
				String leader = rs.getString("LEADER");
				int orgtypes = rs.getInt("ORGTYPES");
				String registerno = rs.getString("REGISTERNO");
				String raiseno = rs.getString("RAISENO");
				String website = rs.getString("website");
				Blob orgimage = rs.getBlob("orgImage");
				String orgfileName = rs.getString("orgFileName");
				String orgname = rs.getString("orgname");
				
				MemberBean mb = new MemberBean(userType, postDate, indId, indPassword, 
						indName, indPhone, indEmail, indAddress,indImage,indFileName);
				OrgBean ob = new OrgBean(indId,updatetime, intro, leader, orgtypes, 
						registerno, raiseno,website,orgimage,orgfileName,orgname);

				obj.add(mb);
				obj.add(ob);			
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
			return obj;
	}
	
	//透過關鍵字查詢社福會員
	public List<Object> getOrgByKeyword(String keyword) throws SQLException {
		List<Object> obj = new ArrayList<>();	
		String sql = 
				"SELECT i.usertype,i.postdate,i.indid,i.indpassword,i.indname,i.indphone,i.indemail,"
				+" i.indaddress, i.indimage, i.indfilename,o.indid,o.updatetime,"
				+ "o.intro,o.leader,o.orgtypes,o.registerno,o.raiseno,o.website, o.orgimage, o.orgfilename,ot.orgname "
				+" FROM ind i JOIN org o ON o.indid = i.indid "
				+" JOIN orgtype ot ON o.orgtypes = ot.orgno "
				+" WHERE i.indname like ?";	
			
		Connection connection = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			connection = ds.getConnection();
			pStmt = connection.prepareStatement(sql);
			pStmt.setString(1, "%" + keyword + "%");
			rs = pStmt.executeQuery();
			while (rs.next()) {				
				int userType = rs.getInt("userType");
				java.sql.Timestamp postDate = rs.getTimestamp("postDate");				
				String indId = rs.getString("indId").trim();
				String indPassword = rs.getString("indPassword");				
				String indName = rs.getString("indName");
				String indPhone = rs.getString("indPhone");
				String indEmail = rs.getString("indEmail");				
				String indAddress = rs.getString("indAddress");	
				Blob indImage = rs.getBlob("indImage");
				String indFileName = rs.getString("indFileName");				
				
				java.sql.Timestamp updatetime = rs.getTimestamp("updatetime");	
				String intro = rs.getString("INTRO");
				String leader = rs.getString("LEADER");
				int orgtypes = rs.getInt("ORGTYPES");
				String registerno = rs.getString("REGISTERNO");
				String raiseno = rs.getString("RAISENO");
				String website = rs.getString("website");
				Blob orgimage = rs.getBlob("orgImage");
				String orgfileName = rs.getString("orgFileName");
				String orgname = rs.getString("orgname");
				
				MemberBean mb = new MemberBean(userType, postDate, indId, indPassword, 
						indName, indPhone, indEmail, indAddress,indImage,indFileName);
				OrgBean ob = new OrgBean(indId,updatetime, intro, leader, orgtypes, 
						registerno, raiseno,website,orgimage,orgfileName,orgname);

				obj.add(mb);
				obj.add(ob);			
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
			return obj;
	}
	
	
	
	//查詢所有社福會員
	public List<Object> getOrg() throws SQLException {
		List<Object> obj = new ArrayList<>();			
		String sql = 
				"SELECT i.usertype,i.postdate,i.indid,i.indpassword,i.indname,i.indphone,i.indemail,"
				+" i.indaddress, i.indimage, i.indfilename,o.indid,o.updatetime,"
				+ "o.intro,o.leader,o.orgtypes,o.registerno,o.raiseno,o.website, o.orgimage, o.orgfilename,ot.orgname "
				+" FROM ind i JOIN org o ON o.indid = i.indid "
				+" JOIN orgtype ot ON o.orgtypes = ot.orgno ";
			
		Connection connection = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			connection = ds.getConnection();
			pStmt = connection.prepareStatement(sql);
			rs = pStmt.executeQuery();
			while (rs.next()) {				
				int userType = rs.getInt("userType");
				java.sql.Timestamp postDate = rs.getTimestamp("postDate");				
				String indId = rs.getString("indId").trim(); 
				String indPassword = rs.getString("indPassword");				
				String indName = rs.getString("indName");
				String indPhone = rs.getString("indPhone");
				String indEmail = rs.getString("indEmail");				
				String indAddress = rs.getString("indAddress");	
				Blob indImage = rs.getBlob("indImage");
				String indFileName = rs.getString("indFileName");			
				
				java.sql.Timestamp updatetime = rs.getTimestamp("updatetime");	
				String intro = rs.getString("INTRO");
				String leader = rs.getString("LEADER");
				int orgtypes = rs.getInt("ORGTYPES");
				String registerno = rs.getString("REGISTERNO");
				String raiseno = rs.getString("RAISENO");
				String website = rs.getString("website");
				Blob orgimage = rs.getBlob("orgImage");
				String orgfileName = rs.getString("orgFileName");
				String orgname = rs.getString("orgname");
				
				MemberBean mb = new MemberBean(userType, postDate, indId, indPassword, 
						indName, indPhone, indEmail, indAddress,indImage,indFileName);
				OrgBean ob = new OrgBean(indId,updatetime, intro, leader, orgtypes, 
						registerno, raiseno,website,orgimage,orgfileName,orgname);

				obj.add(mb);
				obj.add(ob);			
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
			return obj;
	}
	

}