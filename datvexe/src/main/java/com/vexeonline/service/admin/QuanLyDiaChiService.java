package com.vexeonline.service.admin;

import java.util.List;

import com.vexeonline.domain.DiaChi;

public interface QuanLyDiaChiService {
	public List<DiaChi> listDiaChi();

	public void addNew(DiaChi diaChi) throws Exception;

	public void update(DiaChi diaChi) throws Exception;
}
