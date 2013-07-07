package br.com.acad.bean.horario;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.dao.horario.interf.ModalidadeDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.model.horario.Modalidade;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ModalidadeBean implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	//daos
	@EJB
	private ModalidadeDAO modalidadeDAO;
	
	//Modalidade
	private Modalidade modalidade;
	private List<Modalidade> modalidades;
	private boolean showModalidade;

	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	/**
	 * init
	 */
	@PostConstruct
	public void init(){
		modalidades = modalidadeDAO.buscarTodos();
		showModalidade = false;
	}
	
	/**
	 * mostra painel de inserção de uma nova modalidade 
	 */
	public void showNewModalidade(){
		modalidade = new Modalidade();
		showModalidade = true;
	}
	
	/**
	 * mostra painel de edição de uma modalidade
	 */
	public void showEditModalidade(){
		if(modalidade==null){
			MessagesLogic.addWarnMessage("Erro", "Selecione uma modalidade para editar");
		}else{
			showModalidade = true;
		}
	}
	
	/**
	 * fecha painel de inserção de modalidade
	 */
	public void dontShowModalidade(){
		modalidade = new Modalidade();
		showModalidade = false;
	}
	
	/**
	 * inclui ou edita modalidade no banco
	 */
	public void incluirModalidade(){
		if(modalidade.getId()==0){
			modalidade = modalidadeDAO.insert(modalidade);
			modalidades.add(modalidade);
		}else{
			modalidadeDAO.update(modalidade);
		}
		modalidade = new Modalidade();
		showModalidade = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Modalidade salva com sucesso");
	}
	
	/**
	 * deleta modalidade do banco
	 */
	public void deletarModalidade(){
		if(modalidade != null){
			modalidadeDAO.removeById(modalidade.getId());
			modalidades.remove(modalidade);
			showModalidade = false;
			MessagesLogic.addInfoMessage("Sucesso", "Modalidade deletada com sucesso");
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione uma modalidade para deletar");
		}
	}
      
	/**
	 * atualiza informações 
	 */
	public void atualizar(){
		modalidades = modalidadeDAO.buscarTodos();
		modalidade = new Modalidade();
		showModalidade = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Atualizado");
	}

	
	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public List<Modalidade> getModalidades() {
		return modalidades;
	}

	public boolean getShowModalidade() {
		return showModalidade;
	}


	
	
	
	
}
