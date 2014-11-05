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
public interface XeDAO {
	/**
	 * @author Tung
	 * @param session
	 * @param id
	 * @return
	 */
	public Xe getById(Session session, Integer id);

	/**
	 * @author Tung
	 * @param session
	 * @return
	 */
	public List<Xe> list(Session session);

	/**
	 * @author Tung
	 * @param session
	 * @param xe
	 * @return
	 */
	public Integer save(Session session, Xe xe);

	/**
	 * @author Tung
	 * @param session
	 * @param xe
	 */
	public void update(Session session, Xe xe);
}
