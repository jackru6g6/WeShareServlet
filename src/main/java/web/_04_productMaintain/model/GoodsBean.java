package web._04_productMaintain.model;

import java.io.*;
import java.sql.*;

public class GoodsBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int goodsno;
	int goodsstatus;//(0:NULL 1:募資 2:捐贈 3:以物易物)  
	Timestamp updatetime;	
	String indid;
	int goodstype;//物品類別
	String goodsname;
	int goodsloc;//需求地區
	String goodsnote;
	int qty;
	int goodsshipway;//1.面交  2.物流  3.都可	
	long deadline;	//0:結束 1:募完為止   yyyy-MM-dd
	String deadlinestring;	
	Blob goodsimage;	
	String goodsfilename;
	
	public GoodsBean() {
	}
	
	public GoodsBean(int goodsno, int goodsstatus, String indid, int goodstype, String goodsname, int goodsloc,
			String goodsnote, int qty, int goodsshipway, long deadline) {
		super();
		this.goodsno = goodsno;
		this.goodsstatus = goodsstatus;
		this.indid = indid;
		this.goodstype = goodstype;
		this.goodsname = goodsname;
		this.goodsloc = goodsloc;
		this.goodsnote = goodsnote;
		this.qty = qty;
		this.goodsshipway = goodsshipway;
		this.deadline = deadline;
	}

	public GoodsBean(int goodsno, int goodsstatus, Timestamp updatetime, String indid, int goodstype, String goodsname,
			int goodsloc, String goodsnote, int qty, int goodsshipway, long deadline, Blob goodsimage,
			String goodsfilename) {
		super();
		this.goodsno = goodsno;
		this.goodsstatus = goodsstatus;
		this.updatetime = updatetime;
		this.indid = indid;
		this.goodstype = goodstype;
		this.goodsname = goodsname;
		this.goodsloc = goodsloc;
		this.goodsnote = goodsnote;
		this.qty = qty;
		this.goodsshipway = goodsshipway;
		this.deadline = deadline;
		this.goodsimage = goodsimage;
		this.goodsfilename = goodsfilename;
	}
	public int getGoodsno() {
		return goodsno;
	}
	public void setGoodsno(int goodsno) {
		this.goodsno = goodsno;
	}
	public int getGoodsstatus() {
		return goodsstatus;
	}
	public void setGoodsstatus(int goodsstatus) {
		this.goodsstatus = goodsstatus;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public String getIndid() {
		return indid;
	}
	public void setIndid(String indid) {
		this.indid = indid;
	}
	public int getGoodstype() {
		return goodstype;
	}
	public void setGoodstype(int goodstypes) {
		this.goodstype = goodstypes;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public int getGoodsloc() {
		return goodsloc;
	}
	public void setGoodsloc(int goodsloc) {
		this.goodsloc = goodsloc;
	}
	public String getGoodsnote() {
		return goodsnote;
	}
	public void setGoodsnote(String goodsnote) {
		this.goodsnote = goodsnote;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getGoodsshipway() {
		return goodsshipway;
	}
	public void setGoodsshipway(int goodsshipway) {
		this.goodsshipway = goodsshipway;
	}
	public long getDeadline() {
		return deadline;
	}
	public void setDeadline(long deadline) {
		this.deadline = deadline;
	}
	public Blob getGoodsimage() {
		return goodsimage;
	}
	public void setGoodsimage(Blob goodsimage) {
		this.goodsimage = goodsimage;
	}
	public String getGoodsfilename() {
		return goodsfilename;
	}
	public void setGoodsfilename(String goodsfilename) {
		this.goodsfilename = goodsfilename;
	}

	public String getDeadlinestring() {
		return deadlinestring;
	}

	public void setDeadlinestring(String deadlinestring) {
		this.deadlinestring = deadlinestring;
	}
	
	
	
	
	
	
	



}
