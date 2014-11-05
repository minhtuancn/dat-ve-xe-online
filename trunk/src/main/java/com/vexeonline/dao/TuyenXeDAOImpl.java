/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import org.hibernate.Session;

import com.vexeonline.domain.TuyenXe;

/**
 * @author Tung
 *
 */
public class TuyenXeDAOImpl implements TuyenXeDAO {

	/**
	 * @author Tung
	 */
	@Override
	public TuyenXe getById(Session session, Integer id) {
		return (TuyenXe) session.get(TuyenXe.class, id);
	}

	/**
	 * @author Tung
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TuyenXe> list(Session session) {
		return session.createQuery("from TuyenXe").list();
	}

	/**
	 * @author Tung
	 */
	@Override
	public Integer save(Session session, TuyenXe tuyenXe) {
		return (Integer) session.save(tuyenXe);
	}

	/**
	 * @author Tung
	 */
	@Override
	public void update(Session session, TuyenXe tuyenXe) {
		session.update(tuyenXe);
	}

}
