package br.com.acad.model.contato;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.acad.model.GenericEntity;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_LOGRADOURO")
public class Logradouro implements Serializable, GenericEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_LOGRADOURO")
	private int id;
	
	@Column(length=255, nullable=false)
	private String nome;
	
	@Column(length=20, nullable=false)
	private String cep;
	
	@ManyToOne()
	@JoinColumn(name="LOGRADOURO_TIPO_ID", nullable=false)
	private LogradouroTipo logradouroTipo;
	
	@ManyToOne
	@JoinColumn(name="CIDADE_ID", nullable=false)
	private Cidade cidade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public LogradouroTipo getLogradouroTipo() {
		return logradouroTipo;
	}
	public void setLogradouroTipo(LogradouroTipo logradouroTipo) {
		this.logradouroTipo = logradouroTipo;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
