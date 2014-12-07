package com.vexeonline.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vexeonline.dao.ChuyenXeDAO;
import com.vexeonline.dao.ChuyenXeDAOImpl;
import com.vexeonline.dao.DanhGiaDAO;
import com.vexeonline.dao.DanhGiaDAOImpl;
import com.vexeonline.dao.HanhKhachDAO;
import com.vexeonline.dao.HanhKhachDAOImpl;
import com.vexeonline.dao.NhaXeDAOImpl;
import com.vexeonline.dao.TuyenXeDAO;
import com.vexeonline.dao.TuyenXeDAOImpl;
import com.vexeonline.dao.UserDAO;
import com.vexeonline.dao.UserDAOImpl;
import com.vexeonline.dao.VeXeDAO;
import com.vexeonline.dao.VeXeDAOImpl;
import com.vexeonline.domain.ChuyenXe;
import com.vexeonline.domain.DanhGia;
import com.vexeonline.domain.HanhKhach;
import com.vexeonline.domain.NgayCuaTuan;
import com.vexeonline.domain.NhaXe;
import com.vexeonline.domain.TuyenXe;
import com.vexeonline.domain.User;
import com.vexeonline.domain.VeXe;
import com.vexeonline.dto.SDTNhaXeDTO;
import com.vexeonline.dto.ThongTinDanhGiaDTO;
import com.vexeonline.service.admin.QuanLyDanhGiaServiceImpl;
import com.vexeonline.utils.HibernateUtil;

public class KhachHangServiceImpl implements KhachHangService {

	private final Logger logger = Logger.getLogger(getClass());
	private static TuyenXeDAO tuyenXeDAO = new TuyenXeDAOImpl();
	private static UserDAO userDAO = new UserDAOImpl();
	private static VeXeDAO veXeDAO = new VeXeDAOImpl();
	private static ChuyenXeDAO chuyenXeDAO = new ChuyenXeDAOImpl();
	private static HanhKhachDAO hanhKhachDAO = new HanhKhachDAOImpl();
	private static DanhGiaDAO danhGiaDAO = new DanhGiaDAOImpl();

