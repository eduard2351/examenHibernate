package com.ejemplo.generarId;

import com.ejemplo.abstractas.MateriaModel;
import com.ejemplo.entidadesbd.Estudiante;
import com.ejemplo.entidadesbd.Materia;

public class AppMatGenId {
	public static void main(String[] args) {

		MateriaModel mm = new MateriaModel();
		Materia mat=new Materia();
		mat.setSigla("A2");
		mat.setDescripcion("qqqqqqqqqqqqqq facil y divertida");
		mm.crear(mat);
	}
}
