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
public interface LichTuyenDAO {
	/**
	 * @author Tung
	 * @param session
	 * @param id
	 * @return
	 */
	public LichTuyen getById(Session session, Integer id);

	/**
	 * @author Tung
	 * @param session
	 * @return
	 */
	public List<LichTuyen> list(Session session);

	/**
	 * @author Tung
	 * @param session
	 * @param lichTuyen
	 * @return
	 */
	public Integer save(Session session, LichTuyen lichTuyen);
	
	/**
	 * @author Tung
	 * @param session
	 * @param lichTuyen
	 */
	public void update(Session session, LichTuyen lichTuyen);
}
