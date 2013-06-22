package br.com.fiap.cliente.bo;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import br.com.fiap.cliente.dao.ClienteDAO;
import br.com.fiap.cliente.entity.Cliente;

@WebService
@Stateless
public class ClienteBO {

	@EJB
	private ClienteDAO clienteDAO;
	
	public List<Cliente> buscarClientePorNome(String nome){
		return clienteDAO.buscarPorNome(nome);
	}
}
