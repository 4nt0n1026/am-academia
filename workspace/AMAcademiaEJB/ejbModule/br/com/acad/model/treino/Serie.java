package br.com.acad.model.treino;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Serie implements Serializable{

	private int id;
	
	private int numRepeticoes;
	
	private long duracaoSeg;

	public Serie(){}
	
	public long getDuracaoSeg() {
		return duracaoSeg;
	}

	public void setDuracaoSeg(long duracaoSeg) {
		this.duracaoSeg = duracaoSeg;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumRepeticoes() {
		return numRepeticoes;
	}

	public void setNumRepeticoes(int numRepeticoes) {
		this.numRepeticoes = numRepeticoes;
	}
	
	
	
}
