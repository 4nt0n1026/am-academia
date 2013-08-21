package br.com.acad.model.treino;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_SERIE")
public class Serie implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_SERIE")
	private int id;
	
	@Column(nullable=true)
	private int numRepeticoes;
	
	@Column(nullable=true)
	private long duracaoSeg;
	
	private int ordem;

	
	
	public Serie(){}
	
	@Override
	public String toString() {
		return  String.valueOf(numRepeticoes);
	}

	
	public long getDuracaoSeg() {
		return duracaoSeg;
	}

	public void setDuracaoSeg(long duracaoSeg) {
		this.duracaoSeg = duracaoSeg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumRepeticoes() {
		return numRepeticoes;
	}

	public void setNumRepeticoes(int numRepeticoes) {
		this.numRepeticoes = numRepeticoes;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	
	
	
	
}
