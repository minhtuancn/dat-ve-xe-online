/**
 * @author Tung
 * 
 */
package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.ChuyenXe;
import com.vexeonline.utils.HibernateUtil;

public class ChuyenXeDAOImpl implements ChuyenXeDAO {
	public ChuyenXe getById(Integer id) {
		return (ChuyenXe) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(ChuyenXe.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<ChuyenXe> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from ChuyenXe").list();
	}

	public Integer save(ChuyenXe chuyenXe) {
		return (Integer) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(chuyenXe);
	}

	public void update(ChuyenXe chuyenXe) {
		HibernateUtil.getSessionFactory().getCurrentSession().update(chuyenXe);
	}

}
