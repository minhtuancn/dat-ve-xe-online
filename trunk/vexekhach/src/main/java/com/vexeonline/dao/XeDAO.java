/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

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
	public Xe getById(Integer id);

	/**
	 * @author Tung
	 * @param session
	 * @return
	 */
	public List<Xe> list();

	/**
	 * @author Tung
	 * @param session
	 * @param xe
	 * @return
	 */
	public Integer save(Xe xe);

	/**
	 * @author Tung
	 * @param session
	 * @param xe
	 */
	public void update(Xe xe);
}
