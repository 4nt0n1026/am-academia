package br.com.acad.entity.util;

import java.io.Serializable;

public class MenuItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idFoto;
	private String nome;
	
	
	public MenuItem(int idFoto, String nome) {
		this.idFoto = idFoto;
		this.nome = nome;
	}
	
	
	public int getIdFoto() {
		return idFoto;
	}
	public void setIdFoto(int idFoto) {
		this.idFoto = idFoto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
