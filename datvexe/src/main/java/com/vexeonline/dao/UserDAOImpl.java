package com.vexeonline.dao;

import java.util.List;

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

	public int save(User user) {
		return (int) HibernateUtil.getSessionFactory().getCurrentSession().save(user);
	}

	public void update(User user) {
		HibernateUtil.getSessionFactory().getCurrentSession().update(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession().createQuery("from User").list();
	}

	@Override
	public User getUserById(Integer id) {
		return (User) HibernateUtil.getSessionFactory().getCurrentSession().get(User.class, id);
	}
}
