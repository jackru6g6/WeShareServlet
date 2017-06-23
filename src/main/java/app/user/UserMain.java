package app.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;

import javax.sql.rowset.serial.SerialBlob;

public class UserMain {

	public static void main(String[] args) throws Exception {

		File f = new File("images/user.png");
		long size = f.length();
		InputStream is = new FileInputStream(f);
		// Blob blob = Hibernate.getLobCreator(session).createBlob(is,
		// size);//因為沒有session物件，所以無法用這個，改下列方式
		byte[] ba = new byte[(int) size];
		is.read(ba);
		Blob blob = new SerialBlob(ba);

		// Timestamp ts = new
		// Timestamp(System.currentTimeMillis());//現在時間，跟下面2者一樣，選1用
		Timestamp ts = new Timestamp(new java.util.Date().getTime());

		// User user = new User("jack2223", "12322", "22沉沉", "0922658795",
		// "jack@gmail.com", "新北市...", blob, 2, ts);
		//
		// UserDAO dao = new UserDAO();
		// int n = dao.save(user);
		// dao.close();
		// System.out.println("n = " + n);

		MemberBean user = new MemberBean("jack06231", "123", "22沉沉", "0922658795", "jack@gmail.com", "新北市...", blob, 2, ts,
				"kitty");

		MemberDAO dao = new MemberDAO();
		int n = dao.save(user);
		dao.close();
		System.out.println("n = " + n);
	}

}
