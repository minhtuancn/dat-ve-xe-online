package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.VanPhong;
import com.vexeonline.utils.HibernateUtil;

public class VanPhongDAOImpl implements VanPhongDAO {
	public int save(VanPhong vanPhong) {
		return (int) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(vanPhong);
	}

	public void update(VanPhong vanPhong) {
		HibernateUtil.getSessionFactory().getCurrentSession().update(vanPhong);
	}

	@SuppressWarnings("unchecked")
	public List<VanPhong> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from VanPhong").list();
	}
}
