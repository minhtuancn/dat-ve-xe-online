package com.vexeonline.service.admin;

import java.util.List;

import com.vexeonline.dto.NhaXeDTO;

public interface QuanLyNhaXeService {
	public List<NhaXeDTO> listNhaXe() throws Exception;
	public NhaXeDTO getById(Integer id) throws Exception;
	public void addNew(NhaXeDTO nhaXe) throws Exception;
	public void editInfo(NhaXeDTO nhaXe) throws Exception;
}
