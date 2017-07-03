package web._06_MSG.model;

import java.sql.Blob;
import java.sql.Timestamp;

public class MSGBean {
	int MSGNO;
	int MSGSTATUS;
	Timestamp POSTDATE;
	String MSGSOURCEID;
	String MSGENDID;
	String MSGTEXT;
	Blob MSGIMAGE;
	String MSGFILENAME;
	int ROOMNO;
	public MSGBean() {
		// TODO Auto-generated constructor stub
	}

	// INSERT DATA
	public MSGBean(String mSGSOURCEID, String mSGENDID, String mSGTEXT, String mSGFILENAME) {
		super();
		MSGSOURCEID = mSGSOURCEID;
		MSGENDID = mSGENDID;
		MSGTEXT = mSGTEXT;
		MSGFILENAME = mSGFILENAME;

	}

	public MSGBean(int mSGNO, int mSGSTATUS, Timestamp pOSTDATE, String mSGSOURCEID, String mSGENDID, String mSGTEXT,
			Blob mSGIMAGE, String mSGFILENAME, int rOOMNO) {
		super();
		MSGNO = mSGNO;
		MSGSTATUS = mSGSTATUS;
		POSTDATE = pOSTDATE;
		MSGSOURCEID = mSGSOURCEID;
		MSGENDID = mSGENDID;
		MSGTEXT = mSGTEXT;
		MSGIMAGE = mSGIMAGE;
		MSGFILENAME = mSGFILENAME;
		ROOMNO = rOOMNO;
	}

	public int getMSGNO() {
		return MSGNO;
	}

	public void setMSGNO(int mSGNO) {
		MSGNO = mSGNO;
	}

	public int getMSGSTATUS() {
		return MSGSTATUS;
	}

	public void setMSGSTATUS(int mSGSTATUS) {
		MSGSTATUS = mSGSTATUS;
	}

	public Timestamp getPOSTDATE() {
		return POSTDATE;
	}

	public void setPOSTDATE(Timestamp pOSTDATE) {
		POSTDATE = pOSTDATE;
	}

	public String getMSGSOURCEID() {
		return MSGSOURCEID;
	}

	public void setMSGSOURCEID(String mSGSOURCEID) {
		MSGSOURCEID = mSGSOURCEID;
	}

	public String getMSGENDID() {
		return MSGENDID;
	}

	public void setMSGENDID(String mSGENDID) {
		MSGENDID = mSGENDID;
	}

	public String getMSGTEXT() {
		return MSGTEXT;
	}

	public void setMSGTEXT(String mSGTEXT) {
		MSGTEXT = mSGTEXT;
	}

	public Blob getMSGIMAGE() {
		return MSGIMAGE;
	}

	public void setMSGIMAGE(Blob mSGIMAGE) {
		MSGIMAGE = mSGIMAGE;
	}

	public String getMSGFILENAME() {
		return MSGFILENAME;
	}

	public void setMSGFILENAME(String mSGFILENAME) {
		MSGFILENAME = mSGFILENAME;
	}

	public int getROOMNO() {
		return ROOMNO;
	}

	public void setROOMNO(int rOOMNO) {
		ROOMNO = rOOMNO;
	}


}
