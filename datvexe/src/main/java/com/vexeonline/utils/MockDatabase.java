package com.vexeonline.utils;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vexeonline.dao.BenXeDAO;
import com.vexeonline.dao.BenXeDAOImpl;
import com.vexeonline.dao.LichTuyenDAO;
import com.vexeonline.dao.LichTuyenDAOImpl;
import com.vexeonline.dao.NhaXeDAO;
import com.vexeonline.dao.NhaXeDAOImpl;
import com.vexeonline.dao.TuyenXeDAO;
import com.vexeonline.dao.TuyenXeDAOImpl;
import com.vexeonline.dao.XeDAO;
import com.vexeonline.dao.XeDAOImpl;
import com.vexeonline.domain.BenXe;
import com.vexeonline.domain.ChuyenXe;
import com.vexeonline.domain.DanhGia;
import com.vexeonline.domain.DiaChi;
import com.vexeonline.domain.GiaVe;
import com.vexeonline.domain.HanhKhach;
import com.vexeonline.domain.LichTuyen;
import com.vexeonline.domain.NgayCuaTuan;
import com.vexeonline.domain.NhaXe;
import com.vexeonline.domain.RoleOfUser;
import com.vexeonline.domain.SDTVanPhong;
import com.vexeonline.domain.TienIch;
import com.vexeonline.domain.TrangThaiChuyenXe;
import com.vexeonline.domain.TrangThaiVeXe;
import com.vexeonline.domain.TuyenXe;
import com.vexeonline.domain.User;
import com.vexeonline.domain.VanPhong;
import com.vexeonline.domain.VeXe;
import com.vexeonline.domain.Xe;
import com.vexeonline.dto.ChuyenXeDTO;
import com.vexeonline.service.nhaxe.QuanLyChuyenXeService;
import com.vexeonline.service.nhaxe.QuanLyChuyenXeServiceImpl;

public class MockDatabase {
	public static void mockData() throws ParseException {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		
		DiaChi diaChi1 = new DiaChi();
		diaChi1.setTinh("Gia Lai");
		session.save(diaChi1);

		DiaChi diaChi2 = new DiaChi();
		diaChi2.setTinh("HCM");
		session.save(diaChi2);

		BenXe benXe1 = new BenXe();
		benXe1.setTenBenXe("Bến xe An Khên");
		benXe1.setDiaChi(diaChi1);
		session.save(benXe1);

		BenXe benXe2 = new BenXe();
		benXe2.setTenBenXe("Bến xe Miền Đông");
		benXe2.setDiaChi(diaChi2);
		session.save(benXe2);

		TuyenXe tuyenXe = new TuyenXe();
		tuyenXe.setDoDai(100);
		tuyenXe.setBenDen(benXe2);
		tuyenXe.setBenDi(benXe1);
		session.save(tuyenXe);

		NhaXe nhaXe = new NhaXe();
		nhaXe.setTenNhaXe("Việt Tân Phát");
		session.save(nhaXe);

		VanPhong vanPhong  = new VanPhong();
		vanPhong.setDiaChi(diaChi1);
		vanPhong.setNhaXe(nhaXe);
		vanPhong.setTenVanPhong("Văn phòng An Khê");
		session.save(vanPhong);
		
		SDTVanPhong sdtVanPhong = new SDTVanPhong();
		sdtVanPhong.setVanPhong(vanPhong);
		sdtVanPhong.setSDT("01224404993");
		session.save(sdtVanPhong);
		
		vanPhong.getSDTVanPhongs().add(sdtVanPhong);
		
		Xe xe = new Xe();
		xe.setBienSoXe("81-12345");
		xe.setLoaiXe("Ghế Ngồi");
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
		giaVe.setNgayBatDau(new SimpleDateFormat("dd/MM/yyyy").parse("11/1/2014"));
		giaVe.setNgayKetThuc(new SimpleDateFormat("dd/MM/yyyy").parse("20/12/2015"));
		session.save(giaVe);

		//
		lichTuyen.getGiaVes().add(giaVe);

		ChuyenXe chuyenXe = new ChuyenXe();
		chuyenXe.setNgayDi(new SimpleDateFormat("dd/MM/yyyy").parse("20/12/2014"));
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
		veXe.setTrangThai(TrangThaiVeXe.GIUCHO);
		veXe.setHanhKhach(hanhKhach);
		session.save(veXe);

		TienIch tienIch = new TienIch();
		tienIch.setTenTienIch("DRINK");
		tienIch.getXes().add(xe);
		session.save(tienIch);
		
		tienIch = new TienIch();
		tienIch.setTenTienIch("TISSUE");
		session.save(tienIch);
		
		tienIch = new TienIch();
		tienIch.setTenTienIch("DVD");
		session.save(tienIch);
		
		tienIch = new TienIch();
		tienIch.setTenTienIch("TOILET");
		session.save(tienIch);
		
		tienIch = new TienIch();
		tienIch.setTenTienIch("AIRCON");
		session.save(tienIch);
		
		xe.getTienIchs().add(tienIch);

		DanhGia danhGia = new DanhGia();
		danhGia.setDiem(4.2f);
		danhGia.setHanhKhach(hanhKhach);
		danhGia.setNoiDung("12321");
		session.save(danhGia);

		User user = new User();
		user.setUserName("tung");
		user.setPassword("123456");
		user.setRole(RoleOfUser.NHAXE);
		user.setNhaXe(nhaXe);
		session.save(user);
		
		User user2 = new User();
		user2.setUserName("hungdq");
		user2.setPassword("123456");
		user2.setRole(RoleOfUser.NHAXE);
		user2.setNhaXe(nhaXe);
		session.save(user2);
		
		//generateMockData();
		
		tx.commit();
		
		HibernateUtil.close();
	}
	
