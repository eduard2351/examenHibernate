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

public class Max {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Number> consulta = builder.createQuery(Number.class);

			Root<MateriaCursada> raiz = consulta.from(MateriaCursada.class);

			//SELECT MAX(calificacion) FROM materia_cursada;
			consulta.select(builder.max(raiz.get("calificacion")));

			Number valor = session.createQuery(consulta).getSingleResult();

			System.out.println("Max:" + valor);

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}
