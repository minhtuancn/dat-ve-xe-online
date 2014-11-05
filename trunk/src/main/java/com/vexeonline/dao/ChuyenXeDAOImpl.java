/**
 * @author Tung
 * 
 */
package com.vexeonline.dao;

import java.util.List;

import org.hibernate.Session;

import com.vexeonline.domain.ChuyenXe;

/**
 * @author Tung
 *
 */
public class ChuyenXeDAOImpl implements ChuyenXeDAO {

	/**
	 * @author Tung
	 */
	@Override
	public ChuyenXe getById(Session session, Integer id) {
		return (ChuyenXe) session.get(ChuyenXe.class, id);
	}

	/**
	 * @author Tung
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ChuyenXe> list(Session session) {
		return session.createQuery("from ChuyenXe").list();
	}

	/**
	 * @author Tung
	 */
	@Override
	public Integer save(Session session, ChuyenXe chuyenXe) {
		return (Integer) session.save(chuyenXe);
	}

	/**
	 * @author Tung
	 */
	@Override
	public void update(Session session, ChuyenXe chuyenXe) {
		session.update(chuyenXe);
	}

}
