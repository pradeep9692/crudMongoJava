package com.mongo.listener;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mongodb.MongoClient;

@WebListener
public class MongoDBContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		MongoClient mongo = (MongoClient) sce.getServletContext()
							.getAttribute("MONGO_CLIENT");
		mongo.close();
		System.out.println("MongoClient closed successfully");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ServletContext ctx = sce.getServletContext();
			MongoClient mongo = new MongoClient("localhost",27017);
			System.out.println("MongoClient initialized successfully");
			sce.getServletContext().setAttribute("MONGO_CLIENT", mongo);
		} catch (Exception e) {
			throw new RuntimeException("MongoClient init failed");
		}
	}

}
