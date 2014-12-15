package com.vexeonline.action.khachhang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.vexeonline.domain.RoleOfUser;
import com.vexeonline.domain.TuyenXe;
import com.vexeonline.service.KhachHangServiceImpl;
import com.vexeonline.utils.HibernateUtil;

@Namespace(value = "/")
@ParentPackage(value = "default")
@InterceptorRef(value = "defaultStack", params = { "validation.excludeMethods",
		"execute" })
@Results({ @Result(name = "input", location = "home", type = "tiles") })
public class TimChuyen extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = -1959057596225194512L;
	private static Logger logger = Logger.getLogger(TimChuyen.class);
	
	private Map<String, Object> session;
	
	private List<TuyenXe> list;
	private int soCho;
	private String tinhDi;
	private String tinhDen;
	private Date ngayDi;

	@Action(value = "timchuyenxe", results = {
			@Result(name = "guest", location = "trips", type = "tiles"),
			@Result(name = "coach", location = "coach.trip", type = "tiles")
	})
	public String getListChuyenXe() {
		String result = "guest";
		try { 
			list = new KhachHangServiceImpl().getListChuyenXe(tinhDi, tinhDen, ngayDi, soCho);
			RoleOfUser role = (RoleOfUser) session.get("role");
			if (role != null) result = "coach";
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return result;
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public static void main(String[] args) throws ParseException {
		TimChuyen timChuyen = new TimChuyen();
		
		timChuyen.setTinhDi("Gia Lai");
		timChuyen.setTinhDen("Hồ Chí Minh");
		timChuyen.setNgayDi(new SimpleDateFormat("dd/MM/yyyy").parse("15/12/2014"));
		
		System.out.println(timChuyen.getNgayDi());
		
		timChuyen.getListChuyenXe();
		
		for (TuyenXe tuyenXe : timChuyen.getList()) {
			System.out.println(tuyenXe);
		}
		
		HibernateUtil.close();
	}
}
