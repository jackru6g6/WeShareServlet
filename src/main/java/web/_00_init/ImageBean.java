package web._00_init;

import java.io.InputStream;

public class ImageBean {
	String FileName;
	InputStream is;

	public ImageBean(String fileName, InputStream is) {
		super();
		FileName = fileName;
		this.is = is;
	}

	public ImageBean() {
		// TODO Auto-generated constructor stub
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}

}
