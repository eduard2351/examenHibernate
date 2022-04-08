package com.ejemplo.criteriaquery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesartificiales.CursadaEstudianteJoin;
import com.ejemplo.entidadesartificiales.EstudianteSimple;
import com.ejemplo.entidadesbd.Estudiante;
import com.ejemplo.entidadesbd.MateriaCursada;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

public class InnerJoin {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<CursadaEstudianteJoin> consulta = builder.createQuery(CursadaEstudianteJoin.class);

			Root<MateriaCursada> raiz = consulta.from(MateriaCursada.class);

			//se realiza el join
			raiz.join("estudiante",JoinType.INNER);
			
			consulta.select(builder.construct(
					CursadaEstudianteJoin.class,
					raiz.get("estudiante").get("nombre"),
					raiz.get("id"), 
					raiz.get("calificacion")
				));

			System.out.println("ID     NOMBRE   CALIFICACION");
			List<CursadaEstudianteJoin> estudiantes = session.createQuery(consulta).getResultList();
			for (CursadaEstudianteJoin es : estudiantes) {
				System.out.println(es.getId() + "\t" + es.getNombre()+"\t"+es.getCalificacion());
			}

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}
