package br.com.acad.dao.dieta.impl;

import java.util.List;

import javax.ejb.Stateless;

import br.com.acad.dao.dieta.interf.ItemRefeicaoDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.ItemRefeicao;

@Stateless
public class ItemRefeicaoDAOImpl extends DAOImpl<ItemRefeicao,Integer> implements ItemRefeicaoDAO{

	public ItemRefeicaoDAOImpl() {
		super();
	}

	@Override
	public List<ItemRefeicao> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
