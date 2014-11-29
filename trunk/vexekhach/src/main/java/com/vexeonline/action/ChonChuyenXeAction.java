package com.vexeonline.action;

import java.sql.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.domain.TuyenXe;
import com.vexeonline.service.KhachHangServiceImpl;

@Namespace(value = "/")
@ParentPackage(value = "default")
public class ChonChuyenXeAction extends ActionSupport {
	private static final long serialVersionUID = -1959057596225194512L;
	private List<TuyenXe> list;

	@Action(value = "listchuyenxe", results = @Result(name = "success", location = "xxx", type = "tiles"))
	public String getListChuyenXe() {
		try {

			list = new KhachHangServiceImpl().getListChuyenXe("Gia Lai",
					"Ho Chi Minh", Date.valueOf("2014-11-11"));

		} catch (Exception e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		ServletActionContext.getContext().getApplication()
				.get("sessionFactory");
		return SUCCESS;
	}

	public List<TuyenXe> getList() {
		return list;
	}

	public void setList(List<TuyenXe> list) {
		this.list = list;
	}

}
