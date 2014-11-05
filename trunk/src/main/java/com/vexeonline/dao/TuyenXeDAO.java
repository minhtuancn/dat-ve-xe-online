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
public interface TuyenXeDAO {
	/**
	 * @author Tung
	 * @param session
	 * @param id
	 * @return
	 */
	public TuyenXe getById(Session session, Integer id);

	/**
	 * @author Tung
	 * @param session
	 * @return
	 */
	public List<TuyenXe> list(Session session);

	/**
	 * @author Tung
	 * @param session
	 * @param tuyenXe
	 * @return
	 */
	public Integer save(Session session, TuyenXe tuyenXe);
	
	/**
	 * @author Tung
	 * @param session
	 * @param tuyenXe
	 */
	public void update(Session session, TuyenXe tuyenXe);
}
