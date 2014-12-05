package com.vexeonline.service.nhaxe;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vexeonline.dao.XeDAO;
import com.vexeonline.dao.XeDAOImpl;
import com.vexeonline.domain.Xe;
import com.vexeonline.utils.HibernateUtil;

public class QuanLyXeServiceImpl implements QuanLyXeService {
	private static Logger logger = Logger
			.getLogger(QuanLyXeServiceImpl.class);
	private static XeDAO xeDAO = new XeDAOImpl();

	public List<Xe> listXe() {
		List<Xe> list = new ArrayList<Xe>(0);
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			list = xeDAO.list();

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

	public void addNew(Xe Xe) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			xeDAO.save(Xe);

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

	public void update(Xe Xe) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			xeDAO.update(Xe);

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
