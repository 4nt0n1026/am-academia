package br.com.acad.dao.treino.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.ExercicioTreinoDAO;
import br.com.acad.model.treino.DiaTreino;
import br.com.acad.model.treino.ExercicioTreino;

@Repository
public class ExercicioTreinoDAOImpl extends DAOImpl<ExercicioTreino, Integer> implements ExercicioTreinoDAO
{

    public ExercicioTreinoDAOImpl()
    {
        super();
    }

    @Override
    public List<ExercicioTreino> buscarTodos()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExercicioTreino> buscarPorDiaTreino(DiaTreino dia)
    {
        Query q = em.createQuery("select d.exerciciosTreino from DiaTreino d where d.id=:id");
        q.setParameter("id", dia.getId());
        return q.getResultList();
    }

}
