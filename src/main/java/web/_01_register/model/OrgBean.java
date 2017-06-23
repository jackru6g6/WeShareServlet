package web._01_register.model;

import java.io.*;
import java.sql.*;

public class OrgBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	String indid;
	Timestamp updatetime;
	String intro;
	String leader;
	int orgtypes;
	String registerno;
	String raiseno;
	Blob orgimage;	
	String orgfilename;

	
	
	
	
	public OrgBean(String indid, String intro, String leader, int orgtypes, String registerno, String raiseno) {
		super();
		this.indid = indid;
		this.intro = intro;
		this.leader = leader;
		this.orgtypes = orgtypes;
		this.registerno = registerno;
		this.raiseno = raiseno;
	}


	public OrgBean(String indid, Timestamp updatetime, String intro, String leader, int orgtypes, String registerno,
			String raiseno, Blob orgimage, String orgfilename) {
		super();
		this.indid = indid;
		this.updatetime = updatetime;
		this.intro = intro;
		this.leader = leader;
		this.orgtypes = orgtypes;
		this.registerno = registerno;
		this.raiseno = raiseno;
		this.orgimage = orgimage;
		this.orgfilename = orgfilename;
	}


	public OrgBean() {
		super();
	}	

	public String toString() {
		return "userid=" + indid ;
	}


	public String getIndid() {
		return indid;
	}


	public void setIndid(String indid) {
		this.indid = indid;
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


	public Blob getOrgimage() {
		return orgimage;
	}


	public void setOrgimage(Blob orgimage) {
		this.orgimage = orgimage;
	}


	public String getOrgfilename() {
		return orgfilename;
	}


	public void setOrgfilename(String orgfilename) {
		this.orgfilename = orgfilename;
	}

	
	
	



}
