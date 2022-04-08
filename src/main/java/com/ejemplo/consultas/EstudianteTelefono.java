package com.ejemplo.consultas;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesbd.Estudiante;
import com.ejemplo.entidadesbd.Telefono;

public class EstudianteTelefono {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			String hql = "FROM com.ejemplo.entidadesbd.Estudiante WHERE id=1";

			Query consulta = session.createQuery(hql);

			Estudiante es = (Estudiante) consulta.uniqueResult();

			System.out.println("Datos:\n" + es.getNombre() + " " + es.getApellido());
			for (Iterator iterator = es.getTelefonos().iterator(); iterator.hasNext();) {
				Telefono telf = (Telefono) iterator.next();
				System.out.println("Telf: " + telf.getNumero());

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


