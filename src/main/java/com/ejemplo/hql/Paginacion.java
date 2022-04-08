package com.ejemplo.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesartificiales.EstudianteSimple;
import com.ejemplo.entidadesbd.Estudiante;

public class Paginacion {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			System.out.println("PAGINACION\n");

			String hql ="FROM Estudiante";
						
			Query consulta = session.createQuery(hql);
			
			consulta.setFirstResult(10);
			consulta.setMaxResults(13);

			List resultados = consulta.getResultList();

			System.out.println("ID  NOMBRE   APELLIDO");
			for (Iterator iterator = resultados.iterator(); iterator.hasNext();) {
				Estudiante ee = (Estudiante) iterator.next();
				System.out.println(ee.getId() + " " + ee.getApellido()+ " " + ee.getApellido());
			}


			tx.commit();

			System.out.println("EXITO");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}
