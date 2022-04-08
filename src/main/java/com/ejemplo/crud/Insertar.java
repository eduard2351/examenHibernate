package com.ejemplo.crud;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesbd.Estudiante;

public class Insertar {
	public static void main(String[] args) {
		Estudiante est = new Estudiante();
		est.setId(6);
		est.setNombre("Teresa");
		est.setApellido("Roca");

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			int respuesta = (int) session.save(est); // este metodo devuelve un objeto para poder castearlo

			tx.commit();

			System.out.println("EXITO");

			System.out.println("Se registro al Estudiante: " + respuesta); // muestra el la respuesta del id de la
																			// transaccion

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}
}
