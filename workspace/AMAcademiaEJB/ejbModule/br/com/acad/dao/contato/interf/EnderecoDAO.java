package br.com.acad.dao.contato.interf;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.contato.Endereco;

@Remote
public interface EnderecoDAO extends DAO<Endereco,Integer>{
	
	
	
}
