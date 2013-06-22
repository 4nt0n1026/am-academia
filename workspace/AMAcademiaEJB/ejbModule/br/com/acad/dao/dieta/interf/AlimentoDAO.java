package br.com.acad.dao.dieta.interf;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.dieta.Alimento;

@Remote
public interface AlimentoDAO extends DAO<Alimento,Integer>{
	
	
	
}
