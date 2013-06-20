package br.com.acad.model.catGenerico;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FaixaEtariaCat implements Serializable{
	
	private int id;
	
	private String nome;
	
	private int idadeIni;
	
	private int idadeFim;
	
	public FaixaEtariaCat(){}

	public FaixaEtariaCat(int id, String nome, int idadeIni, int idadeFim) {
		super();
		this.id = id;
		this.nome = nome;
		this.idadeIni = idadeIni;
		this.idadeFim = idadeFim;
	}

	
	public int getIdadeIni() {
		return idadeIni;
	}

	public void setIdadeIni(int idadeIni) {
		this.idadeIni = idadeIni;
	}

	public int getIdadeFim() {
		return idadeFim;
	}

	public void setIdadeFim(int idadeFim) {
		this.idadeFim = idadeFim;
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
	
	
	
}
