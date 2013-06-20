package br.com.acad.model.treino;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class DiaTreino implements Serializable{

	private int id;
	
	private String nome;
	
	private String descricao;
	
	private Treino treino;

	private List<ExercicioTreino> exercicioTreino;
	
	
	public DiaTreino(){}

	public DiaTreino(int id, String nome, String descricao, Treino treino,
			List<ExercicioTreino> exercicioTreino) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.treino = treino;
		this.exercicioTreino = exercicioTreino;
	}
	
	public List<ExercicioTreino> getExercicioTreino() {
		return exercicioTreino;
	}

	public void setExercicioTreino(List<ExercicioTreino> exercicioTreino) {
		this.exercicioTreino = exercicioTreino;
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

	public Treino getTreino() {
		return treino;
	}

	public void setTreino(Treino treino) {
		this.treino = treino;
	}
	
	
	
}
