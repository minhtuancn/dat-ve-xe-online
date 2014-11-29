/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.DiaChi;
import com.vexeonline.utils.HibernateUtil;

/**
 * @author Tung
 *
 */
public class DiaChiDAOImpl implements DiaChiDAO {

	/**
	 * @author Tung
	 */

	public DiaChi getById(Integer id) {
		return (DiaChi) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(DiaChi.class, id);
	}

	/**
	 * @author Tung
	 */
	@SuppressWarnings("unchecked")
	public List<DiaChi> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from DiaChi").list();
	}

	/**
	 * @author Tung
	 */

	public Integer save(DiaChi diaChi) {
		return (Integer) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(diaChi);
	}

	/**
	 * @author Tung
	 */

	public void update(DiaChi diaChi) {
		HibernateUtil.getSessionFactory().getCurrentSession().update(diaChi);
	}

}
