/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import org.hibernate.Session;

import com.vexeonline.domain.GiaVe;

/**
 * @author Tung
 *
 */
public class GiaVeDAOImpl implements GiaVeDAO {

	/**
	 * @author Tung
	 */
	@Override
	public GiaVe getById(Session session, Integer id) {
		return (GiaVe) session.get(GiaVe.class, id);
	}

	/**
	 * @author Tung
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<GiaVe> list(Session session) {
		return session.createQuery("from GiaVe").list();
	}

	/**
	 * @author Tung
	 */
	@Override
	public Integer save(Session session, GiaVe giaVe) {
		return (Integer) session.save(giaVe);
	}

	/**
	 * @author Tung
	 */
	@Override
	public void update(Session session, GiaVe giaVe) {
		session.update(giaVe);
	}

}
