package br.com.acad.bean.dieta;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.dieta.interf.UnidadeMedidaDAO;
import br.com.acad.model.dieta.UnidadeMedida;


@SuppressWarnings("serial")
@Component
@Scope(value="view")
public class UnidadeMedidaBean extends Bean<UnidadeMedida> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@Autowired
	private UnidadeMedidaDAO unidadeMedidaDAO;
	

	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		dao = unidadeMedidaDAO;
		super.init();
	}
	
	/**
	 * show form de entity
	 */
	@Override
	public void showNewEntity() {
		showEntity = true;
		entity = new UnidadeMedida();
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
