package com.vexeonline.service.nhaxe;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vexeonline.dao.VanPhongDAO;
import com.vexeonline.dao.VanPhongDAOImpl;
import com.vexeonline.domain.VanPhong;
import com.vexeonline.utils.HibernateUtil;

public class QuanLyVanPhongServiceImpl implements QuanLyVanPhongService{
	private static Logger logger = Logger.getLogger(QuanLyVanPhongServiceImpl.class);
	private static VanPhongDAO vanPhongDAO = new VanPhongDAOImpl();
	
	public List<VanPhong> listVanPhong() {
		List<VanPhong> list = new ArrayList<VanPhong>(0);
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			list = vanPhongDAO.list();
			
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
	
	public void addNew(VanPhong VanPhong) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			vanPhongDAO.save(VanPhong);
			
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

	public void update(VanPhong VanPhong) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			vanPhongDAO.update(VanPhong);
			
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
