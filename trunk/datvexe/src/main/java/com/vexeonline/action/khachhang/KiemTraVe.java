package com.vexeonline.action.khachhang;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.dto.TicketDetailDTO;
import com.vexeonline.service.KhachHangService;
import com.vexeonline.service.KhachHangServiceImpl;

@Namespace(value = "/")
@ParentPackage(value = "default")
@InterceptorRef(value = "defaultStack")
public class KiemTraVe extends ActionSupport {

	private static final long serialVersionUID = -9065358490206667897L;

	private static Logger logger = Logger.getLogger(KiemTraVe.class);
	
	private KhachHangService khachHangService = new KhachHangServiceImpl();
	
	private String maVe;
	private TicketDetailDTO ticket;
	

	@SkipValidation
	@Action(value = "ticketInfo", results = { @Result(name = "success", location = "ticketInfo", type = "tiles"), })
	public String showTicketInfoPage() {
		return SUCCESS;
	}

	@Action(value = "ticketDetail", results = {
			@Result(name = "success", location = "ticketDetail", type = "tiles"),
			@Result(name = "input", location = "ticketInfo", type = "tiles") })
	public String showTicketDetailPage() {
		try {
			ticket = khachHangService.kiemTraVe(maVe);
			logger.info(ticket == null);

		} catch (Exception e) {
			logger.error(e);
		}
		return SUCCESS;
	}

	@Action(value = "destroyticket", results = @Result(name = "success", location = "home", type = "redirect"))
	public String detroyTicket() {
		try {
			logger.info(maVe);
			khachHangService.huyVe(maVe);
		} catch (Exception e) {
			logger.error(e);
		}
		return SUCCESS;
	}

	public String getMaVe() {
		return maVe;
	}

	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}

	public TicketDetailDTO getTicket() {
		return ticket;
	}

	public void setTicket(TicketDetailDTO ticket) {
		this.ticket = ticket;
	}
}
