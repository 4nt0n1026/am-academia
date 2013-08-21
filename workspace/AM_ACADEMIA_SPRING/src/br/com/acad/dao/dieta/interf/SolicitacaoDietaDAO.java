package br.com.acad.dao.dieta.interf;

import java.util.List;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.dieta.SolicitacaoDieta;
import br.com.acad.model.pessoa.Aluno;

public interface SolicitacaoDietaDAO extends DAO<SolicitacaoDieta,Integer>{
	
	public List<SolicitacaoDieta> buscarPorAluno(Aluno aluno);
	
}
