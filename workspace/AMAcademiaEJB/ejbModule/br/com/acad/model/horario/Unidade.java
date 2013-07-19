package br.com.acad.model.horario;

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
@SequenceGenerator(name="seqUnidade", sequenceName="SEQ_UNIDADE", allocationSize=1)
@Table(name="ACAD_UNIDADE")
public class Unidade implements Serializable{

	public static final String[] STATIC_FIELDS = {"nome", "descrição"};

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqUnidade")
	@Column(name="ID_UNIDADE")
	private int id;
	
	@Column(length=255, nullable=false)
	private String nome;
	
	@Column(length=500, nullable=true)
	private String fotoLocal;
	
	@Column(length=500, nullable=true)
	private String descricao;
	
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
	public String getFotoLocal() {
		return fotoLocal;
	}
	public void setFotoLocal(String fotoLocal) {
		this.fotoLocal = fotoLocal;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}
