package br.com.acad.dao.dieta.interf;

import java.util.List;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.dieta.UnidadeMedida;

public interface UnidadeMedidaDAO extends DAO<UnidadeMedida,Integer>{

	List<UnidadeMedida> buscarFieldNome();
	
	
	
}
