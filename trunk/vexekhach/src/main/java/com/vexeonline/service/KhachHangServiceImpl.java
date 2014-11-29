package com.vexeonline.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vexeonline.dao.TuyenXeDAO;
import com.vexeonline.dao.TuyenXeDAOImpl;
import com.vexeonline.dao.UserDAO;
import com.vexeonline.dao.UserDAOImpl;
import com.vexeonline.dao.VeXeDAO;
import com.vexeonline.dao.VeXeDAOImpl;
import com.vexeonline.domain.NgayCuaTuan;
import com.vexeonline.domain.TuyenXe;
import com.vexeonline.domain.User;
import com.vexeonline.domain.VeXe;
import com.vexeonline.utils.EncodeMD5;
import com.vexeonline.utils.HibernateUtil;

public class KhachHangServiceImpl implements KhachHangService {

	private final Logger logger = Logger.getLogger(getClass());
	private static TuyenXeDAO tuyenXeDAO = new TuyenXeDAOImpl(); 
	private static UserDAO userDAO = new UserDAOImpl();
	private static VeXeDAO veXeDAO = new VeXeDAOImpl();

	public List<TuyenXe> getListChuyenXe(String tinhDi, String tinhDen,
			Date ngayDi) {
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
	
}
