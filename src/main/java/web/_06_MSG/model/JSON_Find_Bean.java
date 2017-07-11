package web._06_MSG.model;

import java.util.Collection;

public class JSON_Find_Bean {
	String type;
	String Ans;
	String Message;
	Collection<MSGBean> coll;

	public JSON_Find_Bean() {
		// TODO Auto-generated constructor stub
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

	public Collection<MSGBean> getColl() {
		return coll;
	}

	public void setColl(Collection<MSGBean> coll) {
		this.coll = coll;
	}

}
