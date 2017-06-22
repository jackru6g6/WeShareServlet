package app.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		// Hibernate 5.x 的寫法: 採用addAnnotatedClass()加入永續類別
		try {
//			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
//					.configure("ch99/hibernate.cfg.xml").build();
			
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure("app/main/hibernate.cfg.xml").build();
			
			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		} catch (Throwable ex) {
			System.err.println("新建SessionFactory失敗:" + ex.getMessage());
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void close() {
		sessionFactory.close();
	}

//	// 計算一個文字檔的字元數
//	public static long meteringReader(File f10) {
//		long total = 0;
//		int len = 0;
//		try (FileReader reader = new FileReader(f10);) {
//			char[] ca = new char[8192];
//			while ((len = reader.read(ca)) != -1) {
//				total += len;
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return total;
//	}

}
