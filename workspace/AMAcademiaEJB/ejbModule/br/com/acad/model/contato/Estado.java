package br.com.acad.model.contato;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqEstado", sequenceName="SEQ_ESTADO", allocationSize=1)
@Table(name="ACAD_ESTADO")
public class Estado implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqEstado")
	private int id;
	
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
