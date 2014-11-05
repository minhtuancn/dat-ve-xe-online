/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import org.hibernate.Session;

import com.vexeonline.domain.NhaXe;

/**
 * @author Tung
 *
 */
public class NhaXeDAOImpl implements NhaXeDAO {

	/**
	 * @author Tung
	 */
	@Override
	public NhaXe getById(Session session, Integer id) {
		return (NhaXe) session.get(NhaXe.class, id);
	}

	/**
	 * @author Tung
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NhaXe> list(Session session) {
		return session.createQuery("from NhaXe").list();
	}

	/**
	 * @author Tung
	 */
	@Override
	public Integer save(Session session, NhaXe nhaXe) {
		return (Integer) session.save(nhaXe);
	}

	/**
	 * @author Tung
	 */
	@Override
	public void update(Session session, NhaXe nhaXe) {
		session.update(nhaXe);
	}

}
