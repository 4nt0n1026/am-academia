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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.acad.annotation.Show;
import br.com.acad.model.GenericEntity;
import br.com.acad.model.pessoa.ProfessorFunc;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_NOTICIA")
@XmlRootElement
public class Noticia implements Serializable, GenericEntity {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_NOTICIA")
	private int id;
	
	@Column(length=50, nullable=false)
	@Show(label="Título", order=true)
	private String titulo;
	
	@Column(length=1500, nullable=false)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="PROFESSOR_FUNC_ID")
	@Show(label="Professor/Funcionario", mappedName="professorFunc.nome", order=true)
	private ProfessorFunc professorFunc;
	
	@ManyToOne
	@JoinColumn(name="NOTICIA_CAT_ID")
	@Show(label="Categoria", mappedName="categoria.nome", order=true)
	private NoticiaCat categoria;
	
	@Temporal(TemporalType.DATE)
	@Show(label="data")
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
	
	@Override
	public String toString() {
		return "Noticia [titulo=" + titulo + "]";
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
