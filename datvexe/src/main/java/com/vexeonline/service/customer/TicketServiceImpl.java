package com.vexeonline.service.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.vexeonline.dao.HanhKhachDAO;
import com.vexeonline.dao.HanhKhachDAOImpl;
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
			for (VeXe ve : ves) {
				result.add(new TicketDetailDTO(ve));
			}
		}
		return result;
	}
}
