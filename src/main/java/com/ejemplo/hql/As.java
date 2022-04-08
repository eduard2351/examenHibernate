package com.ejemplo.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesbd.Estudiante;

public class As {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();
			
			System.out.println("uso de  AS");
			
			// Existe la posibilidad de renombrar la clase como en SQL
			 List estudiantes = session.createQuery("FROM Estudiante AS E").list();
			//
			
			for (Iterator iterador = estudiantes.iterator(); iterador.hasNext();) {
				Estudiante es = (Estudiante) iterador.next();

				System.out.println("ID: " + es.getId() + ", " + es.getNombre() + ", " + es.getApellido());
			}
			System.out.println();
			System.out.println("Forma 2");
			// o verificar si solo es en POSGRESQL esta forma de renombrar directamente
			List estudiantes2 = session.createQuery("FROM Estudiante E").list();

			for (Iterator iterador = estudiantes2.iterator(); iterador.hasNext();) {
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
