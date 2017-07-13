package app.message;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "msg_room")
public class MsgRoomBean {
	private int roomNo;
	private String indid1;
	private String indid2;
	private int lastMsgNo;

	public MsgRoomBean() {
		super();
	}

	public MsgRoomBean(int roomNo, String indid1, String indid2, int lastMsgNo) {
		super();
		this.roomNo = roomNo;
		this.indid1 = indid1;
		this.indid2 = indid2;
		this.lastMsgNo = lastMsgNo;
	}

	@Id
	// @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "roomNo")
	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	@Column(name = "indId1")
	public String getIndid1() {
		return indid1;
	}

	public void setIndid1(String indid1) {
		this.indid1 = indid1;
	}

	@Column(name = "indId2")
	public String getIndid2() {
		return indid2;
	}

	public void setIndid2(String indid2) {
		this.indid2 = indid2;
	}

	@Column(name = "lastMsgNo")
	public int getLastMsgNo() {
		return lastMsgNo;
	}

	public void setLastMsgNo(int lastMsgNo) {
		this.lastMsgNo = lastMsgNo;
	}

}