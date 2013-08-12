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
@SequenceGenerator(name="seqUnidadeMedida", sequenceName="SEQ_UNIDADE_MEDIDA", allocationSize=1)
@Table(name="ACAD_UNIDADE_MEDIDA")
public class UnidadeMedida implements Serializable {
	
	public static final String[] STATIC_FIELDS = {"nome", "sigla"};

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqUnidadeMedida")
	@Column(name="ID_UNIDADE_MEDIDA")
	private int id;
	
	@Column(length=255, nullable=false)
	private String nome;
	
	@Column(length=10, nullable=false)
	private String sigla;
	
	public UnidadeMedida(){}

	public UnidadeMedida(Integer id, String nome, String sigla) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
	
}
