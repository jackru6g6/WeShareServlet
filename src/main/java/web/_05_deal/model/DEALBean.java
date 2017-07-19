package web._05_deal.model;

import java.sql.Blob;
import java.sql.Timestamp;

public class DEALBean {
	int DEALNO;
	Timestamp POSTDATE;
	String SOURCEID;
	String ENDID;
	int DEALSTATUS;
	int ENDSHIPWAY;
	int DEALQTY;
	String DEALNOTE;
	Timestamp SHIPDATE;
	String SHIPNO;
	Blob DEALIMAGE;
	String DEALFILENAME;
	/////////////////////////////////////
	String GOODSNAME;
	Blob GOODSIMAGE;
	String GOODSIMAGENAME;
	int GOODSTYPES;
	int GOODSLOC;
	String GOODSNOTE;
	String SOURCENAME;
	String ENDNAME;

	public DEALBean() {
		// TODO Auto-generated constructor stub
	}

	public DEALBean(int dEALNO, Timestamp pOSTDATE, String sOURCEID, String eNDID, int dEALSTATUS, int eNDSHIPWAY,
			int dEALQTY, String dEALNOTE, Timestamp sHIPDATE, String sHIPNO, Blob dEALIMAGE, String dEALFILENAME,
			String gOODSNAME, Blob gOODSIMAGE, String gOODSIMAGENAME, int gOODSTYPES, int gOODSLOC, String gOODSNOTE) {
		super();
		DEALNO = dEALNO;
		POSTDATE = pOSTDATE;
		SOURCEID = sOURCEID;
		ENDID = eNDID;
		DEALSTATUS = dEALSTATUS;
		ENDSHIPWAY = eNDSHIPWAY;
		DEALQTY = dEALQTY;
		DEALNOTE = dEALNOTE;
		SHIPDATE = sHIPDATE;
		SHIPNO = sHIPNO;
		DEALIMAGE = dEALIMAGE;
		DEALFILENAME = dEALFILENAME;
		GOODSNAME = gOODSNAME;
		GOODSIMAGE = gOODSIMAGE;
		GOODSIMAGENAME = gOODSIMAGENAME;
		GOODSTYPES = gOODSTYPES;
		GOODSLOC = gOODSLOC;
		GOODSNOTE = gOODSNOTE;
	}

	public int getDEALNO() {
		return DEALNO;
	}

	public void setDEALNO(int dEALNO) {
		DEALNO = dEALNO;
	}

	public Timestamp getPOSTDATE() {
		return POSTDATE;
	}

	public void setPOSTDATE(Timestamp pOSTDATE) {
		POSTDATE = pOSTDATE;
	}

	public String getSOURCEID() {
		return SOURCEID;
	}

	public void setSOURCEID(String sOURCEID) {
		SOURCEID = sOURCEID;
	}

	public String getENDID() {
		return ENDID;
	}

	public void setENDID(String eNDID) {
		ENDID = eNDID;
	}

	public int getDEALSTATUS() {
		return DEALSTATUS;
	}

	public void setDEALSTATUS(int dEALSTATUS) {
		DEALSTATUS = dEALSTATUS;
	}

	public int getENDSHIPWAY() {
		return ENDSHIPWAY;
	}

	public void setENDSHIPWAY(int eNDSHIPWAY) {
		ENDSHIPWAY = eNDSHIPWAY;
	}

	public int getDEALQTY() {
		return DEALQTY;
	}

	public void setDEALQTY(int dEALQTY) {
		DEALQTY = dEALQTY;
	}

	public String getDEALNOTE() {
		return DEALNOTE;
	}

	public void setDEALNOTE(String dEALNOTE) {
		DEALNOTE = dEALNOTE;
	}

	public Timestamp getSHIPDATE() {
		return SHIPDATE;
	}

	public void setSHIPDATE(Timestamp sHIPDATE) {
		SHIPDATE = sHIPDATE;
	}

	public String getSHIPNO() {
		return SHIPNO;
	}

	public void setSHIPNO(String sHIPNO) {
		SHIPNO = sHIPNO;
	}

	public Blob getDEALIMAGE() {
		return DEALIMAGE;
	}

	public void setDEALIMAGE(Blob dEALIMAGE) {
		DEALIMAGE = dEALIMAGE;
	}

	public String getDEALFILENAME() {
		return DEALFILENAME;
	}

	public void setDEALFILENAME(String dEALFILENAME) {
		DEALFILENAME = dEALFILENAME;
	}

	public String getGOODSNAME() {
		return GOODSNAME;
	}

	public void setGOODSNAME(String gOODSNAME) {
		GOODSNAME = gOODSNAME;
	}

	public Blob getGOODSIMAGE() {
		return GOODSIMAGE;
	}

	public void setGOODSIMAGE(Blob gOODSIMAGE) {
		GOODSIMAGE = gOODSIMAGE;
	}

	public String getGOODSIMAGENAME() {
		return GOODSIMAGENAME;
	}

	public void setGOODSIMAGENAME(String gOODSIMAGENAME) {
		GOODSIMAGENAME = gOODSIMAGENAME;
	}

	public int getGOODSTYPES() {
		return GOODSTYPES;
	}

	public void setGOODSTYPES(int gOODSTYPES) {
		GOODSTYPES = gOODSTYPES;
	}

	public int getGOODSLOC() {
		return GOODSLOC;
	}

	public void setGOODSLOC(int gOODSLOC) {
		GOODSLOC = gOODSLOC;
	}

	public String getGOODSNOTE() {
		return GOODSNOTE;
	}

	public void setGOODSNOTE(String gOODSNOTE) {
		GOODSNOTE = gOODSNOTE;
	}

	public String getSOURCENAME() {
		return SOURCENAME;
	}

	public void setSOURCENAME(String sOURCENAME) {
		SOURCENAME = sOURCENAME;
	}

	public String getENDNAME() {
		return ENDNAME;
	}

	public void setENDNAME(String eNDNAME) {
		ENDNAME = eNDNAME;
	}

}
