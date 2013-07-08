package br.com.acad.model.avisos;

import java.io.Serializable;

import br.com.acad.model.pessoa.ProfessorFunc;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqNoticia", sequenceName="SEQ_NOTICIA", allocationSize=1)
@Table(name="ACAD_NOTICIA")
public class Noticia implements Serializable {
	
	// static field para busca no banco
	public static String[] BUSCA = {"titulo", "descricao", "professorFunc.nome", "categoria.nome"};
	
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
}
