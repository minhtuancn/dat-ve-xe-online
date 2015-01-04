package com.vexeonline.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.vexeonline.domain.SDTVanPhong;
import com.vexeonline.utils.HibernateUtil;

public class PhoneNumberDAOImpl implements PhoneNumberDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<SDTVanPhong> getPhoneNumbers() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from SDTVanPhong").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SDTVanPhong> getPhoneNumbers(Integer nhaXeId) {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createCriteria(SDTVanPhong.class).createCriteria("vanPhong")
				.createCriteria("nhaXe")
				.add(Restrictions.eq("idNhaXe", nhaXeId)).list();
	}

	@Override
	public SDTVanPhong getPhoneNumber(Integer phoneNumberId) {
		return (SDTVanPhong) HibernateUtil.getSessionFactory()
				.getCurrentSession().load(SDTVanPhong.class, phoneNumberId);
	}

	@Override
	public SDTVanPhong getPhoneNumbers(Integer nhaXeId, Integer phoneNumberId) {
		return (SDTVanPhong) HibernateUtil
				.getSessionFactory()
				.getCurrentSession()
				.createCriteria(SDTVanPhong.class)
				.add(Restrictions.and(Restrictions.eq("idSDTVanPhong", phoneNumberId),
						Restrictions.eq("vanPhong.nhaXe.idNhaXe", nhaXeId))).uniqueResult();
	}
}
