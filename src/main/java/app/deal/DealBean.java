package app.deal;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deal")
public class DealBean {
	private int dealNo;
	private java.sql.Timestamp postDate;
	private String sourceId;
	private String endId;
	private int dealStatus;
	private int endShipWay;
	private String shipNo;
	private java.sql.Timestamp shipDate;

	private String goodsName;
	private int dealQty;
	private Blob goodsImage;
	private String goodsImageName;
	private int goodstype;
	private int goodsLoc;
	private String goodsNote;

	public DealBean() {
		super();
	}

	public DealBean(int dealNo, Timestamp postDate, String sourceId, String endId, int dealStatus, int endShipWay,
			String shipNo, Timestamp shipDate, String goodsName, int dealQty, Blob goodsImage, String goodsImageName,
			int goodstype, int goodsLoc, String goodsNote) {
		super();
		this.dealNo = dealNo;
		this.postDate = postDate;
		this.sourceId = sourceId;
		this.endId = endId;
		this.dealStatus = dealStatus;
		this.endShipWay = endShipWay;
		this.shipNo = shipNo;
		this.shipDate = shipDate;
		this.goodsName = goodsName;
		this.dealQty = dealQty;
		this.goodsImage = goodsImage;
		this.goodsImageName = goodsImageName;
		this.goodstype = goodstype;
		this.goodsLoc = goodsLoc;
		this.goodsNote = goodsNote;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "dealNo")
	public int getDealNo() {
		return dealNo;
	}

	public void setDealNo(int dealNo) {
		this.dealNo = dealNo;
	}

	@Column(name = "postDate")
	public java.sql.Timestamp getPostDate() {
		return postDate;
	}

	public void setPostDate(java.sql.Timestamp postDate) {
		this.postDate = postDate;
	}

	@Column(name = "sourceId")
	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	@Column(name = "endId")
	public String getEndId() {
		return endId;
	}

	public void setEndId(String endId) {
		this.endId = endId;
	}

	@Column(name = "dealStatus")
	public int getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(int dealStatus) {
		this.dealStatus = dealStatus;
	}

	@Column(name = "endShipWay")
	public int getEndShipWay() {
		return endShipWay;
	}

	public void setEndShipWay(int endShipWay) {
		this.endShipWay = endShipWay;
	}

	@Column(name = "shipNo")
	public String getShipNo() {
		return shipNo;
	}

	public void setShipNo(String shipNo) {
		this.shipNo = shipNo;
	}

	@Column(name = "shipDate")
	public java.sql.Timestamp getShipDate() {
		return shipDate;
	}

	public void setShipDate(java.sql.Timestamp shipDate) {
		this.shipDate = shipDate;
	}

	@Column(name = "goodsName")
	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Column(name = "dealQty")
	public int getDealQty() {
		return dealQty;
	}

	public void setDealQty(int dealQty) {
		this.dealQty = dealQty;
	}

	@Column(name = "goodsImage")
	public Blob getGoodsImage() {
		return goodsImage;
	}

	public void setGoodsImage(Blob goodsImage) {
		this.goodsImage = goodsImage;
	}

	@Column(name = "goodsImageName")
	public String getGoodsImageName() {
		return goodsImageName;
	}

	public void setGoodsImageName(String goodsImageName) {
		this.goodsImageName = goodsImageName;
	}

	@Column(name = "goodstype")
	public int getGoodstype() {
		return goodstype;
	}

	public void setGoodstype(int goodstype) {
		this.goodstype = goodstype;
	}

	@Column(name = "goodsLoc")
	public int getGoodsLoc() {
		return goodsLoc;
	}

	public void setGoodsLoc(int goodsLoc) {
		this.goodsLoc = goodsLoc;
	}

	@Column(name = "goodsNote")
	public String getGoodsNote() {
		return goodsNote;
	}

	public void setGoodsNote(String goodsNote) {
		this.goodsNote = goodsNote;
	}

}
