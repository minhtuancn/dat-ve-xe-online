package com.vexeonline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

@Entity
public class VeXe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idVeXe;

	@Column(nullable = false)
	private int choNgoi;

	private boolean isThanhToan;
	private boolean trangThai;

	@ManyToOne
	@JoinColumn(nullable = false)
	private ChuyenXe chuyenXe;

	@ManyToOne
	@JoinColumn(nullable = false)
	private HanhKhach hanhKhach;

	public int getIdVeXe() {
		return idVeXe;
	}

	public void setIdVeXe(int idVeXe) {
		this.idVeXe = idVeXe;
	}

	@RequiredFieldValidator(key = "require.choNgoi")
	public int getChoNgoi() {
		return choNgoi;
	}

	public void setChoNgoi(int choNgoi) {
		this.choNgoi = choNgoi;
	}

	public boolean isThanhToan() {
		return isThanhToan;
	}

	public void setThanhToan(boolean isThanhToan) {
		this.isThanhToan = isThanhToan;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public ChuyenXe getChuyenXe() {
		return chuyenXe;
	}

	public void setChuyenXe(ChuyenXe chuyenXe) {
		this.chuyenXe = chuyenXe;
	}

	public HanhKhach getHanhKhach() {
		return hanhKhach;
	}

	public void setHanhKhach(HanhKhach hanhKhach) {
		this.hanhKhach = hanhKhach;
	}

}
