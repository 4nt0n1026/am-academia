package br.com.nac.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(name="seqEditora", sequenceName="SEQ_EDITORA", allocationSize=1)
public class Editora implements Serializable{

	@Id
	@GeneratedValue(generator="seqEditora", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(length=100, nullable=false)
	private String cnpj;
	
	@Column(length=300, nullable=false)
	private String nome;
	
	@Column(length=400)
	private String endereco;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
