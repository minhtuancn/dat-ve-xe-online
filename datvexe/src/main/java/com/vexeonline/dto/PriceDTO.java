package com.vexeonline.dto;

import java.io.Serializable;

public class PriceDTO implements Serializable {
	
	private static final long serialVersionUID = -6316939737469586869L;
	
	private Integer id;
	private Integer giaVe;
	private String ngayBatDau;
	private String ngayKetThuc;
	
	public PriceDTO(Integer id, Integer giaVe, String ngayBatDau, String ngayKetThuc) {
		this.id = id;
		this.giaVe = giaVe;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(Integer giaVe) {
		this.giaVe = giaVe;
	}

	public String getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public String getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	@Override
	public String toString() {
		return "PriceDTO [id=" + id + ", giaVe=" + giaVe + ", ngayBatDau="
				+ ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + "]";
	}
}
