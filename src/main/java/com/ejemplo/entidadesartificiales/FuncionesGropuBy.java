package com.ejemplo.entidadesartificiales;

public class FuncionesGropuBy {
	private int id;
	private long conteo;
	private float min, max;
	private double sum, media;

	
	public FuncionesGropuBy() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FuncionesGropuBy(int id, long conteo, float min, float max, double sum, double media) {
		super();
		this.id = id;
		this.conteo = conteo;
		this.min = min;
		this.max = max;
		this.sum = sum;
		this.media = media;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public long getConteo() {
		return conteo;
	}


	public void setConteo(long conteo) {
		this.conteo = conteo;
	}


	public float getMin() {
		return min;
	}


	public void setMin(float min) {
		this.min = min;
	}


	public float getMax() {
		return max;
	}


	public void setMax(float max) {
		this.max = max;
	}


	public double getSum() {
		return sum;
	}


	public void setSum(double sum) {
		this.sum = sum;
	}


	public double getMedia() {
		return media;
	}


	public void setMedia(double media) {
		this.media = media;
	}

	
	
}
