package br.com.acad.model.dieta;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DietaEspecifica implements Serializable {

	private SolicitacaoDieta solicitacao;
	
	public DietaEspecifica(){}

	public SolicitacaoDieta getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoDieta solicitacao) {
		this.solicitacao = solicitacao;
	}
	
	
	
}
