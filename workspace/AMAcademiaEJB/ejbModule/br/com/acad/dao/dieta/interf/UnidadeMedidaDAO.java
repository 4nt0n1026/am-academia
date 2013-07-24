package br.com.acad.dao.dieta.interf;

import java.util.List;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.dieta.UnidadeMedida;

@Remote
public interface UnidadeMedidaDAO extends DAO<UnidadeMedida,Integer>{

	List<UnidadeMedida> buscarFieldNome();
	
	
	
}
