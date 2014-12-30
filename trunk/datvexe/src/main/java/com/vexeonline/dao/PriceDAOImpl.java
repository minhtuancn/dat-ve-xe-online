package com.vexeonline.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.vexeonline.domain.GiaVe;
import com.vexeonline.utils.HibernateUtil;

public class PriceDAOImpl implements PriceDAO {

	@Override
	public GiaVe getById(Integer priceId) throws Exception {
		return (GiaVe) HibernateUtil.getSessionFactory().getCurrentSession()
				.load(GiaVe.class, priceId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GiaVe> getAll() throws Exception {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from GiaVe").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GiaVe> getBySchedule(Integer scheduleId) throws Exception {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createCriteria(GiaVe.class).createCriteria("lichTuyen")
				.add(Restrictions.eq("idLichTuyen", scheduleId)).list();
	}

	@Override
	public void insert(GiaVe giaVe) throws Exception {
		HibernateUtil.getSessionFactory().getCurrentSession().persist(giaVe);
	}

	@Override
	public void update(GiaVe giaVe) throws Exception {
		HibernateUtil.getSessionFactory().getCurrentSession().update(giaVe);
	}
}
