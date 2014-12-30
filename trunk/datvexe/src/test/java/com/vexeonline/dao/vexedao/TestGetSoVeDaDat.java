package com.vexeonline.dao.vexedao;

import static org.junit.Assert.assertTrue;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vexeonline.dao.VeXeDAO;
import com.vexeonline.dao.VeXeDAOImpl;
import com.vexeonline.utils.HibernateUtil;
import com.vexeonline.utils.MockDatabase;

public class TestGetSoVeDaDat {
	private static SessionFactory sessionFactory;
	private VeXeDAO veXeDao = new VeXeDAOImpl();

	@BeforeClass
	public static void beforeTest() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@AfterClass
	public static void afterTest() {
		sessionFactory.close();
	}

	@Test
	public void test1() throws ParseException {
		MockDatabase.mockData();

		sessionFactory.getCurrentSession().beginTransaction();
		
		long veXe = veXeDao.laySoVeXeTheoLichTuyenVaNgayDi(1, new SimpleDateFormat("dd/mm/yyy").parse("12/12/2014"), Time.valueOf("00:00:00"));

		assertTrue(veXe == 0);

		sessionFactory.getCurrentSession().getTransaction().commit();
	}
}
