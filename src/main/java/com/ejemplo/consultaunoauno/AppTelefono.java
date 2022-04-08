package com.ejemplo.consultaunoauno;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesartificiales.CursadaEstudianteJoin;
import com.ejemplo.entidadesbd.Estudiante;
import com.ejemplo.entidadesbd.MateriaCursada;
import com.ejemplo.entidadesbd.Telefono;

public class AppTelefono {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			//SELECT * FROM telefono WHERE id=2;
			String hql = "FROM com.ejemplo.entidadesbd.Telefono WHERE id= :id";

			Query consulta = session.createQuery(hql);

			consulta.setParameter("id", 2);

			Telefono t = (Telefono) consulta.uniqueResult();
			tx.commit();
			
			System.out.println("ID   NUMERO   PROVEEDOR");
			System.out.printf("t: %d:   %d     (%s) %n",
					t.getId(),t.getNumero() ,t.getTelefonoDetalles().getProveedor());

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}
