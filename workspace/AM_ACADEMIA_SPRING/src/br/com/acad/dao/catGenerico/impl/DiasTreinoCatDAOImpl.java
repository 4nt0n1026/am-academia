package br.com.acad.dao.catGenerico.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.catGenerico.interf.DiasTreinoCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.cat.DiasTreinoCat;

@Repository
public class DiasTreinoCatDAOImpl extends DAOImpl<DiasTreinoCat, Integer> implements DiasTreinoCatDAO
{

    public DiasTreinoCatDAOImpl()
    {
        super();
    }

    @Override
    public List<DiasTreinoCat> buscarTodos()
    {
        TypedQuery<DiasTreinoCat> q = em.createQuery("from DiasTreinoCat", DiasTreinoCat.class);
        return q.getResultList();
    }

}
