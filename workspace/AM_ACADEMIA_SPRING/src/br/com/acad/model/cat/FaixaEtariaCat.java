package br.com.acad.model.cat;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_FAIXA_ETARIA_CAT")
public class FaixaEtariaCat implements Serializable{
	
	public static final String[] STATIC_FIELDS = {"nome"};

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_FAIXA_ETARIA_CAT")
	private int id;
	
	@Column(length=255, nullable=false)
	private String nome;
	
	@Column(length=2, nullable=false)
	private int idadeIni;
	
	@Column(length=2, nullable=false)
	private int idadeFim;
	
	public FaixaEtariaCat(){}

	public FaixaEtariaCat(int id, String nome, int idadeIni, int idadeFim) {
		super();
		this.id = id;
		this.nome = nome;
		this.idadeIni = idadeIni;
		this.idadeFim = idadeFim;
	}

	
	public FaixaEtariaCat(String nome) {
		this.nome= nome;
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
