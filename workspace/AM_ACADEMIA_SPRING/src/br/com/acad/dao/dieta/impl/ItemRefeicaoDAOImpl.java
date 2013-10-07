package br.com.acad.dao.dieta.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.dieta.interf.ItemRefeicaoDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.ItemRefeicao;

@Repository
public class ItemRefeicaoDAOImpl extends DAOImpl<ItemRefeicao,Integer> implements ItemRefeicaoDAO{

	public ItemRefeicaoDAOImpl() {
		super();
	}

	@Override
	public List<ItemRefeicao> buscarTodos() {
		TypedQuery<ItemRefeicao> q = em.createQuery("from ItemRefeicao", ItemRefeicao.class);
		return q.getResultList();
	}


}
