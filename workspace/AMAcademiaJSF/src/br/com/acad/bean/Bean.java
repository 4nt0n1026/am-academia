package br.com.acad.bean;

import java.util.List;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.logic.SqlLogic;

/**
 * Bean generico com metodos, atributos e assinaturas que todos beans devem possuir.
 * 
 * @author Christian Storch
 * 
 * @param <T>
 */
public abstract class Bean<T> {

	
	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/

	// DAO
	protected DAO<T, Integer> dao;

	// Entity
	protected T entity;
	protected List<T> entities;
	
	
	// Search
	protected String[] staticFields;
	protected int page;
	protected String search;
	protected String order;
	protected long totalPages;
	protected long totalEntities;
	
	// Navigation
	protected boolean showEntity;
	protected boolean showEntity2;
	protected boolean showEntity3;
	protected boolean showEntity4;

	// Detail
	protected boolean showEntityDetail;
	
	
	/************************************************************************************************************/
	//ASSINATURAS
	/************************************************************************************************************/
	
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
		closeForms();
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
		entities = buscarTodos();
		atualizaPages();
	}

	/**
	 * Apaga o filtro de search
	 */
	public void resetSearch() {
		search = "";
		closeForms();
		entities = buscarTodos();
		atualizaPages();
	}

	/**
	 * atualiza pagina com msg de sucesso
	 */
	public void atualizarComMsg() {
		closeForms();
		entities = buscarTodos();
		atualizaPages();
		MessagesLogic.addInfoMessage("Sucesso", "Atualizado");
	}
	
	/**
	 * proxima tela da tabela.
	 */
	public void nextPageTable(){
		if(page<totalPages){
			page++;
			atualizar();
		}else{
			MessagesLogic.addWarnMessage("Aviso", "ultima pagina");
		}
	}

	/**
	 * tela anterior da tabela.
	 */
	public void previousPageTable(){
		if(page>1){
			page--;
			atualizar();
		}else{
			MessagesLogic.addWarnMessage("Aviso", "primeira pagina");
		}
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
	//METODOS INTERNOS
	/************************************************************************************************************/
	
	/**
	 * Atualiza o total de entities e o total de paginas
	 */
	public void atualizaPages(){
		totalEntities = contarTodos();
		totalPages = (totalEntities/SqlLogic.TABLE_SIZE); 
		totalPages += totalEntities%SqlLogic.TABLE_SIZE!=0?1:0;
		if(totalPages==0){
			totalPages = 1;
		}
	}
	
	/**
	 * inclui ou edita Entity no banco
	 * @param dao DAO da entity a ser inserida
	 * @param id id do objeto que sera inserido no banco
	 */
	protected void incluirGeneric(Integer id) {
		if(id==0){
			entity = dao.insert(entity);
		}else{
			entity = dao.update(entity);
		}
		atualizar();
		MessagesLogic.addInfoMessage("Sucesso", "Salvo com sucesso");
	}
	
	
	
	/**
	 * Deleta Entity do banco
	 * @param dao DAO referente a entity a ser excluida
	 * @param entity objeto que sera excluido
	 * @param id id da entity que sera excluida
	 */
	protected void deletarGeneric(Integer id){
		if(entity != null){
			dao.removeById(id);
			atualizar();
			MessagesLogic.addInfoMessage("Sucesso", "Deletado com sucesso");
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione um para deletar");
		}
	}
	
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

	/**
	 * retorna busca de todas as entities para tabela
	 * @return
	 */
	protected List<T> buscarTodos(){
		if(search!=null && search.length()>0){
			page = 1;
		}
		return dao.buscarTodos(page, search, order);
	}
	
	/**
	 * retorna contagem de todos as entities
	 * @return
	 */
	protected long contarTodos(){
		return dao.contarTodos(search);
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
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public long getTotalPages() {
		return totalPages;
	}
	public long getTotalEntities() {
		return totalEntities;
	}
	
	
	
}