	@SuppressWarnings("deprecation")
	private static void generateMockData() {

		// /////////////////////////////////////////////

		NhaXeDAO nhaXeDAO = new NhaXeDAOImpl();

		NhaXe nhaXe = new NhaXe();
		nhaXe.setTenNhaXe("Mai Linh");
		nhaXeDAO.save(nhaXe);

		nhaXe = new NhaXe();
		nhaXe.setTenNhaXe("PhÆ°Æ¡ng Trang");
		nhaXeDAO.save(nhaXe);

		// /////////////////////////////////////////////

		BenXeDAO benXeDAO = new BenXeDAOImpl();

		BenXe bx = new BenXe();
		bx.setDiaChi(new DiaChi("Quáº£ng Nam", "ThÄƒng BÃ¬nh", ""));
		bx.setTenBenXe("Báº¿n xe miá»�n Ä‘Ã´ng");
		benXeDAO.save(bx);

		bx = new BenXe();
		bx.setDiaChi(new DiaChi("Quáº£ng Nam", "ThÄƒng BÃ¬nh", ""));
		bx.setTenBenXe("Báº¿n xe Ä�Ã  Náºµng");
		benXeDAO.save(bx);

		bx = new BenXe();
		bx.setDiaChi(new DiaChi("Quáº£ng Nam", "ThÄƒng BÃ¬nh", ""));
		bx.setTenBenXe("Báº¿n xe nÆ°á»›c ngáº§m");
		benXeDAO.save(bx);

		// /////////////////////////////////////////////

		TuyenXeDAO tuyenXeDAO = new TuyenXeDAOImpl();

		TuyenXe tx = new TuyenXe();
		tx.setBenDi(benXeDAO.getById(2));
		tx.setBenDen(benXeDAO.getById(3));
		tx.setDoDai(10000);
		tx.setMoTa("MÃ´ táº£ tuyáº¿n");
		tuyenXeDAO.save(tx);

		tx = new TuyenXe();
		tx.setBenDi(benXeDAO.getById(3));
		tx.setBenDen(benXeDAO.getById(1));
		tx.setDoDai(10000);
		tx.setMoTa("MÃ´ táº£ tuyáº¿n");
		tuyenXeDAO.save(tx);

		tx = new TuyenXe();
		tx.setBenDi(benXeDAO.getById(1));
		tx.setBenDen(benXeDAO.getById(3));
		tx.setDoDai(10000);
		tx.setMoTa("MÃ´ táº£ tuyáº¿n");
		tuyenXeDAO.save(tx);

		// /////////////////////////////////////////////

		XeDAO xeDAO = new XeDAOImpl();

		Xe xe = new Xe();
		xe.setBienSoXe("12345");
		xe.setLoaiXe("GiÆ°á»�ng náº±m 40 chá»—");
		xe.setSoCho(40);
		xe.setNhaXe(nhaXeDAO.getById(1));
		xeDAO.save(xe);

		xe = new Xe();
		xe.setBienSoXe("22345");
		xe.setLoaiXe("GiÆ°á»�ng náº±m 40 chá»—");
		xe.setSoCho(40);
		xe.setNhaXe(nhaXeDAO.getById(2));
		xeDAO.save(xe);

		// /////////////////////////////////////////////

		LichTuyenDAO lichChuyenDAO = new LichTuyenDAOImpl();

		LichTuyen lichChuyen = new LichTuyen();
		lichChuyen.setTuyenXe(tuyenXeDAO.getById(1));
		lichChuyen.setThu(NgayCuaTuan.MONDAY);
		lichChuyen.setGioDi(new Time(10, 30, 00));
		lichChuyen.setXe(xeDAO.getById(1));
		lichChuyenDAO.save(lichChuyen);

		lichChuyen = new LichTuyen();
		lichChuyen.setTuyenXe(tuyenXeDAO.getById(1));
		lichChuyen.setThu(NgayCuaTuan.SUNDAY);
		lichChuyen.setGioDi(new Time(11, 30, 00));
		lichChuyen.setXe(xeDAO.getById(2));
		lichChuyenDAO.save(lichChuyen);

		lichChuyen = new LichTuyen();
		lichChuyen.setTuyenXe(tuyenXeDAO.getById(1));
		lichChuyen.setThu(NgayCuaTuan.THURSDAY);
		lichChuyen.setGioDi(new Time(17, 30, 00));
		lichChuyen.setXe(xeDAO.getById(1));
		lichChuyenDAO.save(lichChuyen);

		ChuyenXeDTO chuyenXe = new ChuyenXeDTO();
		chuyenXe.setIdLichChuyen(1);
		chuyenXe.setIdTuyen(1);
		chuyenXe.setNgayDi("22/12/2014");
		chuyenXe.setGioKhoiHanh("11:30");
		chuyenXe.setTenTaiXe("Nguyen Van A");
		chuyenXe.setTrangThai(TrangThaiChuyenXe.BINHTHUONG);

		QuanLyChuyenXeService service = new QuanLyChuyenXeServiceImpl();
		try {
			System.out
					.println("<====================================================================>");
			service.addNew(chuyenXe);
			System.out
					.println("<====================================================================>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}