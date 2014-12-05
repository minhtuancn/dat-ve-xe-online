package com.vexeonline.service.admin;

import java.util.List;

import com.vexeonline.domain.TuyenXe;

public interface QuanLyTuyenXeService {
	public List<TuyenXe> listTuyenXe();

	public void addNew(TuyenXe tuyenXe) throws Exception;

	public void update(TuyenXe tuyenXe) throws Exception;
}
