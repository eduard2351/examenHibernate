package com.ejemplo.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesbd.Estudiante;

public class OrderBy {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			System.out.println("ORDER BY");

			List est3 = session.createQuery("FROM Estudiante E ORDER BY E.apellido").list();

			for (Iterator iterador = est3.iterator(); iterador.hasNext();) {
				Estudiante es = (Estudiante) iterador.next();

				System.out.println("ID: " + es.getId() + ", " + es.getNombre() + ", " + es.getApellido());
			}
			System.out.println();
			System.out.println("ORDER BY-DESC");

			List est4 = session.createQuery("FROM Estudiante E ORDER BY E.apellido DESC").list();

			for (Iterator iterador = est4.iterator(); iterador.hasNext();) {
				Estudiante es = (Estudiante) iterador.next();

				System.out.println("ID: " + es.getId() + ", " + es.getNombre() + ", " + es.getApellido());
			}
			System.out.println();
			System.out.println("ORDER BY -DESC en 2 campos");
			
			List est5 = session.createQuery("FROM Estudiante E ORDER BY E.apellido , E.nombre DESC").list();

			for (Iterator iterador = est5.iterator(); iterador.hasNext();) {
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
