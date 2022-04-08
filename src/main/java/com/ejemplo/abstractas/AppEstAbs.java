package com.ejemplo.abstractas;

import com.ejemplo.entidadesbd.Estudiante;

public class AppEstAbs {
	public static void main(String[] args) {

		EstudianteModel em = new EstudianteModel();
		Estudiante est = em.obtener(2);

		System.out.println("est:" + est.getId() + " " + est.getNombre() + " " + est.getApellido());

	}
}
