package br.com.acad.model.pessoa;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_PROFESSOR_FUNC")
@PrimaryKeyJoinColumn(name="ID")
public class ProfessorFunc extends Pessoa{

	private String fotoLocal;
	
	private String formacao;
	
	private boolean isProfessor;
	
	public boolean isProfessor() {
		return isProfessor;
	}
	public void setProfessor(boolean isProfessor) {
		this.isProfessor = isProfessor;
	}
	public String getFotoLocal() {
		return fotoLocal;
	}
	public void setFotoLocal(String fotoLocal) {
		this.fotoLocal = fotoLocal;
	}
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
}
