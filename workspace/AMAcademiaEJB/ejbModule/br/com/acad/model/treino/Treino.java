package br.com.acad.model.treino;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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

import br.com.acad.dao.treino.interf.DiaTreinoDAO;
import br.com.acad.model.cat.TipoTreinoDieta;
import br.com.acad.model.pessoa.ProfessorFunc;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name="seqTreino", sequenceName="SEQ_TREINO", allocationSize=1)
@Table(name="ACAD_TREINO")
public class Treino implements Serializable{

	public static final String[] STATIC_FIELDS = null;

	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqTreino")
	@Column(name="ID_TREINO")
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
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="TREINO_ID")
	private Set<DiaTreino> diasTreino = new HashSet<DiaTreino>();
	
	//Metodos
	public boolean addDiaTreino(DiaTreino dia){
		return diasTreino.add(dia);
	}
	
	public boolean removeDiaTreino(DiaTreino dia){
		return diasTreino.remove(dia);
	}
	
	/**
	 * Apaga lista de DiaTreino
	 */
	public void resetDiasTreino(){
		this.diasTreino = new HashSet<DiaTreino>();
	}
	
	//Gets com DAO
	public List<DiaTreino> getDiasTreinos(DiaTreinoDAO dao){
		return dao.buscaPorTreino(this);
	}
	
	//Construtores
	public Treino(){}

	
	//Gets e Sets
	public long getTempoDescanso() {
		return tempoDescanso;
	}

	public void setTempoDescanso(long tempoDescanso) {
		this.tempoDescanso = tempoDescanso;
	}

	public Set<DiaTreino> getDiasTreino() {
		return diasTreino;
	}

	public void setDiasTreino(Set<DiaTreino> diasTreino) {
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
