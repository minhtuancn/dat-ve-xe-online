package com.vexeonline.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {
		"idChuyenXe", "choNgoi" }) })
public class VeXe implements Serializable {

	private static final long serialVersionUID = 2052803547818468572L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer idVeXe;

	@Column(unique = true, nullable = false, length = 8)
	private String maVe;

	@Column(nullable = false, length = 5, name = "choNgoi")
	private String choNgoi;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private TrangThaiVeXe trangThai;

	@ManyToOne
	@JoinColumn(nullable = false, name = "idChuyenXe")
	private ChuyenXe chuyenXe;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private HanhKhach hanhKhach;

	public Integer getIdVeXe() {
		return idVeXe;
	}

	public void setIdVeXe(Integer idVeXe) {
		this.idVeXe = idVeXe;
	}

	@RequiredFieldValidator(key = "require.choNgoi")
	public String getChoNgoi() {
		return choNgoi;
	}

	public void setChoNgoi(String choNgoi) {
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

	public String getMaVe() {
		return maVe;
	}

	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}

	@Override
	public String toString() {
		return "VeXe [idVeXe=" + idVeXe + ", maVe=" + maVe + ", choNgoi="
				+ choNgoi + ", trangThai=" + trangThai + "]";
	}
}