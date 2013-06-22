package br.com.acad.model.avisos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.acad.model.pessoa.ProfessorFunc;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqNoticia", sequenceName="SEQ_NOTICIA", allocationSize=1)
@Table(name="ACAD_NOTICIA")
public class Noticia implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqNoticia")
	@Column(name="ID_AVISO_NOTICIA")
	private int id;
	
	@Column(length=255, nullable=false)
	private String titulo;
	
	@Column(length=500, nullable=true)
	private String fotoLocal;
	
	@ManyToOne
	@JoinColumn(name="PROFESSOR_FUNC_ID")
	private ProfessorFunc professorFunc;
	
	@ManyToOne
	@JoinColumn(name="NOTICIA_CATEGORIA_ID")
	private NoticiaCat categoria;
	
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
	public String getFotoLocal() {
		return fotoLocal;
	}
	public void setFotoLocal(String fotoLocal) {
		this.fotoLocal = fotoLocal;
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
}
