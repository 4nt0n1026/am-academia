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
@Table(name="ACAD_DURACAO_TREINO_CAT")
public class DuracaoTreinoCat implements Serializable, GenericEntity{
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_DURACAO_TREINO_CAT")
	private int id;
	
	@Column(length=255, nullable=false)
	@Show(label = "Nome")
	private String nome;

	public DuracaoTreinoCat(){}
	
	public DuracaoTreinoCat( String nome) {
		super();
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
	
	
	
	
	

}
