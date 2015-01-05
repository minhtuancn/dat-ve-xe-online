package com.vexeonline.dao;

import com.vexeonline.domain.HanhKhach;
import com.vexeonline.utils.HibernateUtil;

public class HanhKhachDAOImpl implements HanhKhachDAO {

	@Override
	public int insert(HanhKhach hanhKhach) {
		return (int) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(hanhKhach);
	}

	public HanhKhach getByEmail(String email) {
		return (HanhKhach) HibernateUtil
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"from HanhKhach as h " + " where h.email = :email ")
				.setString("email", email).uniqueResult();
	}

	@Override
	public HanhKhach getBySDT(String sdt) {
		return (HanhKhach) HibernateUtil.getSessionFactory()
				.getCurrentSession()
				.createQuery("from HanhKhach as h " + " where h.sdt = :sdt ")
				.setString("sdt", sdt).uniqueResult();
	}

	@Override
	public HanhKhach getById(Integer id) {
		return (HanhKhach) HibernateUtil.getSessionFactory()
				.getCurrentSession().load(HanhKhach.class, id);
	}
}
