package web._04_productMaintain.model;

public class JSON_In_Up_Bean {
	String type;
	String Ans;
	String Message;
	Goods_ErrorBean geb;

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

	public Goods_ErrorBean getGeb() {
		return geb;
	}

	public void setGeb(Goods_ErrorBean geb) {
		this.geb = geb;
	}

}
