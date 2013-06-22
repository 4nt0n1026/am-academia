package br.com.acad.model.avisos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqNoticiaCategoria", sequenceName="SEQ_NOTICIA_CATEGORIA", allocationSize=1)
@Table(name="ACAD_NOTICIA_CATEGORIA")
public class NoticiaCategoria implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqNoticiaCategoria")
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
