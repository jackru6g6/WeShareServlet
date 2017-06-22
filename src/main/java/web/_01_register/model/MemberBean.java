package web._01_register.model;

import java.io.*;
import java.sql.*;

public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int usertype;
	Timestamp postdate;
	String indid;
	String indpassword;
	String indname;
	String indphone;
	String indemail;
	String indaddress;
	Blob indimage;	
	String indfilename;
	
	
	
	public MemberBean(int userType, Timestamp postDate, String indId, String indPassword, String indName,
			String indPhone, String indEmail, String indAddress, Blob indImage, String indFileName) {
		super();
		this.usertype = userType;
		this.postdate = postDate;
		this.indid = indId;
		this.indpassword = indPassword;
		this.indname = indName;
		this.indphone = indPhone;
		this.indemail = indEmail;
		this.indaddress = indAddress;
		this.indimage = indImage;
		this.indfilename = indFileName;
	}

	public MemberBean(int userType,  Timestamp postDate, String indId, String indPassword, String indName,
			String indPhone, String indEmail, String indAddress, String indFileName) {
		super();
		this.usertype = userType;
		this.postdate = postDate;
		this.indid = indId;
		this.indpassword = indPassword;
		this.indname = indName;
		this.indphone = indPhone;
		this.indemail = indEmail;
		this.indaddress = indAddress;
		this.indfilename = indFileName;
	}
	
	public MemberBean(int userType, String indId, String indPassword, String indName, String indPhone, String indEmail,
			String indAddress) {
		super();
		this.usertype = userType;
		this.indid = indId;
		this.indpassword = indPassword;
		this.indname = indName;
		this.indphone = indPhone;
		this.indemail = indEmail;
		this.indaddress = indAddress;
	}

	public MemberBean(int userType, Timestamp postDate, String indId, String indPassword, String indName,
			String indPhone, String indEmail, String indAddress) {
		super();
		this.usertype = userType;
		this.postdate = postDate;
		this.indid = indId;
		this.indpassword = indPassword;
		this.indname = indName;
		this.indphone = indPhone;
		this.indemail = indEmail;
		this.indaddress = indAddress;
	}

	public MemberBean() {
		super();
	}	

	public String toString() {
		return "userid=" + indid + "   password="+indpassword;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int userType) {
		this.usertype = userType;
	}

	public Timestamp getPostdate() {
		return postdate;
	}

	public void setPostdate(Timestamp postDate) {
		this.postdate = postDate;
	}

	public String getIndid() {
		return indid;
	}

	public void setIndid(String indId) {
		this.indid = indId;
	}

	public String getIndpassword() {
		return indpassword;
	}

	public void setIndpassword(String indPassword) {
		this.indpassword = indPassword;
	}

	public String getIndname() {
		return indname;
	}

	public void setIndname(String indName) {
		this.indname = indName;
	}

	public String getIndphone() {
		return indphone;
	}

	public void setIndphone(String indPhone) {
		this.indphone = indPhone;
	}

	public String getIndemail() {
		return indemail;
	}

	public void setIndemail(String indEmail) {
		this.indemail = indEmail;
	}

	public String getIndaddress() {
		return indaddress;
	}

	public void setIndaddress(String indAddress) {
		this.indaddress = indAddress;
	}

	public Blob getIndimage() {
		return indimage;
	}

	public void setIndimage(Blob indImage) {
		this.indimage = indImage;
	}

	public String getIndfilename() {
		return indfilename;
	}

	public void setIndfilename(String indFileName) {
		this.indfilename = indFileName;
	}
	
	



}
