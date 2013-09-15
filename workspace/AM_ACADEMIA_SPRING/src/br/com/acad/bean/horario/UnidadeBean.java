package br.com.acad.bean.horario;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.horario.interf.UnidadeDAO;
import br.com.acad.model.horario.Unidade;


@SuppressWarnings("serial")
@Component
@Scope(value="view")
public class UnidadeBean extends Bean<Unidade> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@Autowired
	private UnidadeDAO unidadeDAO;
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		dao = unidadeDAO;
		super.init();
	}
	
	/**
	 * show form de entity
	 */
	@Override
	public void showNewEntity() {
		showEntity = true;
		entity = new Unidade();
	}

	/**
	 * inclui ou edita entity no banco
	 */
	@Override
	public void incluirEntity() {
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
