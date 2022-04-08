package com.ejemplo.entidadesbd;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Telefono {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//se puede poner esta notacion ya q es un valor autoincremental
	private int id;
	private int numero;

	
	//se crea un objeto estudiante en lugar del campo en la tabla(id_est) directamente
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_est")
	private Estudiante estudiante;
	
	
	@OneToOne(fetch = FetchType.LAZY, targetEntity = TelefonoDetalles.class,
			mappedBy = "telf", //atributo q se declaro del objeto TELEFONODETALLES
			cascade = CascadeType.ALL	//es para cuando se quiera guardar un telefono, entonces se actualice TELEFONO DETALLES
			)	
	private TelefonoDetalles telefonoDetalles;
	
	
	
	/*todos tendran getter and setter menos El Objeto estudiante o depende de la estructura necesaria*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	
	public TelefonoDetalles getTelefonoDetalles() {
		return telefonoDetalles;
	}
	public void setTelefonoDetalles(TelefonoDetalles telefonoDetalles) {
		this.telefonoDetalles = telefonoDetalles;
	}
	
	
}
