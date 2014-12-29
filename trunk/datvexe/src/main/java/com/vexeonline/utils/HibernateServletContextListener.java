package com.vexeonline.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class HibernateServletContextListener implements ServletContextListener {
	
	public void contextDestroyed(ServletContextEvent servletContext) {
		HibernateUtil.getSessionFactory().close();
		HibernateUtil.close();
	}

	public void contextInitialized(ServletContextEvent servletContext) {
		HibernateUtil.getSessionFactory();
	}
}
