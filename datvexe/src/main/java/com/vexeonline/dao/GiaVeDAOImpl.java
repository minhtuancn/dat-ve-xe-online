/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.Date;
import java.util.List;

import com.vexeonline.domain.GiaVe;
import com.vexeonline.utils.HibernateUtil;

/**
 * @author Tung
 *
 */
public class GiaVeDAOImpl implements GiaVeDAO {

	public GiaVe getById(Integer id) {
		return (GiaVe) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(GiaVe.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<GiaVe> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from GiaVe").list();
	}

	public Integer save(GiaVe giaVe) {
		return (Integer) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(giaVe);
	}

	public void update(GiaVe giaVe) {
		HibernateUtil.getSessionFactory().getCurrentSession().update(giaVe);
	}

	@Override
	public int getGiaVe(int idLichTuyen, Date ngayDi) {
		// TODO Auto-generated method stub
		return 0;
	}

}
