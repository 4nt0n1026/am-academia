package br.com.nac.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Livro implements Serializable{
	
	@Id
	private int isbn;
	
	@Column(length=200, nullable=false)
	private String titulo;
	
	private Float preco;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataLancamento;
	
	@Column(name="BLB_CONTEUDO")
	@Lob
	private byte[] capa;
	
	@ManyToOne
	@JoinColumn(name="EDITORA_ID")
	private Editora editora;
	
	@ManyToMany
	@JoinTable(name="AUTOR_LIVRO",
	joinColumns={@JoinColumn(name="LIVRO_ISBN")},
	inverseJoinColumns={@JoinColumn(name="AUTOR_ISBN")})
	private List<Autor> autores;
	
	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public byte[] getCapa() {
		return capa;
	}

	public void setCapa(byte[] capa) {
		this.capa = capa;
	}
	
	
	
}
