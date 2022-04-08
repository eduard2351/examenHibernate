package com.ejemplo.entidadesartificiales;

public class CursadaEstudianteJoin {
	private String Nombre;
	private int id;
	private float calificacion;
	
	
	public CursadaEstudianteJoin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CursadaEstudianteJoin(String nombre, int id, float calificacion) {
		super();
		Nombre = nombre;
		this.id = id;
		this.calificacion = calificacion;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getCalificacion() {
		return calificacion;
	}


	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}
	
	
	
}
