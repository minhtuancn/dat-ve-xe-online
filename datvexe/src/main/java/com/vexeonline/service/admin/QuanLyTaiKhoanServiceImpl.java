package com.vexeonline.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vexeonline.dao.NhaXeDAO;
import com.vexeonline.dao.NhaXeDAOImpl;
import com.vexeonline.dao.UserDAO;
import com.vexeonline.dao.UserDAOImpl;
import com.vexeonline.domain.NhaXe;
import com.vexeonline.domain.RoleOfUser;
import com.vexeonline.domain.User;
import com.vexeonline.dto.NhaXeDTO;
import com.vexeonline.dto.UserDTO;
import com.vexeonline.utils.HibernateUtil;
import com.vexeonline.utils.SendEmail;

public class QuanLyTaiKhoanServiceImpl implements QuanLyTaiKhoanService {
	private static Logger logger = Logger.getLogger(QuanLyTaiKhoanServiceImpl.class);
	private static UserDAO userDAO = new UserDAOImpl();
	private static NhaXeDAO nhaXeDAO = new NhaXeDAOImpl();
	@Override
	public List<UserDTO> listUser() {
		List<UserDTO> listData = new ArrayList<UserDTO>(0);
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			
			List<User> list = userDAO.list();
			UserDTO user = null;
			for (User row : list) {
				user = new UserDTO();
				user.setId(row.getIdUser());
				user.setRole(row.getRole().toString());
				user.setUserName(row.getUserName());
				if (user.getRole().equals(RoleOfUser.NHAXE.toString())) {
					user.setNhaXeId(row.getNhaXe().getIdNhaXe());
					user.setTenNhaXe(row.getNhaXe().getTenNhaXe());
				} else {
					user.setNhaXeId(null);
					user.setTenNhaXe("");
				}
				user.setActive(row.isActive());
				user.setEmail(row.getEmail());
				listData.add(user);
			}
			
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return listData;
	}
	
	@Override
	public void addNew(UserDTO userDTO)  {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			User user = new User();
			user.setActive(userDTO.getActive());
			if (userDTO.getRole().equals(RoleOfUser.NHAXE.toString())) {
				user.setNhaXe((NhaXe) session.load(NhaXe.class, userDTO.getNhaXeId()));
			}
			user.setEmail(userDTO.getEmail());
			user.setPassword("randompassword"); //TODO
			if (userDTO.getRole().equals("NHAXE")) {
				user.setRole(RoleOfUser.NHAXE);
			} else if (userDTO.getRole().equals("ADMIN")){
				user.setRole(RoleOfUser.ADMIN);
			}
			user.setUserName(userDTO.getUserName());
			session.save(user);
			
			SendEmail.sendEmail(userDTO.getEmail(), "Mật khảu đăng nhập website datvexe online", 
					"<h3>Hãy sử dụng mật khẩu bên dưới để đăng nhập vào website đặt vé xe online</h3>"
					+ "<p>Mật khẩu của bạn là : </p>" + user.getPassword() + "<br/><i>Cảm ơn bạn!</i>");
			
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
	}

	@Override
	public void update(UserDTO userDTO) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			
			User user = (User) session.load(User.class, userDTO.getId());
			user.setActive(userDTO.getActive());
			if (userDTO.getRole().equals(RoleOfUser.NHAXE.toString())) {
				user.setNhaXe((NhaXe) session.load(NhaXe.class, userDTO.getNhaXeId()));
			}
			user.setEmail(userDTO.getEmail());
			if (userDTO.getRole().equals("NHAXE")) {
				user.setRole(RoleOfUser.NHAXE);
			} else if (userDTO.getRole().equals("ADMIN")){
				user.setRole(RoleOfUser.ADMIN);
			}
			session.update(user);
			
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
			
	}

	@Override
	public UserDTO getById(Integer idUser) {
		UserDTO result = null;
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			
			User user = (User) session.get(User.class, idUser);
			result = new UserDTO();
			result.setActive(user.isActive());
			result.setEmail(user.getEmail());
			if (user.getRole().equals(RoleOfUser.NHAXE)) {
				result.setNhaXeId(user.getNhaXe().getIdNhaXe());
				result.setTenNhaXe(user.getNhaXe().getTenNhaXe());
			} else {
				result.setNhaXeId(null);
				result.setTenNhaXe("");
			}
			result.setId(user.getIdUser());
			result.setRole(user.getRole().toString());
			result.setUserName(user.getUserName());
			result.setEmail(user.getEmail());
			
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		
		return result;
	}

	@Override
	public List<NhaXeDTO> listTenNhaXe() {
		List<NhaXeDTO> listData = new ArrayList<NhaXeDTO>(0);
		listData.add(new NhaXeDTO());
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			List<Object[]> list = nhaXeDAO.listTenNhaXe();
			NhaXeDTO nhaXe = null;
			for (Object[] row : list) {
				nhaXe = new NhaXeDTO();
				nhaXe.setId((Integer) row[0]);
				nhaXe.setName((String) row[1]);
				listData.add(nhaXe);
			}
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		} 
		return listData;
	}
}
