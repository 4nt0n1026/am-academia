package br.com.acad.bean.cat;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.dao.catGenerico.interf.ObjetivoCatDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.model.cat.ObjetivoCat;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ObjetivoCatBean implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	//daos
	@EJB
	private ObjetivoCatDAO objetivoCatDAO;
	
	//ObjetivoCat
	private ObjetivoCat objetivoCat;
	private List<ObjetivoCat> objetivoCats;
	private boolean showObjetivoCat;

	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	/**
	 * init
	 */
	@PostConstruct
	public void init(){
		objetivoCats = objetivoCatDAO.buscarTodos();
		showObjetivoCat = false;
	}
	
	/**
	 * mostra painel de inserção de uma nova objetivoCat 
	 */
	public void showNewObjetivoCat(){
		objetivoCat = new ObjetivoCat();
		showObjetivoCat = true;
	}
	
	/**
	 * mostra painel de edição de uma objetivoCat
	 */
	public void showEditObjetivoCat(){
		if(objetivoCat==null){
			MessagesLogic.addWarnMessage("Erro", "Selecione uma categoria de objetivo para editar");
		}else{
			showObjetivoCat = true;
		}
	}
	
	/**
	 * fecha painel de inserção de objetivoCat
	 */
	public void dontShowObjetivoCat(){
		objetivoCat = new ObjetivoCat();
		showObjetivoCat = false;
	}
	
	/**
	 * inclui ou edita objetivoCat no banco
	 */
	public void incluirObjetivoCat(){
		if(objetivoCat.getId()==0){
			objetivoCat = objetivoCatDAO.insert(objetivoCat);
			objetivoCats.add(objetivoCat);
		}else{
			objetivoCatDAO.update(objetivoCat);
		}
		objetivoCat = new ObjetivoCat();
		showObjetivoCat = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Categoria de objetivo salva com sucesso");
	}
	
	/**
	 * deleta objetivoCat do banco
	 */
	public void deletarObjetivoCat(){
		if(objetivoCat != null){
			objetivoCatDAO.removeById(objetivoCat.getId());
			objetivoCats.remove(objetivoCat);
			showObjetivoCat = false;
			MessagesLogic.addInfoMessage("Sucesso", "Categoria de objetivo deletada com sucesso");
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione uma categoria de objetivo para deletar");
		}
	}
      
	/**
	 * atualiza informações 
	 */
	public void atualizar(){
		objetivoCats = objetivoCatDAO.buscarTodos();
		objetivoCat = new ObjetivoCat();
		showObjetivoCat = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Atualizado");
	}

	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/

	public ObjetivoCat getObjetivoCat() {
		return objetivoCat;
	}

	public void setObjetivoCat(ObjetivoCat objetivoCat) {
		this.objetivoCat = objetivoCat;
	}

	public List<ObjetivoCat> getObjetivoCats() {
		return objetivoCats;
	}

	public boolean getShowObjetivoCat() {
		return showObjetivoCat;
	}



	
	
}
