package com.vexeonline.dao;

import com.vexeonline.domain.VeXe;

public interface VeXeDAO {
	/**
	 * get all information of VeXe
	 * @param maVeXe
	 * @return
	 */
    public VeXe getInfoVeXe(int maVeXe);
    
    public int save(VeXe veXe);
    
    public void delete(VeXe veXe);
}
