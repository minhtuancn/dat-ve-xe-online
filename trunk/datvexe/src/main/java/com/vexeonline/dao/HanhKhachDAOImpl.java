package com.vexeonline.dao;

import com.vexeonline.domain.HanhKhach;
import com.vexeonline.utils.HibernateUtil;

public class HanhKhachDAOImpl implements HanhKhachDAO {

	@Override
	public int save(HanhKhach hanhKhach) {
		return (int) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(hanhKhach);
	}

	public HanhKhach getBySDT(String sdt) {
		return (HanhKhach) HibernateUtil.getSessionFactory()
				.getCurrentSession()
				.createQuery("from HanhKhach as h "
						+ "left join fetch h.veXes as v "
						+ " where h.sdt = :sdt ")
				.setString("sdt", sdt)
				.uniqueResult();
	}

}
