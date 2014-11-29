/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

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
	public LichTuyen getById(Integer id);

	/**
	 * @author Tung
	 * @param session
	 * @return
	 */
	public List<LichTuyen> list();

	/**
	 * @author Tung
	 * @param session
	 * @param lichTuyen
	 * @return
	 */
	public Integer save(LichTuyen lichTuyen);
	
	/**
	 * @author Tung
	 * @param session
	 * @param lichTuyen
	 */
	public void update(LichTuyen lichTuyen);
}
