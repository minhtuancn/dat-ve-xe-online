package com.vexeonline.action.nhaxe;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.vexeonline.service.nhaxe.DatVeService;
import com.vexeonline.service.nhaxe.DatVeServiceImpl;

@Namespace(value = "/coachcp")
@ParentPackage(value = "default")
@InterceptorRef(value = "defaultStack", params = { "validation.excludeMethods",
		"execute" })
@Results({ @Result(name = "input", location = "coach.book", type = "tiles") })
public class DatVeXe extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 6453306615485591423L;
	
	private static Logger logger = Logger.getLogger(DatVeXe.class);
	
	private static DatVeService datVeXeService = new DatVeServiceImpl();
	
	Map<String, Object> session;
	private String tenHanhKhach;
	private String sdt;
	private String[] seateds = new String[0];

	@Action(value = "datve", results = @Result(name = "success", location = "home", type = "redirect"))
	public String datVe() {
		try {
			session.put("user", "tug");
			session.put("role", "NHAXE");
			session.put("idChuyenXe", 1);

			logger.info(seateds.length);
			logger.info(seateds[0]);
			int idChuyenXe = (int) session.get("idChuyenXe");
			logger.info(idChuyenXe);

			if (session.get("user") == null) {
				return INPUT;
			}

			datVeXeService.datVe(idChuyenXe, seateds, tenHanhKhach, sdt);

		} catch (Exception e) {
			logger.error("Error", e);
			addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@RequiredStringValidator(message = "Tên hành khách không thể thiếu!", trim = true)
	public String getTenHanhKhach() {
		return tenHanhKhach;
	}

	public void setTenHanhKhach(String tenHanhKhach) {
		this.tenHanhKhach = tenHanhKhach;
	}

	@StringLengthFieldValidator(message = "Số điện thoại có chiều dài 10 hoặc 11!", trim = true, minLength = "10", maxLength = "11")
	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String[] getSeateds() {
		return seateds;
	}

	public void setSeateds(String[] seateds) {
		this.seateds = seateds;
	}
}
