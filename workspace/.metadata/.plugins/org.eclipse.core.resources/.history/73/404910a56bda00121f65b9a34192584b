package br.com.acad.model.treino;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqExercicio", sequenceName="SEQ_EXERCICIO", allocationSize=1)
@Table(name="ACAD_EXERCICIO")
public class Exercicio implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqExercicio")
	private int id;
	
	@Column(length=255, nullable=false)
	private String nome;
	
	@Column(length=500, nullable=true)
	private String descricao;
	
	@Column(length=1000, nullable=true)
	private String fotoLocal;
	
	@ManyToOne
	@JoinColumn(name="PARTE_CORPO_PRIMARIA_ID", nullable=false)
	private ParteCorpo parteCorpoPrimaria;
	
	@ManyToOne
	@JoinColumn(name="PARTE_CORPO_SECUNDARIA_ID", nullable=false)
	private ParteCorpo parteCorpoSecundaria;
	
	
	public Exercicio(){}
	
	public Exercicio(int id, String nome, String descricao, String fotoLocal,
			ParteCorpo parteCorpoPrimaria, ParteCorpo parteCorpoSecundaria) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.fotoLocal = fotoLocal;
		this.parteCorpoPrimaria = parteCorpoPrimaria;
		this.parteCorpoSecundaria = parteCorpoSecundaria;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFotoLocal() {
		return fotoLocal;
	}

	public void setFotoLocal(String fotoLocal) {
		this.fotoLocal = fotoLocal;
	}

	public ParteCorpo getParteCorpoPrimaria() {
		return parteCorpoPrimaria;
	}

	public void setParteCorpoPrimaria(ParteCorpo parteCorpoPrimaria) {
		this.parteCorpoPrimaria = parteCorpoPrimaria;
	}

	public ParteCorpo getParteCorpoSecundaria() {
		return parteCorpoSecundaria;
	}

	public void setParteCorpoSecundaria(ParteCorpo parteCorpoSecundaria) {
		this.parteCorpoSecundaria = parteCorpoSecundaria;
	}
	
	
	

	
	
	
	
}
