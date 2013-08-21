package br.com.acad.model.treino;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.acad.model.pessoa.Aluno;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_TREINO_ESPECIFICO")
@PrimaryKeyJoinColumn(name="ID_TREINO_ESPECIFICO")
public class TreinoEspecifico extends Treino{
	
	public static final String[] STATIC_FIELDS = {"data", "nome", "professor.nome", "solicitacao.aluno.nome"};
	public static final String[] STATIC_FIELDS_ORDER_VALUE = {"data", "nome", "professor.nome", "solicitacao.aluno.nome"};
	public static final String[] STATIC_FIELDS_ORDER_LABEL = {"Data", "Nome", "Professor", "Aluno"};
	
	@OneToOne
	@JoinColumn(name="SOLICITACAO_TREINO_ID", nullable=false)
	private SolicitacaoTreino solicitacao;
	
	public TreinoEspecifico(){}

	public SolicitacaoTreino getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoTreino solicitacao) {
		this.solicitacao = solicitacao;
	}

	
	/**
	 * Seta o nome padrao para treinos solicitados
	 */
	public void setNomePronto(Aluno aluno) {
		nome = "Treino Solicitaco - " + aluno.getNome() + "(" + aluno.getNumSolicitacao() + ")";
	}
	
	
	
	
	
}
