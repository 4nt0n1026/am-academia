package br.com.fiap.cliente.dao;

import javax.ejb.Remote;

import br.com.fiap.cliente.entity.Cidade;
import br.com.fiap.dao.DAO;

@Remote
public interface CidadeDAO extends DAO<Cidade,Integer>{

}
