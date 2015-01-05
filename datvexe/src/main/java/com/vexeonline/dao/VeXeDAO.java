package com.vexeonline.dao;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.vexeonline.domain.VeXe;

public interface VeXeDAO {
	/**
	 * get all information of VeXe
	 * @param maVeXe
	 * @return
	 */
    public VeXe getInfoVeXe(int maVeXe);
    
    public VeXe get(Integer nhaXeId,Integer ticketId);
    
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
    
    /**
     * get list position seated
     * @param idLichTuyen
     * @param ngayDi
     * @param gioDi
     * @return
     */
    public List<String> getListSeated(int idLichTuyen, Date ngayDi, Time gioDi);
    
    /**
     * @param maVe
     */
    public VeXe getVeXeByMaVe(String maVe);
}
