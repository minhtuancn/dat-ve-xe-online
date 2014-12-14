package com.vexeonline.dto;

import java.io.Serializable;
import java.util.List;

import com.vexeonline.domain.NgayCuaTuan;

public class LichChuyenDTO implements Serializable {

	private static final long serialVersionUID = -4209790089903009090L;

	private Integer id;
	private NgayCuaTuan ngayTrongTuan;
	private String gioChay;
	private Integer idTuyenXe;
	private String tenTuyenXe;
	private String tongThoiGian;
	private Integer idXe;
	private String bienSoXe;
	private boolean active;
	private PriceDTO currentPrice;
	private List<PriceDTO> prices;

	public LichChuyenDTO() {
	}

	public LichChuyenDTO(NgayCuaTuan ngayTrongTuan, String gioChay,
			Integer idTuyenXe, String tongThoiGian, Integer idXe) {
		this.ngayTrongTuan = ngayTrongTuan;
		this.gioChay = gioChay;
		this.idTuyenXe = idTuyenXe;
		this.tongThoiGian = tongThoiGian;
		this.idXe = idXe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public NgayCuaTuan getNgayTrongTuan() {
		return ngayTrongTuan;
	}

	public void setNgayTrongTuan(NgayCuaTuan ngayTrongTuan) {
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public PriceDTO getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(PriceDTO currentPrice) {
		this.currentPrice = currentPrice;
	}

	public List<PriceDTO> getPrices() {
		return prices;
	}

	public void setPrices(List<PriceDTO> prices) {
		this.prices = prices;
	}
}