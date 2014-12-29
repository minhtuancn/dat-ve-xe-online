package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.TienIch;

/**
 * @author hungdq
 *
 */
public interface TienIchDAO {
	public TienIch getById(Integer id);
	public List<TienIch> list();
	public TienIch save(TienIch tienIch);
	public TienIch update(TienIch tienIch);
	
	/**
	 * return tienIchs of xe
	 * @param idXe
	 * @return
	 */
	public List<TienIch> getByXe(int idXe);
}
