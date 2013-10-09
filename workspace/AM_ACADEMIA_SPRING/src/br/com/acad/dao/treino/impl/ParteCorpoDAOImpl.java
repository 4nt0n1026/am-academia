package br.com.acad.dao.treino.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.ParteCorpoDAO;
import br.com.acad.model.treino.Exercicio;
import br.com.acad.model.treino.ParteCorpo;

@Repository
public class ParteCorpoDAOImpl extends DAOImpl<ParteCorpo, Integer> implements ParteCorpoDAO
{

    public ParteCorpoDAOImpl()
    {
        super();
    }

    @Override
    public List<ParteCorpo> buscarTodos()
    {
        TypedQuery<ParteCorpo> q = em.createQuery("from ParteCorpo order by nome", ParteCorpo.class);
        return q.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ParteCorpo> buscarPartesPrimarias(Exercicio exercicio)
    {
        Query q = em.createQuery("select e.parteCorpoPrimaria from Exercicio e where e.id = :id");
        q.setParameter("id", exercicio.getId());
        return q.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ParteCorpo> buscarPartesSecundaria(Exercicio exercicio)
    {
        Query q = em.createQuery("select e.parteCorpoSecundaria from Exercicio e where e.id = :id");
        q.setParameter("id", exercicio.getId());
        return q.getResultList();
    }

}
