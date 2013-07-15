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
@SequenceGenerator(name="seqModalidade", sequenceName="SEQ_MODALIDADE", allocationSize=1)
@Table(name="ACAD_MODALIDADE")
public class Modalidade implements Serializable {

	public static final String[] STATIC_FIELDS = null;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqModalidade")
	@Column(name="ID_MODALIDADE")
	private int id;
	
	@Column(length=255, nullable=false)
	private String nome;
	
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
