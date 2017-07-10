package web._01_register.model;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.naming.*;
import javax.sql.*;

import web._00_init.*;
import web._02_login.model.*;

public class RegisterServiceDAO_JDBC implements RegisterServiceDAO {
	private List<MemberBean> memberList;
	LoginServiceDB lsdb;
	private DataSource ds = null;

	public RegisterServiceDAO_JDBC() throws NamingException, SQLException {
		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		lsdb = new LoginServiceDB();
		memberList = lsdb.getMemberList();
	}

	synchronized public boolean idExists(String id) throws IOException {
		boolean exist = false; // 檢查id是否已經存在
		for (MemberBean mb : memberList) {
			if (mb.getIndid().equals(id.trim())) {
				exist = true;
				break;
			}
		}
		return exist;
	}

	//註冊==>一般會員
	synchronized public int saveMember(MemberBean mb, InputStream is,
			long size, String filename) throws SQLException {
		PreparedStatement pstmt1 = null;
		Connection conn = ds.getConnection();
		int r = 0;
		try {
			String sql1 = "insert into ind " +
			  		" (userType, postDate, indId, indPassword, indName, indPhone, indEmail, " +
			  		" indAddress, indImage, indFileName) " +
			  		" values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt1 = conn.prepareStatement(sql1);
	          pstmt1.setInt(1, mb.getUsertype());          
	          java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
	          pstmt1.setTimestamp(2, now);
	          pstmt1.setString(3, mb.getIndid());
	          String encrypedString = GlobalService.encryptString(mb.getIndpassword());
			  pstmt1.setString(4, GlobalService.getMD5Endocing(encrypedString));
	          pstmt1.setString(5, mb.getIndname());
	          pstmt1.setString(6, mb.getIndphone());
	          pstmt1.setString(7, mb.getIndemail());
	          pstmt1.setString(8, mb.getIndaddress());   
	          // 設定Image欄位
				pstmt1.setBinaryStream(9, is, size);
				pstmt1.setString(10, filename);
				r = pstmt1.executeUpdate();
			
			
			if (r == 1) {
				// 寫入成功，應該將MemberBean mem立即加入LoginService的memberList內
				// 否則，最新的User將無法登入
				mb.setIndpassword(GlobalService.getMD5Endocing(encrypedString));
				memberList.add(mb);
			} else {
				throw new SQLException("RegisterServiceDB:新增記錄數 : 0");
			}
			// System.out.println("新增一筆eMember紀錄，是否成功=" + r);
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
	
	//註冊==>社福會員
	synchronized public int saveOrg(MemberBean mb,OrgBean ob, InputStream is,
			long size, String filename, InputStream is2,
			long size2, String filename2) throws SQLException {
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		Connection conn = ds.getConnection();
		int r = 0;
		try {
			conn.setAutoCommit(false);
			
			String sql1 = "insert into ind " +
			  		" (userType, postDate, indId, indPassword, indName, indPhone, indEmail, " +
			  		" indAddress, indImage, indFileName) " +
			  		" values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt1 = conn.prepareStatement(sql1);
	          pstmt1.setInt(1, mb.getUsertype());          
	          java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
	          pstmt1.setTimestamp(2, now);
	          pstmt1.setString(3, mb.getIndid());
	          String encrypedString = GlobalService.encryptString(mb.getIndpassword());
			  pstmt1.setString(4, GlobalService.getMD5Endocing(encrypedString));
	          pstmt1.setString(5, mb.getIndname());
	          pstmt1.setString(6, mb.getIndphone());
	          pstmt1.setString(7, mb.getIndemail());
	          pstmt1.setString(8, mb.getIndaddress());   
	          // 設定Image欄位
				pstmt1.setBinaryStream(9, is, size);
				pstmt1.setString(10, filename);
				r = pstmt1.executeUpdate();		

			if (r == 1) {
				// 寫入成功，應該將MemberBean mem立即加入LoginService的memberList內
				// 否則，最新的User將無法登入
				mb.setIndpassword(GlobalService.getMD5Endocing(encrypedString));
				memberList.add(mb);
			} else {
				throw new SQLException("RegisterServiceDB:新增記錄數 : 0");
			}
			// System.out.println("新增一筆eMember紀錄，是否成功=" + r);
			
			String sql2 = "insert into org " +
			  		" (indid, updatetime, intro, leader, orgtypes, "
			  		+ "registerno, raiseno, orgimage, orgfilename) " +
			  		" values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			  pstmt2 = conn.prepareStatement(sql2);
			  pstmt2.setString(1, mb.getIndid());          
	          java.sql.Timestamp now2 = new java.sql.Timestamp(System.currentTimeMillis());
	          pstmt2.setTimestamp(2, now2);
	          pstmt2.setString(3, ob.getIntro());
	          pstmt2.setString(4, ob.getLeader());
	          pstmt2.setInt(5, ob.getOrgtypes());
	          pstmt2.setString(6, ob.getRegisterno());
	          pstmt2.setString(7, ob.getRaiseno());		          
	          
	          // 設定Image欄位
				pstmt2.setBinaryStream(8, is2, size2);
				pstmt2.setString(9, filename2);
				r = pstmt2.executeUpdate();	
				
				conn.commit();  
		}catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("資料還原");
			if(conn!=null) conn.rollback();			
			
		} finally {
			// 關閉相關的物件
			if (pstmt1 != null) {
				try {
					pstmt1.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (pstmt2 != null) {
				try {
					pstmt2.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) conn.setAutoCommit(true);
			
			
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
	
	
	
	
	
	//讀取==>社福會員
	public List<Object> populateMember(String pk) throws SQLException {
		// 由Database讀取會員資料
		List<Object> obj = new ArrayList<>();
		List<Object> obj2 = populateMember2(pk);	
		
		String sql = 
				"SELECT i.usertype,i.postdate,i.indid,i.INDPASSWORD,i.INDNAME,i.INDPHONE,i.INDEMAIL,"
				+" i.INDADDRESS, i.indImage, i.indFileName,o.indid,o.updatetime,"
				+ "o.INTRO,o.LEADER,o.ORGTYPES,o.REGISTERNO,o.RAISENO, o.orgimage, o.orgfilename "
				+" From ind i JOIN org o ON i.indid=o.indid "
				+" where i.indid=?";
		
		
		Connection connection = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			connection = ds.getConnection();
			pStmt = connection.prepareStatement(sql);
			pStmt.setString(1, pk);
			rs = pStmt.executeQuery();
			

			
			if (rs.next()) {
				
				int userType = rs.getInt("userType");
				java.sql.Timestamp postDate = rs.getTimestamp("postDate");				
				String indId = rs.getString("indId").trim(); // 必須確定
																// rs.getString("memberID")
																// 不是null才能
																// .trim()
				String indPassword = rs.getString("indPassword").trim();				
				String indName = rs.getString("indName").trim();
				String indPhone = rs.getString("indPhone");
				String indEmail = rs.getString("indEmail");				
				String indAddress = rs.getString("indAddress");	
//				Blob indImage = rs.getBlob("indImage");//
				String indFileName = rs.getString("indFileName");//
				
				
				java.sql.Timestamp updatetime = rs.getTimestamp("updatetime");//	
				String intro = rs.getString("INTRO");
				String leader = rs.getString("LEADER");
				int orgtypes = rs.getInt("ORGTYPES");
				String registerno = rs.getString("REGISTERNO");
				String raiseno = rs.getString("RAISENO");
//				Blob orgimage = rs.getBlob("orgImage");//
				String orgfileName = rs.getString("orgFileName");//
				
				MemberBean mb = new MemberBean(userType, postDate, indId, indPassword, 
						indName, indPhone, indEmail, indAddress,null,indFileName);
				OrgBean ob = new OrgBean(indId,updatetime, intro, leader, orgtypes, 
						registerno, raiseno,null,orgfileName);



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
		if(!obj.isEmpty()){
			return obj;
		}else{
			return obj2;
		}
	}
	
	//讀取==>一般會員
	public List<Object> populateMember2(String pk) throws SQLException {
		// 由Database讀取會員資料
		List<Object> obj = new ArrayList<>();
		String sql = 
		"SELECT *"+ 
		"From ind "+
		"where indid=?";
		

		
		Connection connection = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			connection = ds.getConnection();
			pStmt = connection.prepareStatement(sql);
			pStmt.setString(1, pk);
			rs = pStmt.executeQuery();
			if (rs.next()) {
				
				int userType = rs.getInt("userType");
				java.sql.Timestamp postDate = rs.getTimestamp("postDate");				
				String indId = rs.getString("indId").trim(); // 必須確定
																// rs.getString("memberID")
																// 不是null才能
																// .trim()
				String indPassword = rs.getString("indPassword").trim();				
				String indName = rs.getString("indName").trim();
				String indPhone = rs.getString("indPhone");
				String indEmail = rs.getString("indEmail");				
				String indAddress = rs.getString("indAddress");
//				Blob indImage = rs.getBlob("indImage");//
				String indFileName = rs.getString("indFileName");//
				

				MemberBean mb = new MemberBean(userType, postDate, indId, indPassword, 
						indName, indPhone, indEmail, indAddress,null,indFileName);


				obj.add(mb);
				
				
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
	
	
	// 更新一般會員==>修改圖片
	synchronized public int updateMember(MemberBean mb, InputStream is,
			long size, String filename) throws SQLException {
		PreparedStatement pstmt1 = null;
		Connection conn = ds.getConnection();
		int r = 0;
		
		if (size == -1) { // 不修改圖片
			r = updateMember2(mb);
			return r;
		}
		
		try {
			String sql1 = " update ind " 
					+" set indName=?, indPhone=?, indEmail=?, "
					+" indAddress=?, indImage=?, indFileName=?"
			  		+" where indId=? " ;
			
			pstmt1 = conn.prepareStatement(sql1);
	         
//	          String encrypedString = GlobalService.encryptString(mb.getIndpassword());
//			  pstmt1.setString(1, GlobalService.getMD5Endocing(encrypedString));
	          pstmt1.setString(1, mb.getIndname());
	          pstmt1.setString(2, mb.getIndphone());
	          pstmt1.setString(3, mb.getIndemail());
	          pstmt1.setString(4, mb.getIndaddress());   
	          // 設定Image欄位
				pstmt1.setBinaryStream(5, is, size);
				pstmt1.setString(6, filename);
				pstmt1.setString(7, mb.getIndid());
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
	
	// 更新一般會員==>不修改圖片
	synchronized public int updateMember2(MemberBean mb) throws SQLException {
		PreparedStatement pstmt1 = null;
		Connection conn = ds.getConnection();
		int r = 0;				
		try {
			String sql1 = " update ind " 
					+" set indName=?, indPhone=?, indEmail=?, "
					+" indAddress=?"
			  		+" where indId=? " ;
			
			pstmt1 = conn.prepareStatement(sql1);	         
//	          String encrypedString = GlobalService.encryptString(mb.getIndpassword());
//			  pstmt1.setString(1, GlobalService.getMD5Endocing(encrypedString));
	          pstmt1.setString(1, mb.getIndname());
	          pstmt1.setString(2, mb.getIndphone());
	          pstmt1.setString(3, mb.getIndemail());
	          pstmt1.setString(4, mb.getIndaddress());   	          
				pstmt1.setString(5, mb.getIndid());
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
	
	
	// 更新社福會員==>會員表格|社福表格==>修改圖片
	synchronized public int updateOrg(MemberBean mb,OrgBean ob, InputStream is,
			long size, String filename, InputStream is2,
			long size2, String filename2) throws SQLException {
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		Connection conn = ds.getConnection();
		int r = 0;
		
		
		// 更新社福會員==>不修改圖片
		if (size == -1 && size2 == -1) { 
			r = updateOrg4(mb,ob,is,size,filename,is2,size2,filename2);
			return r;
		}
		// 會員表格不改圖==>社福表格改圖
		if (size == -1) { 
			r = updateOrg2(mb,ob,is,size,filename,is2,size2,filename2);
			return r;
		}
		 // 社福表格不改圖==>會員表格改圖
		if (size2 == -1) {
			r = updateOrg3(mb,ob,is,size,filename,is2,size2,filename2);
			return r;
		}		
		
		
		try {
			conn.setAutoCommit(false);
			
			String sql1 = " update ind " 
					+" set indName=?, indPhone=?, indEmail=?, "
					+" indAddress=?, indImage=?, indFileName=?"
			  		+" where indId=? " ;			
			pstmt1 = conn.prepareStatement(sql1);	         
//	          String encrypedString = GlobalService.encryptString(mb.getIndpassword());
//			  pstmt1.setString(1, GlobalService.getMD5Endocing(encrypedString));
	          pstmt1.setString(1, mb.getIndname());
	          pstmt1.setString(2, mb.getIndphone());
	          pstmt1.setString(3, mb.getIndemail());
	          pstmt1.setString(4, mb.getIndaddress());   
	          // 設定Image欄位
				pstmt1.setBinaryStream(5, is, size);
				pstmt1.setString(6, filename);
				pstmt1.setString(7, mb.getIndid());
				r = pstmt1.executeUpdate();			

				
			String sql2 = " update org " 
					+" set intro=?, leader=?, orgtypes=?, registerno=?, "
					+" raiseno=?, orgimage=?, orgfilename=?"
			  		+" where indId=? " ;
			  pstmt2 = conn.prepareStatement(sql2);
			  pstmt2.setString(1, mb.getIndid());          
	          java.sql.Timestamp now2 = new java.sql.Timestamp(System.currentTimeMillis());
	          pstmt2.setTimestamp(2, now2);
	          pstmt2.setString(1, ob.getIntro());
	          pstmt2.setString(2, ob.getLeader());
	          pstmt2.setInt(3, ob.getOrgtypes());
	          pstmt2.setString(4, ob.getRegisterno());
	          pstmt2.setString(5, ob.getRaiseno());		          
	          
	          // 設定Image欄位
				pstmt2.setBinaryStream(6, is2, size2);
				pstmt2.setString(7, filename2);
				pstmt2.setString(8, ob.getIndid());
				r = pstmt2.executeUpdate();	
				
				conn.commit();  
		}catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("資料還原");
			if(conn!=null) conn.rollback();			
			
		} finally {
			// 關閉相關的物件
			if (pstmt1 != null) {
				try {
					pstmt1.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (pstmt2 != null) {
				try {
					pstmt2.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) conn.setAutoCommit(true);
			
			
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
	// 更新社福會員==>會員表格不改圖==>社福表格改圖
	synchronized public int updateOrg2(MemberBean mb,OrgBean ob, InputStream is,
			long size, String filename, InputStream is2,
			long size2, String filename2) throws SQLException {
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		Connection conn = ds.getConnection();
		int r = 0;		
		
		try {
			conn.setAutoCommit(false);
			
			String sql1 = " update ind " 
					+" set indName=?, indPhone=?, indEmail=?, "
					+" indAddress=?"
			  		+" where indId=? " ;			
			pstmt1 = conn.prepareStatement(sql1);	         
//	          String encrypedString = GlobalService.encryptString(mb.getIndpassword());
//			  pstmt1.setString(1, GlobalService.getMD5Endocing(encrypedString));
	          pstmt1.setString(1, mb.getIndname());
	          pstmt1.setString(2, mb.getIndphone());
	          pstmt1.setString(3, mb.getIndemail());
	          pstmt1.setString(4, mb.getIndaddress());
				pstmt1.setString(5, mb.getIndid());
				r = pstmt1.executeUpdate();			

				
			String sql2 = " update org " 
					+" set intro=?, leader=?, orgtypes=?, registerno=?, "
					+" raiseno=?, orgimage=?, orgfilename=?"
			  		+" where indId=? " ;
			  pstmt2 = conn.prepareStatement(sql2);
//			  pstmt2.setString(1, mb.getIndid());          
	          java.sql.Timestamp now2 = new java.sql.Timestamp(System.currentTimeMillis());
	          pstmt2.setTimestamp(2, now2);
	          pstmt2.setString(1, ob.getIntro());
	          pstmt2.setString(2, ob.getLeader());
	          pstmt2.setInt(3, ob.getOrgtypes());
	          pstmt2.setString(4, ob.getRegisterno());
	          pstmt2.setString(5, ob.getRaiseno());
	          // 設定Image欄位
				pstmt2.setBinaryStream(6, is2, size2);
				pstmt2.setString(7, filename2);
				pstmt2.setString(8, ob.getIndid());
				r = pstmt2.executeUpdate();	
				
				conn.commit();  
		}catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("資料還原");
			if(conn!=null) conn.rollback();			
			
		} finally {
			// 關閉相關的物件
			if (pstmt1 != null) {
				try {
					pstmt1.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (pstmt2 != null) {
				try {
					pstmt2.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) conn.setAutoCommit(true);
			
			
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
	
	
	// 更新社福會員==>社福表格不改圖==>會員表格改圖
		synchronized public int updateOrg3(MemberBean mb,OrgBean ob, InputStream is,
				long size, String filename, InputStream is2,
				long size2, String filename2) throws SQLException {
			PreparedStatement pstmt1 = null;
			PreparedStatement pstmt2 = null;
			Connection conn = ds.getConnection();
			int r = 0;		
			
			try {
				conn.setAutoCommit(false);
				
				String sql1 = " update ind " 
						+" set indName=?, indPhone=?, indEmail=?, "
						+" indAddress=?, indImage=?, indFileName=?"
				  		+" where indId=? " ;			
				pstmt1 = conn.prepareStatement(sql1);	         
//		          String encrypedString = GlobalService.encryptString(mb.getIndpassword());
//				  pstmt1.setString(1, GlobalService.getMD5Endocing(encrypedString));
		          pstmt1.setString(1, mb.getIndname());
		          pstmt1.setString(2, mb.getIndphone());
		          pstmt1.setString(3, mb.getIndemail());
		          pstmt1.setString(4, mb.getIndaddress());
		          // 設定Image欄位
					pstmt1.setBinaryStream(5, is, size);
					pstmt1.setString(6, filename);
					pstmt1.setString(7, mb.getIndid());
					r = pstmt1.executeUpdate();			

					
				String sql2 = " update org " 
						+" set intro=?, leader=?, orgtypes=?, registerno=?, "
						+" raiseno=?"
				  		+" where indId=? " ;
				  pstmt2 = conn.prepareStatement(sql2);
//				  pstmt2.setString(1, mb.getIndid());          
		          java.sql.Timestamp now2 = new java.sql.Timestamp(System.currentTimeMillis());
		          pstmt2.setTimestamp(2, now2);
		          pstmt2.setString(1, ob.getIntro());
		          pstmt2.setString(2, ob.getLeader());
		          pstmt2.setInt(3, ob.getOrgtypes());
		          pstmt2.setString(4, ob.getRegisterno());
		          pstmt2.setString(5, ob.getRaiseno());		          
					pstmt2.setString(6, ob.getIndid());
					r = pstmt2.executeUpdate();	
					
					conn.commit();  
			}catch(SQLException ex){
				ex.printStackTrace();
				System.out.println("資料還原");
				if(conn!=null) conn.rollback();			
				
			} finally {
				// 關閉相關的物件
				if (pstmt1 != null) {
					try {
						pstmt1.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				if (pstmt2 != null) {
					try {
						pstmt2.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(conn!=null) conn.setAutoCommit(true);
				
				
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

	
	// 更新社福會員==>不修改圖片
		synchronized public int updateOrg4(MemberBean mb,OrgBean ob, InputStream is,
				long size, String filename, InputStream is2,
				long size2, String filename2) throws SQLException {
			PreparedStatement pstmt1 = null;
			PreparedStatement pstmt2 = null;
			Connection conn = ds.getConnection();
			int r = 0;		
			
			try {
				conn.setAutoCommit(false);
				
				String sql1 = " update ind " 
						+" set indName=?, indPhone=?, indEmail=?, "
						+" indAddress=?"
				  		+" where indId=? " ;			
				pstmt1 = conn.prepareStatement(sql1);	         
//		          String encrypedString = GlobalService.encryptString(mb.getIndpassword());
//				  pstmt1.setString(1, GlobalService.getMD5Endocing(encrypedString));
		          pstmt1.setString(1, mb.getIndname());
		          pstmt1.setString(2, mb.getIndphone());
		          pstmt1.setString(3, mb.getIndemail());
		          pstmt1.setString(4, mb.getIndaddress());
					pstmt1.setString(5, mb.getIndid());
					r = pstmt1.executeUpdate();			

					
				String sql2 = " update org " 
						+" set intro=?, leader=?, orgtypes=?, registerno=?, "
						+" raiseno=?"
				  		+" where indId=? " ;
				  pstmt2 = conn.prepareStatement(sql2);
//				  pstmt2.setString(1, mb.getIndid());          
		          java.sql.Timestamp now2 = new java.sql.Timestamp(System.currentTimeMillis());
		          pstmt2.setTimestamp(2, now2);
		          pstmt2.setString(1, ob.getIntro());
		          pstmt2.setString(2, ob.getLeader());
		          pstmt2.setInt(3, ob.getOrgtypes());
		          pstmt2.setString(4, ob.getRegisterno());
		          pstmt2.setString(5, ob.getRaiseno());
					pstmt2.setString(6, ob.getIndid());
					r = pstmt2.executeUpdate();	
					
					conn.commit();  
			}catch(SQLException ex){
				ex.printStackTrace();
				System.out.println("資料還原");
				if(conn!=null) conn.rollback();			
				
			} finally {
				// 關閉相關的物件
				if (pstmt1 != null) {
					try {
						pstmt1.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				if (pstmt2 != null) {
					try {
						pstmt2.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(conn!=null) conn.setAutoCommit(true);
				
				
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// 更新會員密碼
		synchronized public int updateMemberPassword(MemberBean mb, String newpassword) throws SQLException {
			PreparedStatement pstmt1 = null;
			Connection conn = ds.getConnection();
			int r = 0;
			
			try {
				String sql1 = " update ind " 
						+" set indPassword=? "
				  		+" where indId=? " ;
				
				pstmt1 = conn.prepareStatement(sql1);		         
//		          String encrypedString = GlobalService.encryptString(mb.getIndpassword());
//				  pstmt1.setString(1, GlobalService.getMD5Endocing(encrypedString));
				pstmt1.setString(1, newpassword);
				pstmt1.setString(2, mb.getIndid());
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