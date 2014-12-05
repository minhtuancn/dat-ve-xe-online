package com.vexeonline.dto;

public class ChuyenXeDTO {
	
	private Integer id;
	private String ngayDi;
	private String gioKhoiHanh;
	private Integer soHanhKhach;
	private String trangThai;

	public ChuyenXeDTO(Integer id, String ngayDi, String gioKhoiHanh,
			Integer soHanhKhach, String trangThai) {
		this.id = id;
		this.ngayDi = ngayDi;
		this.gioKhoiHanh = gioKhoiHanh;
		this.soHanhKhach = soHanhKhach;
		this.trangThai = trangThai;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
}
