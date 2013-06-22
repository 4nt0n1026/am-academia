package br.com.fiap.pacote.dao;

import javax.ejb.Remote;

import br.com.fiap.dao.DAO;
import br.com.fiap.pacote.entity.Transporte;

@Remote
public interface TransporteDAO extends DAO<Transporte,Integer>{

}
