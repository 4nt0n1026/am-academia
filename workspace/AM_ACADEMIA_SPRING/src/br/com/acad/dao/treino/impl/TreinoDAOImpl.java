package br.com.acad.dao.treino.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.TreinoDAO;
import br.com.acad.model.pessoa.Aluno;
import br.com.acad.model.treino.Treino;

@Repository
public class TreinoDAOImpl extends DAOImpl<Treino, Integer> implements TreinoDAO
{

    public TreinoDAOImpl()
    {
        super();
    }

    @Override
    public List<Treino> buscarTodos()
    {
        TypedQuery<Treino> q = em.createQuery("from Treino", Treino.class);
        return q.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Treino> buscarPorAluno(Aluno aluno)
    {
        Query q = em.createQuery("select a.treinos from Aluno a where a.id = :idAluno");
        q.setParameter("idAluno", aluno.getId());
        return q.getResultList();
    }

}
