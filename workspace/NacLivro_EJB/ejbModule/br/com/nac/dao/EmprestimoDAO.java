package br.com.nac.dao;

import java.util.List;

import javax.ejb.Remote;

import br.com.nac.model.Emprestimo;

@Remote
public interface EmprestimoDAO extends DAO< Emprestimo, Integer>{

	public List<Emprestimo> buscarTodos();
	
}
