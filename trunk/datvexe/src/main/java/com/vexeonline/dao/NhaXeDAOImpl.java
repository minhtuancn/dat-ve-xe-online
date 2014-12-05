/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.NhaXe;
import com.vexeonline.utils.HibernateUtil;

/**
 * @author Tung
 *
 */
public class NhaXeDAOImpl implements NhaXeDAO {

	/**
	 * @author Tung
	 */

	public NhaXe getById(Integer id) {
		return (NhaXe) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(NhaXe.class, id);
	}

	/**
	 * @author Tung
	 */
	@SuppressWarnings("unchecked")
	public List<NhaXe> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from NhaXe").list();
	}

	/**
	 * @author Tung
	 */

	public Integer save(NhaXe nhaXe) {
		return (Integer) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(nhaXe);
	}

	/**
	 * @author Tung
	 */

	public void update(NhaXe nhaXe) {
		HibernateUtil.getSessionFactory().getCurrentSession().update(nhaXe);
	}

}
