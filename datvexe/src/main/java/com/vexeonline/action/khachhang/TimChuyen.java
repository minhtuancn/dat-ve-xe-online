package com.vexeonline.action.khachhang;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.vexeonline.domain.TuyenXe;
import com.vexeonline.service.KhachHangServiceImpl;

@Namespace(value = "/")
@ParentPackage(value = "default")
@InterceptorRef(value = "defaultStack", params = { "validation.excludeMethods",
		"execute" })
@Results({ @Result(name = "input", location = "home", type = "tiles") })
public class TimChuyen extends ActionSupport {
	private static final long serialVersionUID = -1959057596225194512L;
	private static Logger logger = Logger.getLogger(TimChuyen.class);
	private List<TuyenXe> list;
	private int soCho;
	private String tinhDi;
	private String tinhDen;
	private Date ngayDi;

	@Action(value = "timchuyenxe", results = @Result(name = "success", location = "trips", type = "tiles"))
	public String getListChuyenXe() {
		try {
			System.out.println(tinhDi);
			
			list = new KhachHangServiceImpl().getListChuyenXe("Gia Lai", "HCM",
					ngayDi, soCho);

		} catch (Exception e) {
			logger.error("Error", e);
			return ERROR;
		}

		return SUCCESS;
	}

	public List<TuyenXe> getList() {
		return list;
	}

	public void setList(List<TuyenXe> list) {
		this.list = list;
	}

	@IntRangeFieldValidator(message = "Số chỗ phải lớn hơn 0", min = "1", max = "40")
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

}
