package com.vexeonline.action.khachhang;

import java.util.Date;
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
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.vexeonline.dto.ThongTinChuyenXeDTO;
import com.vexeonline.dto.UserDTO;
import com.vexeonline.service.KhachHangService;
import com.vexeonline.service.KhachHangServiceImpl;

@Namespace(value = "/")
@ParentPackage(value = "default")
@InterceptorRef(value = "defaultStack", params = {"validation.excludeMethods","execute"})
@Results({ @Result(name = "input", location = "home", type = "tiles") })
public class TimChuyen extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = -1959057596225194512L;
	
	private static Logger logger = Logger.getLogger(TimChuyen.class);
	
	private static KhachHangService khanhHangService = new KhachHangServiceImpl();
	
	private Map<String, Object> session;
	
	private List<ThongTinChuyenXeDTO> list;
	
	private int soCho;
	private String tinhDi;
	private String tinhDen;
	private Date ngayDi;
	
	@Action(value = "timchuyenxe", results = @Result(name = "success", location = "trips", type = "tiles"))
	public String getListChuyenXe() {
		try {
			logger.info(tinhDi + " " + tinhDen + " " + ngayDi);
			UserDTO user = (UserDTO) session.get("user");
			if (user != null && user.getNhaXeId() != null) {
				list = khanhHangService.getListChuyenXe(tinhDi, tinhDen, ngayDi, soCho, user.getNhaXeId());
			} else {
				list = khanhHangService.getListChuyenXe(tinhDi, tinhDen, ngayDi, soCho);
			}
			logger.info(list.size());
		} catch (Exception e) {
			logger.error("Error", e);
			return INPUT;
		}
		return SUCCESS;
	}

	public List<ThongTinChuyenXeDTO> getList() {
		return list;
	}

	public void setList(List<ThongTinChuyenXeDTO> list) {
		this.list = list;
	}

	@IntRangeFieldValidator(message = "Số chỗ phải lớn hơn 0 nhỏ hơn 4", min = "1", max = "4")
	public int getSoCho() {
		return soCho;
	}

	public void setSoCho(int soCho) {
		this.soCho = soCho;
	}

	@RequiredStringValidator(trim = true, message = "Tỉnh đi không được rỗng!")
	public String getTinhDi() {
		return tinhDi;
	}

	public void setTinhDi(String tinhDi) {
		this.tinhDi = tinhDi;
	}

	@RequiredStringValidator(trim = true, message = "Tỉnh đến không được rỗng!")
	public String getTinhDen() {
		return tinhDen;
	}

	public void setTinhDen(String tinhDen) {
		this.tinhDen = tinhDen;
	}

	@RequiredFieldValidator(message = "Ngày đi không hợp lệ!")
	public Date getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
