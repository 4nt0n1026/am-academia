package br.com.acad.model.dieta;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import br.com.acad.model.catGenerico.TipoTreinoDieta;


@SuppressWarnings("serial")
public abstract class Dieta implements Serializable{

	private int id;
	
	private String nome;
	
	private Calendar data;
	
	private String descricao;
	
	private int tempo;
	
	//private ProfessorFunc professo;
	
	private TipoTreinoDieta tipoDieta;
	
	private List<DiaDieta> diasDieta;
	
	public Dieta(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public TipoTreinoDieta getTipoDieta() {
		return tipoDieta;
	}

	public void setTipoDieta(TipoTreinoDieta tipoDieta) {
		this.tipoDieta = tipoDieta;
	}

	public List<DiaDieta> getDiasDieta() {
		return diasDieta;
	}

	public void setDiasDieta(List<DiaDieta> diasDieta) {
		this.diasDieta = diasDieta;
	}
	
	
	
}
