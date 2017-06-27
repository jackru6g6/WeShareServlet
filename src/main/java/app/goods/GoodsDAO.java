package app.goods;

import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import app.main.HibernateUtil;
import app.user.MemberBean;

public class GoodsDAO {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

//	public List<GoodsBean> getAll(String indId) {
//		Session session = sessionFactory.getCurrentSession();
//		Transaction tx = session.beginTransaction();
//		List<GoodsBean> list = new ArrayList<GoodsBean>();
//		try {
//			String hql = "FROM GoodsBean WHERE indId = :uid ORDER BY UpdateTime DESC";
//			Query query = session.createQuery(hql);
//			query.setParameter("uid", indId);
//			list = query.getResultList();
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null)
//				tx.rollback();
//		} finally {
//			session.close();
//		}
//		return list;
//	}

	public byte[] getImage(String indId) {
		byte[] image = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<GoodsBean> list = new ArrayList<GoodsBean>();
		Blob blob = null;
		try {
			String hql = "FROM GoodsBean g WHERE g.indId = :iid;";
			Query query = session.createQuery(hql);
			query.setParameter("iid", indId);
			list = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
		for (GoodsBean gd : list) {
			try {
				blob = gd.getGoodsImage();
				int blobLength = (int) blob.length();
				
				image = blob.getBytes(1, blobLength);
				System.out.println("image="+image);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return image;
	}

	public int save(GoodsBean goods) {
		int n = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Object o = session.save(goods);
			System.out.println("o = " + o);
			tx.commit();
			n = 1;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return n;
	}

	public int delete(int goodsNo) {
		int n = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			GoodsBean goods = new GoodsBean();
			goods.setGoodsNo(goodsNo);
			session.delete(goods);
			tx.commit();
			n = 1;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return n;
	}

	public int update(GoodsBean goods) {
		int n = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(goods);
			tx.commit();
			n = 1;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return n;
	}

	public List<GoodsBean> getAll(String indId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
//		GoodsBean goods = new GoodsBean();
		List<GoodsBean> list = new ArrayList<GoodsBean>();
		try {
			String hql = "SELECT new GoodsBean(g.goodsStatus,g.indId,g.goodsName,g.goodsType,g.qty,g.goodsLoc,g.goodsNote,g.goodsShipWay,g.deadLine) FROM GoodsBean g WHERE g.indId=:uid";
			//String hql = "SELECT new GoodsBean(g.updateTime) AS TIMESTAMP FROM GoodsBean g WHERE indId=:uid";
			Query query = session.createQuery(hql);
		
			query.setParameter("uid", indId);
			list = query.getResultList();
			tx.commit();
			
			
			for(GoodsBean gb : list){
				System.out.println("狀態" + gb.getUpdateTime());
			}
			
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return list;
	}

	public GoodsBean load(int goodsNo) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		GoodsBean goods = new GoodsBean();
		try {
			goods = session.load(GoodsBean.class, goodsNo);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return goods;
	}

	public void close() {
		sessionFactory.close();
	}
}
