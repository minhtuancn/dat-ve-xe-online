package com.vexeonline.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vexeonline.dao.DanhGiaDAO;
import com.vexeonline.dao.DanhGiaDAOImpl;
import com.vexeonline.domain.DanhGia;
import com.vexeonline.utils.HibernateUtil;

public class QuanLyDanhGiaServiceImpl implements QuanLyDanhGiaService{
    private static Logger logger = Logger.getLogger(QuanLyDanhGiaServiceImpl.class);
    private static DanhGiaDAO danhGiaDAO = new DanhGiaDAOImpl();
	
	public List<DanhGia> listDanhGia() {
		List<DanhGia> list = new ArrayList<DanhGia>(0);
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			list = danhGiaDAO.list();
			
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

	public void delete(int idDanhGia) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			DanhGia danhGia = danhGiaDAO.getById(idDanhGia);
			danhGiaDAO.delete(danhGia);
			
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
			throw new Exception("Error");
		} finally {
			session.close();
		}
	}
	
/*	public float tinhNewRate(DanhGia danhGia) {
		if (danhGia == null || !danhGia.getTrangThai()) {
			throw new IllegalArgumentException();
		}
		float sumRate = danhGia.getDiem();
		List<DanhGia> listDanhGia = danhGiaDAO.getListDanhGiaByIdNhaXe(
				danhGia.getChuyenXe().getLichTuyen().getXe().getNhaXe().getIdNhaXe());
		for (DanhGia dg : listDanhGia) {
			sumRate += dg.getDiem();
		}
		
		return sumRate / (listDanhGia.size() + 1);
	}*/

}
