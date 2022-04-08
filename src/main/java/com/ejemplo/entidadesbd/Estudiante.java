package com.ejemplo.entidadesbd;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

@Entity
public class Estudiante {

	@Id
	private int id;
	private String nombre;
	private String apellido;

	/**/
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante", targetEntity = Telefono.class)
	private Set telefonos;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante", targetEntity = MateriaCursada.class)
	private Set<MateriaCursada> materiasCursadas;
	
//	/**Agregamos este atribito para usar Relacion N x M ***/
//	@JoinTable(
//			//para insert se usa Tabla materia_cursada_2, y para consultas  materia_cursada 
//			name = "materia_cursada_2",//se pone la tabla q este de intermediaria en la BD
//			catalog="abc123",	//para hacer enlace entre Estudiantes y Materia (nombre cualquiera)
//			joinColumns= {
//					@JoinColumn(name = "est", nullable = false, updatable = false), //se introduce columna de union--aclarando que se unira al campo est
//			},
//			
//			inverseJoinColumns= {
//					@JoinColumn(name = "id_mat", nullable = false, updatable = false), //se introduce columna de union--aclarando que se unira al campo id_mat
//			}
//			
//			)
//	private Set<Materia> materias; 
	
	
	

	/*En este caso si tiene que tener todos los getter y setter de todos los atributos */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/************/
	public Set getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Set telefonos) {
		this.telefonos = telefonos;
	}

	/************/
	public Set<MateriaCursada> getMateriasCursadas() {
		return materiasCursadas;
	}

	public void setMateriasCursadas(Set<MateriaCursada> materiasCursadas) {
		this.materiasCursadas = materiasCursadas;
	}

	/***********/
//	public Set<Materia> getMaterias() {
//		return materias;
//	}
//
//	public void setMaterias(Set<Materia> materias) {
//		this.materias = materias;
//	}
	
	

	
}
