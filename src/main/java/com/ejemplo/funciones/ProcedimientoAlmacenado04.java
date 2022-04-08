package com.ejemplo.funciones;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesbd.Estudiante;

import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

public class ProcedimientoAlmacenado04 {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			/// haciendo uso solo de JAKARTA PERSISTENCE
			StoredProcedureQuery spq = session.createStoredProcedureQuery("intervalo", Estudiante.class);

			spq.registerStoredProcedureParameter("menor", Integer.class, ParameterMode.IN);
			spq.registerStoredProcedureParameter("mayor", Integer.class, ParameterMode.IN);

			spq.setParameter("menor", 1);
			spq.setParameter("mayor", 3);

			System.out.println("ID      NOMBRE  APELLIDO");
			List<Estudiante> estudiantes = spq.getResultList();
			for (Estudiante es : estudiantes) {
				System.out.println(es.getId() + "\t" + es.getNombre() + "\t" + es.getApellido());
			}

			/*en el video 01-04-2022 video b 12:00
			 *  muestra como llamar a un procedimiento almacenado en POSTGRES
			 *  debo realizarlo para ver q pasael no lo hizo por flojera
			 *  */
			
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}
