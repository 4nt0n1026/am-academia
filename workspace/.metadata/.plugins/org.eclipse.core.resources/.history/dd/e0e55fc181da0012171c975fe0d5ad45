package br.com.acad.model.treino;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.acad.model.pessoa.Aluno;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqSerieFeita", sequenceName="SEQ_SERIE_FEITA", allocationSize=1)
@Table(name="ACAD_SERIE_FEITA")
public class SerieFeita implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqSerieFeita")
	private int id;
	
	@Column(precision=2, nullable=false)
	private double pesoUsado;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Calendar data;
	
	@ManyToOne
	@JoinColumn(name="ALUNO_ID")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name="SERIE_ID")
	private Serie serie;
	
	
	public SerieFeita(){}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getPesoUsado() {
		return pesoUsado;
	}


	public void setPesoUsado(double pesoUsado) {
		this.pesoUsado = pesoUsado;
	}


	public Calendar getData() {
		return data;
	}


	public void setData(Calendar data) {
		this.data = data;
	}


	public Serie getSerie() {
		return serie;
	}


	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	
	
}
