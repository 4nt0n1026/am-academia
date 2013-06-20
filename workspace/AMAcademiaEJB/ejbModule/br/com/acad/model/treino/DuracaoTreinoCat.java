package br.com.acad.model.treino;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DuracaoTreinoCat implements Serializable {
	
	private int id;
	
	private String nome;

	public DuracaoTreinoCat(){}
	
	public DuracaoTreinoCat(int id, String duracao) {
		super();
		this.id = id;
		this.nome = duracao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDuracao() {
		return nome;
	}

	public void setDuracao(String duracao) {
		this.nome = duracao;
	}
	
	
	

}
