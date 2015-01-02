package com.vexeonline.service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

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
	 * @param viTris
	 * @param idLichTuyen
	 * @param ngayDi
	 * @param gioDi
	 * @param tenHanhKhach
	 * @param email
	 * @param sdt
	 * @return
	 */
	public boolean datVe(String viTris, int idLichTuyen, Date ngayDi, Time gioDi, String tenHanhKhach,
			String email, String sdt);

	/**
	 * 
	 * @param ngayDi
	 * @param maVe
	 * @param noiDung
	 * @param diem
	 * @param idNhaXe
	 * @return
	 */
	public boolean danhGiaChuyenXe(Date ngayDi, String maVe, String noiDung,
			float diem, int idNhaXe) ;
	
	/**
	 * 
	 * @param maVe
	 * @return
	 * @throws Exception 
	 */
	public boolean huyVe(int maVe) throws Exception;
	
	public List<ThongTinDanhGiaDTO> getListInfoDanhGiaByNhaXe(int idNhaXe);
	
	public List<SDTNhaXeDTO> getListSDTNhaXe(int idNhaXe);
	
	/**
	 * return file name sodoViTri
	 * listA -> seats column A ,...
	 * @param idXe
	 * @param listA
	 * @param listB
	 * @param listC
	 * @param listD
	 * @param listE
	 */
	public String listChoByXe(int idXe, int idLichTuyen, Date ngayDi, Time gioDi, List<String> listA, 
			List<String> listB, List<String> listC, List<String> listD, List<String> listE);
	
	public void xacNhanVe(String maVe);
}
