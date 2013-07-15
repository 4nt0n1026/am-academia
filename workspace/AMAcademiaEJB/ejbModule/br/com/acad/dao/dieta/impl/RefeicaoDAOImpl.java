package br.com.acad.dao.dieta.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.dieta.interf.RefeicaoDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.dieta.Refeicao;

@Stateless
public class RefeicaoDAOImpl extends DAOImpl<Refeicao,Integer> implements RefeicaoDAO{

	public RefeicaoDAOImpl() {
		super();
	}

	@Override
	public List<Refeicao> buscarTodos() {
		TypedQuery<Refeicao> q = em.createQuery("from Refeicao", Refeicao.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Refeicao> buscarTodos(int page, String txtSearch, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Refeicao> filtrarTodos(int page, Map<String, String> filtros,
			String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long contarTodosFiltro(Map<String, String> filtros) {
		// TODO Auto-generated method stub
		return 0;
	}

}
