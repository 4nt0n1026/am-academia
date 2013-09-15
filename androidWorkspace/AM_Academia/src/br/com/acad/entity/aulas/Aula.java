package br.com.acad.entity.aulas;

import java.io.Serializable;

public class Aula implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String horarios; //String com todos horarios e professores de cada horario buscado do ws
	private String descricao;
	private int foto;

	public Aula(int id, String nome){
		this.id = id;
		this.nome = nome;
	}
	
	public Aula(int id, String horarios, String descricao) {
		this.id = id;
		this.horarios = horarios;
		this.descricao = descricao;
	}
	
	public Aula(int id, String nome, int foto) {
		this.id = id;
		this.nome = nome;
		this.foto = foto;
	}

	@Override
	public String toString() {
		return nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getHorarios() {
		return horarios;
	}
	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getFoto() {
		return foto;
	}

	public void setFoto(int foto) {
		this.foto = foto;
	}
	
	
	
	
	
	
}
