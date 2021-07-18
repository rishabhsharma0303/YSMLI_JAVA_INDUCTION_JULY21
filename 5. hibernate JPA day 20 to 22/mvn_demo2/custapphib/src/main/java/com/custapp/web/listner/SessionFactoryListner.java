package com.custapp.web.listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;

import com.custapp.dao.HibernateSessionFactory;

@WebListener
public class SessionFactoryListner implements ServletContextListener {

	private SessionFactory factory;

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("----------SF is created...---------");
		factory = HibernateSessionFactory.getSessionFactory();
		sce.getServletContext().setAttribute("factory", factory);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		if(factory!=null)
		factory.close();
	}

}
