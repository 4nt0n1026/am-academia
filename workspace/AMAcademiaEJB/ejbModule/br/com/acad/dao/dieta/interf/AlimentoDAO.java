package br.com.acad.dao.dieta.interf;

import java.util.List;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.dieta.Alimento;
import br.com.acad.model.treino.Exercicio;

@Remote
public interface AlimentoDAO extends DAO<Alimento,Integer>{

	
	
	
}
