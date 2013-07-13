package br.com.acad.dao.treino.interf;

import java.util.List;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.treino.Exercicio;
import br.com.acad.model.treino.ParteCorpo;

@Remote
public interface ParteCorpoDAO extends DAO<ParteCorpo,Integer>{
	
	public List<ParteCorpo> buscarPartesPrimarias(Exercicio exercicio);
	public List<ParteCorpo> buscarPartesSecundaria(Exercicio exercicio);
	
}
