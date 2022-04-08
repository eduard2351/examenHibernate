package com.ejemplo.crud;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

public class UpdateMuchos_a_Muchos {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();
			

			Estudiante es = obtenerEst(session, 2);
			es.setApellido("ZORRITO");
			Set<Materia>mats=new HashSet<Materia>();
			es.setMaterias(mats);
			
			session.update(es);

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
	
	
	/*obtiene un estudiante existente de la tabla Estudiante*/
	private static Estudiante obtenerEst(Session session, int i) {
		Query consulta = session.createQuery("FROM Estudiante WHERE id= :id");
		consulta.setParameter("id", i);
		return (Estudiante) consulta.uniqueResult();
	}
}
