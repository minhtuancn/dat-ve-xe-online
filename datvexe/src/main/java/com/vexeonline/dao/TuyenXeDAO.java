/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.TuyenXe;

/**
 * @author Tung
 *
 */
public interface TuyenXeDAO {
	
	public TuyenXe get(Integer benDiId,Integer benDenId);
	
	/**
	 * @author Tung
	 * @param session
	 * @param id
	 * @return
	 */
	public TuyenXe getById(Integer id);

	/**
	 * @author Tung
	 * @param session
	 * @return
	 */
	public List<TuyenXe> list();

	/**
	 * @author Tung
	 * @param session
	 * @param tuyenXe
	 * @return
	 */
	public Integer save(TuyenXe tuyenXe);

	/**
	 * @author Tung
	 * @param session
	 * @param tuyenXe
	 */
	public void update(TuyenXe tuyenXe);

}

