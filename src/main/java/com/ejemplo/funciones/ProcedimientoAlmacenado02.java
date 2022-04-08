package com.ejemplo.funciones;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesartificiales.CursadaEstudianteJoin;
import com.ejemplo.entidadesbd.Estudiante;
import com.ejemplo.entidadesbd.Telefono;

public class ProcedimientoAlmacenado02 {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			/*
			 * para MYSQL
			 * 
			 * 
			 * DELIMITER $$ CREATE PROCEDURE intervalo(menor INTEGER, mayor INTEGER) BEGIN
			 * SELECT * FROM estudiante WHERE id BETWEEN menor AND mayor; END $$ DELIMITER;
			 * 
			 * 
			 * para llamarlo
			 * 
			 * CALL intervalo(1,6);
			 * 
			 * 
			 * en POSTGESQL
			 * 
			 * 
			 * CREATE OR REPLACE FUNCTION intervalo(menor INTEGER, mayor INTEGER) 
			 * RETURNS TABLE (id INT,nombre VARCHAR, apellido VARCHAR) 
			 * AS $$ 
			 * SELECT * FROM estudiante WHERE id>= menor AND id<=mayor $$ 
			 * LANGUAGE SQL;
			 * 
			 * 
			 * 
			 * para llamarlo
			 * 
			 * CALL nombre(); CALL
			 */

//			Esto es para llamar una funcion en MYSQL , aca se usa sql , aca no se pone ;
//			Query consulta = session.createNativeQuery("{CALL intervalo()}",Estudiante.class);

			// Esto es para llmar una funcion en POSTGRES, aca se usa sql,aca no se pone ;
			Query consulta = session.createNativeQuery("SELECT * FROM intervalo(?, ?)", Estudiante.class);
			
			consulta.setParameter(1, 1);
			consulta.setParameter(2, 3);

			List<Estudiante> estudiantes = consulta.getResultList();

			System.out.println("  ID    NOMBRE    APELLIDO");
			for (Estudiante e : estudiantes) {
				System.out.println("E: " + e.getId() + "\t" + e.getNombre() + "\t   " + e.getApellido());
			}

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}
