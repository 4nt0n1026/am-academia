package br.com.acad.model.treino;

import java.io.Serializable;
import java.util.Calendar;

@SuppressWarnings("serial")
public class SolicitacaoTreino implements Serializable {

	private int id;
	
	private String descricao;
	
	private Calendar dataSolicitacao;
	
	private boolean respondido;

	//private Aluno aluno;	
	
	
	public SolicitacaoTreino(){}
	
	public SolicitacaoTreino(int id, String descricao,
			Calendar dataSolicitacao, boolean respondido) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataSolicitacao = dataSolicitacao;
		this.respondido = respondido;
	}

	public boolean isRespondido() {
		return respondido;
	}

	public void setRespondido(boolean respondido) {
		this.respondido = respondido;
	}

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
	
	
	
}
