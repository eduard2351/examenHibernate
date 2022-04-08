package com.ejemplo.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesartificiales.EstudianteCount;

public class Count {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			System.out.println("USO DE COUNT\n");

			
			String hql = "SELECT new com.ejemplo.entidadesartificiales.EstudianteCount(E.apellido, COUNT(*)) "
					+ "FROM Estudiante E GROUP BY apellido";

			Query consulta = session.createQuery(hql);

			List<EstudianteCount> estudiantes = consulta.getResultList();

			System.out.println("APELLIDO \t COUNT");
			for (EstudianteCount ee:estudiantes) {
				System.out.println(ee.getApellido() + "\t\t " + ee.getCount());
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
