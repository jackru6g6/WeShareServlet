package web._07_Feedback.model;

import java.util.Collection;

public class JSON_Find_Bean {
	String type;
	String Ans;
	String Message;
	Collection<FeedbackBean> cfb;

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

	public Collection<FeedbackBean> getCfb() {
		return cfb;
	}

	public void setCfb(Collection<FeedbackBean> cfb) {
		this.cfb = cfb;
	}

}
