package br.com.acad.model.treino;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqExercicioTreino", sequenceName="SEQ_EXERCICIO_TREINO", allocationSize=1)
@Table(name="ACAD_EXERCICIO_TREINO") 
public class ExercicioTreino implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqExercicioTreino")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="EXERCICIO_ID", nullable=false)
	private Exercicio exercicio;
	
	@OneToMany
	@JoinColumn(name="EXERCICIO_TREINO_ID")
	private List<Serie> series;

	public ExercicioTreino(){}
	
	public ExercicioTreino(int id, Exercicio exercicio, List<Serie> series) {
		super();
		this.id = id;
		this.exercicio = exercicio;
		this.series = series;
	}

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

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}
	
	
	
}
