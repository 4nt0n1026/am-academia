package br.com.acad.model.mobile;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ItemMenu implements Serializable {

	private String nome;
	private String fotoLocal;
	private String caminho;
	
	public ItemMenu(String nome, String fotoLocal, String caminho) {
		super();
		this.nome = nome;
		this.fotoLocal = fotoLocal;
		this.caminho = caminho;
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
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	
	
}
