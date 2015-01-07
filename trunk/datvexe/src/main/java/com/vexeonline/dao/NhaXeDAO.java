/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

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
    public NhaXe getById(Integer id);
    
   /**
    * @author Tung
    * @param session
    * @return
    */
    public List<NhaXe> list();
    
    /**
     * @author Tung
     * @param session
     * @param nhaXe
     * @return
     */
    public Integer save(NhaXe nhaXe);
    
    /**
     * @author Tung
     * @param session
     * @param nhaXe
     */
    public void update(NhaXe nhaXe);
    
    public List<Object[]> listTenNhaXe() ;
}
