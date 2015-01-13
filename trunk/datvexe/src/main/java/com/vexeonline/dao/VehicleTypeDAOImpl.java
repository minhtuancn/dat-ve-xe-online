package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.VehicleType;
import com.vexeonline.utils.HibernateUtil;

/**
 * @author Đặng Quang Hưng (hungdq58@gmail.com)
 *
 */
public class VehicleTypeDAOImpl implements VehicleTypeDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<VehicleType> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from VehicleType").list();
	}

	@Override
	public void insert(VehicleType vehicleType) {
		HibernateUtil.getSessionFactory().getCurrentSession()
				.persist(vehicleType);
	}

	@Override
	public VehicleType get(Integer id) {
		return (VehicleType) HibernateUtil.getSessionFactory()
				.getCurrentSession().load(VehicleType.class, id);
	}
}
