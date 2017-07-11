package web._04_productMaintain.model;

import java.util.Collection;

public class JSON_Find_Bean {
	String type;
	String Ans;
	String Message;
	GoodsBean gb;
	Collection<GoodsBean> cgb;

	public Collection<GoodsBean> getCgb() {
		return cgb;
	}

	public void setCgb(Collection<GoodsBean> cgb) {
		this.cgb = cgb;
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

	public GoodsBean getGb() {
		return gb;
	}

	public void setGb(GoodsBean gb) {
		this.gb = gb;
	}

}
