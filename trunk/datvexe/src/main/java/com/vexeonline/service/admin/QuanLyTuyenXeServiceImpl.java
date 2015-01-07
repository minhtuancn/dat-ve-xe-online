package com.vexeonline.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vexeonline.dao.BenXeDAO;
import com.vexeonline.dao.BenXeDAOImpl;
import com.vexeonline.dao.TuyenXeDAO;
import com.vexeonline.dao.TuyenXeDAOImpl;
import com.vexeonline.domain.BenXe;
import com.vexeonline.domain.TuyenXe;
import com.vexeonline.dto.BenXeDTO;
import com.vexeonline.dto.TuyenXeDTO;
import com.vexeonline.utils.HibernateUtil;

public class QuanLyTuyenXeServiceImpl implements QuanLyTuyenXeService{
	private static Logger logger = Logger.getLogger(QuanLyTuyenXeServiceImpl.class);
	private static TuyenXeDAO tuyenXeDAO = new TuyenXeDAOImpl();
	private static BenXeDAO benXeDAO = new BenXeDAOImpl();
	
	public List<TuyenXeDTO> listTuyenXe() {
		List<TuyenXeDTO> listData = new ArrayList<TuyenXeDTO>(0);
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			
			List<TuyenXe> list = tuyenXeDAO.list();
			TuyenXeDTO tuyenXe = null;
			for (TuyenXe row : list) {
				tuyenXe = new TuyenXeDTO();
				BenXeDTO benDi = new BenXeDTO();
				BenXeDTO benDen = new BenXeDTO();
				benDi.setId(row.getBenDi().getIdBenXe());
				benDen.setId(row.getBenDen().getIdBenXe());
				benDi.setName(row.getBenDi().getTenBenXe());
				benDen.setName(row.getBenDen().getTenBenXe());
				benDi.setProvince(row.getBenDi().getDiaChi().getTinh());
				benDen.setProvince(row.getBenDen().getDiaChi().getTinh());
				tuyenXe.setBenDen(benDen);
				tuyenXe.setBenDi(benDi);
				tuyenXe.setId(row.getIdTuyenXe());
				tuyenXe.setDescription(row.getMoTa());
				tuyenXe.setDoDai(row.getDoDai());
				listData.add(tuyenXe);
			}
			
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return listData;
	}
	
	public void addNew(TuyenXeDTO tuyenXeDTO, int idBenDi, int idBenDen)  {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			TuyenXe tuyenXe = new TuyenXe();
			BenXe benDi = (BenXe) session.load(BenXe.class, idBenDi);
			BenXe benDen = (BenXe) session.load(BenXe.class, idBenDen);
			tuyenXe.setBenDen(benDen);
			tuyenXe.setBenDi(benDi);
			tuyenXe.setDoDai(tuyenXeDTO.getDoDai());
			tuyenXe.setMoTa(tuyenXeDTO.getDescription());
			session.save(tuyenXe);
			
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
	}

	@Override
	public void update(TuyenXeDTO tuyenXeDTO, int idBenDi, int idBenDen) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			TuyenXe tuyenXe = (TuyenXe) session.load(TuyenXe.class, tuyenXeDTO.getId());
			BenXe benDi = (BenXe) session.load(BenXe.class, idBenDi);
			BenXe benDen = (BenXe) session.load(BenXe.class, idBenDen);
			tuyenXe.setBenDen(benDen);
			tuyenXe.setBenDi(benDi);
			tuyenXe.setDoDai(tuyenXeDTO.getDoDai());
			tuyenXe.setMoTa(tuyenXeDTO.getDescription());
			session.update(tuyenXe);
			
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
			
	}

	@Override
	public TuyenXeDTO getTuyenXeById(int idTuyenXe) {
		TuyenXeDTO tuyenXe = null;
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			
			TuyenXe row = (TuyenXe) session.get(TuyenXe.class, idTuyenXe);
			tuyenXe = new TuyenXeDTO();
			BenXeDTO benDi = new BenXeDTO();
			BenXeDTO benDen = new BenXeDTO();
			benDi.setId(row.getBenDi().getIdBenXe());
			benDen.setId(row.getBenDen().getIdBenXe());
			benDi.setName(row.getBenDi().getTenBenXe());
			benDen.setName(row.getBenDen().getTenBenXe());
			benDi.setProvince(row.getBenDi().getDiaChi().getTinh());
			benDen.setProvince(row.getBenDen().getDiaChi().getTinh());
			tuyenXe.setBenDen(benDen);
			tuyenXe.setBenDi(benDi);
			tuyenXe.setDescription(row.getMoTa());
			tuyenXe.setDoDai(row.getDoDai());
			
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		
		return tuyenXe;
	}

	@Override
	public List<BenXeDTO> listTenBenXe() {
		List<BenXeDTO> listData = new ArrayList<BenXeDTO>(0);
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			List<Object[]> list = benXeDAO.listTenBenXe();
			BenXeDTO benXe = null;
			for (Object[] row : list) {
				benXe = new BenXeDTO();
				benXe.setId((Integer) row[0]);
				benXe.setName((String) row[1]);
				listData.add(benXe);
			}
			
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		} 
		return listData;
	}

}
