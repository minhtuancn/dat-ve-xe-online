package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.TienIch;
import com.vexeonline.utils.HibernateUtil;

/**
 * @author hungdq
 *
 */
public class TienIchDAOImpl implements TienIchDAO {

	@Override
	public TienIch getById(Integer id) {
		return (TienIch) HibernateUtil.getSessionFactory().getCurrentSession()
				.load(TienIch.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TienIch> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from TienIch").list();
	}

	@Override
	public TienIch save(TienIch tienIch) {
		HibernateUtil.getSessionFactory().getCurrentSession().save(tienIch);
		return tienIch;
	}

	@Override
	public TienIch update(TienIch tienIch) {
		HibernateUtil.getSessionFactory().getCurrentSession().update(tienIch);
		return tienIch;
	}
}