	public List<TuyenXe> getListChuyenXe(String tinhDi, String tinhDen,
			Date ngayDi, int soCho) {
		List<TuyenXe> listTuyenXe = new ArrayList<TuyenXe>(0);
		if (tinhDi == null || tinhDen == null || ngayDi == null) {
			throw new IllegalArgumentException("ArgumentException");
		}

		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			listTuyenXe = tuyenXeDAO.getListTuyenXe(tinhDi, tinhDen,
					ngayDi.toString(), dayOfWeek(ngayDi));

			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		} 
		return listTuyenXe;
	}

	public VeXe kiemTraVe(String SDT, int maSoVe) {
		VeXe veXe = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			veXe = veXeDAO.getInfoVeXe(maSoVe);
			if (veXe == null || !veXe.getHanhKhach().getSdt().equals(SDT)) {
				return null;
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
		return veXe;
	}

	public User login(String userName, String password) {
		//password = EncodeMD5.encodeMD5(password);
		User user = null;
		Transaction tx = null;
		try {
			
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			user = userDAO.getUserByUserName(userName);
			if (user == null || !user.getPassword().equals(password)) {
				user = null;
			}
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);	
		}
		return user;
	}

	public boolean datVe(int soCho, int idChuyenXe, HanhKhach hanhKhach) {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			hanhKhachDAO.save(hanhKhach);

			ChuyenXe chuyenXe = chuyenXeDAO.getById(idChuyenXe);

			VeXe veXe = new VeXe();
			veXe.setChoNgoi(soCho);
			veXe.setChuyenXe(chuyenXe);
			veXe.setHanhKhach(hanhKhach);
			veXeDAO.save(veXe);

			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
			return false;
		} 
		return true;
	}

	public boolean danhGiaChuyenXe(Date ngayDi, String sdt, String noiDung,
			float diem){
		
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			boolean flag = false;
			ChuyenXe chuyenXe = null;
			HanhKhach hanhKhach = hanhKhachDAO.getBySDT(sdt);
			if (hanhKhach == null) {
				return false;
			}
			for (VeXe veXe : hanhKhach.getVeXes()) {
				if (veXe.getChuyenXe().getNgayDi().toString().equals(ngayDi.toString())) {
					flag = true;
					chuyenXe = veXe.getChuyenXe();
					break;
				}
			}
			
			if (flag == true) {
				DanhGia danhGia = new DanhGia();
				danhGia.setChuyenXe(chuyenXe);
				danhGia.setDiem(diem);
				danhGia.setHanhKhach(hanhKhach);
				danhGia.setNoiDung(noiDung);
				//
				danhGia.setTrangThai(true);
				danhGiaDAO.save(danhGia);
				//demo 
				float rate = new QuanLyDanhGiaServiceImpl().tinhNewRate(danhGia);
				NhaXe nhaXe = chuyenXe.getLichTuyen().getXe().getNhaXe();
				nhaXe.setRate(rate);
				new NhaXeDAOImpl().update(nhaXe);
			}
			
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		} 
		return true;
	}

	public boolean huyVe(int maVe) throws Exception {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			VeXe veXe = veXeDAO.getInfoVeXe(maVe);
			if (veXe == null) {
				return false;
			}
			veXeDAO.delete(veXe);

			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
			throw new Exception("Error");
		}
		return true;
	}

	public List<ThongTinDanhGiaDTO> getListInfoDanhGiaByNhaXe(int idNhaXe) {
		List<ThongTinDanhGiaDTO> listThongTinDanhGia = new ArrayList<ThongTinDanhGiaDTO>(0);
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			List<Object[]> listData = danhGiaDAO.getListInfoDanhGiaByIdNhaXe(idNhaXe);
			
			if (listData == null) {
				return null;
			}
			ThongTinDanhGiaDTO thongTin;
			for (Object[] row : listData) {
			    thongTin = new ThongTinDanhGiaDTO();
			    thongTin.setDiem((float) row[0]);
			    thongTin.setTenNguoiDanhGia((String)row[1]);
			    thongTin.setNgayDi((Date)row[2]);
			    thongTin.setNoiDung((String)row[3]);
			    listThongTinDanhGia.add(thongTin);
			}

			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		} 
		return listThongTinDanhGia;
	}
	
	public List<SDTNhaXeDTO> getListSDTNhaXe(int idNhaXe) {
		List<SDTNhaXeDTO> listSDTNhaXe = new ArrayList<SDTNhaXeDTO>(0);
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			List<Object[]> listData = danhGiaDAO.getListSDTNhaXe(idNhaXe);
			
			if (listData == null) {
				return null;
			}
			SDTNhaXeDTO thongTin;
			for (Object[] row : listData) {
			    thongTin = new SDTNhaXeDTO();
			    thongTin.setTenVanPhong((String) row[0]);
			    thongTin.setSdt((String)row[1]);
			    listSDTNhaXe.add(thongTin);
			}
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		} 
		return listSDTNhaXe;
	}


	
	@SuppressWarnings("deprecation")
	private NgayCuaTuan dayOfWeek(Date date) {
		int a = (14 - date.getMonth()) / 12;
		int y = date.getYear() - a;
		int m = date.getMonth() + 12 * a - 2;
		int dayOfWeek = (date.getDay() + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7;

		NgayCuaTuan day = null;

		switch (dayOfWeek) {
		case 0:
			day = NgayCuaTuan.SUNDAY;
			break;
		case 1:
			day = NgayCuaTuan.MONDAY;
			break;
		case 2:
			day = NgayCuaTuan.TUESDAY;
			break;
		case 3:
			day = NgayCuaTuan.WEDNESDAY;
			break;
		case 4:
			day = NgayCuaTuan.THURSDAY;
			break;
		case 5:
			day = NgayCuaTuan.FRIDAY;
			break;
		case 6:
			day = NgayCuaTuan.SATUREDAY;
			break;
		}
		return day;
	}
}
