package br.com.acad.entity.treino;

import java.io.Serializable;

public class Solicitacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String descricao;
	private int alunoId;
	private String data;
	private boolean respondido;
	
	public Solicitacao(String descricao, String data){
		this.descricao = descricao;
		this.data = data;
	}
	
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
	public int getAlunoId() {
		return alunoId;
	}
	public void setAlunoId(int alunoId) {
		this.alunoId = alunoId;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public boolean isRespondido() {
		return respondido;
	}
	public void setRespondido(boolean respondido) {
		this.respondido = respondido;
	}
	
	
	
}
