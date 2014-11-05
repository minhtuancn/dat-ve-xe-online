/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import org.hibernate.Session;

import com.vexeonline.domain.NhaXe;

/**
 * @author Tung
 *
 */
public interface NhaXeDAO {
	/**
	 * @author Tung
	 * @param session
	 * @param id
	 * @return
	 */
    public NhaXe getById(Session session, Integer id);
    
   /**
    * @author Tung
    * @param session
    * @return
    */
    public List<NhaXe> list(Session session);
    
    /**
     * @author Tung
     * @param session
     * @param nhaXe
     * @return
     */
    public Integer save(Session session, NhaXe nhaXe);
    
    /**
     * @author Tung
     * @param session
     * @param nhaXe
     */
    public void update(Session session, NhaXe nhaXe);
}
