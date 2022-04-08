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

public class ProcedimientoAlmacenado {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

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
			

//			Esto es para llamar una funcion en MYSQL , aca se usa sql , aca no se pone ;
//			Query consulta = session.createNativeQuery("{CALL prueba()}",Estudiante.class);

			//Esto es para llmar una funcion en POSTGRES, aca se usa sql,aca no se pone ;
			Query consulta = session.createNativeQuery("SELECT * FROM prueba()", Estudiante.class);
			
			
			List<Estudiante> estudiantes = consulta.getResultList();
			
			System.out.println("  ID    NOMBRE    APELLIDO" );
			for (Estudiante e : estudiantes ) {
				System.out.println("E: "+e.getId()+"\t"+e.getNombre()+"\t   "+e.getApellido());
			}
			
			tx.commit();


		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}


