package com.vexeonline.service.nhaxe;

import java.util.List;

import com.vexeonline.domain.VanPhong;

public interface QuanLyVanPhongService {
	public List<VanPhong> listVanPhong();

	public void addNew(VanPhong vanPhong) throws Exception;

	public void update(VanPhong vanPhong) throws Exception;
}
