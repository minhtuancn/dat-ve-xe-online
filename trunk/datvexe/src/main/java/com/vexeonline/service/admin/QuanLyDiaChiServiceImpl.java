package com.vexeonline.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vexeonline.dao.DiaChiDAO;
import com.vexeonline.dao.DiaChiDAOImpl;
import com.vexeonline.domain.DiaChi;
import com.vexeonline.utils.HibernateUtil;

public class QuanLyDiaChiServiceImpl implements QuanLyDiaChiService{
	private static Logger logger = Logger.getLogger(QuanLyDiaChiServiceImpl.class);
	private static DiaChiDAO diaChiDAO = new DiaChiDAOImpl();
	
	public List<DiaChi> listDiaChi() {
		List<DiaChi> list = new ArrayList<DiaChi>(0);
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			list = diaChiDAO.list();
			
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
	
	public void addNew(DiaChi DiaChi) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			diaChiDAO.save(DiaChi);
			
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

	public void update(DiaChi DiaChi) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			diaChiDAO.update(DiaChi);
			
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
