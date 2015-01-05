package com.vexeonline.dto;

import java.io.Serializable;

import com.vexeonline.domain.TrangThaiVeXe;
import com.vexeonline.domain.VeXe;

public class TicketDTO implements Serializable {

	private static final long serialVersionUID = -7818972427430319359L;

	private Integer id;
	private String ticketId;
	private String seat;
	private TrangThaiVeXe status;
	private HanhKhachDTO customer;

	public TicketDTO() {
	}
	
	public TicketDTO(VeXe ticket) {
		this.id = ticket.getIdVeXe();
		this.ticketId = ticket.getMaVe();
		this.seat = ticket.getChoNgoi();
		this.status = ticket.getTrangThai();
		this.customer = new HanhKhachDTO(ticket.getHanhKhach());
	}
	
	public TicketDTO(String seat) {
		this.seat = seat;
	}
	
	public TicketDTO(String seat, HanhKhachDTO customer) {
		this.seat = seat;
		this.customer = customer;
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

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public TrangThaiVeXe getStatus() {
		return status;
	}

	public void setStatus(TrangThaiVeXe status) {
		this.status = status;
	}

	public HanhKhachDTO getCustomer() {
		return customer;
	}

	public void setCustomer(HanhKhachDTO customer) {
		this.customer = customer;
	}
}
