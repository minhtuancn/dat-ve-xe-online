/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.vexeonline.domain.ChuyenXe;

/**
 * @author Tung
 *
 */
public interface ChuyenXeDAO {
	
	public ChuyenXe get(Integer nhaXeId,Integer chuyenXeId);
	
	public List<ChuyenXe> get(Integer nhaXeId);
	
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
	public Integer insert(ChuyenXe chuyenXe);

	/**
	 * @author Tung
	 * @param session
	 * @param benXe
	 */
	public void update(ChuyenXe chuyenXe);
	
	/**
	 * return chuyenXe if exist otherwise null
	 * @param idLichTuyen
	 * @param ngayDi
	 * @param gioDi
	 * @return
	 */
	public ChuyenXe getChuyenXeIdLichTuyenAndNgayDiGioDi(int idLichTuyen, Date ngayDi, Time gioDi);
}
