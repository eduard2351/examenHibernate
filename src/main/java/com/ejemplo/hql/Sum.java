package com.ejemplo.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesartificiales.EstudianteSum;

public class Sum {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			System.out.println("SUM");

			List<EstudianteSum> est7 = session
					.createQuery("SELECT new com.ejemplo.entidadesartificiales.EstudianteSum(E.apellido,SUM(id))"
							+ "FROM Estudiante E GROUP BY apellido")
					.list();

			System.out.println("APELLIDO \tSUM(id)");
			for (EstudianteSum ec : est7) {

				System.out.println(ec.getApellido()+"\t\t "+ec.getSum());
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
