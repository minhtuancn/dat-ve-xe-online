/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.DiaChi;

/**
 * @author Tung
 *
 */
public interface DiaChiDAO {
	/**
	 * @author Tung
	 * @param session
	 * @param id
	 * @return
	 */
    public DiaChi getById(Integer id);
    
   /**
    * @author Tung
    * @param session
    * @return
    */
    public List<DiaChi> list();
    
    /**
	 * @author Tung
	 * @param session
	 * @param diaChi
	 * @return
	 */
	public Integer save(DiaChi diaChi);

	/**
	 * @author Tung
	 * @param session
	 * @param diaChi
	 */
	public void update(DiaChi diaChi);
}
