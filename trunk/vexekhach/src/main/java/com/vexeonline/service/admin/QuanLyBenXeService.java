package com.vexeonline.service.admin;

import java.util.List;

import com.vexeonline.domain.BenXe;

public interface QuanLyBenXeService {
	public List<BenXe> listBenXe();

	public void addNew(BenXe benXe) throws Exception;

	public void update(BenXe benXe) throws Exception;
}
