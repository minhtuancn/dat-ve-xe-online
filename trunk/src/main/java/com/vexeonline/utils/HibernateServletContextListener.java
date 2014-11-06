package com.vexeonline.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateServletContextListener implements ServletContextListener {
	
	public void contextDestroyed(ServletContextEvent servletContext) {
		SessionFactory sf = (SessionFactory) servletContext.getServletContext().getAttribute("sessionFactory");
		
		sf.close();
	}

	public void contextInitialized(ServletContextEvent servletContext) {
		try {
   		 	Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            
            //apply configuration property settings to StandardServiceRegistryBuilder
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
            									.applySettings(configuration.getProperties()).build(); 
            SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
            
            servletContext.getServletContext().setAttribute("sessionFactory", sf);
        }
        catch (Throwable ex) {
            throw new ExceptionInInitializerError("Hibernate khoi tao that bai");
        }
	}
}
