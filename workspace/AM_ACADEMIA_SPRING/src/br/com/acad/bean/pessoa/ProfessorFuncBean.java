package br.com.acad.bean.pessoa;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.logic.AnnotationsLogic;
import br.com.acad.logic.CriptografiaLogic;
import br.com.acad.logic.TableLogic;
import br.com.acad.model.pessoa.Pessoa;
import br.com.acad.model.pessoa.ProfessorFunc;


@SuppressWarnings("serial")
@Component
@Scope(value="view")
public class ProfessorFuncBean extends Bean<ProfessorFunc> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@Autowired
	private ProfessorFuncDAO professorFuncDAO;
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		dao = professorFuncDAO;
		staticFields = AnnotationsLogic.getSearchValueFields(Pessoa.class, ProfessorFunc.class);
		staticFieldsOrderLabel = AnnotationsLogic.getOrderLabelFields(Pessoa.class, ProfessorFunc.class);
		staticFieldsOrderValue = AnnotationsLogic.getOrderValueFields(Pessoa.class, ProfessorFunc.class);
		
		tableHeaders = TableLogic.getTableHeaders(Pessoa.class, ProfessorFunc.class);
		tableValues= TableLogic.getTableValues(Pessoa.class, ProfessorFunc.class);
		
		super.init();
	}
	
	/**
	 * show form de entity
	 */
	@Override
	public void showNewEntity() {
		showEntity = true;
		entity = new ProfessorFunc();
		String senha = CriptografiaLogic.encriptar("123");
		entity.setSenha(senha);
	}

	
	
	/************************************************************************************************************/
	//GET FIELDS
	/************************************************************************************************************/
	
	

	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	
}
