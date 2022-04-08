package com.ejemplo.consultas.enlazadas;

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

public class Enlazada {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			// SELECT * FROM estudiante WHERE id=2;
			String hql = "FROM com.ejemplo.entidadesbd.Estudiante WHERE id= :id";

			Query consulta = session.createQuery(hql);

			consulta.setParameter("id", 2);

			Estudiante est = (Estudiante) consulta.uniqueResult();
			tx.commit();

			System.out.println("ID MAT   CALIFICACION         APELLIDO");
			for (MateriaCursada mc : est.getMateriasCursadas()) {
				System.out.println(
						"mat: " + mc.getId() + "\t  " + mc.getCalificacion() + "\t\t-\t" 
				+mc.getEstudiante().getApellido());
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}
