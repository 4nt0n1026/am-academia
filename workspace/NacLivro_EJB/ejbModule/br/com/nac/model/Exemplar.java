package br.com.nac.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="seqExemplar", sequenceName="SEQ_EXEMPLAR", allocationSize=1)
public class Exemplar implements Serializable {

	@Id
	@GeneratedValue(generator="seqExemplar", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_AQUISICAO")
	private Calendar dtAquisicao;
	
	@Column(nullable=false)
	private Situacao situacao;
	
	@ManyToOne
	@JoinColumn(name="LIVRO_ISBN", nullable=false)
	private Livro livro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public Calendar getDtAquisicao() {
		return dtAquisicao;
	}

	public void setDtAquisicao(Calendar dtAquisicao) {
		this.dtAquisicao = dtAquisicao;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	
}
