package com.ejemplo.entidadesbd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia_cursada")
public class MateriaCursada {
	@Id
	@GeneratedValue
	private int id;
	
	//esta es por ser llave foranea
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "est", nullable = false)
	private Estudiante estudiante;
	
	@Column(name = "id_mat", nullable = false)
	private int idMat;
	private float calificacion;
	
	
	/**geter y seter de todos los atributos menos de las llaves foraneas ya q se usaran
	 * las notaciones necesarias ****/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdMat() {
		return idMat;
	}
	public void setIdMat(int idMat) {
		this.idMat = idMat;
	}
	public float getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}


	/************ojo REVISAR INFORMACION ********/
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
}

