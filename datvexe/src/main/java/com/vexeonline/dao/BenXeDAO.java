/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.BenXe;

/**
 * @author Tung
 *
 */
public interface BenXeDAO {
	/**
	 * @author Tung
	 * @param session
	 * @param id
	 * @return
	 */
	public BenXe getById(Integer id);

	/**
	 * @author Tung
	 * @param session
	 * @return
	 */
	public List<BenXe> list();

	/**
	 * @author Tung
	 * @param session
	 * @param benXe
	 * @return
	 */
	public Integer save(BenXe benXe);

	/**
	 * @author Tung
	 * @param session
	 * @param benXe
	 */
	public void update(BenXe benXe);
}
