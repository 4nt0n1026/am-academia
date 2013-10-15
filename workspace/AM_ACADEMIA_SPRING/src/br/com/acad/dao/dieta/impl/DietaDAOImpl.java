package br.com.acad.dao.dieta.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.dieta.interf.DietaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.Dieta;
import br.com.acad.model.pessoa.Aluno;

@Repository
public class DietaDAOImpl extends DAOImpl<Dieta, Integer> implements DietaDAO
{

    public DietaDAOImpl()
    {
        super();
    }

    @Override
    public List<Dieta> buscarTodos()
    {
        TypedQuery<Dieta> q = em.createQuery("from Dieta", Dieta.class);
        return q.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Dieta> buscarPorAluno(Aluno aluno)
    {
        Query q = em.createQuery("select a.dietas from Aluno a where a.id = :idAluno");
        q.setParameter("idAluno", aluno.getId());
        return q.getResultList();
    }

}
