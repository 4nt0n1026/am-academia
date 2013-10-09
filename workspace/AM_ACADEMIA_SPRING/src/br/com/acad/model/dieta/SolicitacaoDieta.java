package br.com.acad.model.dieta;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.acad.annotation.Show;
import br.com.acad.annotation.View;
import br.com.acad.model.GenericEntity;
import br.com.acad.model.pessoa.Aluno;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACAD_SOLICITACAO_DIETA")
@View(labels = { "Todos Registros", "Respondidas", "Não Respondidas" }, queries = { "", "respondido=true", "respondido=false" })
public class SolicitacaoDieta implements Serializable, GenericEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_SOLICITACAO_DIETA")
    private int id;

    @Column(length = 500, nullable = false)
    private String descricao;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_SOLICITACAO", nullable = false)
    @Show(label = "Data", order = true)
    private Calendar dataSolicitacao;

    @Column(nullable = false)
    @Show(label = "Respondido", order = true)
    private boolean respondido;

    @ManyToOne
    @JoinColumn(name = "ALUNO_ID", nullable = false)
    @Show(label = "Aluno", mappedName = "aluno.nome", order = true)
    private Aluno aluno;

    public SolicitacaoDieta()
    {
    }

    public SolicitacaoDieta(Integer id, Calendar data)
    {
        this.id = id;
        this.dataSolicitacao = data;
    }

    public int getId()
    {
        return id;
    }

    public Aluno getAluno()
    {
        return aluno;
    }

    public void setAluno(Aluno aluno)
    {
        this.aluno = aluno;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public Calendar getDataSolicitacao()
    {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Calendar dataSolicitacao)
    {
        this.dataSolicitacao = dataSolicitacao;
    }

    public boolean isRespondido()
    {
        return respondido;
    }

    public void setRespondido(boolean respondido)
    {
        this.respondido = respondido;
    }

}
