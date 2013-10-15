package br.com.acad.dao.dieta.interf;

import java.util.List;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.dieta.Dieta;
import br.com.acad.model.pessoa.Aluno;

public interface DietaDAO extends DAO<Dieta, Integer>
{
    List<Dieta> buscarPorAluno(Aluno aluno);

}
