package br.com.acad.dao.horario.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.horario.interf.UnidadeDAO;
import br.com.acad.model.horario.Unidade;

@Repository
public class UnidadeDAOImpl extends DAOImpl<Unidade, Integer> implements UnidadeDAO
{

    public UnidadeDAOImpl()
    {
        super();
    }

    @Override
    public List<Unidade> buscarTodos()
    {
        TypedQuery<Unidade> q = em.createQuery("from Unidade", Unidade.class);
        return q.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Unidade> buscarTodosField()
    {
        Query q = em.createQuery("select u.id, u.nome from Unidade u");
        List<Unidade> unidades = new ArrayList<Unidade>();
        Collection<Object[]> resultado = q.getResultList();
        for (Object[] o : resultado)
        {
            Unidade u = new Unidade((Integer) o[0], (String) o[1]);
            unidades.add(u);
        }
        return unidades;
    }

}
