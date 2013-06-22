package br.com.fiap.cliente.dao;

import java.util.List;

import javax.ejb.Remote;

import br.com.fiap.cliente.entity.Cliente;
import br.com.fiap.dao.DAO;

@Remote
public interface ClienteDAO extends DAO<Cliente,Integer>{

	List<Cliente> buscarTodos();

	List<Cliente> buscarPorNome(String nome);
	
	List<String> buscarPorNomeCliente(String nome);
}
