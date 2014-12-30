package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.DanhGia;

public interface DanhGiaDAO {
    public int save(DanhGia danhGia);
    public List<DanhGia> list();
    public void delete(DanhGia danhGia);
    public DanhGia getById(int idDanhGia);
    
    /**
     * Get info in table DanhGia with column follow order :
     * diem, tenHanhKhach, noiDung, ngayDi, ngayDanhGia
     * @param idNhaXe
     * @return
     */
    public List<Object[]> getListInfoDanhGiaByIdNhaXe(int idNhaXe);
    public List<Object[]> getListSDTNhaXe(int idNhaXe);
    
    /**
     * return rating of nha xe
     * @param idNhaXe
     * @return
     */
    public double ratingByNhaXe(int idNhaXe);
}
