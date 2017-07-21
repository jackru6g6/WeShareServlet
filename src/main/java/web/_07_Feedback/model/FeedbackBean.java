package web._07_Feedback.model;

import java.sql.Blob;
import java.sql.Timestamp;

public class FeedbackBean {
	String DEALNO;
	Timestamp POSTDATE;
	String FBSOURCEID;
	String FBENDID;
	String FBTEXT;
	int FBSCORE;
	Blob FBIMAGE;
	String FBFILENAME;
	int Ans;

	public FeedbackBean(String dEALNO, Timestamp pOSTDATE, String fBSOURCEID, String fBENDID, String fBTEXT,
			int fBSCORE, Blob fBIMAGE, String fBFILENAME) {
		super();
		DEALNO = dEALNO;
		POSTDATE = pOSTDATE;
		FBSOURCEID = fBSOURCEID;
		FBENDID = fBENDID;
		FBTEXT = fBTEXT;
		FBSCORE = fBSCORE;
		FBIMAGE = fBIMAGE;
		FBFILENAME = fBFILENAME;
	}

	public int getAns() {
		return Ans;
	}

	public void setAns(int ans) {
		Ans = ans;
	}

	public FeedbackBean() {
		// TODO Auto-generated constructor stub
	}

	public String getDEALNO() {
		return DEALNO;
	}

	public void setDEALNO(String dEALNO) {
		DEALNO = dEALNO;
	}

	public Timestamp getPOSTDATE() {
		return POSTDATE;
	}

	public void setPOSTDATE(Timestamp pOSTDATE) {
		POSTDATE = pOSTDATE;
	}

	public String getFBSOURCEID() {
		return FBSOURCEID;
	}

	public void setFBSOURCEID(String fBSOURCEID) {
		FBSOURCEID = fBSOURCEID;
	}

	public String getFBENDID() {
		return FBENDID;
	}

	public void setFBENDID(String fBENDID) {
		FBENDID = fBENDID;
	}

	public String getFBTEXT() {
		return FBTEXT;
	}

	public void setFBTEXT(String fBTEXT) {
		FBTEXT = fBTEXT;
	}

	public int getFBSCORE() {
		return FBSCORE;
	}

	public void setFBSCORE(int fBSCORE) {
		FBSCORE = fBSCORE;
	}

	public Blob getFBIMAGE() {
		return FBIMAGE;
	}

	public void setFBIMAGE(Blob fBIMAGE) {
		FBIMAGE = fBIMAGE;
	}

	public String getFBFILENAME() {
		return FBFILENAME;
	}

	public void setFBFILENAME(String fBFILENAME) {
		FBFILENAME = fBFILENAME;
	}

}