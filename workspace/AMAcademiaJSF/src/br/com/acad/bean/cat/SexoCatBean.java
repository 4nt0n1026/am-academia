package br.com.acad.bean.cat;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.dao.catGenerico.interf.SexoCatDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.model.cat.SexoCat;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class SexoCatBean implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	//daos
	@EJB
	private SexoCatDAO sexoCatDAO;
	
	//SexoCat
	private SexoCat sexoCat;
	private List<SexoCat> sexoCats;
	private boolean showSexoCat;

	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	/**
	 * init
	 */
	@PostConstruct
	public void init(){
		sexoCats = sexoCatDAO.buscarTodos();
		showSexoCat = false;
	}
	
	/**
	 * mostra painel de inserção de uma nova sexoCat 
	 */
	public void showNewSexoCat(){
		sexoCat = new SexoCat();
		showSexoCat = true;
	}
	
	/**
	 * mostra painel de edição de uma sexoCat
	 */
	public void showEditSexoCat(){
		if(sexoCat==null){
			MessagesLogic.addWarnMessage("Erro", "Selecione uma categoria de sexo para editar");
		}else{
			showSexoCat = true;
		}
	}
	
	/**
	 * fecha painel de inserção de sexoCat
	 */
	public void dontShowSexoCat(){
		sexoCat = new SexoCat();
		showSexoCat = false;
	}
	
	/**
	 * inclui ou edita sexoCat no banco
	 */
	public void incluirSexoCat(){
		if(sexoCat.getId()==0){
			sexoCat = sexoCatDAO.insert(sexoCat);
			sexoCats.add(sexoCat);
		}else{
			sexoCatDAO.update(sexoCat);
		}
		sexoCat = new SexoCat();
		showSexoCat = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Categoria de sexo salva com sucesso");
	}
	
	/**
	 * deleta sexoCat do banco
	 */
	public void deletarSexoCat(){
		if(sexoCat != null){
			sexoCatDAO.removeById(sexoCat.getId());
			sexoCats.remove(sexoCat);
			showSexoCat = false;
			MessagesLogic.addInfoMessage("Sucesso", "Categoria de sexo deletada com sucesso");
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione uma categoria de sexo para deletar");
		}
	}
      
	/**
	 * atualiza informações 
	 */
	public void atualizar(){
		sexoCats = sexoCatDAO.buscarTodos();
		sexoCat = new SexoCat();
		showSexoCat = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Atualizado");
	}


	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	public SexoCat getSexoCat() {
		return sexoCat;
	}

	public void setSexoCat(SexoCat sexoCat) {
		this.sexoCat = sexoCat;
	}

	public List<SexoCat> getSexoCats() {
		return sexoCats;
	}

	public boolean isShowSexoCat() {
		return showSexoCat;
	}


	
}
