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
	private int goodsQty;
	private int goodsLoc;
	private String goodsNote;
	private int goodsShipWay;
	private Blob image = null;
	private java.sql.Timestamp deadTime;
	
	

	public GoodsBean() {
		System.out.println("ABCCCCCCCC");
		System.out.println("132e1f5ef15ef");
	}

	public GoodsBean(int goodsNo, int goodsStatus, Timestamp updateTime, String indId, String goodsName, int goodsType,
			int goodsQty, int goodsLoc, String goodsNote, int goodsShipWay, Blob image, Timestamp deadTime) {
		super();
		this.goodsNo = goodsNo;
		this.goodsStatus = goodsStatus;
		this.updateTime = updateTime;
		this.indId = indId;
		this.goodsName = goodsName;
		this.goodsType = goodsType;
		this.goodsQty = goodsQty;
		this.goodsLoc = goodsLoc;
		this.goodsNote = goodsNote;
		this.goodsShipWay = goodsShipWay;
		this.image = image;
		this.deadTime = deadTime;
	}

	public GoodsBean(int goodsStatus, Timestamp updateTime, String indId, String goodsName, int goodsType,
			int goodsQty, int goodsLoc, String goodsNote, int goodsShipWay, Blob image, Timestamp deadTime) {
		super();
		this.goodsStatus = goodsStatus;
		this.updateTime = updateTime;
		this.indId = indId;
		this.goodsName = goodsName;
		this.goodsType = goodsType;
		this.goodsQty = goodsQty;
		this.goodsLoc = goodsLoc;
		this.goodsNote = goodsNote;
		this.goodsShipWay = goodsShipWay;
		this.image = image;
		this.deadTime = deadTime;
	}
	
	public GoodsBean(int goodsNo, int goodsStatus, Timestamp updateTime, String indId, String goodsName, int goodsType,
			int goodsQty, int goodsLoc, String goodsNote, int goodsShipWay, Timestamp deadTime) {
		super();
		this.goodsNo = goodsNo;
		this.goodsStatus = goodsStatus;
		this.updateTime = updateTime;
		this.indId = indId;
		this.goodsName = goodsName;
		this.goodsType = goodsType;
		this.goodsQty = goodsQty;
		this.goodsLoc = goodsLoc;
		this.goodsNote = goodsNote;
		this.goodsShipWay = goodsShipWay;
		this.deadTime = deadTime;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GoodsNo")
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

	public int getGoodsQty() {
		return goodsQty;
	}

	public void setGoodsQty(int goodsQty) {
		this.goodsQty = goodsQty;
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

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public java.sql.Timestamp getDeadTime() {
		return deadTime;
	}

	public void setDeadTime(java.sql.Timestamp deadTime) {
		this.deadTime = deadTime;
	}

}
