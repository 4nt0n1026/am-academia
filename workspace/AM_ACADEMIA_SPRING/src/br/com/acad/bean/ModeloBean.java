package br.com.acad.bean;

//import java.io.Serializable;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//
//
//@SuppressWarnings("serial")
//@ManagedBean
//@ViewScoped
//public class ModeloBean extends Bean<Modelo> implements Serializable {
//
//	/************************************************************************************************************/
//	//ATRIBUTOS
//	/************************************************************************************************************/
//	
//	@EJB
//	private ModeloDAO modeloDAO;
//	
//	/************************************************************************************************************/
//	//METODOS
//	/************************************************************************************************************/
//	
//	@PostConstruct
//	@Override
//	public void init() {
//		page = 1;
//		dao = modeloDAO;
//		staticFields = Modelo.STATIC_FIELDS;
//		atualizar();
//	}
//	
//	/**
//	 * show form de entity
//	 */
//	@Override
//	public void showNewEntity() {
//		showEntity = true;
//		entity = new Modelo();
//	}
//
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
//	
//	/************************************************************************************************************/
//	//GET FIELDS
//	/************************************************************************************************************/
//	
//	
//
//	/************************************************************************************************************/
//	//GETS E SETS
//	/************************************************************************************************************/
//	
//	
// }
