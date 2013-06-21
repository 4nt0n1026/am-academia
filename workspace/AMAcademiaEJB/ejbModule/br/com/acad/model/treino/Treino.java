package br.com.acad.model.treino;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.acad.model.catGenerico.TipoTreinoDieta;
import br.com.acad.model.pessoa.ProfessorFunc;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqTreino", sequenceName="SEQ_TREINO", allocationSize=1)
@Table(name="ACAD_TREINO")
public abstract class Treino implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqTreino")
	private int id;
	
	@Column(length=255, nullable=false)
	private String nome;
	
	@Column(length=500, nullable=true)
	private String descricao;
	
	@Column(nullable=true)
	private long tempoDescanso;

	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Calendar data;
	
	@ManyToOne
	@JoinColumn(name="PROFESSOR_ID", nullable=true)
	private ProfessorFunc professor;
	
	@Column(nullable=false)
	private TipoTreinoDieta tipoTreino;
	
	@OneToMany
	@JoinColumn(name="TREINO_ID")
	private List<DiaTreino> diasTreino;
	
	
	
	public Treino(){}

	
	public long getTempoDescanso() {
		return tempoDescanso;
	}

	public void setTempoDescanso(long tempoDescanso) {
		this.tempoDescanso = tempoDescanso;
	}




	public List<DiaTreino> getDiasTreino() {
		return diasTreino;
	}

	public void setDiasTreino(List<DiaTreino> diasTreino) {
		this.diasTreino = diasTreino;
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

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public TipoTreinoDieta getTipoTreino() {
		return tipoTreino;
	}

	public void setTipoTreino(TipoTreinoDieta tipoTreino) {
		this.tipoTreino = tipoTreino;
	}


	public ProfessorFunc getProfessor() {
		return professor;
	}


	public void setProfessor(ProfessorFunc professor) {
		this.professor = professor;
	}
	
	
	
	
	
	
}
