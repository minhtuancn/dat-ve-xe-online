/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import org.hibernate.Session;

import com.vexeonline.domain.LichTuyen;

/**
 * @author Tung
 *
 */
public class LichTuyenDAOImpl implements LichTuyenDAO {

	/**
	 * @author Tung
	 */
	@Override
	public LichTuyen getById(Session session, Integer id) {
		return (LichTuyen) session.get(LichTuyen.class, id);
	}

	/** 
	 * @author Tung
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LichTuyen> list(Session session) {
		return session.createQuery("from LichTuyen").list();
	}

	/**
	 * @author Tung
	 */
	@Override
	public Integer save(Session session, LichTuyen lichTuyen) {
		return (Integer) session.save(lichTuyen);
	}

	/**
	 * @author Tung
	 */
	@Override
	public void update(Session session, LichTuyen lichTuyen) {
		session.update(lichTuyen);
	}

}
