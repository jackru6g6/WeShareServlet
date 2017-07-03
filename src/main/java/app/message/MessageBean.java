package app.message;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "msg")
public class MessageBean {
	private int msgNo;
	private int msgStatus;
	private Timestamp postDate = null;
	private String msgSourceId;
	private String msgEndId;
	private String msgText;
	private Blob msgImage = null;
	private String msgFileName = "msgFileName";

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "assigned")
	@Column(name = "msgNo")
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
	public String getMsgSource() {
		return msgSourceId;
	}

	public void setMsgSource(String msgSourceId) {
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
}
