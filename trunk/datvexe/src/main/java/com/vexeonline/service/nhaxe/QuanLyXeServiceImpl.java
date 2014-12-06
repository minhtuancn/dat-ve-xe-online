package com.vexeonline.service.nhaxe;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vexeonline.dao.TienIchDAO;
import com.vexeonline.dao.TienIchDAOImpl;
import com.vexeonline.dao.XeDAO;
import com.vexeonline.dao.XeDAOImpl;
import com.vexeonline.domain.TienIch;
import com.vexeonline.domain.Xe;
import com.vexeonline.dto.XeDTO;
import com.vexeonline.utils.HibernateUtil;

public class QuanLyXeServiceImpl implements QuanLyXeService {
	private static Logger logger = Logger
			.getLogger(QuanLyXeServiceImpl.class);
	
	private static XeDAO xeDAO = new XeDAOImpl();
	private static TienIchDAO tienIchDAO = new TienIchDAOImpl();
	
	public List<XeDTO> listXe() {
		
		List<XeDTO> result = new ArrayList<XeDTO>();
		List<Xe> list = new ArrayList<Xe>();
		
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			list = xeDAO.list();
			XeDTO tmp = null;
			
			for (Xe xe : list) {
				tmp = new XeDTO();
				tmp.setId(xe.getIdXe());
				tmp.setBienSo(xe.getBienSoXe());
				tmp.setLoaiXe(xe.getLoaiXe());
				tmp.setSoCho(xe.getSoCho());
				tmp.setActive(xe.isActive());
				for (TienIch tienIch : xe.getTienIchs()) {
					tmp.getTienIchs().add(tienIch.getTenTienIch());
				}
				result.add(tmp);
			}
			
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		} finally {
			session.close();
		}
		return result;
	}

	public void addNew(XeDTO xe) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			
			Xe tmp = new Xe();
			tmp.setBienSoXe(xe.getBienSo());
			tmp.setLoaiXe(xe.getLoaiXe());
			tmp.setSoCho(xe.getSoCho());
			tmp.setActive(xe.isActive());
			
			TienIch tienIch = null;
			
			for (Integer idTienIch : xe.getMaTienIchs()) {
				tienIch = tienIchDAO.getById(idTienIch);
				tmp.getTienIchs().add(tienIch);
			}
			
			xeDAO.save(tmp);
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

	public void update(XeDTO xe) throws Exception {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			
			Xe tmp = xeDAO.getById(xe.getId());
			tmp.setBienSoXe(xe.getBienSo());
			tmp.setLoaiXe(xe.getLoaiXe());
			tmp.setSoCho(xe.getSoCho());
			tmp.setActive(xe.isActive());
			
			TienIch tienIch = null;
			
			for (Integer idTienIch : xe.getMaTienIchs()) {
				tienIch = tienIchDAO.getById(idTienIch);
				tmp.getTienIchs().add(tienIch);
			}
			
			xeDAO.update(tmp);

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

	@Override
	public XeDTO getById(Integer id) throws Exception {
		
		Session session = null;
		Transaction tx = null;
		XeDTO result = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			Xe xe = xeDAO.getById(id);
			
			result = new XeDTO();
			result.setId(xe.getIdXe());
			result.setBienSo(xe.getBienSoXe());
			result.setLoaiXe(xe.getLoaiXe());
			result.setSoCho(xe.getSoCho());
			result.setActive(xe.isActive());
			
			for (TienIch tienIch : xe.getTienIchs()) {
				result.getMaTienIchs().add(tienIch.getIdTienIch());
				result.getTienIchs().add(tienIch.getTenTienIch());
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		
		return result;
	}
}
