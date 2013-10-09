package br.com.acad.dao.treino.interf;

import java.util.List;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.treino.Exercicio;
import br.com.acad.model.treino.ParteCorpo;

public interface ExercicioDAO extends DAO<Exercicio, Integer>
{

    public List<Exercicio> buscarTodos();

    public List<Exercicio> buscarFieldNome();

    public List<Exercicio> buscarPorParteCorpo(ParteCorpo parteCorpo);

}
