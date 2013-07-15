package br.com.acad.model.dieta;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.acad.model.cat.TipoTreinoDieta;
import br.com.acad.model.pessoa.ProfessorFunc;


@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name="seqDieta", sequenceName="SEQ_DIETA", allocationSize=1)
@Table(name="ACAD_DIETA")
public class Dieta implements Serializable{

	public static final String[] STATIC_FIELDS = null;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqDieta")
	@Column(name="ID_DIETA")
	private int id;
	
	@Column(length=255, nullable=false)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	@Column(length=500, nullable=true)
	private String descricao;
	
	@Column(length=2, nullable=false)
	private int tempo;
	
	@Column(nullable=false)
	private TipoTreinoDieta tipoDieta;
	
	@ManyToOne
	@JoinColumn(name="PROFESSOR_ID", nullable=true)
	private ProfessorFunc professor;
	
	@OneToMany
	@JoinColumn(name="DIETA_ID", nullable=true)
	private Set<DiaDieta> diasDieta = new HashSet<DiaDieta>();
	
	public Dieta(){}

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

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public ProfessorFunc getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorFunc professor) {
		this.professor = professor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public TipoTreinoDieta getTipoDieta() {
		return tipoDieta;
	}

	public void setTipoDieta(TipoTreinoDieta tipoDieta) {
		this.tipoDieta = tipoDieta;
	}

	public Set<DiaDieta> getDiasDieta() {
		return diasDieta;
	}

	public void setDiasDieta(Set<DiaDieta> diasDieta) {
		this.diasDieta = diasDieta;
	}
	
	
	
}
