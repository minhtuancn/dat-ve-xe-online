package com.vexeonline.utils;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vexeonline.dao.BenXeDAO;
import com.vexeonline.dao.BenXeDAOImpl;
import com.vexeonline.dao.NhaXeDAO;
import com.vexeonline.dao.NhaXeDAOImpl;
import com.vexeonline.dao.ScheduleDAO;
import com.vexeonline.dao.ScheduleDAOImpl;
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

public class MockDatabase {

	public static void mockData() throws ParseException {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		DiaChi diaChi1 = new DiaChi();
		diaChi1.setTinh("Gia Lai");
		diaChi1.setHuyen("An Khê");
		session.save(diaChi1);

		DiaChi diaChi2 = new DiaChi();
		diaChi2.setTinh("Hồ Chí Minh");
		diaChi2.setHuyen("Bình Thạnh");
		session.save(diaChi2);

		BenXe benXe1 = new BenXe();
		benXe1.setTenBenXe("Bến xe An Khê");
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

		VanPhong vanPhong = new VanPhong();
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
		xe.setBienSoXe("81E-11110");
		xe.setLoaiXe("Ghế Ngồi");
		xe.setSoCho(45);
		xe.setNhaXe(nhaXe);
		xe.setHinhAnh("GheNgoi45Cho.png");
		Set<String> viTris = new HashSet<String>(0);
		viTris.add("A1");
		viTris.add("A2");
		viTris.add("B1");
		viTris.add("B2");
		viTris.add("C1");
		viTris.add("C2");
		xe.setViTris(viTris);
		session.save(xe);

		LichTuyen lichTuyen = new LichTuyen();
		lichTuyen.setThu(NgayCuaTuan.MONDAY);
		lichTuyen.setGioDi(Time.valueOf("18:00:00"));
		lichTuyen.setTongThoiGian(12.5);
		lichTuyen.setXe(xe);
		lichTuyen.setTuyenXe(tuyenXe);
		session.save(lichTuyen);

		tuyenXe.getLichTuyens().add(lichTuyen);

		GiaVe giaVe = new GiaVe();
		giaVe.setGiaVe(300000);
		giaVe.setLichTuyen(lichTuyen);
		giaVe.setNgayBatDau(new SimpleDateFormat("dd/MM/yyyy")
				.parse("11/1/2014"));
		giaVe.setNgayKetThuc(new SimpleDateFormat("dd/MM/yyyy")
				.parse("20/12/2015"));
		session.save(giaVe);

		lichTuyen.getGiaVes().add(giaVe);

		ChuyenXe chuyenXe = new ChuyenXe();
		chuyenXe.setNgayDi(new SimpleDateFormat("dd/MM/yyyy")
				.parse("20/12/2014"));
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
		veXe.setChoNgoi("A1");
		veXe.setMaVe("AB3223AV");
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
		danhGia.setNoiDung("Very Good");
		danhGia.setNgayDanhGia(new SimpleDateFormat("dd/mm/yyyy").parse("12/12/2014"));
		danhGia.setNgayDi(new SimpleDateFormat("dd/mm/yyyy").parse("22/12/2014"));
		danhGia.setNhaXe(nhaXe);
		session.save(danhGia);

		User user = new User();
		user.setUserName("tung");
		user.setPassword("123456");
		user.setRole(RoleOfUser.NHAXE);
		user.setNhaXe(nhaXe);
		session.save(user);
		
		NhaXe nhaXe2 = new NhaXe();
		nhaXe2.setTenNhaXe("Mai Linh");
		session.save(nhaXe2);
		
		User user2 = new User();
		user2.setUserName("hungdq");
		user2.setPassword("123456");
		user2.setRole(RoleOfUser.NHAXE);
		user2.setNhaXe(nhaXe2);
		session.save(user2);
	}
	
	private static Set<String> generateViTri(int socho) {
		Set<String> vt = new HashSet<String>();
		for (int i=1; i<=socho/3; i++) {
			vt.add("A" + i);
			vt.add("B" + i);
			vt.add("C" + i);
		}
		for (int i=1; i<=socho%3; i++) {
			vt.add("D" + i);
		}
		return vt;
	}
	
