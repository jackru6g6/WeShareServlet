package web._01_register.model;

public class JSON_Find_Bean {
	String type;
	String Ans;
	String Message;
	MemberBean mb;
	OrgBean ob;

	public JSON_Find_Bean() {
		// TODO Auto-generated constructor stub
	}

	public JSON_Find_Bean(String type, String ans, String message, MemberBean mb, OrgBean ob) {
		super();
		this.type = type;
		Ans = ans;
		Message = message;
		this.mb = mb;
		this.ob = ob;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAns() {
		return Ans;
	}

	public void setAns(String ans) {
		Ans = ans;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public MemberBean getMb() {
		return mb;
	}

	public void setMb(MemberBean mb) {
		this.mb = mb;
	}

	public OrgBean getOb() {
		return ob;
	}

	public void setOb(OrgBean ob) {
		this.ob = ob;
	}

}