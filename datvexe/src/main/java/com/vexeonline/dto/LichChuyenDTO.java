package com.vexeonline.dto;

import java.io.Serializable;

import com.vexeonline.domain.NgayCuaTuan;

public class LichChuyenDTO implements Serializable {

	private static final long serialVersionUID = -4209790089903009090L;

	private Integer id;
	private String ngayTrongTuan;
	private NgayCuaTuan idNgayTrongTuan;
	private String gioChay;
	private Integer idTuyenXe;
	private String tenTuyenXe;
	private String tongThoiGian;
	private Integer idXe;
	private String bienSoXe;
	private Integer giaVe;
	private boolean active;
	
	public LichChuyenDTO() {
		// TODO Auto-generated constructor stub
	}

	public LichChuyenDTO(NgayCuaTuan idNgayTrongTuan, String gioChay,
			Integer idTuyenXe, String tongThoiGian, Integer idXe, Integer giaVe) {
		this.idNgayTrongTuan = idNgayTrongTuan;
		this.gioChay = gioChay;
		this.idTuyenXe = idTuyenXe;
		this.tongThoiGian = tongThoiGian;
		this.idXe = idXe;
		this.giaVe = giaVe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNgayTrongTuan() {
		return ngayTrongTuan;
	}

	public void setNgayTrongTuan(String ngayTrongTuan) {
		this.ngayTrongTuan = ngayTrongTuan;
	}

	public NgayCuaTuan getIdNgayTrongTuan() {
		return idNgayTrongTuan;
	}

	public void setIdNgayTrongTuan(NgayCuaTuan idNgayTrongTuan) {
		this.idNgayTrongTuan = idNgayTrongTuan;
	}

	public String getGioChay() {
		return gioChay;
	}

	public void setGioChay(String gioChay) {
		this.gioChay = gioChay;
	}

	public Integer getIdTuyenXe() {
		return idTuyenXe;
	}

	public void setIdTuyenXe(Integer idTuyenXe) {
		this.idTuyenXe = idTuyenXe;
	}

	public String getTenTuyenXe() {
		return tenTuyenXe;
	}

	public void setTenTuyenXe(String tenTuyenXe) {
		this.tenTuyenXe = tenTuyenXe;
	}

	public String getTongThoiGian() {
		return tongThoiGian;
	}

	public void setTongThoiGian(String tongThoiGian) {
		this.tongThoiGian = tongThoiGian;
	}

	public Integer getIdXe() {
		return idXe;
	}

	public void setIdXe(Integer idXe) {
		this.idXe = idXe;
	}

	public String getBienSoXe() {
		return bienSoXe;
	}

	public void setBienSoXe(String bienSoXe) {
		this.bienSoXe = bienSoXe;
	}

	public Integer getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(Integer giaVe) {
		this.giaVe = giaVe;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}