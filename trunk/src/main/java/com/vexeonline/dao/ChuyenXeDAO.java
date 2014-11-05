/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import org.hibernate.Session;

import com.vexeonline.domain.ChuyenXe;

/**
 * @author Tung
 *
 */
public interface ChuyenXeDAO {
	/**
	 * @author Tung
	 * @param session
	 * @param id
	 * @return
	 */
	public ChuyenXe getById(Session session, Integer id);

	/**
	 * @author Tung
	 * @param session
	 * @return
	 */
	public List<ChuyenXe> list(Session session);

	/**
	 * @author Tung
	 * @param session
	 * @param chuyenXe
	 * @return
	 */
	public Integer save(Session session, ChuyenXe chuyenXe);

	/**
	 * @author Tung
	 * @param session
	 * @param benXe
	 */
	public void update(Session session, ChuyenXe chuyenXe);
}
