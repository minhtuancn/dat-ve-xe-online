package com.vexeonline.service.nhaxe;

import java.sql.Date;
import java.util.List;

import org.hibernate.Transaction;

import com.vexeonline.dao.ChuyenXeDAO;
import com.vexeonline.dao.ChuyenXeDAOImpl;
import com.vexeonline.dao.HanhKhachDAO;
import com.vexeonline.dao.HanhKhachDAOImpl;
import com.vexeonline.dao.ScheduleDAO;
import com.vexeonline.dao.ScheduleDAOImpl;
import com.vexeonline.dao.VeXeDAO;
import com.vexeonline.dao.VeXeDAOImpl;
import com.vexeonline.domain.ChuyenXe;
import com.vexeonline.domain.HanhKhach;
import com.vexeonline.domain.LichTuyen;
import com.vexeonline.domain.TrangThaiChuyenXe;
import com.vexeonline.domain.TrangThaiVeXe;
import com.vexeonline.domain.VeXe;
import com.vexeonline.utils.HibernateUtil;

public class DatVeServiceImpl implements DatVeService{
	//private static Logger logger = Logger.getLogger(DatVeServiceImpl.class);
	private static ChuyenXeDAO chuyenXeDAO = new ChuyenXeDAOImpl();
	private static ScheduleDAO lichTuyenDAO = new ScheduleDAOImpl();
	private static HanhKhachDAO hanhKhachDAO = new HanhKhachDAOImpl();
	private static VeXeDAO veXeDAO = new VeXeDAOImpl();
	
	public int getInfoChuyenXe(List<Boolean> seats, int idLichTuyen, Date ngayDi) throws Exception {
		int idChuyenXe ;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			
			ChuyenXe chuyenXe = null;//TODO chuyenXeDAO.getChuyenXeByNgayDiLichTuyen(idLichTuyen, ngayDi);
			
			if (chuyenXe == null) {  //create new chuyen xe
				LichTuyen lichTuyen = lichTuyenDAO.getById(idLichTuyen);
				chuyenXe = new ChuyenXe();
				chuyenXe.setLichTuyen(lichTuyen);
				chuyenXe.setNgayDi(ngayDi);
				chuyenXe.setTrangThai(TrangThaiChuyenXe.BINHTHUONG);
				chuyenXeDAO.insert(chuyenXe);
				
			}
			/*int soCho = chuyenXe.getLichTuyen().getXe().getSoCho();*/
			int soCho = chuyenXe.getLichTuyen().getXe().getType().getSeats();
			idChuyenXe = chuyenXe.getIdChuyenXe();
			
			for (int i = 0; i < soCho; ++i) {
				seats.add(false);
			}
			
			/*for (int i = 0; i < soCho; ++i) {
				for (VeXe veXe : chuyenXe.getVeXes()) {
					if (veXe.getChoNgoi() == (i + 1)) {
						seats.set(i, true);
						break;
					}
				}
			}*/
	
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw new Exception("Error", ex);
		} 
		return idChuyenXe;
	}

	public void datVe(int idChuyenXe, String[] seatings,
			String tenHanhKhach, String sdt) throws Exception {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			
			ChuyenXe chuyenXe = chuyenXeDAO.getById(idChuyenXe);
			HanhKhach hanhKhach = hanhKhachDAO.getBySDT(sdt);
			if (hanhKhach == null) {
				hanhKhach = new HanhKhach();
				hanhKhach.setSdt(sdt);
				hanhKhach.setTenHanhKhach(tenHanhKhach);
				hanhKhachDAO.insert(hanhKhach);
			}
			/*int soChoConLai = chuyenXe.getLichTuyen().getXe().getSoCho() - chuyenXe.getVeXes().size();*/
			int soChoConLai = chuyenXe.getLichTuyen().getXe().getType().getSeats() - chuyenXe.getVeXes().size();
			if (soChoConLai < seatings.length) {  //số chỗ không đủ
				throw new Exception("Hiện tại chỉ có " + soChoConLai);
			}
			
			for (String choNgoi : seatings) {
				VeXe veXe = new VeXe();
				veXe.setChoNgoi(choNgoi);
				veXe.setChuyenXe(chuyenXe);
				veXe.setHanhKhach(hanhKhach);
				veXe.setTrangThai(TrangThaiVeXe.GIUCHO);
				veXeDAO.save(veXe);
			}
	
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw new Exception(ex.getMessage(), ex);
		} 
	}
}
