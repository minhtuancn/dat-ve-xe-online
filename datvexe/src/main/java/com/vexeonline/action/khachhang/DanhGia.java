package com.vexeonline.action.khachhang;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DoubleRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.vexeonline.dto.ThongTinDanhGia;
import com.vexeonline.service.KhachHangService;
import com.vexeonline.service.KhachHangServiceImpl;

@Namespace(value = "/")
@ParentPackage(value = "default")
@Results({ @Result(name = "input", location = "trips", type = "tiles") })
public class DanhGia extends ActionSupport {
	private static final long serialVersionUID = 8885262333443840202L;
	private static Logger logger = Logger.getLogger(DanhGia.class);
	private static KhachHangService khachHangService = new KhachHangServiceImpl();
	private Date ngayDi;
	private String sdt;
	private String noiDung;
	private float diem;
	private int idNhaXe;
	private List<ThongTinDanhGia> list;

	@Action(value = "danhgia")
	public void getListChuyenXe() {
		try {
			khachHangService.danhGiaChuyenXe(ngayDi, sdt, noiDung, diem);
		} catch (Exception e) {
			logger.error("Error", e);
		}
	}

	@Action(value = "listdanhgia", results = @Result(type = "json", name = SUCCESS, params = {"root", "list" }))
	public String getListInfoDanhGia() {
		try {
			System.out.println(idNhaXe); 
			list = khachHangService.getListInfoDanhGiaByNhaXe(idNhaXe);
			
		} catch (Exception e) {
			logger.error("Error", e);
		}
		
		return SUCCESS;
	}

	@RequiredFieldValidator(message = "Ngày đi không hợp lệ!")
	public Date getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}

	@StringLengthFieldValidator(message = "SĐT phải có độ dài 10 hoặc 11 số", minLength = "10", maxLength = "11", trim = true)
	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	@RequiredStringValidator(message = "Nội dung đánh giá là cần thiết", trim = true)
	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	@DoubleRangeFieldValidator(message = "Điểm phải có giá trị từ 0.0 đến 5.0", minInclusive = "0.0", maxInclusive = "5.0")
	public float getDiem() {
		return diem;
	}

	public void setDiem(float diem) {
		this.diem = diem;
	}

	public int getIdNhaXe() {
		return idNhaXe;
	}

	public void setIdNhaXe(int idNhaXe) {
		this.idNhaXe = idNhaXe;
	}

	public List<ThongTinDanhGia> getList() {
		return list;
	}

	public void setList(List<ThongTinDanhGia> list) {
		this.list = list;
	}

}