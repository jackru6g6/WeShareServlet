package web._03_updateMember.model;

public class JSON_In_Up_Bean {
	String type;
	String Ans;
	String Message;
	MB_ORG_ErrorBean moeb;

	public JSON_In_Up_Bean() {
		// TODO Auto-generated constructor stub
	}

	public JSON_In_Up_Bean(String type, String ans, String message, MB_ORG_ErrorBean moeb) {
		super();
		this.type = type;
		Ans = ans;
		Message = message;
		this.moeb = moeb;
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

	public MB_ORG_ErrorBean getMoeb() {
		return moeb;
	}

	public void setMoeb(MB_ORG_ErrorBean moeb) {
		this.moeb = moeb;
	}

}