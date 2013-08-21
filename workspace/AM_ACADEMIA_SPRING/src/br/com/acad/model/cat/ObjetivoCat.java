package br.com.acad.model.cat;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_OBJETIVO_CAT")
public class ObjetivoCat implements Serializable{
	
	public static final String[] STATIC_FIELDS = {"nome"};

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_OBJETIVO_CAT")
	private int id;
	
	@Column(length=255, nullable=false)
	private String nome;
	
	@Column(length=255, nullable=true)
	private String fotoLocalIcone;
	
	public ObjetivoCat(){}

	public ObjetivoCat(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public ObjetivoCat(String nome) {
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
