package com.ejemplo.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;

public class Avg {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			System.out.println("Uso de AVG");
			List avg = session.createQuery("SELECT AVG(id) FROM Estudiante ").list();
			for (Iterator iterator = avg.iterator(); iterator.hasNext();) {
				double nombre = (double) iterator.next();
				System.out.println( nombre);
			}

						
			tx.commit();

			System.out.println("EXITO");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}
