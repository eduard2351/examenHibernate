package com.ejemplo.entidadesbd;

import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Materia {
	@Id
	@GenericGenerator(name = "genMat",	//nombre inventado
		strategy =	"com.ejemplo.generarId.GeneradorMateria"//referencia a la clase q genera el ID 
			)	//Para usar el generador de Id q realizamos
	@GeneratedValue(generator = "genMat")
	private int id;
	
	private String sigla, descripcion;

	/* anotaciones para la relacion MUCHOS A MUCHOS */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			// para insert se usa Tabla materia_cursada_2, y para consultas materia_cursada
			name = "materia_cursada_2", // se pone la tabla q este de intermediaria en la BD
			catalog = "abc123", // para hacer enlace entre Estudiantes y Materia (nombre cualquiera)
			joinColumns = { @JoinColumn(name = "id_mat", nullable = false, updatable = false), // se introduce columna
																								// de union--aclarando
																								// que se unira al campo
																								// id_mat
			},

			inverseJoinColumns = { @JoinColumn(name = "est", nullable = false, updatable = false), // se introduce
																									// columna de
																									// union--aclarando
																									// que se unira al
																									// campo est
			}

	)
	private Set<Estudiante> estudiantes;

	/********************/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Set<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

}
