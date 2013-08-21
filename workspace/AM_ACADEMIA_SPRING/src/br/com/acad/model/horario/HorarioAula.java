package br.com.acad.model.horario;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.acad.model.pessoa.ProfessorFunc;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_HORARIO_AULA")
public class HorarioAula implements Serializable {

	public static final String[] STATIC_FIELDS = {"unidade.nome", "professor.nome", "aula.nome"};
	public static final String[] STATIC_FIELDS_ORDER_VALUE = {"aula.nome", "unidade.nome", "professor.nome"};
	public static final String[] STATIC_FIELDS_ORDER_LABEL = {"Aula", "Unidade", "Professor"};

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_HORARIO_AULA")
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Calendar hora;
	
	@Column(name="DIA_SEMANA")
	private String diasSemana;
	
	@ManyToOne
	@JoinColumn(name="UNIDADE_ID")
	private Unidade unidade;
	
	@ManyToOne
	@JoinColumn(name="PROFESSOR_ID")
	private ProfessorFunc professor;

	@ManyToOne
	@JoinColumn(name="AULA_ID")
	private Aula aula;
	
	
	
	public HorarioAula() {
		super();
	}
	
	public HorarioAula(Calendar hora, String diasSemana, int idUnidade, int idProfessor, int idAula) {
		ProfessorFunc professor = new ProfessorFunc();
		professor.setId(idProfessor);
		Unidade unidade = new Unidade();
		unidade.setId(idUnidade);
		Aula aula = new Aula();
		aula.setId(idAula);
		
		this.hora = hora;
		this.diasSemana = diasSemana;
		this.unidade = unidade;
		this.professor = professor;
		this.aula = aula;
	}
	
	
	
	public Aula getAula() {
		return aula;
	}
	public void setAula(Aula aula) {
		this.aula = aula;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Calendar getHora() {
		return hora;
	}
	public void setHora(Calendar hora) {
		this.hora = hora;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	public ProfessorFunc getProfessor() {
		return professor;
	}
	public void setProfessor(ProfessorFunc professor) {
		this.professor = professor;
	}
	public String getDiasSemana() {
		return diasSemana;
	}
	public void setDiasSemana(String diasSemana) {
		this.diasSemana = diasSemana;
	}
	
	
}
