package com.vexeonline.dao.nhaxe;

import org.hibernate.Transaction;

import com.vexeonline.dao.TuyenXeDAO;
import com.vexeonline.dao.TuyenXeDAOImpl;
import com.vexeonline.utils.HibernateUtil;

public class TuyenXeDAOTest {
	
	private static final TuyenXeDAO dao = new TuyenXeDAOImpl();
	
	public static void test000() {
		System.out.println(dao.get(1, 3));
	}
	
	public static void main(String[] args) {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			test000();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
}
