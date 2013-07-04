package br.com.acad.dao.avisos.interf;

import java.util.List;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.avisos.Noticia;

@Remote
public interface NoticiaDAO extends DAO<Noticia,Integer>{
	
	public List<Noticia> buscarTodos();
	
}
