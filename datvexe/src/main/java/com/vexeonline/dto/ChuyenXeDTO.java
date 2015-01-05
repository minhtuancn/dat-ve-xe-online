package com.vexeonline.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vexeonline.domain.ChuyenXe;
import com.vexeonline.domain.TrangThaiChuyenXe;
import com.vexeonline.domain.VeXe;

public class ChuyenXeDTO implements Serializable {

	private static final long serialVersionUID = -5895438306191748301L;

	private Integer id;
	private ScheduleDTO schedule;
	private Date departDate;
	private String tenTaiXe;
	private TrangThaiChuyenXe trangThai;
	private List<TicketDTO> tickets = new ArrayList<TicketDTO>();

	public String getRoute() {
		return schedule.getTuyenXe().getBenDi().getProvince() + " - "
				+ schedule.getTuyenXe().getBenDen().getProvince();
	}

	public ChuyenXeDTO() {

	}

	public ChuyenXeDTO(ChuyenXe chuyenXe, boolean includeScheduleInfo,
			boolean includeTicketsInfo) {
		this.id = chuyenXe.getIdChuyenXe();
		this.departDate = chuyenXe.getNgayDi();
		this.tickets = new ArrayList<TicketDTO>();
		this.tenTaiXe = chuyenXe.getTaiXe();
		this.trangThai = chuyenXe.getTrangThai();
		
		if (includeScheduleInfo) {
			this.schedule = new ScheduleDTO(chuyenXe.getLichTuyen());
		}

		if (includeTicketsInfo) {
			for (VeXe ticket : chuyenXe.getVeXes()) {
				this.tickets.add(new TicketDTO(ticket));
			}
		}
	}

	public ChuyenXeDTO(ChuyenXe chuyenXe) {
		this(chuyenXe, false, false);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ScheduleDTO getSchedule() {
		return schedule;
	}

	public void setSchedule(ScheduleDTO schedule) {
		this.schedule = schedule;
	}

	public Date getDepartDate() {
		return departDate;
	}

	public void setDepartDate(Date departDate) {
		this.departDate = departDate;
	}

	public String getTenTaiXe() {
		return tenTaiXe;
	}

	public void setTenTaiXe(String tenTaiXe) {
		this.tenTaiXe = tenTaiXe;
	}

	public TrangThaiChuyenXe getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThaiChuyenXe trangThai) {
		this.trangThai = trangThai;
	}

	public List<TicketDTO> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketDTO> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "ChuyenXeDTO [id=" + id + ", departDate=" + departDate
				+ ", tenTaiXe=" + tenTaiXe + ", trangThai=" + trangThai + "]";
	}
}
