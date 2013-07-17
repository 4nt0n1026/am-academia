package br.com.acad.model.treino;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqExercicioTreino", sequenceName="SEQ_EXERCICIO_TREINO", allocationSize=1)
@Table(name="ACAD_EXERCICIO_TREINO") 
public class ExercicioTreino implements Serializable {

	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqExercicioTreino")
	@Column(name="ID_EXERCICIO_TREINO")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="EXERCICIO_ID", nullable=false)
	private Exercicio exercicio = new Exercicio();
	
	@OneToMany
	@JoinColumn(name="EXERCICIO_TREINO_ID")
	private Set<Serie> series = new HashSet<Serie>();

	//Metodos
	
	
	//Construtores
	public ExercicioTreino(){}
	
	public ExercicioTreino(int id, Exercicio exercicio, Set<Serie> series) {
		super();
		this.id = id;
		this.exercicio = exercicio;
		this.series = series;
	}

	
	//Gets e Sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	public Set<Serie> getSeries() {
		return series;
	}

	public void setSeries(Set<Serie> series) {
		this.series = series;
	}
	
	
	
}
