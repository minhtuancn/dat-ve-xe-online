package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.DanhGia;

public interface DanhGiaDAO {
    public int save(DanhGia danhGia);
    public List<DanhGia> list();
    public void delete(DanhGia danhGia);
    public DanhGia getById(int idDanhGia);
    public List<DanhGia> getListDanhGiaByIdNhaXe(int idNhaXe);
}
