package com.vexeonline.action.admin;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.dto.NhaXeDTO;
import com.vexeonline.service.admin.QuanLyNhaXeService;
import com.vexeonline.service.admin.QuanLyNhaXeServiceImpl;
import com.vexeonline.utils.HibernateUtil;

@Namespace(value = "/admincp")
@ParentPackage(value = "default")
public class QuanLyNhaXe extends ActionSupport {
	private static final long serialVersionUID = 4381814030611900241L;

	private static final QuanLyNhaXeService coachService = new QuanLyNhaXeServiceImpl();
	
	private Integer id;
	private NhaXeDTO coach;
	private List<NhaXeDTO> coachs;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public NhaXeDTO getCoach() {
		return coach;
	}

	public void setCoach(NhaXeDTO coach) {
		this.coach = coach;
	}

	public List<NhaXeDTO> getCoachs() {
		return coachs;
	}

	public void setCoachs(List<NhaXeDTO> coachs) {
		this.coachs = coachs;
	}

	@Action(value = "coachs", results = @Result(name = "success", location="admin.coachs", type = "tiles"))
	public String showCoachsPage() {
		Transaction tx = null;
		try {
			tx =  HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			coachs = coachService.listNhaXe();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value = "newCoach", results = @Result(name = "success", location="admin.newCoach", type = "tiles"))
	public String showNewCoachPage() {
		return SUCCESS;
	}
	
	@Action(value = "coachDetail", results = @Result(name = "success", location="admin.newCoach", type = "tiles"))
	public String showCoachDetailPage() {
		Transaction tx = null;
		try {
			tx =  HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			coach = coachService.getById(id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value = "saveCoach", results = @Result(name = "success", location="/admincp/coachs", type = "redirect"))
	public String saveStation() {
		try {
			if (id == null) {
				coachService.addNew(coach);
			} else {
				coachService.editInfo(coach);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
