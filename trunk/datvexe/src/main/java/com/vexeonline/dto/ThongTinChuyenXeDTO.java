package com.vexeonline.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

public class ThongTinChuyenXeDTO implements Serializable {
	
	private static final long serialVersionUID = 2596991614311901006L;
	
	private String tenNhaXe;
	private List<String> tienIchs;
	private String loaiXe;
	private String tenBenDi;
	private String tenBenDen;
	private Time gioDi;
	private Double tongThoiGian;
	private Long soChoConLai;
	private Integer soCho;
	private Double rating;
	private Integer idNhaXe;
	private Integer idLichTuyen;
	private Integer giaVe;
	private Integer idXe;

	public String getTenNhaXe() {
		return tenNhaXe;
	}

	public void setTenNhaXe(String tenNhaXe) {
		this.tenNhaXe = tenNhaXe;
	}

	public List<String> getTienIchs() {
		return tienIchs;
	}

	public void setTienIchs(List<String> tienIchs) {
		this.tienIchs = tienIchs;
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

	public String getTenBenDi() {
		return tenBenDi;
	}

	public void setTenBenDi(String tenBenDi) {
		this.tenBenDi = tenBenDi;
	}

	public String getTenBenDen() {
		return tenBenDen;
	}

	public void setTenBenDen(String tenBenDen) {
		this.tenBenDen = tenBenDen;
	}

	public Time getGioDi() {
		return gioDi;
	}

	public void setGioDi(Time gioDi) {
		this.gioDi = gioDi;
	}

	public Double getTongThoiGian() {
		return tongThoiGian;
	}

	public void setTongThoiGian(Double tongThoiGian) {
		this.tongThoiGian = tongThoiGian;
	}

	public Long getSoChoConLai() {
		return soChoConLai;
	}

	public void setSoChoConLai(Long l) {
		this.soChoConLai = l;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getIdNhaXe() {
		return idNhaXe;
	}

	public void setIdNhaXe(Integer idNhaXe) {
		this.idNhaXe = idNhaXe;
	}

	public Integer getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(Integer giaVe) {
		this.giaVe = giaVe;
	}

	public Integer getIdLichTuyen() {
		return idLichTuyen;
	}

	public void setIdLichTuyen(Integer idLichTuyen) {
		this.idLichTuyen = idLichTuyen;
	}

	public Integer getIdXe() {
		return idXe;
	}

	public void setIdXe(Integer idXe) {
		this.idXe = idXe;
	}

	public Integer getSoCho() {
		return soCho;
	}

	public void setSoCho(Integer soCho) {
		this.soCho = soCho;
	}
}
