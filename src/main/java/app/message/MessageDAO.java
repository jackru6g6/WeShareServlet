package app.message;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import app.deal.DealBean;
import app.main.HibernateUtil;

public class MessageDAO {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public int save(MessageBean msg) {
		int n = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Object o = session.save(msg);
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

	public int updateRoom(MsgRoomBean room) {
		int n = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(room);
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

	public boolean checkRoomNo(String indId1, String indId2) {
		boolean check = false; // 檢查id是否已經存在
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			String hql = "FROM MsgRoomBean m WHERE (m.indid1 = :uid AND m.indid2 = :aid) OR (m.indid1 = :u1id AND m.indid2 = :u2id)";
			// String hql = "FROM MsgRoomBean m WHERE m.indid1 = :uid AND
			// m.indid2 = :aid";
			Query query = session.createQuery(hql);
			query.setParameter("uid", indId1);
			query.setParameter("aid", indId2);
			query.setParameter("u1id", indId2);
			query.setParameter("u2id", indId1);
			List<MsgRoomBean> list = query.getResultList();
			for (MsgRoomBean pop : list) {
				System.out.println("popNO=" + pop.getRoomNo());
			}
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

	public List<MsgRoomBean> getRoomNo(String indId1, String indId2) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<MsgRoomBean> roomNo = null;
		try {
			String hql = "FROM MsgRoomBean m where (m.indid1 = :uid AND m.indid2 = :aid) OR (m.indid1 = :aid AND m.indid2 = :uid)";
			Query query = session.createQuery(hql);
			query.setParameter("uid", indId1);
			query.setParameter("aid", indId2);
			roomNo = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
		return roomNo;
	}

	// public int delete(String userId) {
	// int n = 0;
	// Session session = sessionFactory.openSession();
	// Transaction tx = session.beginTransaction();
	// try {
	// MemberBean user = new MemberBean();
	// user.setUserId(userId);
	// session.delete(user);
	// tx.commit();
	// n = 1;
	// } catch (Exception ex) {
	// tx.rollback();
	// ex.printStackTrace();
	// } finally {
	// if (session != null)
	// session.close();
	// }
	// return n;
	// }

	// public int update(MemberBean user) {
	// int n = 0;
	// Session session = sessionFactory.openSession();
	// Transaction tx = session.beginTransaction();
	// try {
	// session.update(user);
	// tx.commit();
	// n = 1;
	// } catch (Exception ex) {
	// tx.rollback();
	// ex.printStackTrace();
	// } finally {
	// if (session != null)
	// session.close();
	// }
	// return n;
	// }
	public int getMaxNo() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<MessageBean> list = new ArrayList<MessageBean>();
		int i = 0;
		try {
			String hql = "FROM MessageBean m ORDER BY m.msgNo ASC";
			Query query = session.createQuery(hql);
			list = query.getResultList();
			for (MessageBean pop : list) {
				i = pop.getMsgNo();
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

	public List<MsgRoomBean> get(String userId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// List<Object[]> list= new ArrayList<>();
		List<MsgRoomBean> list = new ArrayList<MsgRoomBean>();
		try {
			String hql = "FROM MsgRoomBean m WHERE m.indid1 = :uid OR m.indid2 = :aid";
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
		return list;
	}

	public MessageBean getMessageBean(int msgNo) {
		MessageBean msg = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			msg = (MessageBean) session.get(MessageBean.class, msgNo);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return msg;
	}

	public List<MessageBean> getOne(String userId, String talkTo) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// List<Object[]> list= new ArrayList<>();
		List<MessageBean> list = new ArrayList<MessageBean>();
		try {
			// String hql = "FROM MessageBean m WHERE m.msgSource = :uid OR
			// m.msgEndId = :aid";
			// String hql = "SELECT new
			// MessageBean(m.msgNo,m.msgStatus,m.postDate,m.msgEndId,m.msgText)
			// FROM MessageBean m WHERE m.msgSourceId = :uid OR m.msgEndId =
			// :aid";
			String hql = "SELECT new MessageBean(m.msgNo,m.msgStatus,m.msgSourceId,m.msgEndId,m.msgText,m.roomNo) FROM MessageBean m WHERE (m.msgSourceId = :uid AND m.msgEndId = :aid) OR (m.msgSourceId = :sid AND m.msgEndId = :zid)";
			// String hql = "SELECT m.postDate FROM MessageBean m WHERE
			// m.msgSource = :uid OR m.msgEndId = :aid";

			Query query = session.createQuery(hql);
			query.setParameter("uid", userId);
			query.setParameter("aid", talkTo);
			query.setParameter("sid", talkTo);
			query.setParameter("zid", userId);
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

	public byte[] getImage(String id) {
		byte[] image = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<MessageBean> list = new ArrayList<MessageBean>();
		Blob blob = null;
		try {
			String hql = "FROM MessageBean m WHERE m.magSource = :uid OR m.msgEndId = :uid";
			Query query = session.createQuery(hql);
			query.setParameter("uid", id);
			list = query.getResultList();
			for (MessageBean msg : list) {
				System.out.println(id + "--->" + msg.getClass().getName());
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}

		System.out.println("list" + list);
		for (MessageBean msg : list) {
			try {
				// mb.toString();
				// System.out.println("blob=" + blob);
				int blobLength = 0;
				blob = msg.getMsgImage();
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
