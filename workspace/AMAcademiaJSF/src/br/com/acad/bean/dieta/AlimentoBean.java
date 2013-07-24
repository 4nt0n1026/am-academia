package br.com.acad.bean.dieta;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.bean.Bean;
import br.com.acad.dao.dieta.interf.AlimentoDAO;
import br.com.acad.dao.dieta.interf.UnidadeMedidaDAO;
import br.com.acad.model.dieta.Alimento;
import br.com.acad.model.dieta.UnidadeMedida;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AlimentoBean extends Bean<Alimento> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@EJB
	private AlimentoDAO alimentoDAO;
	@EJB
	private UnidadeMedidaDAO unidadeMedidaDAO;
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		page = 1;
		dao = alimentoDAO;
		staticFields = Alimento.STATIC_FIELDS;
		atualizar();
	}
	
	/**
	 * show form de entity
	 */
	@Override
	public void showNewEntity() {
		showEntity = true;
		entity = new Alimento();
		entity.setUnidadeMedida(new UnidadeMedida());
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
	
	/**
	 * busca todas as unidades de medida para preencher o field
	 */
	public List<UnidadeMedida> getUnidadeMedidaField() {
		return unidadeMedidaDAO.buscarFieldNome();
	}
	

	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	
}
