package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.VanPhong;

public interface VanPhongDAO {
	 public int save(VanPhong vanPhong);
	    public void update(VanPhong vanPhong);
	    public List<VanPhong> list();
}
