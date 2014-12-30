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
import com.opensymphony.xwork2.validator.annotations.DoubleRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.vexeonline.dto.ThongTinDanhGiaDTO;
import com.vexeonline.service.KhachHangService;
import com.vexeonline.service.KhachHangServiceImpl;

@Namespace(value = "/")
@ParentPackage(value = "default")
@InterceptorRef(value = "defaultStack", params = { "validation.excludeMethods",
		"getListInfoDanhGia" })
@Results({ @Result(name = "input", location = "trips", type = "tiles") })
public class DanhGia extends ActionSupport {
	private static final long serialVersionUID = 8885262333443840202L;
	private static Logger logger = Logger.getLogger(DanhGia.class);
	private static KhachHangService khachHangService = new KhachHangServiceImpl();
	private Date ngayDi;
	private String maVe;
	private String noiDung;
	private float diem;
	private int idNhaXe;
	private List<ThongTinDanhGiaDTO> list;

	@Action(value = "danhgia")
	public void getListChuyenXe() {
		try {
			logger.info("ngayDi = " + ngayDi + " idNhaXe = " + idNhaXe);
			
			khachHangService.danhGiaChuyenXe(ngayDi, maVe, noiDung, diem, idNhaXe);
		} catch (Exception e) {
			logger.error("Error", e);
		}
	}

	@Action(value = "listdanhgia", results = @Result(type = "json", name = SUCCESS, params = {
			"root", "list" }))
	public String getListInfoDanhGia() {
		try {		
			list = khachHangService.getListInfoDanhGiaByNhaXe(idNhaXe);
			logger.info("size of list " + list.size() + " with idNhaXe = " + idNhaXe);
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

	@StringLengthFieldValidator(message = "Mã vé có 8 kí tự!", minLength = "8", maxLength = "8", trim = true)
	public String getMaVe() {
		return maVe;
	}

	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}

	@RequiredStringValidator(message = "Nội dung không được để trống!", trim = true)
	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	@DoubleRangeFieldValidator(message = "Điểm phải từ 0.0 đến 5.0", minInclusive = "0.0", maxInclusive = "5.0")
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

	public List<ThongTinDanhGiaDTO> getList() {
		return list;
	}

	public void setList(List<ThongTinDanhGiaDTO> list) {
		this.list = list;
	}

}