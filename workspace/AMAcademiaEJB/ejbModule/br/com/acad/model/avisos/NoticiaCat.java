package br.com.acad.model.avisos;

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
@SequenceGenerator(name="seqNoticiaCategoria", sequenceName="SEQ_NOTICIA_CATEGORIA", allocationSize=1)
@Table(name="ACAD_NOTICIA_CAT")
public class NoticiaCat implements Serializable{

	public static final String[] STATIC_FIELDS = {"nome"};

	// static field para busca no banco
	public static String[] BUSCA = {"nome"};
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqNoticiaCategoria")
	@Column(name="ID_NOTICIA_CAT")
	private int id;
	
	@Column(length=255, nullable=false)
	private String nome;
	
	@Column(length=255, nullable=true)
	private String fotoLocalIcone;
	
	
	
	public NoticiaCat(){}
	
	public NoticiaCat(String nome) {
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

	public String getFotoLocalIcone() {
		return fotoLocalIcone;
	}

	public void setFotoLocalIcone(String fotoLocalIcone) {
		this.fotoLocalIcone = fotoLocalIcone;
	}
	
	
}
