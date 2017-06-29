package app.goods;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GOODS")
public class GoodsBean implements Serializable{
	private int goodsNo;
	private int goodsStatus;
	private Timestamp updateTime;
	private String indId;
	private String goodsName;
	private int goodsType;
	private int Qty;
	private int goodsLoc;
	private String goodsNote;
	private int goodsShipWay;
	private Blob goodsImage = null;
	private long deadLine;

	public GoodsBean() {
		super();
	}
	


	public GoodsBean(Blob goodsImage) {
		super();
		this.goodsImage = goodsImage;
	}



	public GoodsBean(int goodsNo) {
		super();
		this.goodsNo = goodsNo;
	}


	public GoodsBean(Timestamp updateTime) {
		super();
		this.updateTime = updateTime;
	}






	public GoodsBean(int goodsNo,int goodsStatus, String indId, String goodsName, int goodsType, int qty,
			int goodsLoc, String goodsNote, int goodsShipWay, long deadLine) {
		super();
		this.goodsNo=goodsNo;
		this.goodsStatus = goodsStatus;
		this.indId = indId;
		this.goodsName = goodsName;
		this.goodsType = goodsType;
		Qty = qty;
		this.goodsLoc = goodsLoc;
		this.goodsNote = goodsNote;
		this.goodsShipWay = goodsShipWay;
		this.deadLine = deadLine;
	}

	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getGoodsNo() {
		return goodsNo;
	}
	
	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}

	@Column(name="goodsStatus")
	public int getGoodsStatus() {
		return goodsStatus;
	}

	public void setGoodsStatus(int goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	@Column(name="updateTime")
	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	@Column(name="indId")
	public String getIndId() {
		return indId;
	}

	public void setIndId(String indId) {
		this.indId = indId;
	}
	@Column(name="goodsName")
	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	@Column(name="goodstype")
	public int getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(int goodsType) {
		this.goodsType = goodsType;
	}
	
	@Column(name="Qty")
	public int getQty() {
		return Qty;
	}

	public void setQty(int qty) {
		Qty = qty;
	}
	@Column(name="goodsLoc")
	public int getGoodsLoc() {
		return goodsLoc;
	}

	public void setGoodsLoc(int goodsLoc) {
		this.goodsLoc = goodsLoc;
	}
	@Column(name="goodsNote")
	public String getGoodsNote() {
		return goodsNote;
	}

	public void setGoodsNote(String goodsNote) {
		this.goodsNote = goodsNote;
	}
	@Column(name="goodsShipWay")
	public int getGoodsShipWay() {
		return goodsShipWay;
	}

	public void setGoodsShipWay(int goodsShipWay) {
		this.goodsShipWay = goodsShipWay;
	}
	@Column(name="goodsImage")
	public Blob getGoodsImage() {
		return goodsImage;
	}

	public void setGoodsImage(Blob goodsImage) {
		this.goodsImage = goodsImage;
	}
	@Column(name="deadLine")
	public long getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(long deadLine) {
		this.deadLine = deadLine;
	}

	
	


}