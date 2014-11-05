/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import org.hibernate.Session;

import com.vexeonline.domain.BenXe;

/**
 * @author Tung
 *
 */
public class BenXeDAOImpl implements BenXeDAO{

	/**
	 * @author Tung
	 */
	@Override
	public BenXe getById(Session session, Integer id) {
		return (BenXe) session.get(BenXe.class, id);
	}

	/**
	 * @author Tung
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BenXe> list(Session session) {
		return session.createQuery("from BenXe").list();
	}

	@Override
	public Integer save(Session session, BenXe benXe) {
		return (Integer) session.save(benXe);
	}

	@Override
	public void update(Session session, BenXe benXe) {
		session.update(benXe);
	}
}
