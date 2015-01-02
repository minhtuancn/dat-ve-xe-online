/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.Xe;

/**
 * @author Tung
 *
 */
public interface XeDAO {
	
	public Xe getById(Integer xeId);
	
	public Xe getById(Integer nhaXeId,Integer id);
	
	public List<Xe> list();
	
	public List<Xe> listActive();
	
	public List<Xe> list(Integer nhaXeId);
	
	public List<Xe> listActive(Integer nhaXeId);

	public Integer save(Xe xe);

	public void update(Xe xe);
	
	public List<String> getListChoByidXe(int idXe);
}
