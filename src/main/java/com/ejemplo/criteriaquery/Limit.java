package com.ejemplo.criteriaquery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesbd.Estudiante;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class Limit {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			
			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Estudiante> consulta = builder.createQuery(Estudiante.class);

			Root<Estudiante> raiz = consulta.from(Estudiante.class);

			consulta.select(raiz).orderBy(builder.desc(raiz.get("apellido")));

			
			List<Estudiante> estudiantes = session.createQuery(consulta).setMaxResults(2).getResultList();
			for (Estudiante es : estudiantes) {
				System.out.println("Est: " + es.getApellido());
			}

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}
