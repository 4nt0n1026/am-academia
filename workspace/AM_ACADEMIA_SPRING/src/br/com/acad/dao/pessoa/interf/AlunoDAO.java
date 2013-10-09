package br.com.acad.dao.pessoa.interf;

import java.util.List;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.pessoa.Aluno;

public interface AlunoDAO extends DAO<Aluno, Integer>
{

    public List<Aluno> buscarTodos();

    public List<Aluno> buscarFieldNome();

    public Aluno logar(Aluno aluno);

}
