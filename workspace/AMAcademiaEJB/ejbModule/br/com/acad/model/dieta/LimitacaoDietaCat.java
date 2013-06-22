package br.com.acad.model.dieta;

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
@SequenceGenerator(name="seqLimitacaoDieta", sequenceName="SEQ_LIMITACAO_DIETA", allocationSize=1)
@Table(name="ACAD_LIMITACAO_DIETA_CAT")
public class LimitacaoDietaCat implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqLimitacaoDieta")
	@Column(name="ID_LIMITACAO_DIETA_CAT")
	private int id;
	
	@Column(length=255, nullable=false)
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
