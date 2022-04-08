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

public class InsertMuchos_a_Muchos {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			Estudiante es = new Estudiante();
			es.setId(300);
			es.setNombre("PEPE");
			es.setApellido("PEPE");
			Set<Materia> mats = new HashSet<Materia>();
			mats.add(obtenerMat(session, 10));
			mats.add(obtenerMat(session, 20));
			mats.add(obtenerMat(session, 30));

//			es.setMaterias(mats);
			
			session.save(es);

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
	
	
	/*obtiene una materia existente de la tabla Materia*/
	private static Materia obtenerMat(Session session, int i) {
		Query consulta = session.createQuery("FROM Materia WHERE id= :id");
		consulta.setParameter("id", i);
		return (Materia) consulta.uniqueResult();
	}
}
