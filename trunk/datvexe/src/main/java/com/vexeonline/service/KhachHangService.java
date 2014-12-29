package com.vexeonline.service;

import java.util.Date;
import java.util.List;

import com.vexeonline.domain.HanhKhach;
import com.vexeonline.domain.User;
import com.vexeonline.domain.VeXe;
import com.vexeonline.dto.SDTNhaXeDTO;
import com.vexeonline.dto.ThongTinChuyenXeDTO;
import com.vexeonline.dto.ThongTinDanhGiaDTO;

/**
 * 
 * @author Tung
 *
 */
public interface KhachHangService {
	/**
	 * get list ChuyenXe by tinhDi, tinhDen, ngayDi, soCho
	 * 
	 * @param tinhDi
	 * @param tinhDen
	 * @param ngayDi
	 * @param soCho
	 * @return List<TuyenXe>
	 */
	public List<ThongTinChuyenXeDTO> getListChuyenXe(String tinhDi, String tinhDen,
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
	public User login(String userName, String password);

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
	public boolean danhGiaChuyenXe(Date ngayDi, String sdt, String noiDung,
			float diem) ;
	
	/**
	 * 
	 * @param maVe
	 * @return
	 * @throws Exception 
	 */
	public boolean huyVe(int maVe) throws Exception;
	
	public List<ThongTinDanhGiaDTO> getListInfoDanhGiaByNhaXe(int idNhaXe);
	
	public List<SDTNhaXeDTO> getListSDTNhaXe(int idNhaXe);
}
