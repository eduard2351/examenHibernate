package com.ejemplo.criteriaquery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesbd.Estudiante;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class CriterialQuery02 {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			/* este ejemplo es similar a select * from estudiante where id entre 1 a 3 */

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Estudiante> consulta = builder.createQuery(Estudiante.class);

			Root<Estudiante> raiz = consulta.from(Estudiante.class);

			//aca le dice que sea mayor igual a 2
			consulta.select(raiz).where(builder.ge(raiz.get("id"), 2));

			
			List<Estudiante> estudiantes = session.createQuery(consulta).getResultList();
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
