package com.ejemplo.criteriaquery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesartificiales.CursadaEstudianteJoin;
import com.ejemplo.entidadesartificiales.EstudianteSimple;
import com.ejemplo.entidadesartificiales.FuncionesGropuBy;
import com.ejemplo.entidadesbd.Estudiante;
import com.ejemplo.entidadesbd.MateriaCursada;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

public class ConsultaMixta {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<FuncionesGropuBy> consulta = builder.createQuery(FuncionesGropuBy.class);

			Root<MateriaCursada> raiz = consulta.from(MateriaCursada.class);

			//agregando GROUP BY
			consulta.groupBy(raiz.get("estudiante").get("id"));
			
			consulta.select(builder.construct(
					FuncionesGropuBy.class,
					raiz.get("estudiante").get("id"),
					builder.count(raiz.get("id")),
					builder.max(raiz.get("calificacion")),
					builder.min(raiz.get("calificacion")),
					builder.sum(raiz.get("calificacion")),
					builder.avg(raiz.get("calificacion"))					
				));

			System.out.println("ID     COUNT    MAX     MIN    SUM      AVG");
			List<FuncionesGropuBy> estudiantes = session.createQuery(consulta).getResultList();
			for (FuncionesGropuBy es : estudiantes) {
				System.out.println(es.getId() 
						+"\t"+es.getConteo()
						+"\t"+es.getMax()
						+"\t"+es.getMin()
						+"\t"+es.getSum()
						+"\t"+es.getMedia()
						);
			}

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}
