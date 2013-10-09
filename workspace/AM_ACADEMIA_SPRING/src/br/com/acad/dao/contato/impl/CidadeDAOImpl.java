package br.com.acad.dao.contato.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.contato.interf.CidadeDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.contato.Cidade;

@Repository
public class CidadeDAOImpl extends DAOImpl<Cidade, Integer> implements CidadeDAO
{

    public CidadeDAOImpl()
    {
        super();
    }

    @Override
    public List<Cidade> buscarTodos()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
