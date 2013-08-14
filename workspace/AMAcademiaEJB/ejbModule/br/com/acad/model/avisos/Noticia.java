package br.com.acad.model.avisos;

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

import br.com.acad.model.pessoa.ProfessorFunc;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqNoticia", sequenceName="SEQ_NOTICIA", allocationSize=1)
@Table(name="ACAD_NOTICIA")
public class Noticia implements Serializable {
	
	// static field para busca no banco
	public static final String[] STATIC_FIELDS = {"titulo", "professorFunc.nome", "categoria.nome"};
	public static final String[] STATIC_FIELDS_ORDER_VALUE = {"titulo", "categoria.nome", "professorFunc.nome"};
	public static final String[] STATIC_FIELDS_ORDER_LABEL = {"Titulo", "Categoria", "Professor/Funcionario"};
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqNoticia")
	@Column(name="ID_NOTICIA")
	private int id;
	
	@Column(length=255, nullable=false)
	private String titulo;
	
	@Column(length=1500, nullable=false)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="PROFESSOR_FUNC_ID")
	private ProfessorFunc professorFunc;
	
	@ManyToOne
	@JoinColumn(name="NOTICIA_CAT_ID")
	private NoticiaCat categoria;
	
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	public Noticia(Calendar data, String titulo, String descricao, NoticiaCat noticiaCat, ProfessorFunc professor) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.categoria = noticiaCat;
		this.professorFunc = professor;
		this.data = data;
		
	}
	public Noticia() {
	}
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public ProfessorFunc getProfessorFunc() {
		return professorFunc;
	}
	public void setProfessorFunc(ProfessorFunc professorFunc) {
		this.professorFunc = professorFunc;
	}
	public NoticiaCat getCategoria() {
		return categoria;
	}
	public void setCategoria(NoticiaCat categoria) {
		this.categoria = categoria;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	
	
}
