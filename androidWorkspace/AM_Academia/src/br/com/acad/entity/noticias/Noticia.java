package br.com.acad.entity.noticias;

import java.io.Serializable;

public class Noticia implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private String descricao;
	private String categoria;
	private String data;
	private int iconeId;
	
	public Noticia(){}
	
	
	
	public Noticia(int id, String nome, String categoria, String data,
			int iconeId) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.data = data;
		this.iconeId = iconeId;
	}



	public Noticia(int id, String nome, String descricao, String categoria, String data) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
		this.data = data;
	}
	
	
	@Override
	public String toString() {
		return this.nome + " - " + this.categoria;
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getIconeId() {
		return iconeId;
	}

	public void setIconeId(int iconeId) {
		this.iconeId = iconeId;
	}
	
	
	
	
}
