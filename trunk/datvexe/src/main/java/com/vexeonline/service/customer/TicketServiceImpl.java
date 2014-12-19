package com.vexeonline.service.customer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.vexeonline.dao.HanhKhachDAO;
import com.vexeonline.dao.HanhKhachDAOImpl;
import com.vexeonline.domain.GiaVe;
import com.vexeonline.domain.HanhKhach;
import com.vexeonline.domain.VeXe;
import com.vexeonline.dto.TicketDetailDTO;

public class TicketServiceImpl implements TicketService {

	private static final HanhKhachDAO hanhKhachDAO = new HanhKhachDAOImpl();
	
	@Override
	public List<TicketDetailDTO> getTicketByPhoneNumber(String phoneNumber)
			throws Exception {
		List<TicketDetailDTO> result = null;
		HanhKhach hk = hanhKhachDAO.getBySDT(phoneNumber);
		
		if (hk != null) {
			Set<VeXe> ves = hk.getVeXes();
			result = new ArrayList<TicketDetailDTO>();
			TicketDetailDTO ticket = null;
			for (VeXe ve : ves) {
				ticket = new TicketDetailDTO();
				ticket.setId(ve.getIdVeXe());
				Date start = ve.getChuyenXe().getNgayDi();
				ticket.setStartDate(new SimpleDateFormat("dd/MM/yyyy").format(start));
				ticket.setStartTime(new SimpleDateFormat("HH:mm").format(start));
				ticket.setVehicleType(ve.getChuyenXe().getLichTuyen().getXe().getLoaiXe());
				ticket.setSeatId(ve.getChoNgoi());
				ticket.setCustomerName(ve.getHanhKhach().getTenHanhKhach());
				ticket.setCustomerPhoneNumber(ve.getHanhKhach().getSdt());
				ticket.setCustomerEmail(ve.getHanhKhach().getEmail());
				Set<GiaVe> giaVes = ve.getChuyenXe().getLichTuyen().getGiaVes();
				for (GiaVe giaVe : giaVes) {
					if (giaVe.getNgayBatDau().before(start) && giaVe.getNgayKetThuc().after(start)) {
						ticket.setPrice(giaVe.getGiaVe());
						break;
					}
				}
				result.add(ticket);
			}
		}
		return result;
	}
}
