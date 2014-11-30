package com.vexeonline.service.admin;

import java.util.List;

import com.vexeonline.domain.NhaXe;

public interface QuanLyNhaXeService {
	public List<NhaXe> listNhaXe();

	public void addNew(NhaXe nhaXe) throws Exception;

	public void editInfo(NhaXe nhaXe) throws Exception;
}
