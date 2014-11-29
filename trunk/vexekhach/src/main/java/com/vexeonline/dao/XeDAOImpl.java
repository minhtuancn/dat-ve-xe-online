/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.Xe;
import com.vexeonline.utils.HibernateUtil;

/**
 * @author Tung
 *
 */
public class XeDAOImpl implements XeDAO {

	/**
	 * @author Tung
	 */

	public Xe getById(Integer id) {
		return (Xe) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(Xe.class, id);
	}

	/**
	 * @author Tung
	 */
	@SuppressWarnings("unchecked")
	public List<Xe> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from Xe").list();
	}

	/**
	 * @author Tung
	 */

	public Integer save(Xe xe) {
		return (Integer) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(xe);
	}

	/**
	 * @author Tung
	 */

	public void update(Xe xe) {
		HibernateUtil.getSessionFactory().getCurrentSession().update(xe);
	}

}
