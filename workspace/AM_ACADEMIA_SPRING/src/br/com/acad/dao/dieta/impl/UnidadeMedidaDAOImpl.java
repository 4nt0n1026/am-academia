package br.com.acad.dao.dieta.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.dieta.interf.UnidadeMedidaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.UnidadeMedida;

@Repository
public class UnidadeMedidaDAOImpl extends DAOImpl<UnidadeMedida, Integer> implements UnidadeMedidaDAO
{

    public UnidadeMedidaDAOImpl()
    {
        super();
    }

    @Override
    public List<UnidadeMedida> buscarTodos()
    {
        TypedQuery<UnidadeMedida> q = em.createQuery("from UnidadeMedida", UnidadeMedida.class);
        return q.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UnidadeMedida> buscarFieldNome()
    {
        Query q = em.createQuery("select u.id, u.nome, u.sigla from UnidadeMedida u");
        List<UnidadeMedida> unidadeMedida = new ArrayList<UnidadeMedida>();
        Collection<Object[]> resultado = q.getResultList();
        for (Object[] o : resultado)
        {
            UnidadeMedida u = new UnidadeMedida((Integer) o[0], (String) o[1], (String) o[2]);
            unidadeMedida.add(u);
        }
        return unidadeMedida;
    }

}
