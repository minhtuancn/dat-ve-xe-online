package com.vexeonline.service;

import java.sql.Date;
import java.util.List;

import com.vexeonline.domain.HanhKhach;
import com.vexeonline.domain.TuyenXe;
import com.vexeonline.domain.VeXe;

/**
 * 
 * @author Tung
 *
 */
public interface KhachHangService {
	/**
	 * get list ChuyenXe by tinhDi, tinhDen, ngayDi
	 * 
	 * @param tinhDi
	 * @param tinhDen
	 * @param ngayDi
	 * @param soCho
	 * @return List<TuyenXe>
	 */
	public List<TuyenXe> getListChuyenXe(String tinhDi, String tinhDen,
			Date ngayDi, int soCho);

	/**
	 * 
	 * @param SDT
	 * @param maSoVe
	 * @return VeXe null if maSoVe not exist or SDT hanhKhach not same
	 */
	public VeXe kiemTraVe(String SDT, int maSoVe);

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean login(String userName, String password);

	/**
	 * 
	 * @param soCho
	 * @param idChuyenXe
	 * @param hanhKhach
	 * @return true if success otherwise fasle
	 */
	public boolean datVe(int soCho, int idChuyenXe, HanhKhach hanhKhach);

	/**
	 * 
	 * @param maVe
	 * @param noiDung
	 * @param maLichTuyen
	 * @param diem
	 * @return false if maVe not correct, otherwise success
	 * @throws Exception
	 *             if exception
	 */
	public boolean danhGiaChuyenXe(int maVe, int maLichTuyen, String noiDung,
			float diem) throws Exception;
	
	/**
	 * 
	 * @param maVe
	 * @return
	 * @throws Exception 
	 */
	public boolean huyVe(int maVe) throws Exception;
}
