package com.vexeonline.action.nhaxe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.dao.TienIchDAO;
import com.vexeonline.dao.TienIchDAOImpl;
import com.vexeonline.dao.UserDAO;
import com.vexeonline.dao.UserDAOImpl;
import com.vexeonline.domain.TienIch;
import com.vexeonline.dto.VehicleDTO;
import com.vexeonline.service.nhaxe.VehicleService;
import com.vexeonline.service.nhaxe.VehicleServiceImpl;
import com.vexeonline.utils.HibernateUtil;

@Namespace(value = "/coachcp")
@ParentPackage(value = "default")
@InterceptorRef(value = "defaultStack", params = {"validation.excludeMethods", "vehicles, saveVehicle, vehicleDetail"})
public class QuanLyXe extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1003544484121846277L;
	
	private static final VehicleService xeService = new VehicleServiceImpl();
	private static final TienIchDAO tienIchDAO = new TienIchDAOImpl();
	private static final UserDAO userDAO = new UserDAOImpl();
	
	private Map<String,Object> session;
	
	private Integer id;
	private List<VehicleDTO> xes = null;
	private VehicleDTO xe = null;
	private List<Integer> maTienIchs = new ArrayList<Integer>();
	private List<TienIch> tienIchs = new ArrayList<TienIch>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Integer> getMaTienIchs() {
		return maTienIchs;
	}

	public void setMaTienIchs(List<Integer> maTienIchs) {
		this.maTienIchs = maTienIchs;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public List<VehicleDTO> getXes() {
		return xes;
	}

	public VehicleDTO getXe() {
		return xe;
	}

	public void setXe(VehicleDTO xe) {
		this.xe = xe;
	}

	public List<TienIch> getTienIchs() {
		return tienIchs;
	}

	public void setTienIchs(List<TienIch> tienIchs) {
		this.tienIchs = tienIchs;
	}

	@Action(value = "vehicles", results = @Result(name = "success", location = "coach.vehicles", type = "tiles"))
	public String showVehiclesPage() {
		/*Transaction tx = null;*/
		try {
			/*tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();*/
			xes = xeService.getVehicles();
			/*tx.commit();*/
		} catch (Exception e) {
			/*if (tx != null) tx.rollback();*/
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "newVehicle",results = {
			@Result(name = "success", location = "coach.newVehicle", type = "tiles")	
	})
	public String showNewVehiclePage() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			tienIchs = tienIchDAO.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value = "saveVehicle", results = {
		@Result(name = "success", location = "vehicles", type = "redirect"),
		@Result(name = "input", location = "coach.newVehicle", type = "tiles")
	})
	public String saveVehicle() {
		
		Transaction tx = null;
		
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			if (xe.getId() != null) {
				xeService.updateVehicle(xe);
			} else {
				Integer userId = (Integer) session.get("userId");
				Integer idNhaXe = userDAO.getUserById(userId).getNhaXe().getIdNhaXe();
				xe.setIdNhaXe(idNhaXe);
				xeService.insertVehicle(xe);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value = "vehicleDetail", results = @Result(name = "success", location = "coach.vehicleDetail", type = "tiles"))
	public String showVehicleDetailPage() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			tienIchs = tienIchDAO.list();
			xe = xeService.getVehicle(id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
