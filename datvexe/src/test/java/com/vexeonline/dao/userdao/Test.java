package com.vexeonline.dao.userdao;

import org.hibernate.Transaction;

import com.vexeonline.dao.UserDAO;
import com.vexeonline.dao.UserDAOImpl;
import com.vexeonline.domain.User;
import com.vexeonline.utils.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAOImpl();
		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		User user = userDAO.get(1);
		tx.commit();
		
		System.out.println(user);
	}
}
