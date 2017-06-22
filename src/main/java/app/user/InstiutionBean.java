package app.user;

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
@Table(name = "org")
public class InstiutionBean {
	private String indId;
	private String leader;
	private String orgType;
	private String registerNo;
	private String raiseNo;
	private String intRo;
	private Blob image = null;
	private java.sql.Timestamp updatetime = null;
	

//	private MemberBean memberBean;

	public InstiutionBean() {
	}

	public InstiutionBean(String indId, String leader, String orgType, String registerNo, String raiseNo, String intRo,
			Blob image, Timestamp updatetime) {
		super();
		this.indId = indId;
		this.leader = leader;
		this.orgType = orgType;
		this.registerNo = registerNo;
		this.raiseNo = raiseNo;
		this.intRo = intRo;
		this.image = image;
		this.updatetime = updatetime;
	}

	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "assigned")
	@Column(name = "indId")
	public String getIndId() {
		return indId;
	}

	public void setIndId(String indId) {
		this.indId = indId;
	}
	@Column(name = "leader")
	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}
	@Column(name = "orgtypes")
	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	@Column(name = "registerno")
	public String getRegisterNo() {
		return registerNo;
	}

	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}
	@Column(name = "raiseno")
	public String getRaiseNo() {
		return raiseNo;
	}

	public void setRaiseNo(String raiseNo) {
		this.raiseNo = raiseNo;
	}
	@Column(name = "intro")
	public String getIntRo() {
		return intRo;
	}

	public void setIntRo(String intRo) {
		this.intRo = intRo;
	}
	@Column(name = "orgimage")
	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}
	@Column(name = "updatetime")
	public java.sql.Timestamp getupdatetime() {
		return updatetime;
	}

	public void setupdatetime(java.sql.Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	
	
	
//	@OneToOne(cascade=CascadeType.ALL)
//	// 1. @JoinColumn(name="FK_School_id")->說明外鍵的欄位為何
//	// 在本類別(Principal)所對應的表格(Principal_Table)內加入能找到School紀錄之外鍵，
//	// 外鍵名稱為『FK_School_id』
//	// 2. 如果改為 @JoinColumn(name="id")
//	// 利用本類別(Principal)的主鍵當作是外來鍵，因此 Principal表格就不會多
//	// 出一個外鍵
//	// 3. 加入@JoinColumn註釋之類別表示可由此類別的物件找到對照之類別的物件(們)	
////	@JoinColumn(name="FK_School_id") 
//	@JoinColumn(name="indId")
//	public MemberBean getMemberBean() {
//		return memberBean;
//	}
//	
//	public void setMemberBean(MemberBean memberBean) {//...
//		this.memberBean = memberBean;
//	}
	
	
	
	
}
