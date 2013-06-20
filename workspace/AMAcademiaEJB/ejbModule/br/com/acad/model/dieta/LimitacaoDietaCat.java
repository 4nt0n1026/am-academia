package br.com.acad.model.dieta;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LimitacaoDietaCat implements Serializable {

	private int id;
	
	private String nome;
	
	public LimitacaoDietaCat(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
