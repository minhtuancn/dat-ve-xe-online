package com.vexeonline.service;

import java.sql.Date;
import java.sql.Time;
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
import com.vexeonline.domain.BenXe;
import com.vexeonline.domain.ChuyenXe;
import com.vexeonline.domain.DanhGia;
import com.vexeonline.domain.DiaChi;
import com.vexeonline.domain.GiaVe;
import com.vexeonline.domain.HanhKhach;
import com.vexeonline.domain.LichTuyen;
import com.vexeonline.domain.NgayCuaTuan;
import com.vexeonline.domain.NhaXe;
import com.vexeonline.domain.TienIch;
import com.vexeonline.domain.TrangThaiChuyenXe;
import com.vexeonline.domain.TuyenXe;
import com.vexeonline.domain.User;
import com.vexeonline.domain.VeXe;
import com.vexeonline.domain.Xe;
import com.vexeonline.domain.json.ThongTinDanhGia;
import com.vexeonline.service.admin.QuanLyDanhGiaServiceImpl;
import com.vexeonline.utils.EncodeMD5;
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

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
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
		} finally {
			session.close();
		}

		return listTuyenXe;
	}

	static {
		Session session = HibernateUtil.getSessionFactory().openSession();
		DiaChi diaChi1 = new DiaChi();
		diaChi1.setTinh("Gia Lai");
		session.save(diaChi1);

		DiaChi diaChi2 = new DiaChi();
		diaChi2.setTinh("HCM");
		session.save(diaChi2);

		BenXe benXe1 = new BenXe();
		benXe1.setTenBenXe("BX.AnKhe");
		benXe1.setDiaChi(diaChi1);
		session.save(benXe1);

		BenXe benXe2 = new BenXe();
		benXe2.setTenBenXe("BX.MienDong");
		benXe2.setDiaChi(diaChi2);
		session.save(benXe2);

		TuyenXe tuyenXe = new TuyenXe();
		tuyenXe.setDoDai(100);
		tuyenXe.setBenDen(benXe2);
		tuyenXe.setBenDi(benXe1);
		session.save(tuyenXe);

		NhaXe nhaXe = new NhaXe();
		nhaXe.setTenNhaXe("VietTanPhat");
		session.save(nhaXe);

		Xe xe = new Xe();
		xe.setBienSoXe("81-12345");
		xe.setLoaiXe("Ghe Ngoi");
		xe.setSoCho(45);
		xe.setNhaXe(nhaXe);
		session.save(xe);

		LichTuyen lichTuyen = new LichTuyen();
		lichTuyen.setThu(NgayCuaTuan.MONDAY);
		lichTuyen.setGioDi(Time.valueOf("18:00:00"));
		lichTuyen.setTongThoiGian(12.5);
		lichTuyen.setXe(xe);
		lichTuyen.setTuyenXe(tuyenXe);
		session.save(lichTuyen);

		//
		tuyenXe.getLichTuyens().add(lichTuyen);

		GiaVe giaVe = new GiaVe();
		giaVe.setGiaVe(300000);
		giaVe.setLichTuyen(lichTuyen);
		giaVe.setNgayBatDau(Date.valueOf("2014-10-10"));
		giaVe.setNgayKetThuc(Date.valueOf("2014-12-10"));
		session.save(giaVe);

		//
		lichTuyen.getGiaVes().add(giaVe);

		ChuyenXe chuyenXe = new ChuyenXe();
		chuyenXe.setNgayDi(Date.valueOf("2014-11-24"));
		chuyenXe.setLichTuyen(lichTuyen);
		chuyenXe.setTrangThai(TrangThaiChuyenXe.BINHTHUONG);
		session.save(chuyenXe);

		HanhKhach hanhKhach = new HanhKhach();
		hanhKhach.setEmail("tungnt620@gmail.com");
		hanhKhach.setSdt("01696899620");
		hanhKhach.setTenHanhKhach("tung");
		session.save(hanhKhach);

		VeXe veXe = new VeXe();
		veXe.setChuyenXe(chuyenXe);
		veXe.setChoNgoi(1);
		veXe.setHanhKhach(hanhKhach);
		session.save(veXe);

		TienIch tienIch = new TienIch();
		tienIch.setTenTienIch("DRINK");
		tienIch.getXes().add(xe);
		session.save(tienIch);

		xe.getTienIchs().add(tienIch);

		DanhGia danhGia = new DanhGia();
		danhGia.setChuyenXe(chuyenXe);
		danhGia.setDiem(4.2f);
		danhGia.setHanhKhach(hanhKhach);
		danhGia.setNoiDung("12321");
		session.save(danhGia);

		session.flush();
		session.close();

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

	public boolean login(String userName, String password) {
		password = EncodeMD5.encodeMD5(password);
		boolean flag = true;
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			User user = userDAO.getUserByUserName(userName);
			if (user == null || !user.getPassword().equals(password)) {
				flag = false;
			}

			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			flag = false;
			logger.error("Error", ex);
		} finally {
			session.close();
		}
		return flag;
	}

	public boolean datVe(int soCho, int idChuyenXe, HanhKhach hanhKhach) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
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
		} finally {
			session.close();
		}
		return true;
	}

	public boolean danhGiaChuyenXe(Date ngayDi, String sdt, String noiDung,
			float diem){
		
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
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
		} finally {
			session.close();
		}
		return true;
	}

	public boolean huyVe(int maVe) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
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
		} finally {
			session.close();
		}
		return true;
	}

	public List<ThongTinDanhGia> getListInfoDanhGiaByNhaXe(int idNhaXe) {
		List<ThongTinDanhGia> listThongTinDanhGia = new ArrayList<ThongTinDanhGia>(0);
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			List<Object[]> listData = danhGiaDAO.getListInfoDanhGiaByIdNhaXe(idNhaXe);
			
			if (listData == null) {
				return null;
			}
			ThongTinDanhGia thongTin;
			for (Object[] row : listData) {
			    thongTin = new ThongTinDanhGia();
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
		} finally {
			session.close();
		}
		return listThongTinDanhGia;
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
