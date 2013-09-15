package br.com.acad.model.treino;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.acad.annotation.Show;
import br.com.acad.model.GenericEntity;


@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_PARTE_CORPO")
public class ParteCorpo implements Serializable, GenericEntity{

	
	// Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_PARTE_CORPO")
	private int id;
	
	@Column(length=255, nullable=false)
	@Show(label="Nome")
	private String nome;
	
	@ManyToMany(mappedBy="parteCorpoPrimaria")
	private Set<Exercicio> exerciciosPrimarios;

	// Construtores
	public ParteCorpo(){}
	
	public ParteCorpo(String nome) {
		super();
		this.nome = nome;
	}

	public ParteCorpo(int id) {
		this.id = id;
	}

	// toString()
	@Override
	public String toString() {
		return this.nome;
	}
	
	
	// Gets e Sets
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

	public Set<Exercicio> getExerciciosPrimarios() {
		return exerciciosPrimarios;
	}

	public void setExerciciosPrimarios(Set<Exercicio> exerciciosPrimarios) {
		this.exerciciosPrimarios = exerciciosPrimarios;
	}

	
	
	
}
