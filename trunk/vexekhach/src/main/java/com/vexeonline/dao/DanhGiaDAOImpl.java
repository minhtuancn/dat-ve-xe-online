package com.vexeonline.dao;

import com.vexeonline.domain.DanhGia;
import com.vexeonline.utils.HibernateUtil;

public class DanhGiaDAOImpl implements DanhGiaDAO{

	public int save(DanhGia danhGia) {
		return (Integer) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(danhGia);
	}
    
}
