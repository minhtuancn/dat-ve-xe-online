package com.vexeonline.dto;

import java.io.Serializable;

public class TicketDetailDTO implements Serializable {

	private static final long serialVersionUID = -5282181709947490322L;

	private Integer id;
	private String purchaseDate;
	private String startDate;
	private String startTime;
	private String vehicleType;
	private String seatId;
	private String customerName;
	private String customerPhoneNumber;
	private String customerEmail;
	private Integer price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "TicketDetailDTO [id=" + id + ", purchaseDate=" + purchaseDate
				+ ", startDate=" + startDate + ", startTime=" + startTime
				+ ", vehicleType=" + vehicleType + ", seatId=" + seatId
				+ ", customerName=" + customerName + ", customerPhoneNumber="
				+ customerPhoneNumber + ", customerEmail=" + customerEmail
				+ ", price=" + price + "]";
	}
}
