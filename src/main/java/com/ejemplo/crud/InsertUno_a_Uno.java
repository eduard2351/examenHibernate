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

public class InsertUno_a_Uno {
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
			TelefonoDetalles td=new TelefonoDetalles();
			
			//insertamos un nuevo telefono detalles
			td.setProveedor("VIVA");
			td.setTipo("personal");
			td.setPropietario("XX YY");
			
			//insertamos un nuevo telefono
			Telefono t = new Telefono();
			t.setEstudiante(est);
			t.setNumero(771);
			
			//esto por relacion UNO a UNO
			t.setTelefonoDetalles(td);
			td.setTelf(t);
			
			//ahora se guarda el registro
			session.save(t);
			
			System.out.println("EXITO");
			
			tx.commit();
			
			

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}
