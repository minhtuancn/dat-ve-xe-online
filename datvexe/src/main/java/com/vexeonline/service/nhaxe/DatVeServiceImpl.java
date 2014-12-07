package com.vexeonline.service.nhaxe;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Transaction;

import com.vexeonline.dao.ChuyenXeDAO;
import com.vexeonline.dao.ChuyenXeDAOImpl;
import com.vexeonline.dao.LichTuyenDAO;
import com.vexeonline.dao.LichTuyenDAOImpl;
import com.vexeonline.domain.ChuyenXe;
import com.vexeonline.domain.LichTuyen;
import com.vexeonline.domain.TrangThaiChuyenXe;
import com.vexeonline.domain.VeXe;
import com.vexeonline.utils.HibernateUtil;

public class DatVeServiceImpl implements DatVeService{
	private static Logger logger = Logger.getLogger(DatVeServiceImpl.class);
	private static ChuyenXeDAO chuyenXeDAO = new ChuyenXeDAOImpl();
	private static LichTuyenDAO lichTuyenDAO = new LichTuyenDAOImpl();
	
	public int getInfoChuyenXe(List<Boolean> seats, int idLichTuyen, Date ngayDi) throws Exception {
		int idChuyenXe ;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			
			ChuyenXe chuyenXe = chuyenXeDAO.getChuyenXeByNgayDiLichTuyen(idLichTuyen, ngayDi);
			int soCho = 0;
			if (chuyenXe == null) {  //create new chuyen xe
				LichTuyen lichTuyen = lichTuyenDAO.getById(idLichTuyen);
				chuyenXe = new ChuyenXe();
				chuyenXe.setLichTuyen(lichTuyen);
				chuyenXe.setNgayDi(ngayDi);
				chuyenXe.setTrangThai(TrangThaiChuyenXe.BINHTHUONG);
				chuyenXeDAO.save(chuyenXe);
				soCho = chuyenXe.getLichTuyen().getXe().getSoCho();
			} else {
				soCho = chuyenXe.getLichTuyen().getXe().getSoCho() - chuyenXe.getVeXes().size();
			}
			idChuyenXe = chuyenXe.getIdChuyenXe();
			
			logger.info(soCho);
			for (int i = 0; i < soCho; ++i) {
				seats.add(false);
			}
			
			for (int i = 0; i < soCho; ++i) {
				for (VeXe veXe : chuyenXe.getVeXes()) {
					if (veXe.getChoNgoi() == (i + 1)) {
						seats.set(i, true);
						break;
					}
				}
			}
	
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw new Exception("Error", ex);
		} 
		return idChuyenXe;
	}

	public void datVe(int idChuyenXe, List<Integer> seatings) {
		
	}
}
