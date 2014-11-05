/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import org.hibernate.Session;

import com.vexeonline.domain.Xe;

/**
 * @author Tung
 *
 */
public class XeDAOImpl implements XeDAO {

	/**
	 * @author Tung
	 */
	@Override
	public Xe getById(Session session, Integer id) {
		return (Xe) session.get(Xe.class, id);
	}

	/**
	 * @author Tung
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Xe> list(Session session) {
		return session.createQuery("from Xe").list();
	}

	/**
	 * @author Tung
	 */
	@Override
	public Integer save(Session session, Xe xe) {
		return (Integer) session.save(xe);
	}

	/**
	 * @author Tung
	 */
	@Override
	public void update(Session session, Xe xe) {
		session.update(xe);
	}

}
