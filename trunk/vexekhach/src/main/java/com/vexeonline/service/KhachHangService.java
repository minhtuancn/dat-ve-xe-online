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
	 * @return
	 */
	public VeXe kiemTraVe(String SDT, String maSoVe);

}
