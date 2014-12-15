package com.vexeonline.action.nhaxe;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
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
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.vexeonline.domain.RoleOfUser;
import com.vexeonline.service.nhaxe.DatVeService;
import com.vexeonline.service.nhaxe.DatVeServiceImpl;

@Namespace(value = "/coachcp")
@ParentPackage(value = "default")
@InterceptorRef(value = "defaultStack", params = { "validation.excludeMethods",
		"execute" })
@Results({ @Result(name = "input", location = "book", type = "redirect"), })
public class DanhSachGheTrenChuyenXe extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -2637519288857253163L;
	private static Logger logger = Logger.getLogger(DanhSachGheTrenChuyenXe.class);
	private static DatVeService datVeXeService = new DatVeServiceImpl();
	Map<String, Object> session;
	private int idLichTuyen;
	private Date ngayDi;
	private List<Boolean> seats = new ArrayList<Boolean>(0);

	@Action(value = "chonghe", results = @Result(name = "success", location = "coach.book", type = "tiles"))
	public String danhSachGhe() {
		try {
			//for demo
			//session.put("user", "tung");
			//session.put("role", "NHAXE");

			if (session.get("user") == null
					|| session.get("role") == null
					|| !session.get("role").toString()
							.equals(RoleOfUser.NHAXE.toString())) {

				return INPUT;
			}

			int idChuyenXe = datVeXeService.getInfoChuyenXe(seats, idLichTuyen,
					ngayDi);
			logger.info(seats.size());

			session.put("idChuyenXe", idChuyenXe);
		} catch (Exception e) {
			logger.error("Error", e);
			addActionError("Sorry!Error occur");
			return ERROR;
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@RequiredFieldValidator(message = "Thiếu id Lịch tuyến!")
	public int getIdLichTuyen() {
		return idLichTuyen;
	}

	public void setIdLichTuyen(int idLichTuyen) {
		this.idLichTuyen = idLichTuyen;
	}

	@RequiredFieldValidator(message = "Thiếu ngày đi!")
	public Date getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}

	public List<Boolean> getSeats() {
		return seats;
	}

	public void setSeats(List<Boolean> seats) {
		this.seats = seats;
	}
}
