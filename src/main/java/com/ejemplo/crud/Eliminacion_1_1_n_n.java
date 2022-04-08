package com.ejemplo.crud;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesartificiales.CursadaEstudianteJoin;
import com.ejemplo.entidadesbd.Estudiante;
import com.ejemplo.entidadesbd.Materia;
import com.ejemplo.entidadesbd.MateriaCursada;
import com.ejemplo.entidadesbd.Telefono;
import com.ejemplo.entidadesbd.TelefonoDetalles;

public class Eliminacion_1_1_n_n {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			// Eliminacion normal
			Materia m1 = obtenerMat(session, 100);
			session.delete(m1);

			// ELiminacion 1:1
			Query consulta = session.createQuery("FROM Telefono WHERE id = :id");
			consulta.setParameter("id", 27);
			Telefono f = (Telefono) consulta.uniqueResult();
			session.delete(f);

			// Eliminacion N:N
			Query consulta2 = session.createQuery("FROM Estudiante WHERE id = :id");
			consulta2.setParameter("id", 93);
			Estudiante es = (Estudiante) consulta2.uniqueResult();

			session.delete(es);
			// se van a eliminar registros de materia_cursada_2

			tx.commit();

			System.out.println("EXITO");
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}

	/* obtiene una materia existente de la tabla Materia */
	private static Materia obtenerMat(Session session, int i) {
		Query consulta = session.createQuery("FROM Materia WHERE id= :id");
		consulta.setParameter("id", i);
		return (Materia) consulta.uniqueResult();
	}
}
