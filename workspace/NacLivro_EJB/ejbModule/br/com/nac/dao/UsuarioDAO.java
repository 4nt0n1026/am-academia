package br.com.nac.dao;

import java.util.List;

import javax.ejb.Remote;

import br.com.nac.model.Usuario;

@Remote
public interface UsuarioDAO extends DAO< Usuario, Integer> {
		
	public List<Usuario> buscarTodos();
}
