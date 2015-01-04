package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.VanPhong;

public interface VanPhongDAO {

	public List<VanPhong> getOffices();
	
	public List<VanPhong> getOffices(Integer nhaXeId);
	
	public VanPhong getOffice(Integer officeId);
	
	public VanPhong getOffice(Integer nhaXeId,Integer officeId);
	
	public void insert(VanPhong vanPhong);

	public void update(VanPhong vanPhong);
}
