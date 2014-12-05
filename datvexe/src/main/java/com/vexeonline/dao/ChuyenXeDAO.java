/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

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
	public ChuyenXe getById(Integer id);

	/**
	 * @author Tung
	 * @param session
	 * @return
	 */
	public List<ChuyenXe> list( );

	/**
	 * @author Tung
	 * @param session
	 * @param chuyenXe
	 * @return
	 */
	public Integer save(ChuyenXe chuyenXe);

	/**
	 * @author Tung
	 * @param session
	 * @param benXe
	 */
	public void update(ChuyenXe chuyenXe);
}
