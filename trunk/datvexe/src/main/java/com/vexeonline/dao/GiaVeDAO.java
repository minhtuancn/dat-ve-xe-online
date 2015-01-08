/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.Date;
import java.util.List;

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
	public GiaVe getById(Integer id);

	/**
	 * @author Tung
	 * @param session
	 * @return
	 */
	public List<GiaVe> list();

	/**
	 * @author Tung
	 * @param session
	 * @param giaVe
	 * @return
	 */
	public Integer save(GiaVe giaVe);
	
	/**
	 * @author Tung
	 * @param session
	 * @param giaVe
	 */
	public void update(GiaVe giaVe);
	
	/**
	 * @param idLichTuyen
	 * @param ngayDi
	 * @return
	 */
	public Integer getGiaVe(int idLichTuyen, Date ngayDi);
}
