package br.com.acad.model.treino;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="SeqDuracaoTreinoCat", sequenceName="SEQ_DURACAO_TREINO_CAT", allocationSize=1)
@Table(name="ACAD_DURACAO_TREINO_CAT")
public class DuracaoTreinoCat implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SeqDuracaoTreinoCat")
	@Column(name="ID_DURACAO_TREINO_CAT")
	private int id;
	
	@Column(length=255, nullable=false)
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
