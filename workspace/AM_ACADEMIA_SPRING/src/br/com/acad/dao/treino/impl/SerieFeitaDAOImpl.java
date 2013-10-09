package br.com.acad.dao.treino.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.SerieFeitaDAO;
import br.com.acad.model.treino.SerieFeita;

@Repository
public class SerieFeitaDAOImpl extends DAOImpl<SerieFeita, Integer> implements SerieFeitaDAO
{

    public SerieFeitaDAOImpl()
    {
        super();
    }

    @Override
    public List<SerieFeita> buscarTodos()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
