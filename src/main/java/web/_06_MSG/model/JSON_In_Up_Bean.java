package web._06_MSG.model;

public class JSON_In_Up_Bean {
	String type;
	String Ans;
	String Message;
	MSG_ErrorBean msgeb;

	public MSG_ErrorBean getMsgeb() {
		return msgeb;
	}

	public void setMsgeb(MSG_ErrorBean msgeb) {
		this.msgeb = msgeb;
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
}
