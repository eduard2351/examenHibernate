package com.ejemplo.entidadesartificiales;

public class EstudianteCount extends EstudianteSimple {
	private long count;

	public EstudianteCount(String apellido, long count) {
		this.setApellido(apellido);
		this.count = count;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
	
	

}
