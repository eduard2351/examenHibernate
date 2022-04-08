package com.ejemplo.muchosamuchos;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesartificiales.CursadaEstudianteJoin;
import com.ejemplo.entidadesbd.Estudiante;
import com.ejemplo.entidadesbd.Materia;
import com.ejemplo.entidadesbd.MateriaCursada;
import com.ejemplo.entidadesbd.Telefono;

public class AppMuchosAMuchos {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			//SELECT * FROM telefono WHERE id=2;
			String hql = "FROM com.ejemplo.entidadesbd.Estudiante WHERE id= :id";

			Query consulta = session.createQuery(hql);

			consulta.setParameter("id", 2);

			Estudiante est = (Estudiante) consulta.uniqueResult();
			tx.commit();
			
			System.err.printf("Est: %s %s %n",est.getNombre(),est.getApellido());
			
			for (Materia m : est.getMaterias()) {
				System.out.printf("Materia %s: %s %n",
						m.getSigla(),m.getDescripcion());
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}
