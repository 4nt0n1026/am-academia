package br.com.acad.model.cat;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.acad.annotation.Show;
import br.com.acad.model.GenericEntity;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_DIAS_TREINO_CAT")
public class DiasTreinoCat implements Serializable, GenericEntity {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_DIAS_TREINO_CAT")
	private int id;
	
	@Column(length=255, nullable=false)
	@Show(label = "Nome")
	private String nome;
	
	@Column(length=1, nullable=false)
	private int qtdDias;
	
	public DiasTreinoCat(){}

	public DiasTreinoCat(String nome, int qtdDias) {
		super();
		this.nome = nome;
		this.qtdDias = qtdDias;
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

	public int getQtdDias() {
		return qtdDias;
	}

	public void setQtdDias(int qtdDias) {
		this.qtdDias = qtdDias;
	}
	
	
	
}
