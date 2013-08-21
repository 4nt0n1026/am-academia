package br.com.acad.model.dieta;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_DIETA_ESPECIFICA")
@PrimaryKeyJoinColumn(name="ID_DIETA_ESPECIFICA")
public class DietaEspecifica extends Dieta {

	public static final String[] STATIC_FIELDS = {"data", "nome", "professor.nome", "solicitacao.aluno.nome"};
	public static final String[] STATIC_FIELDS_ORDER_VALUE = {"data", "nome", "professor.nome", "solicitacao.aluno.nome"};
	public static final String[] STATIC_FIELDS_ORDER_LABEL = {"Data", "Nome", "Professor", "Aluno"};
	
	@OneToOne
	@JoinColumn(name="SOLICITACAO_DIETA_ID", nullable=false)
	private SolicitacaoDieta solicitacao;
	
	public DietaEspecifica(){}

	public SolicitacaoDieta getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoDieta solicitacao) {
		this.solicitacao = solicitacao;
	}
	
	
	
}
