package com.vexeonline.service.nhaxe;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vexeonline.dao.ChuyenXeDAO;
import com.vexeonline.dao.ChuyenXeDAOImpl;
import com.vexeonline.domain.ChuyenXe;
import com.vexeonline.utils.HibernateUtil;

public class QuanLyChuyenXeServiceImpl implements QuanLyChuyenXeService{
	private static Logger logger = Logger.getLogger(QuanLyChuyenXeServiceImpl.class);
	private static ChuyenXeDAO chuyenXeDAO = new ChuyenXeDAOImpl();
	
	public List<ChuyenXe> listChuyenXe() {
		List<ChuyenXe> list = new ArrayList<ChuyenXe>(0);
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			list = chuyenXeDAO.list();
			
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
	
	public void addNew(ChuyenXe ChuyenXe) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			chuyenXeDAO.save(ChuyenXe);
			
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

	public void update(ChuyenXe ChuyenXe) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			chuyenXeDAO.update(ChuyenXe);
			
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
