package com.vexeonline.service;

import java.sql.Date;
import java.util.List;

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
	 * @return List<TuyenXe>
	 */
	public List<TuyenXe> getListChuyenXe(String tinhDi, String tinhDen,
			Date ngayDi);

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

}
