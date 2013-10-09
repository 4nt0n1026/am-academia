package br.com.acad.model.treino;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.acad.annotation.Show;
import br.com.acad.model.pessoa.Aluno;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACAD_TREINO_ESPECIFICO")
@PrimaryKeyJoinColumn(name = "ID_TREINO_ESPECIFICO")
public class TreinoEspecifico extends Treino
{

    @OneToOne
    @JoinColumn(name = "SOLICITACAO_TREINO_ID", nullable = false)
    @Show(label = "Aluno", mappedName = "solicitacao.aluno.nome", order = true)
    private SolicitacaoTreino solicitacao;

    public TreinoEspecifico()
    {
    }

    public SolicitacaoTreino getSolicitacao()
    {
        return solicitacao;
    }

    public void setSolicitacao(SolicitacaoTreino solicitacao)
    {
        this.solicitacao = solicitacao;
    }

    /**
     * Seta o nome padrao para treinos solicitados
     */
    public void setNomePronto(Aluno aluno)
    {
        nome = "Treino Solicitaco - " + aluno.getNome() + "(" + aluno.getNumSolicitacao() + ")";
    }

}
