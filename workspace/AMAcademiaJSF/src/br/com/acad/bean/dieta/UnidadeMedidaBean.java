package br.com.acad.bean.dieta;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.bean.Bean;
import br.com.acad.dao.dieta.interf.UnidadeMedidaDAO;
import br.com.acad.model.dieta.UnidadeMedida;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UnidadeMedidaBean extends Bean<UnidadeMedida> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@EJB
	private UnidadeMedidaDAO unidadeMedidaDAO;
	

	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		dao = unidadeMedidaDAO;
		entities = unidadeMedidaDAO.buscarTodos();
	}
	
	@Override
	public void showNewEntity() {
		showEntity = true;
		entity = new UnidadeMedida();
	}

	@Override
	public void incluirEntity() {
		incluirGeneric( entity!=null? entity.getId():0);
	}

	@Override
	public void deletarEntity() {
		deletarGeneric(entity!=null?entity.getId():0);
	}

	
	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	


	

	
	

	
	
}
