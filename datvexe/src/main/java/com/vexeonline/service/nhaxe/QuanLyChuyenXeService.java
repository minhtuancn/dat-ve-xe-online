package com.vexeonline.service.nhaxe;

import java.util.List;

import com.vexeonline.domain.ChuyenXe;

public interface QuanLyChuyenXeService {
	public List<ChuyenXe> listChuyenXe();

	public void addNew(ChuyenXe ChuyenXe) throws Exception;

	public void update(ChuyenXe ChuyenXe) throws Exception;
}
