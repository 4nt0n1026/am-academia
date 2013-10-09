package br.com.acad.dao.horario.interf;

import java.util.List;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.horario.Aula;
import br.com.acad.model.horario.HorarioAula;

public interface HorarioAulaDAO extends DAO<HorarioAula, Integer>
{

    public List<HorarioAula> buscarPorAula(Aula aula);

}
