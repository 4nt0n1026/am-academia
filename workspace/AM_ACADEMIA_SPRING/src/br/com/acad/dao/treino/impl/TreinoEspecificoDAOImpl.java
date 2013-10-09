package br.com.acad.dao.treino.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.TreinoEspecificoDAO;
import br.com.acad.model.treino.TreinoEspecifico;

@Repository
public class TreinoEspecificoDAOImpl extends DAOImpl<TreinoEspecifico, Integer> implements TreinoEspecificoDAO
{

    public TreinoEspecificoDAOImpl()
    {
        super();
    }

    @Override
    public List<TreinoEspecifico> buscarTodos()
    {
        TypedQuery<TreinoEspecifico> q = em.createQuery("from TreinoEspecifico", TreinoEspecifico.class);
        return q.getResultList();
    }

}
