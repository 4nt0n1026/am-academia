package br.com.acad.dao.dieta.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.dieta.interf.AlimentoDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.Alimento;

@Repository
public class AlimentoDAOImpl extends DAOImpl<Alimento, Integer> implements AlimentoDAO
{

    public AlimentoDAOImpl()
    {
        super();
    }

    @Override
    public List<Alimento> buscarTodos()
    {
        TypedQuery<Alimento> q = em.createQuery("from Alimento", Alimento.class);
        return q.getResultList();
    }

}
