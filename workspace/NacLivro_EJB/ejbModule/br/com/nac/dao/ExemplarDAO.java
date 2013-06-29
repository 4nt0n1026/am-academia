package br.com.nac.dao;

import java.util.List;

import javax.ejb.Remote;

import br.com.nac.model.Exemplar;
import br.com.nac.model.Livro;

@Remote
public interface ExemplarDAO extends DAO< Exemplar, Integer>{

	public List<Exemplar> buscarPorLivro(Livro livro);
	
}
