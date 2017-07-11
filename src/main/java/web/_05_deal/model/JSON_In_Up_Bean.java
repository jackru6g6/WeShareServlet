package web._05_deal.model;

public class JSON_In_Up_Bean {
	String type;
	String Ans;
	String Message;
	DEAL_ErrorBean dealb;

	public DEAL_ErrorBean getDealb() {
		return dealb;
	}

	public void setDealb(DEAL_ErrorBean dealb) {
		this.dealb = dealb;
	}

	public JSON_In_Up_Bean() {
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

}
