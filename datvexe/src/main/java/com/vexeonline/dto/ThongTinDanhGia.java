package com.vexeonline.dto;

import java.sql.Date;

public class ThongTinDanhGia {
	private String noiDung;
	private String tenNguoiDanhGia;
	private float diem;
	private Date ngayDi;

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

}
