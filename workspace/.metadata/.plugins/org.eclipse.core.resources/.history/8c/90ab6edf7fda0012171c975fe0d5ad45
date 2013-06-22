package br.com.acad.model.avisos;

import java.io.Serializable;

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
@SequenceGenerator(name="seqAvisoNoticia", sequenceName="SEQ_AVISO_NOTICIA", allocationSize=1)
@Table(name="ACAD_AVISO_NOTICIA")
public class AvisoNoticia implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqAvisoNoticia")
	private int id;
	
	private String titulo;
	
	private String fotoLocal;
	
	@ManyToOne
	@JoinColumn(name="PROFESSOR_FUNC_ID")
	private ProfessorFunc professorFunc;
	
	@ManyToOne
	@JoinColumn(name="NOTICIA_CATEGORIA_ID")
	private NoticiaCategoria categoria;
	
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
	public NoticiaCategoria getCategoria() {
		return categoria;
	}
	public void setCategoria(NoticiaCategoria categoria) {
		this.categoria = categoria;
	}
}
