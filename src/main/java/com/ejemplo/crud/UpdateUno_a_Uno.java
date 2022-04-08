package com.ejemplo.crud;

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
import com.ejemplo.entidadesbd.TelefonoDetalles;

public class UpdateUno_a_Uno {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			// SELECT * FROM telefono WHERE id=2;
			String hql = "FROM com.ejemplo.entidadesbd.Telefono WHERE id= :id";

			Query consulta = session.createQuery(hql);

			consulta.setParameter("id", 2);

			Telefono t = (Telefono) consulta.uniqueResult();
			t.setNumero(67874541);
			TelefonoDetalles td = t.getTelefonoDetalles();
			td.setProveedor("TIGO");
			//esto por si acaso (revisar en pruebas)
			t.setTelefonoDetalles(td);
			
			session.update(t);

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}
