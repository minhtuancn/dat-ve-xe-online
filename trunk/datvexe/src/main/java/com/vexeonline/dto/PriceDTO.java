package com.vexeonline.dto;

import java.io.Serializable;
import java.util.Date;

import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.vexeonline.domain.GiaVe;

public class PriceDTO implements Serializable {
	
	private static final long serialVersionUID = -6316939737469586869L;
	
	private Integer id;
	private Integer giaVe;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	
	public PriceDTO() {
	}
	
	public PriceDTO(Integer giaVe, Date ngayBatDau, Date ngayKetThuc) {
		this.giaVe = giaVe;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}

	public PriceDTO(GiaVe giaVe) {
		if (giaVe != null) {
			this.id = giaVe.getIdGiaVe();
			this.giaVe = giaVe.getGiaVe();
			this.ngayBatDau = giaVe.getNgayBatDau();
			this.ngayKetThuc = giaVe.getNgayKetThuc();
		}
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@RequiredFieldValidator(key = "price.require.price")
	@IntRangeFieldValidator(min = "0", key = "price.range.price")
	public Integer getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(Integer giaVe) {
		this.giaVe = giaVe;
	}
	
	@TypeConversion(converter = "com.vexeonline.converter.DateConverter")
	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	
	@RequiredFieldValidator(key = "price.require.enddate")
	@TypeConversion(converter = "com.vexeonline.converter.DateConverter")
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
