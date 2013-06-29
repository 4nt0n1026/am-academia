package br.com.nac.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.nac.dao.UsuarioDAO;
import br.com.nac.model.Usuario;

@Stateless
public class UsuarioDAOImpl extends DAOImpl<Usuario, Integer> implements UsuarioDAO{
	
	public UsuarioDAOImpl(){
		super();
	}

	@Override
	public List<Usuario> buscarTodos() {
		TypedQuery<Usuario> q = em.createQuery("from Usuario", Usuario.class);
		return q.getResultList();
	}

	

}
