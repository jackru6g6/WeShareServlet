package app.message;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "msg")
public class MessageBean {
	private int msgNo;
	private int msgStatus;
	private java.sql.Timestamp postDate;
	private String msgSourceId;
	private String msgEndId;
	private String msgText;
	private Blob msgImage = null;
	private String msgFileName = "msgFileName";
	private int roomNo;

	

	public MessageBean() {
		super();
	}

	public MessageBean(int msgNo, int msgStatus, String msgSourceId, String msgEndId, String msgText, int roomNo) {
		super();
		this.msgNo = msgNo;
		this.msgStatus = msgStatus;
		this.msgSourceId = msgSourceId;
		this.msgEndId = msgEndId;
		this.msgText = msgText;
		this.roomNo = roomNo;
	}

	public MessageBean(int msgNo, int msgStatus, String msgSourceId, String msgEndId, String msgText) {
		super();
		this.msgNo = msgNo;
		this.msgStatus = msgStatus;
		this.msgSourceId = msgSourceId;
		this.msgEndId = msgEndId;
		this.msgText = msgText;
	}

	public MessageBean(java.sql.Timestamp postDate) {
		super();
		this.postDate = postDate;
	}

	public MessageBean(int msgNo, int msgStatus, Timestamp postDate, String msgSourceId, String msgEndId,
			String msgText, Blob msgImage, String msgFileName) {
		super();
		this.msgNo = msgNo;
		this.msgStatus = msgStatus;
		this.postDate = postDate;
		this.msgSourceId = msgSourceId;
		this.msgEndId = msgEndId;
		this.msgText = msgText;
		this.msgImage = msgImage;
		this.msgFileName = msgFileName;
	}

	public MessageBean(int msgNo, int msgStatus, java.sql.Timestamp postDate, String msgSourceId, String msgEndId,
			String msgText) {
		super();
		this.msgNo = msgNo;
		this.msgStatus = msgStatus;
		this.postDate = postDate;
		this.msgSourceId = msgSourceId;
		this.msgEndId = msgEndId;
		this.msgText = msgText;
	}
	

	public MessageBean(int msgNo, int msgStatus, java.sql.Timestamp postDate, String msgEndId, String msgText) {
		super();
		this.msgNo = msgNo;
		this.msgStatus = msgStatus;
		this.postDate = postDate;
		this.msgEndId = msgEndId;
		this.msgText = msgText;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getMsgNo() {
		return msgNo;
	}

	public void setMsgNo(int msgNo) {
		this.msgNo = msgNo;
	}

	@Column(name = "msgStatus")
	public int getMsgStatus() {
		return msgStatus;
	}

	public void setMsgStatus(int msgStatus) {
		this.msgStatus = msgStatus;
	}

	@Column(name = "postDate")
	public Timestamp getPostDate() {
		return postDate;
	}

	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}

	@Column(name = "msgSourceId")
	public String getMsgSourceId() {
		return msgSourceId;
	}

	public void setMsgSourceId(String msgSourceId) {
		this.msgSourceId = msgSourceId;
	}

	@Column(name = "msgEndId")
	public String getMsgEndId() {
		return msgEndId;
	}

	public void setMsgEndId(String msgEndId) {
		this.msgEndId = msgEndId;
	}

	@Column(name = "msgText")
	public String getMsgText() {
		return msgText;
	}

	public void setMsgText(String msgText) {
		this.msgText = msgText;
	}

	@Column(name = "msgImage")
	public Blob getMsgImage() {
		return msgImage;
	}

	public void setMsgImage(Blob msgImage) {
		this.msgImage = msgImage;
	}

	@Column(name = "msgFileName")
	public String getMsgFileName() {
		return msgFileName;
	}

	public void setMsgFileName(String msgFileName) {
		this.msgFileName = msgFileName;
	}
	
	@Column(name = "roomNo")
	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
}
