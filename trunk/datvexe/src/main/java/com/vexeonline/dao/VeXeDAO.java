package com.vexeonline.dao;

import java.sql.Time;
import java.util.Date;

import com.vexeonline.domain.VeXe;

public interface VeXeDAO {
	/**
	 * get all information of VeXe
	 * @param maVeXe
	 * @return
	 */
    public VeXe getInfoVeXe(int maVeXe);
    
    public int save(VeXe veXe);
    
    public void delete(VeXe veXe);
    
    /**
     * return number booked by lich tuyen, ngay di, gio di
     * if no chuyen xe generated return 0
     * @param idLichTuyen
     * @param ngayDi
     * @return int
     */
    public long laySoVeXeTheoLichTuyenVaNgayDi (int idLichTuyen, Date ngayDi, Time gioDi);
    
    /**
     * get follow order ngayDi, idHanhKhach, idNhaXe
     * @param maVe
     * @return
     */
    public Object[] getInfoByMaVe(String maVe);
    
}
