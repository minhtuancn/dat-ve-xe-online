package com.vexeonline.dto;

import java.io.Serializable;
import java.util.List;

import com.vexeonline.domain.TrangThaiChuyenXe;

public class ChuyenXeDTO implements Serializable{
	
	private static final long serialVersionUID = -5895438306191748301L;
	
	private Integer id;
	private Integer idLichChuyen;
	private Integer idTuyen;
	private String tuyen;
	private String ngayDi;
	private String gioKhoiHanh;
	private Integer soHanhKhach;
	private String tenTaiXe;
	private TrangThaiChuyenXe trangThai;
	private List<HanhKhachDTO> hanhKhachs;
	
	public ChuyenXeDTO() {
	}
	
	public ChuyenXeDTO(Integer id,String tuyen,String ngayDi, String gioKhoiHanh,
			Integer soHanhKhach) {
		this.id = id;
		this.tuyen = tuyen;
		this.ngayDi = ngayDi;
		this.gioKhoiHanh = gioKhoiHanh;
		this.soHanhKhach = soHanhKhach;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdTuyen() {
		return idTuyen;
	}

	public void setIdTuyen(Integer idTuyen) {
		this.idTuyen = idTuyen;
	}

	public String getTuyen() {
		return tuyen;
	}

	public void setTuyen(String tuyen) {
		this.tuyen = tuyen;
	}

	public Integer getIdLichChuyen() {
		return idLichChuyen;
	}

	public void setIdLichChuyen(Integer idLichChuyen) {
		this.idLichChuyen = idLichChuyen;
	}

	public String getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(String ngayDi) {
		this.ngayDi = ngayDi;
	}

	public String getGioKhoiHanh() {
		return gioKhoiHanh;
	}

	public void setGioKhoiHanh(String gioKhoiHanh) {
		this.gioKhoiHanh = gioKhoiHanh;
	}

	public Integer getSoHanhKhach() {
		return soHanhKhach;
	}

	public void setSoHanhKhach(Integer soHanhKhach) {
		this.soHanhKhach = soHanhKhach;
	}

	public String getTenTaiXe() {
		return tenTaiXe;
	}

	public void setTenTaiXe(String tenTaiXe) {
		this.tenTaiXe = tenTaiXe;
	}

	public TrangThaiChuyenXe getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThaiChuyenXe trangThai) {
		this.trangThai = trangThai;
	}

	public List<HanhKhachDTO> getHanhKhachs() {
		return hanhKhachs;
	}

	public void setHanhKhachs(List<HanhKhachDTO> hanhKhachs) {
		this.hanhKhachs = hanhKhachs;
	}
}
