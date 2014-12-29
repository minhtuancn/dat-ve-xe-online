/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.TuyenXe;
import com.vexeonline.utils.HibernateUtil;

/**
 * @author Tung
 *
 */
public class TuyenXeDAOImpl implements TuyenXeDAO {

	/**
	 * @author Tung
	 */

	public TuyenXe getById(Integer id) {
		return (TuyenXe) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(TuyenXe.class, id);
	}

	/**
	 * @author Tung
	 */
	@SuppressWarnings("unchecked")
	public List<TuyenXe> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from TuyenXe").list();
	}

	/**
	 * @author Tung
	 */

	public Integer save(TuyenXe tuyenXe) {
		return (Integer) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(tuyenXe);
	}

	/**
	 * @author Tung
	 */

	public void update(TuyenXe tuyenXe) {
		HibernateUtil.getSessionFactory().getCurrentSession().update(tuyenXe);
	}

}
