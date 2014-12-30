package com.vexeonline.dto;

import java.io.Serializable;
import java.util.Date;

import com.vexeonline.domain.GiaVe;

public class PriceDTO implements Serializable {
	
	private static final long serialVersionUID = -6316939737469586869L;
	
	private Integer id;
	private Integer giaVe;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	
	public PriceDTO() {
	}
	
	public PriceDTO(GiaVe giaVe) {
		this.id = giaVe.getIdGiaVe();
		this.giaVe = giaVe.getGiaVe();
		this.ngayBatDau = giaVe.getNgayBatDau();
		this.ngayKetThuc = giaVe.getNgayKetThuc();
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

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	@Override
	public String toString() {
		return "PriceDTO [id=" + id + ", giaVe=" + giaVe + ", ngayBatDau="
				+ ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + "]";
	}
}
