package com.ejemplo.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;

public class Select {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			System.out.println("Uso de SELECT");
			List nombres = session.createQuery("SELECT E.nombre FROM Estudiante E").list();
			for (Iterator iterator = nombres.iterator(); iterator.hasNext();) {
				String nombre = (String) iterator.next();
				System.out.println("NOMBRE=" + nombre);
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
