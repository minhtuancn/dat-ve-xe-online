package com.vexeonline.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

@Entity
public class VeXe implements Serializable {

	private static final long serialVersionUID = 2052803547818468572L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idVeXe;

	@Column(nullable = false)
	private int choNgoi;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private TrangThaiVeXe trangThai;

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

	public TrangThaiVeXe getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThaiVeXe trangThai) {
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