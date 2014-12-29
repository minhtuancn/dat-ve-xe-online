package com.vexeonline.service.khachhangservice;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vexeonline.domain.BenXe;
import com.vexeonline.domain.DiaChi;
import com.vexeonline.domain.GiaVe;
import com.vexeonline.domain.LichTuyen;
import com.vexeonline.domain.NgayCuaTuan;
import com.vexeonline.domain.NhaXe;
import com.vexeonline.domain.TuyenXe;
import com.vexeonline.domain.Xe;
import com.vexeonline.service.KhachHangService;
import com.vexeonline.service.KhachHangServiceImpl;
import com.vexeonline.utils.HibernateUtil;

public class TestGetListChuyenXe {
	private static SessionFactory sessionFactory;
	private KhachHangService khachHang = new KhachHangServiceImpl();

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
		/*List<TuyenXe> list = khachHang.getListChuyenXe("Gia Lai", "HCM", Date.valueOf("2014-11-24"), 1);
		org.junit.Assert.assertTrue(list.size() == 1);*/
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
		lichTuyen.setGioDi(Time.valueOf("17:30:00"));
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

		session.flush();
		session.close();

	}
}
