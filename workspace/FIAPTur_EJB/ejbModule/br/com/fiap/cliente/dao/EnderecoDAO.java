package br.com.fiap.cliente.dao;

import javax.ejb.Remote;

import br.com.fiap.cliente.entity.Endereco;
import br.com.fiap.dao.DAO;

@Remote
public interface EnderecoDAO extends DAO<Endereco,Integer>{

}
