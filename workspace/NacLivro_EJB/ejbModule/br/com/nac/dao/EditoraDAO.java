package br.com.nac.dao;

import java.util.List;

import javax.ejb.Remote;

import br.com.nac.model.Editora;

@Remote
public interface EditoraDAO extends DAO< Editora, Integer> {

	public List<Editora> buscaPorNome(String nome);
	
	public List<Editora> buscarTodos();
	
}
