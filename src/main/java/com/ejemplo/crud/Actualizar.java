package com.ejemplo.crud;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesbd.Estudiante;

public class Actualizar {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			System.out.println("ACTUALIZAR");

			// se supone que ya tenemos el ID de estudiante

			int id_est = 2; // ID del estudiante a modificar

			Estudiante es = session.get(Estudiante.class, id_est);
			es.setApellido("Rocha");

			tx.commit();

			System.out.println("EXITO");

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();

		} finally {
			session.close();
		}
	}
}
