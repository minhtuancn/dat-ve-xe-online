package com.vexeonline.service.nhaxe;

import java.sql.Date;
import java.util.List;

public interface DatVeService {
	/**
	 * seats is list true/false present of seat booked or not 
	 * @param seats 
	 * @param idLichTuyen
	 * @param ngayDi
	 * @return idChuyenXe geted from DB or create new if not exist folow idLichTuyen and ngayDi
	 */
    public int getInfoChuyenXe(List<Boolean> seats, int idLichTuyen, Date ngayDi) throws Exception;
   
    /**
     *  seatings is seats wil book
     * @param idChuyenXe
     * @param seatings
     * @param tenHanhKhach
     * @param sdt
     */
    public void datVe(int idChuyenXe, String[] seatings, String tenHanhKhach, String sdt) throws Exception; 
}
