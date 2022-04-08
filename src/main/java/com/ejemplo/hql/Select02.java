package com.ejemplo.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesartificiales.EstudianteSimple;

public class Select02 {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			System.out.println("PROYECCION");

			String hql = "SELECT new com.ejemplo.entidadesartificiales.EstudianteSimple(E.id, E.apellido) "
					+ "FROM Estudiante E ";

			Query consulta = session.createQuery(hql);

			List<EstudianteSimple> estudiantes = consulta.getResultList();

			System.out.println("ID      APELLIDO");
			for (EstudianteSimple ee:estudiantes) {
				System.out.println(ee.getId() + "       " + ee.getApellido());
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
