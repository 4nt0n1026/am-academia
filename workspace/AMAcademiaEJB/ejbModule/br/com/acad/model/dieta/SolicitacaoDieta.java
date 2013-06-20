package br.com.acad.model.dieta;

import java.io.Serializable;
import java.util.Calendar;

@SuppressWarnings("serial")
public class SolicitacaoDieta implements Serializable {

	private int id;
	
	private String descricao;
	
	private Calendar dataSolicitacao;
	
	private boolean respondido;
	
	//private Aluno aluno;
	
	public SolicitacaoDieta(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Calendar dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public boolean isRespondido() {
		return respondido;
	}

	public void setRespondido(boolean respondido) {
		this.respondido = respondido;
	}
	
	
	
	
	
}
