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
	private int id;
	
	@Column(length=255, nullable=false)
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
