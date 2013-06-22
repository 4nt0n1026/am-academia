package br.com.fiap.pacote.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.impl.DAOImpl;
import br.com.fiap.pacote.dao.ReservaDAO;
import br.com.fiap.pacote.entity.Reserva;

@Stateless
public class ReservaDAOImpl extends DAOImpl<Reserva,Integer> implements ReservaDAO {

	public ReservaDAOImpl() {
		super();
	}

	@Override
	public List<Reserva> buscaPorNomeCliente(String nome) {
		TypedQuery<Reserva> query = em.createQuery("from Reserva r where r.cliente.nome like :nome",Reserva.class);
		query.setParameter("nome", "%"+nome+"%");
		return query.getResultList();
	}

	@Override
	public List<Reserva> buscarTodos() {
		TypedQuery<Reserva> query = em.createQuery("from Reserva",Reserva.class);
		return query.getResultList();
	}

}
