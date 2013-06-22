package br.com.fiap.pacote.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqTransporte", sequenceName="SEQ_TRANSPORTE", allocationSize=1)
public class Transporte implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqTransporte")
	private int id;
	
	@Column(nullable=false)
	private String empresa;
	
	public Transporte(String empresa) {
		super();
		this.empresa = empresa;
	}

	public Transporte() {
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public int getId() {
		return id;
	}
}
