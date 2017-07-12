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
@Table(name = "feedback")
public class FeedbackBean {
	private int dealNo;
	private Timestamp postDate;
	private String fbSourceId;
	private String fbEndId;
	private String fbText;
	private int fbScore;
	private Blob fbImage;
	private String fbFileName;

	public FeedbackBean() {
		super();
	}

	public FeedbackBean(int dealNo, Timestamp postDate, String fbSourceId, String fbEndId, String fbText, int fbScore,
			Blob fbImage, String fbFileName) {
		super();
		this.dealNo = dealNo;
		this.postDate = postDate;
		this.fbSourceId = fbSourceId;
		this.fbEndId = fbEndId;
		this.fbText = fbText;
		this.fbScore = fbScore;
		this.fbImage = fbImage;
		this.fbFileName = fbFileName;
	}

	@Id
	// @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "dealNo")
	public int getDealNo() {
		return dealNo;
	}

	public void setDealNo(int dealNo) {
		this.dealNo = dealNo;
	}

	@Column(name = "postDate")
	public Timestamp getPostDate() {
		return postDate;
	}

	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}

	@Column(name = "fbSourceId")
	public String getFbSourceId() {
		return fbSourceId;
	}

	public void setFbSourceId(String fbSourceId) {
		this.fbSourceId = fbSourceId;
	}

	@Column(name = "fbEndId")
	public String getFbEndId() {
		return fbEndId;
	}

	public void setFbEndId(String fbEndId) {
		this.fbEndId = fbEndId;
	}

	@Column(name = "fbText")
	public String getFbText() {
		return fbText;
	}

	public void setFbText(String fbText) {
		this.fbText = fbText;
	}

	@Column(name = "fbScore")
	public int getFbScore() {
		return fbScore;
	}

	public void setFbScore(int fbScore) {
		this.fbScore = fbScore;
	}

	@Column(name = "fbImage")
	public Blob getFbImage() {
		return fbImage;
	}

	public void setFbImage(Blob fbImage) {
		this.fbImage = fbImage;
	}

	@Column(name = "fbFileName")
	public String getFbFileName() {
		return fbFileName;
	}

	public void setFbFileName(String fbFileName) {
		this.fbFileName = fbFileName;
	}

}
