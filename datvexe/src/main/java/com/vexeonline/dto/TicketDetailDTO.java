package com.vexeonline.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class TicketDetailDTO implements Serializable {

	private static final long serialVersionUID = -5282181709947490322L;
	private String maVe;
	private Date ngayDi;
	private Time gioDi;
	private String loaiXe;
	private String soGhe;
	private int giaVe;
	private String tenHanhKhach;
	private String sdt;
	private String email;


	public String getMaVe() {
		return maVe;
	}

	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}

	public Date getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}

	public Time getGioDi() {
		return gioDi;
	}

	public void setGioDi(Time gioDi) {
		this.gioDi = gioDi;
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

	public String getSoGhe() {
		return soGhe;
	}

	public void setSoGhe(String soGhe) {
		this.soGhe = soGhe;
	}

	public int getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(int giaVe) {
		this.giaVe = giaVe;
	}

	public String getTenHanhKhach() {
		return tenHanhKhach;
	}

	public void setTenHanhKhach(String tenHanhKhach) {
		this.tenHanhKhach = tenHanhKhach;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
