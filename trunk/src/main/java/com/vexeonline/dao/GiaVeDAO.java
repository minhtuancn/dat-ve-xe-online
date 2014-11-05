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
public interface GiaVeDAO {
	/**
	 * @author Tung
	 * @param session
	 * @param id
	 * @return
	 */
	public GiaVe getById(Session session, Integer id);

	/**
	 * @author Tung
	 * @param session
	 * @return
	 */
	public List<GiaVe> list(Session session);

	/**
	 * @author Tung
	 * @param session
	 * @param giaVe
	 * @return
	 */
	public Integer save(Session session, GiaVe giaVe);
	
	/**
	 * @author Tung
	 * @param session
	 * @param giaVe
	 */
	public void update(Session session, GiaVe giaVe);
}
