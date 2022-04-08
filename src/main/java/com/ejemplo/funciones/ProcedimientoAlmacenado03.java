package com.ejemplo.funciones;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.hibernate.result.ResultSetOutput;

import com.ejemplo.HibernateUtil;
import com.ejemplo.entidadesartificiales.CursadaEstudianteJoin;
import com.ejemplo.entidadesbd.Estudiante;
import com.ejemplo.entidadesbd.Telefono;

import jakarta.persistence.ParameterMode;

public class ProcedimientoAlmacenado03 {
	public static void main(String[] args) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			tx = session.beginTransaction();

			ProcedureCall pc = session.createStoredProcedureCall("intervalo");

			// registrando los parametros
			pc.registerParameter("menor", Integer.class, ParameterMode.IN);
			pc.registerParameter("mayor", Integer.class, ParameterMode.IN);

			pc.getParameterRegistration("menor").bindValue(1);
			pc.getParameterRegistration("mayor").bindValue(3);

			// creamos las salidas del procedimiento
			ProcedureOutputs po = pc.getOutputs();
			ResultSetOutput rso = (ResultSetOutput) po.getCurrent();

			List resultados = rso.getResultList();

			System.out.println("  ID    NOMBRE    APELLIDO");
			for (int i = 0; i < resultados.size(); i++) {
				Object[] registro = (Object[]) resultados.get(i);
				System.out.println("E: " + registro[0] + "\t" + registro[1] + "\t   " + registro[2]);
			}

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
}
