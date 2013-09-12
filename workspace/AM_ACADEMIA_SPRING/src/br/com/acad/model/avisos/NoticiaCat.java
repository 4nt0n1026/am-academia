package br.com.acad.model.avisos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.acad.logic.PathLogic;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_NOTICIA_CAT")
public class NoticiaCat implements Serializable{

	public static final String[] STATIC_FIELDS = {"nome"};

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_NOTICIA_CAT")
	private int id;
	
	@Column(length=50, nullable=false)
	private String nome;
	
	@Column(length=50, nullable=true)
	private String fotoLocalIcone;
	
	
	
	public NoticiaCat(){}
	
	public NoticiaCat(String nome) {
		this.nome = nome;
	}
	
	
	public NoticiaCat(String nome, String icone) {
		this.nome = nome;
		this.fotoLocalIcone = icone;
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
	
	public String getFotoLocalIconePath(){
		if(fotoLocalIcone!=null && fotoLocalIcone.length()>1){
			return "/" + PathLogic.PATH_ICONES + fotoLocalIcone + ".png";
		}
		return "/" + PathLogic.PATH_ICONES + "semFoto.jpg";
	}
	
}
