package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.DanhGia;
import com.vexeonline.utils.HibernateUtil;

public class DanhGiaDAOImpl implements DanhGiaDAO {

	public int save(DanhGia danhGia) {
		return (Integer) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(danhGia);
	}

	@SuppressWarnings("unchecked")
	public List<DanhGia> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from DanhGia").list();
	}

	public void delete(DanhGia danhGia) {
		HibernateUtil.getSessionFactory().getCurrentSession().delete(danhGia);
	}

	public DanhGia getById(int idDanhGia) {
		return (DanhGia) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(DanhGia.class, idDanhGia);
	}

}
