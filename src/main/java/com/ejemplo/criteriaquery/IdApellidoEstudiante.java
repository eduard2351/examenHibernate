package com.ejemplo.criteriaquery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesartificiales.EstudianteSimple;
import com.ejemplo.entidadesbd.Estudiante;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class IdApellidoEstudiante {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<EstudianteSimple> consulta = builder.createQuery(EstudianteSimple.class);

			Root<Estudiante> raiz = consulta.from(Estudiante.class);

			consulta.select(builder.construct(EstudianteSimple.class, raiz.get("id"), raiz.get("apellido")));

			List<EstudianteSimple> estudiantes = session.createQuery(consulta).getResultList();
			for (EstudianteSimple es : estudiantes) {
				System.out.println("Est: " + es.getId() + "\t" + es.getApellido());
			}

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}
