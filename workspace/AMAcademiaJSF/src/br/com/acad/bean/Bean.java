package br.com.acad.bean;

import java.util.List;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.logic.MessagesLogic;

public abstract class Bean<T> {

	
	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/

	protected DAO<T, Integer> dao;
	
	protected T entity;
	protected List<T> entities;
	protected boolean showEntity;
	
	
	/************************************************************************************************************/
	//ASSINATURAS
	/************************************************************************************************************/
	
	/**
	 * mostra painel de inserção de uma nova Entity 
	 */
	public abstract void init();
	public abstract void showNewEntity();
	public abstract void incluirEntity();
	public abstract void deletarEntity();
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	/**
	 * fecha painel de edicao de uma entity
	 */
	public void dontShowEntity() {
		showEntity = false;
	}
	
	/**
	 * mostra painel de edição de uma Entity
	 */
	public void showEditEntity(){
		if(entity!=null){
			showEntity = true;
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione um para editar");
		}
	}

	/************************************************************************************************************/
	//METODOS CHAMADOS
	/************************************************************************************************************/
	
	/**
	 * inclui ou edita Entity no banco
	 * @param dao DAO da entity a ser inserida
	 * @param id id do objeto que sera inserido no banco
	 */
	public void incluirGeneric(Integer id) {
		if(id==0){
			entity =  dao.insert(entity);
			entities.add(entity);
		}else{
			dao.update(entity);
		}
		showEntity = false;		
		MessagesLogic.addInfoMessage("Sucesso", "Salvo com sucesso");
		entity = null;
	}
	
	
	
	/**
	 * Deleta Entity do banco
	 * @param dao DAO referente a entity a ser excluida
	 * @param entity objeto que sera excluido
	 * @param id id da entity que sera excluida
	 */
	public void deletarGeneric(Integer id){
		if(entity != null){
			dao.removeById(id);
			entities.remove(entity);
			showEntity = false;
			MessagesLogic.addInfoMessage("Sucesso", "Deletado com sucesso");
			
			entity = null;
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione um para deletar");
		}
	}

	/**
	 * atualiza pagina
	 */
	public void atualizar() {
		showEntity = false;
		entities = dao.buscarTodos();
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
	
	
	

	
	
	
	
	
}
