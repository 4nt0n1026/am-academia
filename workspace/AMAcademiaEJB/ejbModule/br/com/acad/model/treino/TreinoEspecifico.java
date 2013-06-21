package br.com.acad.model.treino;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_TREINO_ESPECIFICO")
@PrimaryKeyJoinColumn(name="ID")
public class TreinoEspecifico extends Treino{
	
	@OneToOne
	@JoinColumn(name="SOLICITACAO_TREINO_ID")
	private SolicitacaoTreino solicitacao;

	public TreinoEspecifico(){}

	public SolicitacaoTreino getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoTreino solicitacao) {
		this.solicitacao = solicitacao;
	}
	
	
	
	
	
}
