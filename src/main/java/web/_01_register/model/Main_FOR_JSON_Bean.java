package web._01_register.model;

import java.sql.Blob;
import java.sql.Timestamp;

public class Main_FOR_JSON_Bean {
	int usertype;
	Timestamp postdate;
	String indid;
	String indpassword;
	String indname;
	String indphone;
	String indemail;
	String indaddress;
	String indfilename;
	Timestamp updatetime;
	String intro;
	String leader;
	int orgtypes;
	String registerno;
	String raiseno;
	String orgfilename;

	public Main_FOR_JSON_Bean() {
	}

	public Main_FOR_JSON_Bean(int usertype, Timestamp postdate, String indid, String indpassword, String indname, String indphone,
			String indemail, String indaddress, String indfilename, Timestamp updatetime, String intro, String leader,
			int orgtypes, String registerno, String raiseno, String orgfilename) {
		super();
		this.usertype = usertype;
		this.postdate = postdate;
		this.indid = indid;
		this.indpassword = indpassword;
		this.indname = indname;
		this.indphone = indphone;
		this.indemail = indemail;
		this.indaddress = indaddress;
		this.indfilename = indfilename;
		this.updatetime = updatetime;
		this.intro = intro;
		this.leader = leader;
		this.orgtypes = orgtypes;
		this.registerno = registerno;
		this.raiseno = raiseno;
		this.orgfilename = orgfilename;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public Timestamp getPostdate() {
		return postdate;
	}

	public void setPostdate(Timestamp postdate) {
		this.postdate = postdate;
	}

	public String getIndid() {
		return indid;
	}

	public void setIndid(String indid) {
		this.indid = indid;
	}

	public String getIndpassword() {
		return indpassword;
	}

	public void setIndpassword(String indpassword) {
		this.indpassword = indpassword;
	}

	public String getIndname() {
		return indname;
	}

	public void setIndname(String indname) {
		this.indname = indname;
	}

	public String getIndphone() {
		return indphone;
	}

	public void setIndphone(String indphone) {
		this.indphone = indphone;
	}

	public String getIndemail() {
		return indemail;
	}

	public void setIndemail(String indemail) {
		this.indemail = indemail;
	}

	public String getIndaddress() {
		return indaddress;
	}

	public void setIndaddress(String indaddress) {
		this.indaddress = indaddress;
	}

	public String getIndfilename() {
		return indfilename;
	}

	public void setIndfilename(String indfilename) {
		this.indfilename = indfilename;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public int getOrgtypes() {
		return orgtypes;
	}

	public void setOrgtypes(int orgtypes) {
		this.orgtypes = orgtypes;
	}

	public String getRegisterno() {
		return registerno;
	}

	public void setRegisterno(String registerno) {
		this.registerno = registerno;
	}

	public String getRaiseno() {
		return raiseno;
	}

	public void setRaiseno(String raiseno) {
		this.raiseno = raiseno;
	}

	public String getOrgfilename() {
		return orgfilename;
	}

	public void setOrgfilename(String orgfilename) {
		this.orgfilename = orgfilename;
	}

}
