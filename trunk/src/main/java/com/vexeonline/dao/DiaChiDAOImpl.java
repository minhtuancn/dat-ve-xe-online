/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import org.hibernate.Session;

import com.vexeonline.domain.DiaChi;

/**
 * @author Tung
 *
 */
public class DiaChiDAOImpl implements DiaChiDAO {

	/**
	 * @author Tung
	 */
	@Override
	public DiaChi getById(Session session, Integer id) {
		return (DiaChi) session.get(DiaChi.class, id);
	}

	/**
	 * @author Tung
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DiaChi> list(Session session) {
		return session.createQuery("from DiaChi").list();
	}

	/**
	 * @author Tung
	 */
	@Override
	public Integer save(Session session, DiaChi diaChi) {
		return (Integer) session.save(diaChi);
	}

	/**
	 * @author Tung
	 */
	@Override
	public void update(Session session, DiaChi diaChi) {
		session.update(diaChi);
	}

}
