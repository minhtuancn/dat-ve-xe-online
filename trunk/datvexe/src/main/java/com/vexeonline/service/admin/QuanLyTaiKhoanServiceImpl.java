package com.vexeonline.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vexeonline.dao.UserDAO;
import com.vexeonline.dao.UserDAOImpl;
import com.vexeonline.domain.User;
import com.vexeonline.utils.HibernateUtil;

public class QuanLyTaiKhoanServiceImpl implements QuanLyTaiKhoanService {
	private static Logger logger = Logger
			.getLogger(QuanLyTaiKhoanServiceImpl.class);
	private static UserDAO userDAO = new UserDAOImpl();

	public List<User> listUser() {
		List<User> list = new ArrayList<User>(0);
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			list = userDAO.list();

			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		} finally {
			session.close();
		}
		return list;
	}

	public void addNew(User User) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			userDAO.insert(User);

			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
			throw new Exception(ex);
		} finally {
			session.close();
		}
	}

	public void update(User User) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			userDAO.update(User);

			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
			throw new Exception(ex);
		} finally {
			session.close();
		}
	}
}
