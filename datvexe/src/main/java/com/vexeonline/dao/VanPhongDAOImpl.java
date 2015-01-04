package com.vexeonline.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.vexeonline.domain.VanPhong;
import com.vexeonline.utils.HibernateUtil;

public class VanPhongDAOImpl implements VanPhongDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<VanPhong> getOffices() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from VanPhong").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VanPhong> getOffices(Integer nhaXeId) {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createCriteria(VanPhong.class)
				.add(Restrictions.eq("nhaXe.idNhaXe", nhaXeId)).list();
	}

	@Override
	public VanPhong getOffice(Integer officeId) {
		return (VanPhong) HibernateUtil.getSessionFactory().getCurrentSession()
				.load(VanPhong.class, officeId);
	}

	@Override
	public VanPhong getOffice(Integer nhaXeId, Integer officeId) {
		return (VanPhong) HibernateUtil
				.getSessionFactory()
				.getCurrentSession()
				.createCriteria(VanPhong.class)
				.add(Restrictions.and(
						Restrictions.eq("nhaXe.idNhaXe", nhaXeId),
						Restrictions.eq("idVanPhong", officeId))).uniqueResult();
	}

	@Override
	public void insert(VanPhong vanPhong) {
		HibernateUtil.getSessionFactory().getCurrentSession().persist(vanPhong);
	}

	@Override
	public void update(VanPhong vanPhong) {
		HibernateUtil.getSessionFactory().getCurrentSession().update(vanPhong);
	}
}
