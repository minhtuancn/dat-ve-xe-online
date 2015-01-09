package com.vexeonline.dto;

import java.io.Serializable;
import java.util.Date;

public class ThongTinDanhGiaDTO implements Serializable {
	
	private static final long serialVersionUID = 3325712387902900722L;
	
	private String noiDung;
	private String tenNguoiDanhGia;
	private float diem;
	private Date ngayDi;
	private Date ngayDanhGia;

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getTenNguoiDanhGia() {
		return tenNguoiDanhGia;
	}

	public void setTenNguoiDanhGia(String tenNguoiDanhGia) {
		this.tenNguoiDanhGia = tenNguoiDanhGia;
	}

	public float getDiem() {
		return diem;
	}

	public void setDiem(float diem) {
		this.diem = diem;
	}

	public Date getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}

	public Date getNgayDanhGia() {
		return ngayDanhGia;
	}

	public void setNgayDanhGia(Date ngayDanhGia) {
		this.ngayDanhGia = ngayDanhGia;
	}
}
