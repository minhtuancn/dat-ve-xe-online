package com.vexeonline.dao;

import com.vexeonline.domain.HanhKhach;
import com.vexeonline.utils.HibernateUtil;

public class HanhKhachDAOImpl implements HanhKhachDAO{

	@Override
	public int save(HanhKhach hanhKhach) {
		return (int) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(hanhKhach);
	}
    
}
