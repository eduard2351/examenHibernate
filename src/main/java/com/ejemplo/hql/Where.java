package com.ejemplo.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesbd.Estudiante;

public class Where {
	public static void main(String[] args) {
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			System.out.println("USO DE WHERE");
			
			// USO de WHERE
			List est1 = session.createQuery("FROM Estudiante E WHERE E.id=2").list();
			for (Iterator iterador = est1.iterator(); iterador.hasNext();) {
				Estudiante es = (Estudiante) iterador.next();

				System.out.println("ID: " + es.getId() + ", " + es.getNombre() + ", " + es.getApellido());
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
