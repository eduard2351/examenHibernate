package com.ejemplo.criteriaquery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesbd.Estudiante;

import jakarta.persistence.criteria.CriteriaQuery;

public class CriterialQuery {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			/*este ejemplo es similar a select * from estudiante */
			CriteriaQuery<Estudiante> cq = session.getCriteriaBuilder().createQuery(Estudiante.class);

			cq.from(Estudiante.class);
			List<Estudiante> estudiantes = session.createQuery(cq).getResultList();
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
