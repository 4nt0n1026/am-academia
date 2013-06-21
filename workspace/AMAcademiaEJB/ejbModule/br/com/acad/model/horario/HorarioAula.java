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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.acad.model.catGenerico.DiaSemana;
import br.com.acad.model.pessoa.ProfessorFunc;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqHorarioAula", sequenceName="SEQ_HORARIO_AULA", allocationSize=1)
@Table(name="ACAD_HORARIO_AULA")
public class HorarioAula implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqHorarioAula")
	private int id;
	
	private Calendar hora;
	
	@Column(name="DIA_SEMANA")
	private DiaSemana diaSemana;
	
	@ManyToOne
	@JoinColumn(name="UNIDADE_ID")
	private Unidade unidade;
	
	@ManyToOne
	@JoinColumn(name="PROFESSOR_ID")
	private ProfessorFunc professor;
	
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
	public DiaSemana getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
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
	
}
