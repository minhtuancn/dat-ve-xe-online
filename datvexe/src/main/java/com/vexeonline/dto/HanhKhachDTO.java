package com.vexeonline.dto;

import java.io.Serializable;

import com.vexeonline.domain.HanhKhach;

public class HanhKhachDTO implements Serializable {
	
	private static final long serialVersionUID = 8134035739691083295L;
	
	private Integer idHanhKhach;
	private String tenHanhKhach;
	private String soDienThoai;
	private String email;
	
	public HanhKhachDTO() {
	}
	
	public HanhKhachDTO(HanhKhach customer) {
		this.idHanhKhach = customer.getIdHanhKhach();
		this.tenHanhKhach = customer.getTenHanhKhach();
		this.soDienThoai = customer.getSdt();
		this.email = customer.getEmail();
	}
	
	public HanhKhachDTO(String tenHanhKhach, String soDienThoai, String email) {
		this.tenHanhKhach = tenHanhKhach;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}

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
	
	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
