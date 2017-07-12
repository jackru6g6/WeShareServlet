package web._07_Feedback.model;

public class JSON_In_Up_Bean {
	String type;
	String Ans;
	String Message;
	Feedback_ErrorBean fdbeb;

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

	public Feedback_ErrorBean getFdbeb() {
		return fdbeb;
	}

	public void setFdbeb(Feedback_ErrorBean fdbeb) {
		this.fdbeb = fdbeb;
	}

}