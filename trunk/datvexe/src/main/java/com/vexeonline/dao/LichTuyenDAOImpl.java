/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.LichTuyen;
import com.vexeonline.utils.HibernateUtil;

/**
 * @author Tung
 *
 */
public class LichTuyenDAOImpl implements LichTuyenDAO {

	/**
	 * @author Tung
	 */

	public LichTuyen getById(Integer id) {
		return (LichTuyen) HibernateUtil.getSessionFactory()
				.getCurrentSession().get(LichTuyen.class, id);
	}

	/**
	 * @author Tung
	 */
	@SuppressWarnings("unchecked")
	public List<LichTuyen> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from LichTuyen").list();
	}

	/**
	 * @author Tung
	 */

	public Integer save(LichTuyen lichTuyen) {
		return (Integer) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(lichTuyen);
	}

	/**
	 * @author Tung
	 */

	public void update(LichTuyen lichTuyen) {
		HibernateUtil.getSessionFactory().getCurrentSession().update(lichTuyen);
	}

}
