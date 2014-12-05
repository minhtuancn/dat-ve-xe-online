package com.vexeonline.service.admin;

import java.util.List;

import com.vexeonline.domain.DanhGia;

public interface QuanLyDanhGiaService {
	
    public List<DanhGia> listDanhGia();
    /**
     * 
     * @param idDanhGia
     * @throws Exception if error
     */
    public void delete(int idDanhGia) throws Exception;
}