	public static void generateMockData() throws Exception {

		// /////////////////////////////////////////////
		
		NhaXeDAO nhaXeDAO = new NhaXeDAOImpl();

		NhaXe nhaXe = new NhaXe();
		nhaXe.setTenNhaXe("Hoàng Long");
		nhaXeDAO.save(nhaXe);

		nhaXe = new NhaXe();
		nhaXe.setTenNhaXe("Phương Trang");
		nhaXeDAO.save(nhaXe);

		// /////////////////////////////////////////////

		BenXeDAO benXeDAO = new BenXeDAOImpl();

		BenXe bx = new BenXe();
		bx.setDiaChi(new DiaChi("Quảng Nam", "Thăng Bình", ""));
		bx.setTenBenXe("Bến xe Hà Lam");
		benXeDAO.save(bx);

		bx = new BenXe();
		bx.setDiaChi(new DiaChi("Đà Nẵng", "Cẩm Lệ", ""));
		bx.setTenBenXe("Bến xe Đà Nẵng");
		benXeDAO.save(bx);

		bx = new BenXe();
		bx.setDiaChi(new DiaChi("Hà Nội", "Hoàng Mai", ""));
		bx.setTenBenXe("Bến xe nước ngầm");
		benXeDAO.save(bx);

		// /////////////////////////////////////////////

		TuyenXeDAO tuyenXeDAO = new TuyenXeDAOImpl();

		TuyenXe tx0 = new TuyenXe();
		tx0.setBenDi(benXeDAO.getById(3));
		tx0.setBenDen(benXeDAO.getById(2));
		tx0.setDoDai(1000);
		tx0.setMoTa("Mô tả tuyến");
		tuyenXeDAO.save(tx0);

		TuyenXe tx1 = new TuyenXe();
		tx1.setBenDi(benXeDAO.getById(2));
		tx1.setBenDen(benXeDAO.getById(3));
		tx1.setDoDai(1100);
		tx1.setMoTa("Mô tả tuyến");
		tuyenXeDAO.save(tx1);

		TuyenXe tx2 = new TuyenXe();
		tx2.setBenDi(benXeDAO.getById(3));
		tx2.setBenDen(benXeDAO.getById(4));
		tx2.setDoDai(1200);
		tx2.setMoTa("Mô tả tuyến");
		tuyenXeDAO.save(tx2);
		
		TuyenXe tx3 = new TuyenXe();
		tx3.setBenDi(benXeDAO.getById(4));
		tx3.setBenDen(benXeDAO.getById(5));
		tx3.setDoDai(1300);
		tx3.setMoTa("Mô tả tuyến");
		tuyenXeDAO.save(tx3);
		
		TuyenXe tx4 = new TuyenXe();
		tx4.setBenDi(benXeDAO.getById(5));
		tx4.setBenDen(benXeDAO.getById(1));
		tx4.setDoDai(1400);
		tx4.setMoTa("Mô tả tuyến");
		tuyenXeDAO.save(tx4);
		
		TuyenXe tx5 = new TuyenXe();
		tx5.setBenDi(benXeDAO.getById(2));
		tx5.setBenDen(benXeDAO.getById(5));
		tx5.setDoDai(1500);
		tx5.setMoTa("Mô tả tuyến");
		tuyenXeDAO.save(tx5);
		
		TuyenXe tx6 = new TuyenXe();
		tx6.setBenDi(benXeDAO.getById(2));
		tx6.setBenDen(benXeDAO.getById(4));
		tx6.setDoDai(1600);
		tx6.setMoTa("Mô tả tuyến");
		tuyenXeDAO.save(tx6);
		
		TuyenXe tx7 = new TuyenXe();
		tx7.setBenDi(benXeDAO.getById(2));
		tx7.setBenDen(benXeDAO.getById(1));
		tx7.setDoDai(1700);
		tx7.setMoTa("Mô tả tuyến");
		tuyenXeDAO.save(tx7);

		// /////////////////////////////////////////////

		XeDAO xeDAO = new XeDAOImpl();
		
		Xe xe0 = new Xe();
		xe0.setBienSoXe("81C-11111");
		xe0.setLoaiXe("Giường nằm");
		xe0.setSoCho(40);
		xe0.setNhaXe(nhaXeDAO.getById(1));
		xe0.setActive(true);
		xe0.setViTris(generateViTri(40));
		xeDAO.save(xe0);
		
		Xe xe1 = new Xe();
		xe1.setBienSoXe("81B-11112");
		xe1.setLoaiXe("Giường nằm");
		xe1.setSoCho(40);
		xe1.setNhaXe(nhaXeDAO.getById(1));
		xe1.setActive(true);
		xe1.setViTris(generateViTri(40));
		xeDAO.save(xe1);

		Xe xe2 = new Xe();
		xe2.setBienSoXe("81A-11113");
		xe2.setLoaiXe("Giường nằm");
		xe2.setSoCho(40);
		xe2.setNhaXe(nhaXeDAO.getById(1));
		xe2.setActive(true);
		xe2.setViTris(generateViTri(40));
		xeDAO.save(xe2);
		
		Xe xe3 = new Xe();
		xe3.setBienSoXe("92H-11111");
		xe3.setLoaiXe("Giường nằm");
		xe3.setSoCho(40);
		xe3.setNhaXe(nhaXeDAO.getById(2));
		xe3.setActive(true);
		xe3.setViTris(generateViTri(40));
		xeDAO.save(xe3);
		
		Xe xe4 = new Xe();
		xe4.setBienSoXe("92H-11112");
		xe4.setLoaiXe("Giường nằm");
		xe4.setSoCho(40);
		xe4.setNhaXe(nhaXeDAO.getById(2));
		xe4.setActive(true);
		xe4.setViTris(generateViTri(40));
		xeDAO.save(xe4);
		
		Xe xe5 = new Xe();
		xe5.setBienSoXe("92H-11113");
		xe5.setLoaiXe("Giường nằm");
		xe5.setSoCho(40);
		xe5.setNhaXe(nhaXeDAO.getById(2));
		xe5.setActive(true);
		xe5.setViTris(generateViTri(40));
		xeDAO.save(xe5);
		
		Xe xe6 = new Xe();
		xe6.setBienSoXe("92H-11114");
		xe6.setLoaiXe("Giường nằm");
		xe6.setSoCho(40);
		xe6.setNhaXe(nhaXeDAO.getById(2));
		xe6.setActive(true);
		xe6.setViTris(generateViTri(40));
		xeDAO.save(xe6);
		
		Xe xe7 = new Xe();
		xe7.setBienSoXe("92H-11115");
		xe7.setLoaiXe("Giường nằm");
		xe7.setSoCho(40);
		xe7.setNhaXe(nhaXeDAO.getById(2));
		xe7.setActive(true);
		xe7.setViTris(generateViTri(40));
		xeDAO.save(xe7);
		
		Xe xe8 = new Xe();
		xe8.setBienSoXe("92H-11116");
		xe8.setLoaiXe("Giường nằm");
		xe8.setSoCho(40);
		xe8.setNhaXe(nhaXeDAO.getById(2));
		xe8.setActive(true);
		xe8.setViTris(generateViTri(40));
		xeDAO.save(xe8);
		
		Xe xe9 = new Xe();
		xe9.setBienSoXe("92H-11117");
		xe9.setLoaiXe("Giường nằm");
		xe9.setSoCho(40);
		xe9.setNhaXe(nhaXeDAO.getById(2));
		xe9.setActive(true);
		xe9.setViTris(generateViTri(40));
		xeDAO.save(xe9);
		
		Xe xe10 = new Xe();
		xe10.setBienSoXe("92H-11118");
		xe10.setLoaiXe("Giường nằm");
		xe10.setSoCho(40);
		xe10.setNhaXe(nhaXeDAO.getById(2));
		xe10.setActive(true);
		xe10.setViTris(generateViTri(40));
		xeDAO.save(xe10);
		
		Xe xe11 = new Xe();
		xe11.setBienSoXe("92H-11119");
		xe11.setLoaiXe("Giường nằm");
		xe11.setSoCho(40);
		xe11.setNhaXe(nhaXeDAO.getById(2));
		xe11.setActive(true);
		xe11.setViTris(generateViTri(40));
		xeDAO.save(xe11);

		// /////////////////////////////////////////////

		ScheduleDAO lichChuyenDAO = new ScheduleDAOImpl();

		LichTuyen lichChuyen0 = new LichTuyen();
		lichChuyen0.setTuyenXe(tuyenXeDAO.getById(1));
		lichChuyen0.setThu(NgayCuaTuan.MONDAY);
		lichChuyen0.setGioDi(new SimpleDateFormat("kk:mm").parse("10:15"));
		lichChuyen0.setXe(xeDAO.getById(1));
		lichChuyen0.setTongThoiGian(20);
		lichChuyen0.setActive(true);
		lichChuyenDAO.insert(lichChuyen0);

		LichTuyen lichChuyen1 = new LichTuyen();
		lichChuyen1.setTuyenXe(tuyenXeDAO.getById(2));
		lichChuyen1.setThu(NgayCuaTuan.SUNDAY);
		lichChuyen1.setGioDi(new SimpleDateFormat("kk:mm").parse("08:30"));
		lichChuyen1.setXe(xeDAO.getById(1));
		lichChuyen1.setTongThoiGian(22);
		lichChuyen1.setActive(true);
		lichChuyenDAO.insert(lichChuyen1);

		LichTuyen lichChuyen2 = new LichTuyen();
		lichChuyen2.setTuyenXe(tuyenXeDAO.getById(3));
		lichChuyen2.setThu(NgayCuaTuan.THURSDAY);
		lichChuyen2.setGioDi(new SimpleDateFormat("kk:mm").parse("10:30"));
		lichChuyen2.setXe(xeDAO.getById(2));
		lichChuyen2.setTongThoiGian(19);
		lichChuyen2.setActive(true);
		lichChuyenDAO.insert(lichChuyen2);
		
		LichTuyen lichChuyen3 = new LichTuyen();
		lichChuyen3.setTuyenXe(tuyenXeDAO.getById(4));
		lichChuyen3.setThu(NgayCuaTuan.WEDNESDAY);
		lichChuyen3.setGioDi(new SimpleDateFormat("kk:mm").parse("17:30"));
		lichChuyen3.setXe(xeDAO.getById(2));
		lichChuyen3.setTongThoiGian(15);
		lichChuyen3.setActive(true);
		lichChuyenDAO.insert(lichChuyen3);
		
		LichTuyen lichChuyen4 = new LichTuyen();
		lichChuyen4.setTuyenXe(tuyenXeDAO.getById(1));
		lichChuyen4.setThu(NgayCuaTuan.FRIDAY);
		lichChuyen4.setGioDi(new SimpleDateFormat("kk:mm").parse("15:30"));
		lichChuyen4.setXe(xeDAO.getById(3));
		lichChuyen4.setTongThoiGian(10);
		lichChuyen4.setActive(true);
		lichChuyenDAO.insert(lichChuyen4);
		
		LichTuyen lichChuyen5 = new LichTuyen();
		lichChuyen5.setTuyenXe(tuyenXeDAO.getById(2));
		lichChuyen5.setThu(NgayCuaTuan.MONDAY);
		lichChuyen5.setGioDi(new SimpleDateFormat("kk:mm").parse("10:30"));
		lichChuyen5.setXe(xeDAO.getById(3));
		lichChuyen5.setTongThoiGian(25);
		lichChuyen5.setActive(true);
		lichChuyenDAO.insert(lichChuyen5);
		
		LichTuyen lichChuyen6 = new LichTuyen();
		lichChuyen6.setTuyenXe(tuyenXeDAO.getById(3));
		lichChuyen6.setThu(NgayCuaTuan.MONDAY);
		lichChuyen6.setGioDi(new SimpleDateFormat("kk:mm").parse("10:30"));
		lichChuyen6.setXe(xeDAO.getById(4));
		lichChuyen6.setTongThoiGian(27);
		lichChuyen6.setActive(true);
		lichChuyenDAO.insert(lichChuyen6);
		
		LichTuyen lichChuyen7 = new LichTuyen();
		lichChuyen7.setTuyenXe(tuyenXeDAO.getById(4));
		lichChuyen7.setThu(NgayCuaTuan.MONDAY);
		lichChuyen7.setGioDi(new SimpleDateFormat("kk:mm").parse("09:45"));
		lichChuyen7.setXe(xeDAO.getById(4));
		lichChuyen7.setTongThoiGian(25);
		lichChuyen7.setActive(true);
		lichChuyenDAO.insert(lichChuyen7);
		
		LichTuyen lichChuyen8 = new LichTuyen();
		lichChuyen8.setTuyenXe(tuyenXeDAO.getById(1));
		lichChuyen8.setThu(NgayCuaTuan.MONDAY);
		lichChuyen8.setGioDi(new SimpleDateFormat("kk:mm").parse("10:30"));
		lichChuyen8.setXe(xeDAO.getById(5));
		lichChuyen8.setTongThoiGian(19);
		lichChuyen8.setActive(true);
		lichChuyenDAO.insert(lichChuyen8);
		
		LichTuyen lichChuyen9 = new LichTuyen();
		lichChuyen9.setTuyenXe(tuyenXeDAO.getById(2));
		lichChuyen9.setThu(NgayCuaTuan.MONDAY);
		lichChuyen9.setGioDi(new SimpleDateFormat("kk:mm").parse("10:00"));
		lichChuyen9.setXe(xeDAO.getById(5));
		lichChuyen9.setTongThoiGian(30);
		lichChuyen9.setActive(true);
		lichChuyenDAO.insert(lichChuyen9);
		
		LichTuyen lichChuyen10 = new LichTuyen();
		lichChuyen10.setTuyenXe(tuyenXeDAO.getById(3));
		lichChuyen10.setThu(NgayCuaTuan.MONDAY);
		lichChuyen10.setGioDi(new SimpleDateFormat("kk:mm").parse("16:30"));
		lichChuyen10.setXe(xeDAO.getById(5));
		lichChuyen10.setTongThoiGian(20);
		lichChuyen10.setActive(true);
		lichChuyenDAO.insert(lichChuyen10);
		
		LichTuyen lichChuyen11 = new LichTuyen();
		lichChuyen11.setTuyenXe(tuyenXeDAO.getById(4));
		lichChuyen11.setThu(NgayCuaTuan.SUNDAY);
		lichChuyen11.setGioDi(new SimpleDateFormat("kk:mm").parse("13:30"));
		lichChuyen11.setXe(xeDAO.getById(5));
		lichChuyen11.setTongThoiGian(26);
		lichChuyen11.setActive(true);
		lichChuyenDAO.insert(lichChuyen11);
		
		LichTuyen lichChuyen12 = new LichTuyen();
		lichChuyen12.setTuyenXe(tuyenXeDAO.getById(1));
		lichChuyen12.setThu(NgayCuaTuan.MONDAY);
		lichChuyen12.setGioDi(new SimpleDateFormat("kk:mm").parse("13:15"));
		lichChuyen12.setXe(xeDAO.getById(5));
		lichChuyen12.setTongThoiGian(35);
		lichChuyen12.setActive(true);
		lichChuyenDAO.insert(lichChuyen12);
		
		LichTuyen lichChuyen13 = new LichTuyen();
		lichChuyen13.setTuyenXe(tuyenXeDAO.getById(2));
		lichChuyen13.setThu(NgayCuaTuan.TUESDAY);
		lichChuyen13.setGioDi(new SimpleDateFormat("kk:mm").parse("15:45"));
		lichChuyen13.setXe(xeDAO.getById(5));
		lichChuyen13.setTongThoiGian(23);
		lichChuyen13.setActive(true);
		lichChuyenDAO.insert(lichChuyen13);
		
		LichTuyen lichChuyen14 = new LichTuyen();
		lichChuyen14.setTuyenXe(tuyenXeDAO.getById(3));
		lichChuyen14.setThu(NgayCuaTuan.WEDNESDAY);
		lichChuyen14.setGioDi(new SimpleDateFormat("kk:mm").parse("16:00"));
		lichChuyen14.setXe(xeDAO.getById(5));
		lichChuyen14.setTongThoiGian(24);
		lichChuyen14.setActive(true);
		lichChuyenDAO.insert(lichChuyen14);
		
		LichTuyen lichChuyen15 = new LichTuyen();
		lichChuyen15.setTuyenXe(tuyenXeDAO.getById(4));
		lichChuyen15.setThu(NgayCuaTuan.THURSDAY);
		lichChuyen15.setGioDi(new SimpleDateFormat("kk:mm").parse("19:00"));
		lichChuyen15.setXe(xeDAO.getById(5));
		lichChuyen15.setTongThoiGian(36);
		lichChuyen15.setActive(true);
		lichChuyenDAO.insert(lichChuyen15);
	}
	
	public static void main(String[] args) {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			mockData();
			generateMockData();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
}