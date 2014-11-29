/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.GiaVe;
import com.vexeonline.utils.HibernateUtil;

/**
 * @author Tung
 *
 */
public class GiaVeDAOImpl implements GiaVeDAO {

	/**
	 * @author Tung
	 */

	public GiaVe getById(Integer id) {
		return (GiaVe) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(GiaVe.class, id);
	}

	/**
	 * @author Tung
	 */
	@SuppressWarnings("unchecked")
	public List<GiaVe> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from GiaVe").list();
	}

	/**
	 * @author Tung
	 */

	public Integer save(GiaVe giaVe) {
		return (Integer) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(giaVe);
	}

	/**
	 * @author Tung
	 */

	public void update(GiaVe giaVe) {
		HibernateUtil.getSessionFactory().getCurrentSession().update(giaVe);
	}

}
