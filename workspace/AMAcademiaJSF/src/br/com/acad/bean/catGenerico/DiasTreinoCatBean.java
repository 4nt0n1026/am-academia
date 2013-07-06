package br.com.acad.bean.catGenerico;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.dao.treino.interf.DiasTreinoCatDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.model.treino.DiasTreinoCat;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class DiasTreinoCatBean implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	//daos
	@EJB
	private DiasTreinoCatDAO diasCatDAO;
	
	//DiasTreinoCat
	private DiasTreinoCat diasTreinoCat;
	private List<DiasTreinoCat> diasTreinoCats;
	private boolean showDiasTreinoCat;

	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	/**
	 * init
	 */
	@PostConstruct
	public void init(){
		diasTreinoCats = diasCatDAO.buscarTodos();
		showDiasTreinoCat = false;
	}
	
	/**
	 * mostra painel de inserção de uma nova diasTreinoCat 
	 */
	public void showNewDiasTreinoCat(){
		diasTreinoCat = new DiasTreinoCat();
		showDiasTreinoCat = true;
	}
	
	/**
	 * mostra painel de edição de uma diasTreinoCat
	 */
	public void showEditDiasTreinoCat(){
		if(diasTreinoCat==null){
			MessagesLogic.addWarnMessage("Erro", "Selecione uma categoria de dias de treino para editar");
		}else{
			showDiasTreinoCat = true;
		}
	}
	
	/**
	 * fecha painel de inserção de diasTreinoCat
	 */
	public void dontShowDiasTreinoCat(){
		diasTreinoCat = new DiasTreinoCat();
		showDiasTreinoCat = false;
	}
	
	/**
	 * inclui ou edita diasTreinoCat no banco
	 */
	public void incluirDiasTreinoCat(){
		if(diasTreinoCat.getId()==0){
			diasTreinoCat = diasCatDAO.insert(diasTreinoCat);
			diasTreinoCats.add(diasTreinoCat);
		}else{
			diasCatDAO.update(diasTreinoCat);
		}
		diasTreinoCat = new DiasTreinoCat();
		showDiasTreinoCat = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Categoria de dias de treino salva com sucesso");
	}
	
	/**
	 * deleta diasTreinoCat do banco
	 */
	public void deletarDiasTreinoCat(){
		if(diasTreinoCat != null){
			diasCatDAO.removeById(diasTreinoCat.getId());
			diasTreinoCats.remove(diasTreinoCat);
			showDiasTreinoCat = false;
			MessagesLogic.addInfoMessage("Sucesso", "Categoria de dias de treino deletada com sucesso");
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione uma categoria de dias de treino para deletar");
		}
	}
      
	/**
	 * atualiza informações 
	 */
	public void atualizar(){
		diasTreinoCats = diasCatDAO.buscarTodos();
		diasTreinoCat = new DiasTreinoCat();
		showDiasTreinoCat = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Atualizado");
	}

	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	public DiasTreinoCat getDiasTreinoCat() {
		return diasTreinoCat;
	}

	public void setDiasTreinoCat(DiasTreinoCat diasTreinoCat) {
		this.diasTreinoCat = diasTreinoCat;
	}

	public List<DiasTreinoCat> getDiasTreinoCats() {
		return diasTreinoCats;
	}

	public boolean getShowDiasTreinoCat() {
		return showDiasTreinoCat;
	}

	
	

	
}