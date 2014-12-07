package com.vexeonline.service.nhaxe;

import java.util.List;

import com.vexeonline.dto.LichChuyenDTO;

public interface QuanLyLichChuyenService {
	public LichChuyenDTO getById(Integer id) throws Exception;
	public List<LichChuyenDTO> list() throws Exception;
	public void themLichChuyen(LichChuyenDTO lichChuyen) throws Exception;
	public void capNhatLichChuyen(LichChuyenDTO lichChuyen) throws Exception;
}