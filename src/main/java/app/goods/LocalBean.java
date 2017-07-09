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
@Table(name = "Local")
public class LocalBean implements Serializable {
	private int localNo;
	private String localName;

	public LocalBean() {
		super();
	}

	public LocalBean(int localNo, String localName) {
		super();
		this.localNo = localNo;
		this.localName = localName;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getLocalNo() {
		return localNo;
	}

	public void setLocalNo(int localNo) {
		this.localNo = localNo;
	}
	
	@Column(name="LocalName")
	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

}