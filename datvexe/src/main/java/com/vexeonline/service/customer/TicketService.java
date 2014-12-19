package com.vexeonline.service.customer;

import java.util.List;

import com.vexeonline.dto.TicketDetailDTO;

public interface TicketService {
	public List<TicketDetailDTO> getTicketByPhoneNumber(String phoneNumber) throws Exception;
}