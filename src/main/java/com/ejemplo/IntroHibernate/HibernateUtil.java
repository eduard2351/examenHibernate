package com.ejemplo.IntroHibernate;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory SESSION_FACTORY = construirSessionFactory();

	private static SessionFactory construirSessionFactory() {
		SessionFactory sf = null;
		try {
			sf=new Configuration().configure().buildSessionFactory();
			System.out.println(sf);
			return sf;
		} catch (Exception e) {
			e.printStackTrace();
			return sf;
		}
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
