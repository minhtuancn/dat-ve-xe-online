package com.vexeonline.service.nhaxe;

import java.util.List;

import com.vexeonline.dto.XeDTO;

public interface QuanLyXeService {
	public XeDTO getById(Integer id) throws Exception;
	public List<XeDTO> listXe() throws Exception;
	public void addNew(XeDTO xe) throws Exception;
	public void update(XeDTO xe) throws Exception;
}
