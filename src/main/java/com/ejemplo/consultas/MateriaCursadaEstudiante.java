package com.ejemplo.consultas;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesartificiales.CursadaEstudianteJoin;
import com.ejemplo.entidadesbd.Estudiante;
import com.ejemplo.entidadesbd.Telefono;

public class MateriaCursadaEstudiante {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			/**
			 * SELECT e.nombre, m.id,m.calificacion 
			 * FROM materia_cursada m 
			 * INNER JOIN estudiante e 
			 * ON e.id=m.est;
			 */
			String hql = "SELECT new com.ejemplo.entidadesartificiales.CursadaEstudianteJoin("
					+ "M.estudiante.nombre, M.id, M.calificacion) " 
			 + "FROM MateriaCursada M, Estudiante E "
			 + "WHERE M.estudiante = E";

			Query consulta = session.createQuery(hql);
			
			List<CursadaEstudianteJoin> cej=consulta.getResultList();
			
			System.out.println("NOMBRE  ID  CALIFICACION" );
			for (CursadaEstudianteJoin c : cej) {
				System.out.println(c.getNombre()+"\t"+c.getId()+"\t"+c.getCalificacion());
			}
			
			tx.commit();


		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}

/*
 * para MYSQL
 * 
 * 
 * DELIMITER $$
 * CREATE PROCEDURE nombre(IN param INTEGER)
 * BEGIN
 * .......
 * END $$
 * DELIMITER;
 * 
 * 
 * para llamarlo
 * 
 * CALL nombre(66);
 * 
 * 
 * en POSTGESQL
 * 
 * 
 * CREATE OR REPLACE 
 * PROCEDURE nombre()
 * LANGUAGE SQL
 * AS $$
 * SELECT * FROM materia_cursada;
 * $$
 * ;
 * CREATE PROCEDURE
 * 
 * 
 * para llamarlo
 * 
 * CALL nombre();
 * CALL
 * */
