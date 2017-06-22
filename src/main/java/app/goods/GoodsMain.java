package app.goods;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;

import javax.sql.rowset.serial.SerialBlob;

public class GoodsMain {

public static void main(String[] args) throws Exception{
		
		File f = new File("images/user.png");
		long size = f.length();
		InputStream is = new FileInputStream(f);
//		Blob blob = Hibernate.getLobCreator(session).createBlob(is, size);//因為沒有session物件，所以無法用這個，改下列方式
		byte[] ba = new byte[(int)size];
		is.read(ba);
		Blob blob = new SerialBlob(ba);
		Timestamp now=new Timestamp(1993-03-14);
		Timestamp dl=new Timestamp(2017-10-21);
		// Timestamp ts = new Timestamp(System.currentTimeMillis());//現在時間，跟下面2者一樣，選1用
		Timestamp ts = new Timestamp(new java.util.Date().getTime());

		GoodsBean goods = new GoodsBean(1, now, "jack", "印表機", 3, 5, 8, "9成新", 3, blob, dl);
//		GoodsBean goods2 = new GoodsBean(9, "id2", "na6me",3, blob, "c2z",
//				"cxz", "loc", now, ts, 1, "dsa");
//		GoodsBean goods3 = new GoodsBean(9, "id6", "name",3, blob, "cz3",
//				"cxz", "loc", now, ts, 1, "dsa");
//		GoodsBean goods4 = new GoodsBean(9, "id3", "na5me",3, blob, "c1z",
//				"cxz", "loc", now, ts, 1, "dsa");
//		GoodsBean goods5 = new GoodsBean(9, "id2", "na3me",3, blob, "c.z",
//				"cxz", "loc", now, ts, 1, "dsa");
//		GoodsBean goods6 = new GoodsBean(9, "id5", "name",3, blob, "c.z",
//				"cxz", "loc", now, ts, 1, "dsa");
//		
//		GoodsBean goods7 = new GoodsBean(9, "id4", "na2me",3, blob, "c1z",
//				"cxz", "loc", now, ts, 1, "dsa");
//		GoodsBean goods8 = new GoodsBean(9, "id6", "name",3, blob, "c5z",
//				"cxz", "loc", now, ts, 1, "dsa");
		
		GoodsDAO dao = new GoodsDAO();
		int n = dao.save(goods);
	
		dao.close();
		System.out.println("n = " + n);
	}

}
