/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.NgayCuaTuan;
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

	 /**
	  * get list TuyenXe where tinhDi , TinhDen, ngayDi
	  * @param tinhDi
	  * @param tinhDen
	  * @param ngayDi
	  * @param thu
	  * @return
	  */
	public List<TuyenXe> getListTuyenXe(String tinhDi, String tinhDen,
			String ngayDi, NgayCuaTuan thu);
}

