package br.com.acad.model.horario;

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
@SequenceGenerator(name="seqAula", sequenceName="SEQ_AULA", allocationSize=1)
@Table(name="ACAD_AULA")
public class Aula implements Serializable{

	public static final String[] STATIC_FIELDS = {"descricao", "modalidade.nome"};

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqAula")
	@Column(name="ID_AULA")
	private int id;
	
	@Column(length=500, nullable=true)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="MODALIDADE_ID")
	private Modalidade modalidade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Modalidade getModalidade() {
		return modalidade;
	}
	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}	
}
