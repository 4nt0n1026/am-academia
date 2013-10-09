package br.com.acad.dao.treino.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.SolicitacaoTreinoDAO;
import br.com.acad.model.pessoa.Aluno;
import br.com.acad.model.treino.SolicitacaoTreino;

@Repository
public class SolicitacaoTreinoDAOImpl extends DAOImpl<SolicitacaoTreino, Integer> implements SolicitacaoTreinoDAO
{

    public SolicitacaoTreinoDAOImpl()
    {
        super();
    }

    @Override
    public List<SolicitacaoTreino> buscarTodos()
    {
        TypedQuery<SolicitacaoTreino> q = em.createQuery("from SolicitacaoTreino", SolicitacaoTreino.class);
        return q.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SolicitacaoTreino> buscarPorAluno(Aluno aluno)
    {
        Query q = em.createQuery("select s.id, s.dataSolicitacao from SolicitacaoTreino s where s.aluno.id = :id)");
        q.setParameter("id", aluno.getId());
        List<SolicitacaoTreino> solicitacoes = new ArrayList<SolicitacaoTreino>();
        Collection<Object[]> resultado = q.getResultList();
        for (Object[] o : resultado)
        {
            SolicitacaoTreino s = new SolicitacaoTreino((Integer) o[0], (Calendar) o[1]);
            solicitacoes.add(s);
        }
        return solicitacoes;
    }
}
