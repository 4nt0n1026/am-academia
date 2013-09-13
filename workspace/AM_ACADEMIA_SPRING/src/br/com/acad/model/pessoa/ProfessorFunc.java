package br.com.acad.model.pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_PESSOA_PROFESSOR_FUNC")
@PrimaryKeyJoinColumn(name="ID_PESSOA_PROFESSOR_FUNC")
public class ProfessorFunc extends Pessoa{

	public static final String[] STATIC_FIELDS = {"nome", "email", "cpf", "rg"};
	public static final String[] STATIC_FIELDS_ORDER_LABEL = {"Nome", "Data Nascimento", "Email", "CPF", "RG", "Professor"};
	public static final String[] STATIC_FIELDS_ORDER_VALUE = {"nome", "dataNascimento", "email", "cpf", "rg", "isProfessor"};
	public static final String[] STATIC_VIEWS_LABEL = {"Todos Registros", "Professores", "Funcionarios"};
	public static final String[] STATIC_VIEWS_VALUE = {"", "isProfessor=true", "isProfessor=false"};

	@Column(length=500, nullable=true)
	private String fotoLocal;
	
	@Column(length=500, nullable=true)
	private String formacao;
	
	@Column(nullable=false)
	private boolean isProfessor;
	
	public ProfessorFunc(){}
	
	//Construtor para busca como field
	public ProfessorFunc(Integer id, String nome) {
		this.setId(id);
		this.setNome(nome);
	}
	
	public boolean getIsProfessor() {
		return isProfessor;
	}
	public void setIsProfessor(boolean isProfessor) {
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
