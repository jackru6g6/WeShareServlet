package web._01_register.model;

public class OrgTypeBean {
	int orgno;
	String orgname;
	
	public OrgTypeBean() {
	}
	public OrgTypeBean(int orgno, String orgname) {
		super();
		this.orgno = orgno;
		this.orgname = orgname;
	}
	public int getOrgno() {
		return orgno;
	}
	public void setOrgno(int orgno) {
		this.orgno = orgno;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	
	
	

}
