package br.com.acad.dao.dieta.interf;

import java.util.List;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.dieta.SolicitacaoDieta;
import br.com.acad.model.pessoa.Aluno;

@Remote
public interface SolicitacaoDietaDAO extends DAO<SolicitacaoDieta,Integer>{
	
	public List<SolicitacaoDieta> buscarPorAluno(Aluno aluno);
	
}
