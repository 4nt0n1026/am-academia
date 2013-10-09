package br.com.acad.dao.dieta.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.dieta.interf.SolicitacaoDietaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.SolicitacaoDieta;
import br.com.acad.model.pessoa.Aluno;

@Repository
public class SolicitacaoDietaDAOImpl extends DAOImpl<SolicitacaoDieta, Integer> implements SolicitacaoDietaDAO
{

    public SolicitacaoDietaDAOImpl()
    {
        super();
    }

    @Override
    public List<SolicitacaoDieta> buscarTodos()
    {
        TypedQuery<SolicitacaoDieta> q = em.createQuery("from SolicitacaoDieta", SolicitacaoDieta.class);
        return q.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SolicitacaoDieta> buscarPorAluno(Aluno aluno)
    {
        Query q = em.createQuery("select s.id, s.dataSolicitacao from SolicitacaoDieta s where s.aluno.id = :id)");
        q.setParameter("id", aluno.getId());
        List<SolicitacaoDieta> solicitacoes = new ArrayList<SolicitacaoDieta>();
        Collection<Object[]> resultado = q.getResultList();
        for (Object[] o : resultado)
        {
            SolicitacaoDieta s = new SolicitacaoDieta((Integer) o[0], (Calendar) o[1]);
            solicitacoes.add(s);
        }
        return solicitacoes;
    }

}
