package com.vexeonline.action.khachhang;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.vexeonline.dto.TicketDetailDTO;
import com.vexeonline.service.customer.TicketService;
import com.vexeonline.service.customer.TicketServiceImpl;
import com.vexeonline.utils.HibernateUtil;

@Namespace(value = "/")
@ParentPackage(value = "default")
public class KiemTraVe extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private static final TicketService ticketService = new TicketServiceImpl();
	
	private String phoneNumber;
	private List<TicketDetailDTO> tickets;
	
	@RequiredStringValidator(trim = true, key = "ticketinfo.require.phonenumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<TicketDetailDTO> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketDetailDTO> tickets) {
		this.tickets = tickets;
	}

	@SkipValidation
	@Action(value = "ticketInfo", results = {
			@Result(name = "success", location = "ticketInfo", type = "tiles"),
	})
	public String showTicketInfoPage() {
		return SUCCESS;
	}
	
	@Action(value = "ticketDetail", results = {
			@Result(name = "success", location = "ticketDetail", type = "tiles"),
			@Result(name = "input", location = "ticketInfo", type = "tiles")
	})
	public String showTicketDetailPage() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			tickets = ticketService.getTicketByPhoneNumber(phoneNumber);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public static void main(String[] args) {
		KiemTraVe ktv = new KiemTraVe();
		ktv.setPhoneNumber("01662488323");
		ktv.showTicketDetailPage();
		List<TicketDetailDTO> tickets = ktv.getTickets();
		for (TicketDetailDTO t : tickets) {
			System.out.println(t);
		}
	}
}
