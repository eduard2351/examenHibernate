package com.ejemplo.IntroHibernate;


import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Estudiante est = new Estudiante();
		est.setId(1);
		est.setNombre("Sofia");
		est.setApellido("Roca");

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();
			
			session.save(est);	//INSERT  -> estudiante

			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
