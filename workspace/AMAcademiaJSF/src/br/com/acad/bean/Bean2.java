package br.com.acad.bean;

import java.util.List;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.logic.MessagesLogic;

/**
 * Bean generico com metodos, atributos e assinaturas que todos beans devem possuir.
 * 
 * @author Christian Storch
 * 
 * @param <T>
 */
public abstract class Bean2<T> {

	
	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/

	protected DAO<T, Integer> dao;
	
	protected Integer id;
	protected T entity;
	protected List<T> entities;
	
	protected boolean showEntity;
	protected boolean showEntity2;
	protected boolean showEntity3;
	protected boolean showEntity4;
	protected boolean showEntityDetail;
	
	
	/************************************************************************************************************/
	//ASSINATURAS
	/************************************************************************************************************/
	
	public abstract void init();
	public abstract void showNewEntity();
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	/**
	 * fecha painel de edicao de uma entity
	 */
	public void dontShowEntity() {
		closeForms();
	}
	
	/**
	 * inclui ou edita Entity no banco
	 * @param dao DAO da entity a ser inserida
	 * @param id id do objeto que sera inserido no banco
	 */
	public void incluirEntity() {
		if(id==0){
			entity = dao.insert(entity);
			entities.add(entity);
		}else{
			entity = dao.update(entity);
		}
		closeForms();	
		MessagesLogic.addInfoMessage("Sucesso", "Salvo com sucesso");
	}
	
	/**
	 * Deleta Entity do banco
	 * @param dao DAO referente a entity a ser excluida
	 * @param entity objeto que sera excluido
	 * @param id id da entity que sera excluida
	 */
	public void deletarEntity(){
		if(entity != null){
			dao.removeById(id);
			entities.remove(entity);
			closeForms();
			MessagesLogic.addInfoMessage("Sucesso", "Deletado com sucesso");
			
			entity = null;
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione um para deletar");
		}
	}
	
	/**
	 * mostra painel de edicao de uma Entity
	 */
	public void showEditEntity(){
		if(entity!=null){
			showEntity = true;
			showEntity2 = false;
			showEntity3 = false;
			showEntity4 = false;
			showEntityDetail = false;
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione um para editar");
		}
	}
	
	/**
	 * atualiza pagina
	 */
	public void atualizar() {
		closeForms();
		entities = dao.buscarTodos();
		MessagesLogic.addInfoMessage("Sucesso", "Atualizado");
	}
	
	/**
	 * abre formulario 1.
	 * Utilizado somente para casos de formularios mais complexos
	 */
	public void showForm1(){
		showEntity = true;
		showEntity2 = false;
		showEntity3 = false;
		showEntity4 = false;
	}
	
	/**
	 * fecha formulario 1 e abre o 2.
	 * Utilizado somente para casos de formularios mais complexos
	 */
	public void showForm2(){
		showEntity = false;
		showEntity2 = true;
		showEntity3 = false;
		showEntity4 = false;
	}
	
	/**
	 * fecha formulario 2 e abre o 3.
	 * Utilizado somente para casos de formularios mais complexos
	 */
	public void showForm3(){
		showEntity = false;
		showEntity2 = false;
		showEntity3 = true;
		showEntity4 = false;
	}
	
	/**
	 * fecha formulario 3 e abre o 4.
	 * Utilizado somente para casos de formularios mais complexos
	 */
	public void showForm4(){
		showEntity = false;
		showEntity2 = false;
		showEntity3 = false;
		showEntity4 = true;
	}
	
	/**
	 * Mostra detalhes da entidade selecionada
	 * Utilizado somente para casos de formularios mais complexos
	 */
	public void showFormDetail(){
		closeForms();
		showEntityDetail = true;
	}
	
	/**
	 * Mostra detalhes da entidade selecionada
	 * Utilizado somente para casos de formularios mais complexos
	 */
	public void hideFormDetail(){
		showEntityDetail = false;
	}

	/************************************************************************************************************/
	//METODOS CHAMADOS
	/************************************************************************************************************/
	

	/**
	 * fecha todos formularios.
	 * Utilizado somente para casos de formularios mais complexos
	 */
	public void closeForms(){
		showEntity = false;
		showEntity2 = false;
		showEntity3 = false;
		showEntity4 = false;
	}
	
	
	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	public List<T> getEntities() {
		return entities;
	}
	public boolean getShowEntity() {
		return showEntity;
	}
	public T getEntity() {
		return entity;
	}
	public void setEntity(T entity) {
		this.entity = entity;
	}
	public boolean getShowEntity2() {
		return showEntity2;
	}
	public boolean getShowEntity3() {
		return showEntity3;
	}
	public boolean getShowEntity4() {
		return showEntity4;
	}
	public boolean getShowEntityDetail() {
		return showEntityDetail;
	}
	
	
	
	

	
	
	
	
	
}
