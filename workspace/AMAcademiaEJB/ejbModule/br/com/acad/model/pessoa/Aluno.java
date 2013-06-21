package br.com.acad.model.pessoa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.acad.model.treino.Treino;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_ALUNO")
@PrimaryKeyJoinColumn(name="ID")
public class Aluno extends Pessoa{

	@Column(nullable=true, precision=2)
	private double peso;
	
	@Column(nullable=true, precision=2)
	private double altura;
	
	@OneToMany
	@JoinColumn(name="ALUNO_ID")
	private List<Treino> treinos;
	
	public Aluno(){}
	
	
	public List<Treino> getTreinos() {
		return treinos;
	}

	public void setTreinos(List<Treino> treinos) {
		this.treinos = treinos;
	}

	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
}
