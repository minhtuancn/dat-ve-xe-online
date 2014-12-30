package com.vexeonline.service.admin.quanlydanhgiaservice;

import java.util.List;

import org.hibernate.Transaction;

import com.vexeonline.dto.UserDTO;
import com.vexeonline.service.UserService;
import com.vexeonline.service.UserServiceImpl;
import com.vexeonline.utils.HibernateUtil;

public class UserServiceTest {
	
	private static final UserService service = new UserServiceImpl();
	
	public static void list() throws Exception {
		List<UserDTO> users = service.getUsers();
		for (UserDTO user : users) {
			System.out.println(user);
		}
	}
	
	public static void get() throws Exception {
		UserDTO user = service.getUser("hungdq", "12345");
		System.out.println(user);
	}
	
	public static void insert() throws Exception {
		/*UserDTO user1 = new UserDTO(null, 1, "user00", "user00", false, "NHAXE");
		service.insertUser(user1);*/
		
		UserDTO user2 = new UserDTO(null, 1, "user02", "user02", false, "NHAXE");
		service.insertUser(user2);
		
		UserDTO user3 = new UserDTO(null, 2, "user03", "user03", true, "NHAXE");
		service.insertUser(user3);
		
		UserDTO user4 = new UserDTO(null, 1, "user04", "user04", true, "NHAXE");
		service.insertUser(user4);
		
		UserDTO user5 = new UserDTO(null, 2, "user05", "user05", false, "NHAXE");
		service.insertUser(user5);
	}
	
	public static void update() throws Exception {
		/*UserDTO user3 = service.getUser(3);
		user3.setActive(true);
		service.updateUser(user3);*/
		
		UserDTO user5 = service.getUser(5);
		user5.setActive(true);
		service.updateUser(user5);
		
		UserDTO user7 = service.getUser(7);
		user7.setActive(true);
		service.updateUser(user7);
	}
	
	public static void main(String[] args) {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			//insert();
			update();
			list();
			//get();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		
		HibernateUtil.close();
	}
}
