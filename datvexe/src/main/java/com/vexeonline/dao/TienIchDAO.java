package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.TienIch;

/**
 * @author hungdq
 *
 */
public interface TienIchDAO {
	public TienIch getById(Integer id);
	public TienIch get(String name);
	public List<TienIch> list();
	public TienIch save(TienIch tienIch);
	public TienIch update(TienIch tienIch);
	
	/**
	 * return list ten tien ich of xe
	 * @param idXe
	 * @return
	 */
	public List<String> getByXe(int idXe);
}
