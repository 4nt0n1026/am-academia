package br.com.nac.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.nac.dao.EditoraDAO;
import br.com.nac.model.Editora;

@Stateless
public class EditoraDAOImpl extends DAOImpl<Editora, Integer> implements EditoraDAO {

	public EditoraDAOImpl(){
		super();
	}
	
	@Override
	public List<Editora> buscaPorNome(String nome) {
		TypedQuery<Editora> q =  em.createQuery("select e from Editora e where e.nome like :t", Editora.class);
		q.setParameter("t", "%" + nome + "%");
		return q.getResultList();
	}

	@Override
	public List<Editora> buscarTodos() {
		TypedQuery<Editora> q = em.createQuery("from Editora", Editora.class);
		return q.getResultList();
	}
	
}
