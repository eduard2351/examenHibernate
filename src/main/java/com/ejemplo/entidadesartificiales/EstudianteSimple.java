package com.ejemplo.entidadesartificiales;

public class EstudianteSimple {
	private int id;
	private String apellido;
	
		
	public EstudianteSimple() {
		super();
	}


	public EstudianteSimple(int id, String apellido) {
		super();
		this.id = id;
		this.apellido = apellido;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	
	
}
