package br.com.acad.dao.dieta.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

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
		TypedQuery<ItemRefeicao> q = em.createQuery("from ItemRefeicao", ItemRefeicao.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ItemRefeicao> buscarTodos(int page, String txtSearch,
			String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemRefeicao> filtrarTodos(int page,
			Map<String, String> filtros, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long contarTodosFiltro(Map<String, String> filtros) {
		// TODO Auto-generated method stub
		return 0;
	}

}
