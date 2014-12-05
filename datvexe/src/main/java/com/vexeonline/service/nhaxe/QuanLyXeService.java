package com.vexeonline.service.nhaxe;

import java.util.List;

import com.vexeonline.domain.Xe;

public interface QuanLyXeService {
	public List<Xe> listXe();

	public void addNew(Xe xe) throws Exception;

	public void update(Xe xe) throws Exception;
}
