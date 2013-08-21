package br.com.acad.dao.treino.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.DiaTreinoDAO;
import br.com.acad.model.treino.DiaTreino;
import br.com.acad.model.treino.Treino;

@Repository
public class DiaTreinoDAOImpl extends DAOImpl<DiaTreino,Integer> implements DiaTreinoDAO{

	public DiaTreinoDAOImpl() {
		super();
	}

	@Override
	public List<DiaTreino> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DiaTreino> buscaPorTreino(Treino treino) {
		
		Query q = getEntityManager().createQuery("select t.diasTreino from Treino t where t.id=:id");
		q.setParameter("id", treino.getId());
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DiaTreino> buscarTodos(int page, String txtSearch, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DiaTreino> filtrarTodos(int page, Map<String, String> filtros,
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
