package com.vexeonline.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import com.vexeonline.domain.GiaVe;
import com.vexeonline.domain.VeXe;

public class TicketDetailDTO implements Serializable {

	private static final long serialVersionUID = -5282181709947490322L;
	private static final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private static final SimpleDateFormat tf = new SimpleDateFormat("HH:mm");
	
	private Integer id;
	private String ticketId;
	private String purchaseDate;
	private String startDate;
	private String startTime;
	private String vehicleType;
	private String seatId;
	private String customerName;
	private String customerPhoneNumber;
	private String customerEmail;
	private Integer price;

	public TicketDetailDTO() {
	}
	
	public TicketDetailDTO(VeXe ticket) {
		this.id = ticket.getIdVeXe();
		this.ticketId = ticket.getMaVe();
		Date start = ticket.getChuyenXe().getNgayDi();
		this.startDate = df.format(start);
		this.startTime = tf.format(start);
		this.vehicleType = ticket.getChuyenXe().getLichTuyen().getXe().getLoaiXe();
		this.seatId = ticket.getChoNgoi();
		this.customerName = ticket.getHanhKhach().getTenHanhKhach();
		this.customerPhoneNumber = ticket.getHanhKhach().getSdt();
		this.customerEmail = ticket.getHanhKhach().getEmail();
		Set<GiaVe> giaVes = ticket.getChuyenXe().getLichTuyen().getGiaVes();
		for (GiaVe giaVe : giaVes) {
			if (giaVe.getNgayBatDau().before(start) && giaVe.getNgayKetThuc().after(start)) {
				this.setPrice(giaVe.getGiaVe());
				break;
			}
		}
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
