package com.ejemplo.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesbd.Estudiante;

public class GroupBy {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			System.out.println("GROUP BY");
			//SELECT apellido COUNT(*) FROM Estudiante GROUP BY apellido---averiguar como usar
			List est6 = session.createQuery("SELECT apellido FROM Estudiante GROUP BY apellido").list();

			for (Iterator iterador = est6.iterator(); iterador.hasNext();) {
				
				String apellido = (String) iterador.next();
				System.out.println("Apellido=" + apellido);
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
