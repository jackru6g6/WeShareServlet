package web._01_register.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public interface RegisterServiceDAO {
	public int saveMember(MemberBean mb, InputStream is, long size, String filename)
	    throws SQLException ;
	
	
	public int saveOrg(MemberBean mb,OrgBean ob, InputStream is,
			long size, String filename, InputStream is2,
			long size2, String filename2) throws SQLException;
	
	public List<Object> populateMember(String pk) throws SQLException;
	public int updateMember(MemberBean mb, InputStream is,
			long size, String filename) throws SQLException ;

	
	public int updateOrg(MemberBean mb,OrgBean ob, InputStream is,
			long size, String filename, InputStream is2,
			long size2, String filename2) throws SQLException ;
	
	public boolean idExists(String id) throws IOException;

}
