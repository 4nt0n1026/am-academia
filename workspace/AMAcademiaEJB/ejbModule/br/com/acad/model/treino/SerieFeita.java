package br.com.acad.model.treino;

import java.io.Serializable;
import java.util.Calendar;

@SuppressWarnings("serial")
public class SerieFeita implements Serializable {

	private int id;
	
	private double pesoUsado;
	
	private Calendar data;
	
	//private Aluno aluno;
	
	private Serie serie;
	
	
	public SerieFeita(){}


	public SerieFeita(int id, double pesoUsado, Calendar data, Serie serie) {
		super();
		this.id = id;
		this.pesoUsado = pesoUsado;
		this.data = data;
		this.serie = serie;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getPesoUsado() {
		return pesoUsado;
	}


	public void setPesoUsado(double pesoUsado) {
		this.pesoUsado = pesoUsado;
	}


	public Calendar getData() {
		return data;
	}


	public void setData(Calendar data) {
		this.data = data;
	}


	public Serie getSerie() {
		return serie;
	}


	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	
	
}
