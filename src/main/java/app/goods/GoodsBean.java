package app.goods;

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
public class GoodsBean {
	private int goodsNo;
	private int goodsStatus;
	private java.sql.Timestamp updateTime;
	private String indId;
	private String goodsName;
	private int goodsType;
	private int Qty;
	private int goodsLoc;
	private String goodsNote;
	private int goodsShipWay;
	private Blob goodsImage = null;
	private java.sql.Timestamp deadLine;

	public GoodsBean() {
		super();
	}

	public GoodsBean(int goodsNo, int goodsStatus, Timestamp updateTime, String indId, String goodsName, int goodsType,
			int qty, int goodsLoc, String goodsNote, int goodsShipWay, Blob goodsImage, Timestamp deadLine) {
		super();
		this.goodsNo = goodsNo;
		this.goodsStatus = goodsStatus;
		this.updateTime = updateTime;
		this.indId = indId;
		this.goodsName = goodsName;
		this.goodsType = goodsType;
		Qty = qty;
		this.goodsLoc = goodsLoc;
		this.goodsNote = goodsNote;
		this.goodsShipWay = goodsShipWay;
		this.goodsImage = goodsImage;
		this.deadLine = deadLine;
	}

	public GoodsBean(int goodsNo, int goodsStatus, Timestamp updateTime, String goodsName, int goodsType, int qty,
			int goodsLoc, String goodsNote, int goodsShipWay, Timestamp deadLine) {
		super();
		this.goodsNo = goodsNo;
		this.goodsStatus = goodsStatus;
		this.updateTime = updateTime;
		this.goodsName = goodsName;
		this.goodsType = goodsType;
		Qty = qty;
		this.goodsLoc = goodsLoc;
		this.goodsNote = goodsNote;
		this.goodsShipWay = goodsShipWay;
		this.deadLine = deadLine;
	}

	public int getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}

	public int getGoodsStatus() {
		return goodsStatus;
	}

	public void setGoodsStatus(int goodsStatus) {
		this.goodsStatus = goodsStatus;
	}

	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getIndId() {
		return indId;
	}

	public void setIndId(String indId) {
		this.indId = indId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(int goodsType) {
		this.goodsType = goodsType;
	}

	public int getQty() {
		return Qty;
	}

	public void setQty(int qty) {
		Qty = qty;
	}

	public int getGoodsLoc() {
		return goodsLoc;
	}

	public void setGoodsLoc(int goodsLoc) {
		this.goodsLoc = goodsLoc;
	}

	public String getGoodsNote() {
		return goodsNote;
	}

	public void setGoodsNote(String goodsNote) {
		this.goodsNote = goodsNote;
	}

	public int getGoodsShipWay() {
		return goodsShipWay;
	}

	public void setGoodsShipWay(int goodsShipWay) {
		this.goodsShipWay = goodsShipWay;
	}

	public Blob getGoodsImage() {
		return goodsImage;
	}

	public void setGoodsImage(Blob goodsImage) {
		this.goodsImage = goodsImage;
	}

	public java.sql.Timestamp getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(java.sql.Timestamp deadLine) {
		this.deadLine = deadLine;
	}

	
	


}