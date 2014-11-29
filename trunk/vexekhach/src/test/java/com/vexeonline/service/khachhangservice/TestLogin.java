package com.vexeonline.service.khachhangservice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vexeonline.domain.RoleOfUser;
import com.vexeonline.domain.User;
import com.vexeonline.service.KhachHangService;
import com.vexeonline.service.KhachHangServiceImpl;
import com.vexeonline.utils.HibernateUtil;

public class TestLogin {
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
		org.junit.Assert.assertTrue(khachHang.login("tung", "123456"));
	}

	private void addData() {
		Session session = sessionFactory.openSession();

		User user = new User();
		user.setUserName("tung");
		user.setPassword("123456");
		user.setRole(RoleOfUser.ADMIN);
		session.save(user);
		
		session.close();
	}
}
