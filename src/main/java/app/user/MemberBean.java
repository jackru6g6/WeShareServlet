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
@Table(name = "ind")
public class MemberBean {
	private String userId;
	private String password;
	private String name;
	private String tal;
	private String email;
	private String address;
	private Blob image = null;
	private int idType;
	private java.sql.Timestamp createDate;
	private String fileName = "userPicture";

//	private InstiutionBean instiutionBean;

	public MemberBean() {
	}

	public MemberBean(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public MemberBean(String tal, String email, String address, int idType) {
		this.tal = tal;
		this.email = email;
		this.address = address;
		this.idType = idType;
	}

	public MemberBean(String userId, String password, String name, String tal, String email, String address, Blob image,
			int idType, Timestamp createDate, String fileName) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.tal = tal;
		this.email = email;
		this.address = address;
		this.image = image;
		this.idType = idType;
		this.createDate = createDate;
		this.fileName = fileName;
	}

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "assigned")
	@Column(name = "indId")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "indPassword")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "indName")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "indPhone")
	public String getTal() {
		return tal;
	}

	public void setTal(String tal) {
		this.tal = tal;
	}

	@Column(name = "indEmail")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "indAddress")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "indImage")
	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	@Column(name = "userType")
	public Integer getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	@Column(name = "postDate")
	public java.sql.Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.sql.Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "indFileName")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	// @OneToOne: 說明School到Prinpal也是一對一的關係。
	// 屬性mappedBy="school": 由於本類別並未使用@JoinColumn，所以本類別對應之
	// 表格沒有表示關係的外鍵。因此mappedBy屬性的作用為通知Hibernate，
	// 『到對照類別(Principal)內的school性質去找，該性質有說明兩表格關聯的資訊
	//
	// 注意：表格之間的關係僅一方需要有外鍵即可
//	@OneToOne(mappedBy = "MemberBean") // ...
//	public InstiutionBean getInstiutionBean() {
//		return instiutionBean;
//	}
//
//	public void setInstiutionBean(InstiutionBean instiutionBean) {
//		this.instiutionBean = instiutionBean;
//	}
	// public String toString(){
	// return "校長: " + name + ", 服務學校:" + school.getSchoolName() +
	// ", 地址:" + school.getAddress();
	// }

}
