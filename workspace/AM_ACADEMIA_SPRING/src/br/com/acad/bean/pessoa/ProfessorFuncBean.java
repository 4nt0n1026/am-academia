package br.com.acad.bean.pessoa;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.logic.CriptografiaLogic;
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
		staticFields = ProfessorFunc.STATIC_FIELDS;
		staticFieldsOrderLabel = ProfessorFunc.STATIC_FIELDS_ORDER_LABEL;
		staticFieldsOrderValue = ProfessorFunc.STATIC_FIELDS_ORDER_VALUE;
		staticViewsLabel = ProfessorFunc.STATIC_VIEWS_LABEL;
		staticViewsValue = ProfessorFunc.STATIC_VIEWS_VALUE;
		view = staticViewsLabel[0];
		order = staticFieldsOrderLabel[0];
		atualizar();
	}
	
	/**
	 * show form de entity
	 */
	@Override
	public void showNewEntity() {
		showEntity = true;
		entity = new ProfessorFunc();
		String senha = CriptografiaLogic.encriptar(entity.getSenha());
		entity.setSenha(senha);
	}

	/**
	 * inclui ou edita entity no banco
	 */
	@Override
	public void incluirEntity() {
//		// Encriptografa senha caso seja uma nova entidade
//		if(entity.getId()==0){
//			String senha = CriptografiaLogic.encriptar(entity.getSenha());
//			entity.setSenha(senha);
//		}
		incluirGeneric( entity!=null? entity.getId():0);
	}

	/**
	 * deleta entity do banco
	 */
	@Override
	public void deletarEntity() {
		deletarGeneric(entity!=null?entity.getId():0);
	}
	
	
	/************************************************************************************************************/
	//GET FIELDS
	/************************************************************************************************************/
	
	

	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	
}
