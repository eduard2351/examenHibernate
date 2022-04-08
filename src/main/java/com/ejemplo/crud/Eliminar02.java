package com.ejemplo.crud;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesbd.Estudiante;

public class Eliminar02 {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			System.out.println("ELIMINAR");
			
			// se supone que ya tenemos el ID de estudiante

			int id_est = 4; // ID del estudiante a modificar

			String hql = "DELETE FROM Estudiante WHERE id= :e_id";

			Query consulta = session.createQuery(hql);

			consulta.setParameter("e_id", id_est);
			
			consulta.executeUpdate();	//este metodo devuelve un valor escalar

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

