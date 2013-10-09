package br.com.acad.dao.catGenerico.interf;

import java.util.List;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.cat.DuracaoTreinoCat;

public interface DuracaoTreinoCatDAO extends DAO<DuracaoTreinoCat, Integer>
{

    public List<DuracaoTreinoCat> buscarTodos();

}
