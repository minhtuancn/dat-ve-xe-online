package com.vexeonline.dto;

import java.io.Serializable;

public class HanhKhachDTO implements Serializable {
	
	private static final long serialVersionUID = 8134035739691083295L;
	
	private Integer idHanhKhach;
	private String tenHanhKhach;
	private Integer idVeXe;
	private String soDienThoai;
	private Integer viTri;
	private boolean thanhToan;
	
	public Integer getIdHanhKhach() {
		return idHanhKhach;
	}

	public String getTenHanhKhach() {
		return tenHanhKhach;
	}

	public void setTenHanhKhach(String tenHanhKhach) {
		this.tenHanhKhach = tenHanhKhach;
	}

	public void setIdHanhKhach(Integer idHanhKhach) {
		this.idHanhKhach = idHanhKhach;
	}

	public Integer getIdVeXe() {
		return idVeXe;
	}

	public void setIdVeXe(Integer idVeXe) {
		this.idVeXe = idVeXe;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public Integer getViTri() {
		return viTri;
	}

	public void setViTri(Integer viTri) {
		this.viTri = viTri;
	}

	public boolean isThanhToan() {
		return thanhToan;
	}

	public void setThanhToan(boolean thanhToan) {
		this.thanhToan = thanhToan;
	}
}
