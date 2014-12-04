package com.vexeonline.service.khachhangservice;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vexeonline.domain.BenXe;
import com.vexeonline.domain.ChuyenXe;
import com.vexeonline.domain.DanhGia;
import com.vexeonline.domain.DiaChi;
import com.vexeonline.domain.GiaVe;
import com.vexeonline.domain.HanhKhach;
import com.vexeonline.domain.LichTuyen;
import com.vexeonline.domain.NgayCuaTuan;
import com.vexeonline.domain.NhaXe;
import com.vexeonline.domain.TrangThaiChuyenXe;
import com.vexeonline.domain.TuyenXe;
import com.vexeonline.domain.VeXe;
import com.vexeonline.domain.Xe;
import com.vexeonline.domain.json.ThongTinDanhGia;
import com.vexeonline.service.KhachHangService;
import com.vexeonline.service.KhachHangServiceImpl;
import com.vexeonline.utils.HibernateUtil;

public class TestGetListInfoDanhGiaByIdNhaXe {
	private static SessionFactory sessionFactory;
	private KhachHangService khachHangService = new KhachHangServiceImpl();

	@BeforeClass
	public static void beforeTest() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@AfterClass
	public static void afterTest() {
		sessionFactory.close();
	}

	@Test
	public void test1() {
		addData();	
		List<ThongTinDanhGia> list = khachHangService.getListInfoDanhGiaByNhaXe(1);
		
		Assert.assertTrue(list.get(0).getNgayDi().toString().equals("2014-11-24") );
	
	}

	private void addData() {
		Session session = sessionFactory.openSession();
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
		hanhKhach.setSdt("012212132");
		hanhKhach.setTenHanhKhach("nguyen tung");
		session.save(hanhKhach);
		
		VeXe veXe = new VeXe();
		veXe.setChoNgoi(3);
		veXe.setChuyenXe(chuyenXe);
		veXe.setHanhKhach(hanhKhach);
		session.save(veXe);
		
		DanhGia danhGia = new DanhGia();
		danhGia.setChuyenXe(chuyenXe);
		danhGia.setDiem(4.9f);
		danhGia.setNoiDung("tung nguyen");
		danhGia.setHanhKhach(hanhKhach);
		session.save(danhGia);
		
		session.flush();
		session.close();

	}

}
