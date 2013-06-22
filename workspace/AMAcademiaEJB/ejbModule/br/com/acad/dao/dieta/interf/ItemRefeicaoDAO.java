package br.com.acad.dao.dieta.interf;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.dieta.ItemRefeicao;

@Remote
public interface ItemRefeicaoDAO extends DAO<ItemRefeicao,Integer>{
	
	
	
}
