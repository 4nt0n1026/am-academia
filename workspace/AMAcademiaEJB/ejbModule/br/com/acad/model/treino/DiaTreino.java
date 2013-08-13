package br.com.acad.model.treino;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.acad.dao.treino.interf.ExercicioTreinoDAO;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqDiaTreino", sequenceName="SEQ_DIA_TREINO", allocationSize=1)
@Table(name="ACAD_DIA_TREINO")
public class DiaTreino implements Serializable{

	
	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqDiaTreino")
	@Column(name="ID_DIA_TREINO")
	private int id;
	
	@Column(length=255, nullable=false)
	private String nome;
	
	@Column(length=500, nullable=true)
	private String descricao;
	
	private int ordem;
	
	@OneToMany( cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="DIA_TREINO_ID")
	private List<ExercicioTreino> exerciciosTreino = new ArrayList<ExercicioTreino>();
	
	
	//Metodos
	public boolean addExercicioTreino(ExercicioTreino exercicioTreino){
		return exerciciosTreino.add(exercicioTreino);
	}

	public boolean removeExercicioTreino(ExercicioTreino exercicioTreino){
		return exerciciosTreino.remove(exercicioTreino);
	}
	
	public void resetExerciciosTreino(){
		this.exerciciosTreino = new ArrayList<ExercicioTreino>();
	}
	
	public List<ExercicioTreino> getExerciciosTreino(ExercicioTreinoDAO exercicioTreinoDAO) {
		return exercicioTreinoDAO.buscarPorDiaTreino(this);
	}
	
	//Contrutores
	public DiaTreino(){}
	
	public DiaTreino(String nome) {
		super();
		this.nome = nome;
	}

	public DiaTreino(int ordem, String nome) {
		this.ordem = ordem;
		this.nome = nome;
	}

	//Gets e Sets
	

	public int getId() {
		return id;
	}

	public List<ExercicioTreino> getExerciciosTreino() {
		return this.exerciciosTreino;
	}

	public void setExerciciosTreino(List<ExercicioTreino> exerciciosTreino) {
		this.exerciciosTreino = exerciciosTreino;
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

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	
	

	
	
}
