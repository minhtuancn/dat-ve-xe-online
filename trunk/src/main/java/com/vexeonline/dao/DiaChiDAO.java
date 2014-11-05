/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import org.hibernate.Session;

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
    public DiaChi getById(Session session, Integer id);
    
   /**
    * @author Tung
    * @param session
    * @return
    */
    public List<DiaChi> list(Session session);
    
    /**
	 * @author Tung
	 * @param session
	 * @param diaChi
	 * @return
	 */
	public Integer save(Session session, DiaChi diaChi);

	/**
	 * @author Tung
	 * @param session
	 * @param diaChi
	 */
	public void update(Session session, DiaChi diaChi);
}
