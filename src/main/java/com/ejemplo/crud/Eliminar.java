package com.ejemplo.crud;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesartificiales.EstudianteSimple;
import com.ejemplo.entidadesbd.Estudiante;

public class Eliminar {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			System.out.println("ELIMINAR");

			// se supone que ya tenemos el ID de estudiante

			int id_est = 4; // ID del estudiante a modificar

			Estudiante es = session.get(Estudiante.class, id_est);
			session.delete(es);

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
