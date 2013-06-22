package br.com.acad.dao.dieta.interf;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.dieta.SolicitacaoDieta;

@Remote
public interface SolicitacaoDietaDAO extends DAO<SolicitacaoDieta,Integer>{
	
	
	
}
