package br.com.acad.dao.catGenerico.interf;

import java.util.List;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.cat.SexoCat;

public interface SexoCatDAO extends DAO<SexoCat, Integer>
{

    public List<SexoCat> buscarTodos();

}
