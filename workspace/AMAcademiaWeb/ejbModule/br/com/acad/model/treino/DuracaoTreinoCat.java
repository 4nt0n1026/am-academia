package br.com.acad.model.treino;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DuracaoTreinoCat implements Serializable {
	
	private int id;
	
	private String duracao;

	public DuracaoTreinoCat(){}
	
	public DuracaoTreinoCat(int id, String duracao) {
		super();
		this.id = id;
		this.duracao = duracao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	
	
	

}
