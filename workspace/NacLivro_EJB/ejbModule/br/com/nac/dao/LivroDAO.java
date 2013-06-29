package br.com.nac.dao;

import java.util.List;

import javax.ejb.Remote;

import br.com.nac.model.Livro;

@Remote
public interface LivroDAO extends DAO<Livro, Integer> {

	public List<Livro> buscaTodos();
	public List<Livro> buscaPorTitulo(String titulo);
	
	
}
