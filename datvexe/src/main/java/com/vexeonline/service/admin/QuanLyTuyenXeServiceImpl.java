package com.vexeonline.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vexeonline.dao.TuyenXeDAO;
import com.vexeonline.dao.TuyenXeDAOImpl;
import com.vexeonline.domain.TuyenXe;
import com.vexeonline.utils.HibernateUtil;

public class QuanLyTuyenXeServiceImpl implements QuanLyTuyenXeService{
	private static Logger logger = Logger.getLogger(QuanLyTuyenXeServiceImpl.class);
	private static TuyenXeDAO tuyenXeDAO = new TuyenXeDAOImpl();
	
	public List<TuyenXe> listTuyenXe() {
		List<TuyenXe> list = new ArrayList<TuyenXe>(0);
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			list = tuyenXeDAO.list();
			
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
	
	public void addNew(TuyenXe TuyenXe) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			tuyenXeDAO.save(TuyenXe);
			
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

	public void update(TuyenXe TuyenXe) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			tuyenXeDAO.update(TuyenXe);
			
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
