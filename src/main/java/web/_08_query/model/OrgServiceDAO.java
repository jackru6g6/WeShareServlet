package web._08_query.model;

import java.sql.SQLException;
import java.util.List;


public interface OrgServiceDAO {
	
	public List<Object> getOrg() throws SQLException ;
	
	public List<Object> getOrgByKeyword(String keyword) throws SQLException ;
	
	public List<Object> getOrgByOrgtypes(String orgtype) throws SQLException ;
	
	public List<Object> getOrgByIndAddress(String indaddress) throws SQLException ;

}
