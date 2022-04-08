package com.ejemplo.consultaunoauno;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesartificiales.CursadaEstudianteJoin;
import com.ejemplo.entidadesbd.Estudiante;
import com.ejemplo.entidadesbd.MateriaCursada;
import com.ejemplo.entidadesbd.Telefono;

public class Enlazada02 {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			// SELECT * FROM estudiante WHERE id=2;
			String hql = "FROM com.ejemplo.entidadesbd.MateriaCursada WHERE id= :id";

			Query consulta = session.createQuery(hql);

			consulta.setParameter("id", 4);

			MateriaCursada mc = (MateriaCursada) consulta.uniqueResult();
			tx.commit();

			System.out.printf("Mat cur %d: %s (%f)%n",
					mc.getId(), mc.getEstudiante().getApellido(), mc.getCalificacion() );

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}
