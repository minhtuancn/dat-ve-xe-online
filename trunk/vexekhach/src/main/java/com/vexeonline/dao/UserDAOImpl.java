package com.vexeonline.dao;

import org.hibernate.Session;

import com.vexeonline.domain.User;
import com.vexeonline.utils.HibernateUtil;

public class UserDAOImpl implements UserDAO {
	private static Session session;

	public User getUserByUserName(String userName) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		User user = (User) session.createQuery("from User where userName = :userName")
				.setString("userName", userName)
				.uniqueResult();
		
		return user;
	}

}
