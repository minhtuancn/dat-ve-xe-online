package com.vexeonline.dao.nhaxe;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Transaction;

import com.vexeonline.dao.ScheduleDAO;
import com.vexeonline.dao.ScheduleDAOImpl;
import com.vexeonline.domain.LichTuyen;
import com.vexeonline.domain.NgayCuaTuan;
import com.vexeonline.utils.HibernateUtil;

public class ScheduleDAOTest {
	
	private static final ScheduleDAO dao = new ScheduleDAOImpl();
	
	public static void test000() throws Exception {
		for (int i=1; i<=10; i++) {
			System.out.println("===== Id " + i + " ======");
			try {
				LichTuyen schedule = dao.getById(i);
				System.out.println(schedule);
			} catch(ObjectNotFoundException e) {
				System.out.println("Not found: " + e.getMessage());
			}
		}
	}
	
	public static void test001() throws Exception {
		List<LichTuyen> schedules = dao.getAll();
		for (LichTuyen schedule : schedules) {
			System.out.println(schedule);
		}
	}
	
	public static void test002() throws Exception {
		for (NgayCuaTuan n : NgayCuaTuan.values()) {
			System.out.println("===== " + n + " ======");
			List<LichTuyen> schedules = dao.get(n);
			for (LichTuyen schedule : schedules) {
				System.out.println(schedule);
			}
		}
	}
	
	public static void test003() throws Exception {
		for (int i=1; i<=10; i++) {
			System.out.println("===== Nha xe " + i + " ======");
			List<LichTuyen> schedules = dao.getByNhaXe(i);
			for (LichTuyen schedule : schedules) {
				System.out.println(schedule);
			}
		}
	}
	
	public static void test004() throws Exception {
		for (int i=1; i<=10; i++) {
			System.out.println("===== Tuyen xe " + i + " ======");
			List<LichTuyen> schedules = dao.getByTuyenXe(i);
			for (LichTuyen schedule : schedules) {
				System.out.println(schedule);
			}
		}
	}

	public static void test005() throws Exception {
		for (int i=1; i<=10; i++) {
			System.out.println("===== Vehicle " + i + " ======");
			List<LichTuyen> schedules = dao.getByVehicle(i);
			for (LichTuyen schedule : schedules) {
				System.out.println(schedule);
			}
		}
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
