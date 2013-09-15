package br.com.acad.entity.treino;

import java.io.Serializable;

public class Exercicio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String partesCorpoPrimarias;
	private String partesCorpoSecundarias;
	private String descricao;
	
	public Exercicio() {
	}

	public Exercicio(String nome) {
		this.nome = nome;
	}
	
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
	public String getPartesCorpoPrimarias() {
		return partesCorpoPrimarias;
	}
	public void setPartesCorpoPrimarias(String partesCorpoPrimarias) {
		this.partesCorpoPrimarias = partesCorpoPrimarias;
	}
	public String getPartesCorpoSecundarias() {
		return partesCorpoSecundarias;
	}
	public void setPartesCorpoSecundarias(String partesCorpoSecundarias) {
		this.partesCorpoSecundarias = partesCorpoSecundarias;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
}
