package com.vexeonline.service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vexeonline.dao.ChuyenXeDAO;
import com.vexeonline.dao.ChuyenXeDAOImpl;
import com.vexeonline.dao.DanhGiaDAO;
import com.vexeonline.dao.DanhGiaDAOImpl;
import com.vexeonline.dao.GiaVeDAO;
import com.vexeonline.dao.GiaVeDAOImpl;
import com.vexeonline.dao.HanhKhachDAO;
import com.vexeonline.dao.HanhKhachDAOImpl;
import com.vexeonline.dao.LichTuyenDAO;
import com.vexeonline.dao.LichTuyenDAOImpl;
import com.vexeonline.dao.TienIchDAO;
import com.vexeonline.dao.TienIchDAOImpl;
import com.vexeonline.dao.UserDAO;
import com.vexeonline.dao.UserDAOImpl;
import com.vexeonline.dao.VeXeDAO;
import com.vexeonline.dao.VeXeDAOImpl;
import com.vexeonline.domain.ChuyenXe;
import com.vexeonline.domain.DanhGia;
import com.vexeonline.domain.HanhKhach;
import com.vexeonline.domain.NgayCuaTuan;
import com.vexeonline.domain.NhaXe;
import com.vexeonline.domain.User;
import com.vexeonline.domain.VeXe;
import com.vexeonline.dto.SDTNhaXeDTO;
import com.vexeonline.dto.ThongTinChuyenXeDTO;
import com.vexeonline.dto.ThongTinDanhGiaDTO;
import com.vexeonline.utils.HibernateUtil;

public class KhachHangServiceImpl implements KhachHangService {

	private final Logger logger = Logger.getLogger(getClass());
	private static LichTuyenDAO lichTuyenDAO = new LichTuyenDAOImpl();
	private static UserDAO userDAO = new UserDAOImpl();
	private static VeXeDAO veXeDAO = new VeXeDAOImpl();
	private static TienIchDAO tienIchDAO = new TienIchDAOImpl();
	private static ChuyenXeDAO chuyenXeDAO = new ChuyenXeDAOImpl();
	private static HanhKhachDAO hanhKhachDAO = new HanhKhachDAOImpl();
	private static DanhGiaDAO danhGiaDAO = new DanhGiaDAOImpl();
	private static GiaVeDAO giaVeDAO = new GiaVeDAOImpl();
	
	public List<ThongTinChuyenXeDTO> getListChuyenXe(String tinhDi, String tinhDen,
			Date ngayDi, int soCho) {
		List<ThongTinChuyenXeDTO> listData = new ArrayList<ThongTinChuyenXeDTO>(0); 
		List<Object[]> list;
		Transaction tx = null;
		
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			list = lichTuyenDAO.getListInfo(tinhDi, tinhDen, dayOfWeek(ngayDi));
			if (list == null) {
				return listData;
			}
			
			ThongTinChuyenXeDTO temp;
			List<String> tenTienIchs = new ArrayList<String>(0);
			double rating;
			int giaVe;
			long soChoDaDat;
			for (Object[] row : list) {
				temp = new ThongTinChuyenXeDTO();
				temp.setIdLichTuyen((int) row[0]);
				temp.setIdNhaXe((int) row[1]);
				temp.setIdXe((int) row[2]);
				temp.setTenNhaXe((String) row[3]);
				temp.setLoaiXe((String) row[4]);
				temp.setSoCho((int)row[5]);
				temp.setTenBenDi((String) row[6]);
				temp.setTenBenDen((String) row[7]);
				temp.setGioDi((Time) row[8]);
				temp.setTongThoiGian((double) row[9]);
				
				tenTienIchs = tienIchDAO.getByXe(temp.getIdXe());
				temp.setTienIchs(tenTienIchs);
				logger.info(tenTienIchs.size());
				
				rating = danhGiaDAO.ratingByNhaXe(temp.getIdNhaXe());
				temp.setRating(rating);
				
				giaVe = giaVeDAO.getGiaVe(temp.getIdLichTuyen(), ngayDi);
				temp.setGiaVe(giaVe);
				
				/* When user book, they only choose date not hour and minute,
				It not enough determined chuyenXe => more parameter gioDi to determined soCho booked 
				*/
				soChoDaDat = veXeDAO.laySoVeXeTheoLichTuyenVaNgayDi(temp.getIdLichTuyen(), ngayDi, temp.getGioDi());
				if (temp.getSoCho() < (soChoDaDat + soCho)) {
					continue;
				}
				temp.setSoChoConLai((temp.getSoCho() - soChoDaDat));
				
				listData.add(temp);
			}
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) tx.rollback();
			logger.error("Error", ex);
		} 
		return listData;
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

			user = userDAO.get(userName);
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

	public boolean datVe(String soCho, int idChuyenXe, HanhKhach hanhKhach) {
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

	public boolean danhGiaChuyenXe(Date ngayDi, String maVe, String noiDung,
			float diem, int idNhaXe){
		
		Transaction tx = null;
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Object[] info = veXeDAO.getInfoByMaVe(maVe);
			if (info == null) {
				return false;
			}
			
			Date ngayDi_ = (Date) info[0];
			int idHanhKhach_ = (int) info[1];
			int idNhaXe_ = (int) info[2];
			
			//check info ngayDi, nhaXe fit with info got from maVe
			if (!ngayDi.equals(ngayDi_) || idNhaXe != idNhaXe_) {
				return false;
			}
			
			NhaXe nhaXe = (NhaXe) session.load(NhaXe.class, idNhaXe);
			HanhKhach hanhKhach = (HanhKhach) session.load(HanhKhach.class, idHanhKhach_);
			
			DanhGia danhGia = new DanhGia();
			danhGia.setDiem(diem);
			danhGia.setNoiDung(noiDung);
			danhGia.setNgayDi(ngayDi);
			danhGia.setNgayDanhGia(new Date());
			danhGia.setTrangThai(true);		//only display when ADMIN change trangThai to true
			danhGia.setHanhKhach(hanhKhach);
			danhGia.setNhaXe(nhaXe);
			danhGiaDAO.save(danhGia);
			
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
		logger.info(idNhaXe);
		List<ThongTinDanhGiaDTO> listThongTinDanhGia = new ArrayList<ThongTinDanhGiaDTO>(0);
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			List<Object[]> listData = danhGiaDAO.getListInfoDanhGiaByIdNhaXe(idNhaXe);
			if (listData == null) {
				return listThongTinDanhGia;
			}
			ThongTinDanhGiaDTO thongTin;
			for (Object[] row : listData) {
			    thongTin = new ThongTinDanhGiaDTO();
			    thongTin.setDiem((float) row[0]);
			    thongTin.setTenNguoiDanhGia((String)row[1]);
			    thongTin.setNoiDung((String)row[2]);
			    thongTin.setNgayDi((Date)row[3]);
			    thongTin.setNgayDanhGia((Date) row[4]);
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
		NgayCuaTuan day = null;

		switch (date.getDay()) {
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
