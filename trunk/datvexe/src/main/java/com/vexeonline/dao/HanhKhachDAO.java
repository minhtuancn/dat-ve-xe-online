package com.vexeonline.dao;

import com.vexeonline.domain.HanhKhach;

public interface HanhKhachDAO {
	
	public int insert(HanhKhach hanhKhach);

	public HanhKhach getById(Integer id);
	
	public HanhKhach getByEmail(String email);

	public HanhKhach getBySDT(String sdt);
}
