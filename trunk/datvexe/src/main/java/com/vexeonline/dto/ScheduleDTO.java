package com.vexeonline.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vexeonline.domain.GiaVe;
import com.vexeonline.domain.LichTuyen;
import com.vexeonline.domain.NgayCuaTuan;

public class ScheduleDTO implements Serializable {

	private static final long serialVersionUID = -4209790089903009090L;

	private Integer id;
	private NgayCuaTuan ngayTrongTuan;
	private Date gioChay;
	private TuyenXeDTO tuyenXe;
	private Double tongThoiGian;
	private VehicleDTO vehicle;
	private boolean active;
	private List<PriceDTO> prices;

	public ScheduleDTO() {
	}
	
	public ScheduleDTO(LichTuyen schedule) {
		this.id = schedule.getIdLichTuyen();
		this.ngayTrongTuan = schedule.getThu();
		this.gioChay = schedule.getGioDi();
		this.tuyenXe = new TuyenXeDTO(schedule.getTuyenXe());
		this.tongThoiGian = schedule.getTongThoiGian();
		this.vehicle = new VehicleDTO(schedule.getXe());
		this.active = schedule.isActive();
		this.prices = new ArrayList<PriceDTO>();
		for (GiaVe giaVe : schedule.getGiaVes()) {
			prices.add(new PriceDTO(giaVe));
		}
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

	public Date getGioChay() {
		return gioChay;
	}
	
	public void setGioChay(String gioChay) {
		try {
			this.gioChay = new SimpleDateFormat("kk:mm").parse(gioChay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void setGioChay(Date gioChay) {
		this.gioChay = gioChay;
	}

	public TuyenXeDTO getTuyenXe() {
		return tuyenXe;
	}

	public void setTuyenXe(TuyenXeDTO tuyenXe) {
		this.tuyenXe = tuyenXe;
	}

	public Double getTongThoiGian() {
		return tongThoiGian;
	}

	public void setTongThoiGian(Double tongThoiGian) {
		this.tongThoiGian = tongThoiGian;
	}

	public VehicleDTO getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleDTO vehicle) {
		this.vehicle = vehicle;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<PriceDTO> getPrices() {
		return prices;
	}

	public void setPrices(List<PriceDTO> prices) {
		this.prices = prices;
	}

	@Override
	public String toString() {
		return "ScheduleDTO [id=" + id + ", ngayTrongTuan=" + ngayTrongTuan
				+ ", gioChay=" + gioChay + ", tongThoiGian=" + tongThoiGian
				+ ", active=" + active + "]";
	}
}