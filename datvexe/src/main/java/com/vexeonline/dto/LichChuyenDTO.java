package com.vexeonline.dto;

import java.io.Serializable;

public class LichChuyenDTO implements Serializable {

	private static final long serialVersionUID = -4209790089903009090L;
	
	private Integer id;
	private String ngayTrongTuan;
	private String gioChay;
	private Integer idTuyenXe;
	private String tenTuyenXe;
	private String tongThoiGian;
	private Integer idXe;
	private String bienSoXe;
	private Integer giaVe;
	private String trangThai;

	public LichChuyenDTO() {
		// TODO Auto-generated constructor stub
	}

	public LichChuyenDTO(Integer id, String ngayTrongTuan, String gioChay,
			Integer idTuyenXe, String tenTuyenXe, String tongThoiGian,
			Integer idXe, String bienSoXe, Integer giaVe, String trangThai) {
		this.id = id;
		this.ngayTrongTuan = ngayTrongTuan;
		this.gioChay = gioChay;
		this.idTuyenXe = idTuyenXe;
		this.tenTuyenXe = tenTuyenXe;
		this.tongThoiGian = tongThoiGian;
		this.idXe = idXe;
		this.bienSoXe = bienSoXe;
		this.giaVe = giaVe;
		this.trangThai = trangThai;
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

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
}