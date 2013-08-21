package br.com.acad.model.pessoa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.acad.model.treino.Treino;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_PESSOA_ALUNO")
@PrimaryKeyJoinColumn(name="ID_PESSOA_ID")
public class Aluno extends Pessoa{

	public static final String[] STATIC_FIELDS = {"nome", "email", "cpf", "rg", "peso", "altura"};
	public static final String[] STATIC_FIELDS_ORDER_VALUE = {"nome", "dataNascimento", "email", "cpf", "rg", "peso", "altura" };
	public static final String[] STATIC_FIELDS_ORDER_LABEL = {"Nome", "dataNascimento", "Email", "CPF", "RG", "Peso", "Altura"};

	@Column(nullable=true, precision=2)
	private double peso;
	
	@Column(nullable=true, precision=2)
	private double altura;
	
	private int numSolicitacao = 0;
	
	@ManyToMany(fetch= FetchType.LAZY)
	@JoinTable(name="ACAD_ALUNO_TREINO", 
				joinColumns={@JoinColumn(name="ALUNO_ID")},
				inverseJoinColumns={@JoinColumn(name="TREINO_ID")})
	private Set<Treino> treinos = new HashSet<Treino>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="ACAD_ALUNO_DIETA", 
				joinColumns={@JoinColumn(name="ALUNO_DIETA")},
				inverseJoinColumns={@JoinColumn(name="DIETA_ID")})
	private Set<Treino> dietas = new HashSet<Treino>();
	
	// Metodos
	public void addTreino(Treino treino){
		treinos.add(treino);
	}
	
	public void removeTreino(Treino treino){
		treinos.add(treino);
	}
	
	
	public Aluno(){}
	
	public Aluno(Integer id, String nome) {
		this.setId(id);
		this.setNome(nome);
	}

	public void incrementNumSolicitacao(){
		numSolicitacao += 1;
	}
	
	
	public Set<Treino> getDietas() {
		return dietas;
	}

	public void setDietas(Set<Treino> dietas) {
		this.dietas = dietas;
	}

	public Set<Treino> getTreinos() {
		return treinos;
	}

	public void setTreinos(Set<Treino> treinos) {
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

	public int getNumSolicitacao() {
		return numSolicitacao;
	}

	public void setNumSolicitacao(int numSolicitacao) {
		this.numSolicitacao = numSolicitacao;
	}
	
}
