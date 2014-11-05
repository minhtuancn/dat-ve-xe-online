/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

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
    public BenXe getById(Session session, Integer id);
    
   /**
    * @author Tung
    * @param session
    * @return
    */
    public List<BenXe> list(Session session);
    
    /**
     * @author Tung
     * @param session
     * @param benXe
     * @return
     */
    public Integer save(Session session, BenXe benXe);
    
    /**
     * @author Tung
     * @param session
     * @param benXe
     */
    public void update(Session session, BenXe benXe) throws HibernateException;
}
