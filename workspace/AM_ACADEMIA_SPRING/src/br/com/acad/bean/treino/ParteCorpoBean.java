package br.com.acad.bean.treino;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.treino.interf.ParteCorpoDAO;
import br.com.acad.model.treino.ParteCorpo;


@SuppressWarnings("serial")
@Component
@Scope(value="view")
public class ParteCorpoBean extends Bean<ParteCorpo> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@Autowired
	private ParteCorpoDAO parteCorpoDAO;
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		dao = parteCorpoDAO;
		super.init();
	}
	
	
	/**
	 * show form de entity
	 */
	@Override
	public void showNewEntity() {
		showEntity = true;
		entity = new ParteCorpo();
	}

//	/**
//	 * inclui ou edita entity no banco
//	 */
//	@Override
//	public void incluirEntity() {
//		incluirGeneric( entity!=null? entity.getId():0);
//	}
//
//	/**
//	 * deleta entity do banco
//	 */
//	@Override
//	public void deletarEntity() {
//		deletarGeneric(entity!=null?entity.getId():0);
//	}
	
	/************************************************************************************************************/
	//GET FIELDS
	/************************************************************************************************************/
	
	

	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	
}
