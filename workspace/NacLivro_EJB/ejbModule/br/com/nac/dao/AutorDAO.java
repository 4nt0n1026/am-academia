package br.com.nac.dao;

import java.util.List;

import javax.ejb.Remote;

import br.com.nac.model.Autor;
import br.com.nac.model.Livro;

@Remote
public interface AutorDAO extends DAO<Autor, Integer> {
	
	public List<Autor> buscarTodos();
	
	public List<Autor> buscarTodosPorLivro(Livro livro);
	
}
