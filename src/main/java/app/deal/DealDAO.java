package app.deal;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import app.main.HibernateUtil;

public class DealDAO {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public DealBean getDealBean(int dealNo) {
		DealBean deal = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			deal = (DealBean) session.get(DealBean.class, dealNo);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return deal;
	}

	public byte[] getFbImage(int id) {
		byte[] image = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<FeedbackBean> list = new ArrayList<FeedbackBean>();
		Blob blob = null;
		try {
			String hql = "FROM FeedbackBean WHERE dealNo = :uid";
			Query query = session.createQuery(hql);
			query.setParameter("uid", id);
			list = query.getResultList();
			for (FeedbackBean pop : list) {
				System.out.println(id + "--->" + pop.getClass().getName());
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}

		System.out.println("list" + list);
		for (FeedbackBean pop : list) {
			try {
				int blobLength = 0;
				blob = pop.getFbImage();
				if (blob != null) {
					blobLength = (int) blob.length();
					image = blob.getBytes(1, blobLength);
					System.out.println("image=" + image);
				} else {
					System.out.println("image 沒有圖片歐~");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return image;
	}

	public int update(DealBean deal) {
		int n = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(deal);
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

	public int save(DealBean deal) {
		int n = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Object o = session.save(deal);
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

	public int saveFeedback(FeedbackBean fb) {
		int n = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Object o = session.save(fb);
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

	public boolean isFbExists(int fbNo) {
		boolean check = false; // 檢查id是否已經存在
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "From FeedbackBean where dealNo = :fbNo";
			Query query = session.createQuery(hql);
			query.setParameter("fbNo", fbNo);
			List<FeedbackBean> list = query.getResultList();
			if (list.size() > 0) {
				check = true;
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
		return check;
	}

	public List<FeedbackBean> getFb(int fbNo) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<FeedbackBean> list = new ArrayList<FeedbackBean>();
		try {
			String hql = "FROM FeedbackBean d WHERE dealNo = :fbNo";
			Query query = session.createQuery(hql);
			query.setParameter("fbNo", fbNo);
			list = query.getResultList();
			tx.commit();

		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return list;
	}

	public int getMaxNo() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<DealBean> list = new ArrayList<DealBean>();
		int i = 0;
		try {
			String hql = "FROM DealBean d ORDER BY d.dealNo";
			Query query = session.createQuery(hql);
			list = query.getResultList();
			for (DealBean pop : list) {
				i = pop.getDealNo();
				// System.out.println("++i" + i);
			}
			tx.commit();

		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return i;
	}

	public List<DealBean> get(String userId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// List<Object[]> list= new ArrayList<>();
		List<DealBean> list = new ArrayList<DealBean>();
		try {
			String hql = "FROM DealBean d WHERE d.sourceId = :uid OR d.endId = :aid";
			// String hql = "SELECT new
			// MessageBean(m.msgNo,m.msgStatus,m.postDate,m.msgEndId,m.msgText)
			// FROM MessageBean m WHERE m.msgSourceId = :uid OR m.msgEndId =
			// :aid";
			// String hql = "SELECT new
			// MessageBean(m.msgNo,m.msgStatus,m.msgSourceId,m.msgEndId,m.msgText)
			// FROM MessageBean m WHERE m.msgSourceId = :uid OR m.msgEndId =
			// :aid";
			// String hql = "SELECT m.postDate FROM MessageBean m WHERE
			// m.msgSource = :uid OR m.msgEndId = :aid";
			// String hql = "SELECT new
			// MessageBean(m.msgNo,m.msgStatus,m.msgSourceId,m.msgEndId,m.msgText,m.roomNo)
			// FROM MessageBean m WHERE m.msgSourceId = :uid OR m.msgEndId =
			// :aid GROUP BY m.roomNo ORDER BY MIN(m.postDate)";

			Query query = session.createQuery(hql);
			query.setParameter("uid", userId);
			query.setParameter("aid", userId);
			list = query.getResultList();
			tx.commit();

		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		// List<MessageBean> list2;
		// for(MessageBean test : list){
		// list2.add(test);
		// }
		return list;
	}

	public List<DealBean> getNotDeal(String userId, int status) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// List<Object[]> list= new ArrayList<>();
		List<DealBean> list = new ArrayList<DealBean>();
		try {
			String hql = "FROM DealBean d WHERE  d.endId = :aid AND d.dealStatus = :status";
			Query query = session.createQuery(hql);
			query.setParameter("aid", userId);
			query.setParameter("status", status);
			list = query.getResultList();
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return list;
	}

	public List<DealBean> getStatus(String userId, int status) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// List<Object[]> list= new ArrayList<>();
		List<DealBean> list = new ArrayList<DealBean>();
		try {
			String hql = "FROM DealBean d WHERE (d.sourceId = :uid OR d.endId = :aid) AND d.dealStatus = :status";
			Query query = session.createQuery(hql);
			query.setParameter("uid", userId);
			query.setParameter("aid", userId);
			query.setParameter("status", status);
			list = query.getResultList();
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return list;
	}

	public List<FeedbackBean> getAllFb(String userId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// List<Object[]> list= new ArrayList<>();
		List<FeedbackBean> list = new ArrayList<FeedbackBean>();
		try {
			String hql = "FROM FeedbackBean d WHERE d.fbEndId = :uid";
			Query query = session.createQuery(hql);
			query.setParameter("uid", userId);
			list = query.getResultList();
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return list;
	}

	//
	// public List<DealBean> getOne(String userId, String talkTo) {
	// Session session = sessionFactory.openSession();
	// Transaction tx = session.beginTransaction();
	// // List<Object[]> list= new ArrayList<>();
	// List<DealBean> list = new ArrayList<DealBean>();
	// try {
	// // String hql = "FROM MessageBean m WHERE m.msgSource = :uid OR
	// // m.msgEndId = :aid";
	// // String hql = "SELECT new
	// // MessageBean(m.msgNo,m.msgStatus,m.postDate,m.msgEndId,m.msgText)
	// // FROM MessageBean m WHERE m.msgSourceId = :uid OR m.msgEndId =
	// // :aid";
	// String hql = "SELECT new
	// MessageBean(m.msgNo,m.msgStatus,m.msgSourceId,m.msgEndId,m.msgText,m.roomNo)
	// FROM MessageBean m WHERE (m.msgSourceId = :uid AND m.msgEndId = :aid) OR
	// (m.msgSourceId = :sid AND m.msgEndId = :zid)";
	// // String hql = "SELECT m.postDate FROM MessageBean m WHERE
	// // m.msgSource = :uid OR m.msgEndId = :aid";
	//
	// Query query = session.createQuery(hql);
	// query.setParameter("uid", userId);
	// query.setParameter("aid", talkTo);
	// query.setParameter("sid", talkTo);
	// query.setParameter("zid", userId);
	// list = query.getResultList();
	// tx.commit();
	//
	// } catch (Exception ex) {
	// tx.rollback();
	// ex.printStackTrace();
	// } finally {
	// if (session != null)
	// session.close();
	// }
	// // List<MessageBean> list2;
	// // for(MessageBean test : list){
	// // list2.add(test);
	// // }
	// return list;
	// }
	//
	public byte[] getImage(int id) {
		byte[] image = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<DealBean> list = new ArrayList<DealBean>();
		Blob blob = null;
		try {
			String hql = "FROM DealBean WHERE dealNo = :uid";
			// String hql = "FROM DealBean d WHERE d.sourceId = :uid";
			Query query = session.createQuery(hql);
			query.setParameter("uid", id);
			list = query.getResultList();
			for (DealBean pop : list) {
				System.out.println(id + "--->" + pop.getClass().getName());
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}

		System.out.println("list" + list);
		for (DealBean pop : list) {
			try {
				// mb.toString();
				// System.out.println("blob=" + blob);
				int blobLength = 0;
				blob = pop.getGoodsImage();
				if (blob != null) {
					blobLength = (int) blob.length();
					image = blob.getBytes(1, blobLength);
					System.out.println("image=" + image);
				} else {
					System.out.println("image 沒有圖片歐~");
				}
				// blob = list.get(0).getImage();
				// int blobLength = (int) blob.length();
				// image = blob.getBytes(1, blobLength);
				// System.out.println("image=" + image);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return image;
	}

}
