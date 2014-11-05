package com.vexeonline.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration()
					.configure("hibernate.cfg.xml");

			// apply configuration property settings to
			// StandardServiceRegistryBuilder
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			return configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(
					"configuration hibernate fail !");
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}