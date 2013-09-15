package br.com.acad.model.dieta;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.acad.annotation.Show;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_DIETA_ESPECIFICA")
@PrimaryKeyJoinColumn(name="ID_DIETA_ESPECIFICA")
public class DietaEspecifica extends Dieta {

	@OneToOne
	@JoinColumn(name="SOLICITACAO_DIETA_ID", nullable=false)
	@Show(label="Aluno", mappedName="solicitacao.aluno.nome", order=true)
	private SolicitacaoDieta solicitacao;
	
	public DietaEspecifica(){}

	public SolicitacaoDieta getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoDieta solicitacao) {
		this.solicitacao = solicitacao;
	}
	
	
	
}
