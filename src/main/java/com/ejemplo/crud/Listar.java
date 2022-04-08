package com.ejemplo.crud;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesbd.Estudiante;

public class Listar {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			System.out.println("LISTAR");
			
			// HQL lenguaje de consulta a objetos propio de HIBERNATE
			List estudiantes = session.createQuery("FROM Estudiante").list();
			
			for (Iterator iterador = estudiantes.iterator(); iterador.hasNext();) {
				Estudiante es = (Estudiante) iterador.next();

				System.out.println("ID: " + es.getId() + ", " + es.getNombre() + ", " + es.getApellido());
			}

			System.out.println();
			System.out.println("FORMA 2: ");
			
			// podemos usar la clase usando su direccion completa
			List estudiantes2 = session.createQuery("FROM com.ejemplo.entidadesbd.Estudiante").list();

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
