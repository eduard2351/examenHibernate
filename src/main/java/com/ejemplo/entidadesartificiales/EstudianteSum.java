package com.ejemplo.entidadesartificiales;

public class EstudianteSum extends EstudianteSimple {
	private long sum;

	public EstudianteSum(String apellido, long sum) {
		this.setApellido(apellido);
		this.sum = sum;
	}

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}
	
	

}
