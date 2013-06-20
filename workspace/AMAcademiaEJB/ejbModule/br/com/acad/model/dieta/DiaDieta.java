package br.com.acad.model.dieta;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class DiaDieta implements Serializable {

	private int id;
	
	private String nome;
	
	private List<Refeicao> refeicoes;
	
	public DiaDieta(){}

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

	public List<Refeicao> getRefeicoes() {
		return refeicoes;
	}

	public void setRefeicoes(List<Refeicao> refeicoes) {
		this.refeicoes = refeicoes;
	}
	
	
	
}
