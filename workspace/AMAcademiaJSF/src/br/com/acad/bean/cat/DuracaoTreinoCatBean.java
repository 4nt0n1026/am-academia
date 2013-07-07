package br.com.acad.bean.cat;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.dao.catGenerico.interf.DuracaoTreinoCatDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.model.cat.DuracaoTreinoCat;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class DuracaoTreinoCatBean implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	//daos
	@EJB
	private DuracaoTreinoCatDAO duracaoTreinoCatDAO;
	
	//DuracaoTreinoCat
	private DuracaoTreinoCat duracaoTreinoCat;
	private List<DuracaoTreinoCat> duracaoTreinoCats;
	private boolean showDuracaoTreinoCat;

	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	/**
	 * init
	 */
	@PostConstruct
	public void init(){
		duracaoTreinoCats = duracaoTreinoCatDAO.buscarTodos();
		showDuracaoTreinoCat = false;
	}
	
	/**
	 * mostra painel de inserção de uma nova duracaoTreinoCat 
	 */
	public void showNewDuracaoTreinoCat(){
		duracaoTreinoCat = new DuracaoTreinoCat();
		showDuracaoTreinoCat = true;
	}
	
	/**
	 * mostra painel de edição de uma duracaoTreinoCat
	 */
	public void showEditDuracaoTreinoCat(){
		if(duracaoTreinoCat==null){
			MessagesLogic.addWarnMessage("Erro", "Selecione categoria de duração de treino para editar");
		}else{
			showDuracaoTreinoCat = true;
		}
	}
	
	/**
	 * fecha painel de inserção de duracaoTreinoCat
	 */
	public void dontShowDuracaoTreinoCat(){
		duracaoTreinoCat = new DuracaoTreinoCat();
		showDuracaoTreinoCat = false;
	}
	
	/**
	 * inclui ou edita duracaoTreinoCat no banco
	 */
	public void incluirDuracaoTreinoCat(){
		if(duracaoTreinoCat.getId()==0){
			duracaoTreinoCat = duracaoTreinoCatDAO.insert(duracaoTreinoCat);
			duracaoTreinoCats.add(duracaoTreinoCat);
		}else{
			duracaoTreinoCatDAO.update(duracaoTreinoCat);
		}
		duracaoTreinoCat = new DuracaoTreinoCat();
		showDuracaoTreinoCat = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Categoria de duração de treino salva com sucesso");
	}
	
	/**
	 * deleta duracaoTreinoCat do banco
	 */
	public void deletarDuracaoTreinoCat(){
		if(duracaoTreinoCat != null){
			duracaoTreinoCatDAO.removeById(duracaoTreinoCat.getId());
			duracaoTreinoCats.remove(duracaoTreinoCat);
			showDuracaoTreinoCat = false;
			MessagesLogic.addInfoMessage("Sucesso", "Categoria de duração de treino deletada com sucesso");
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione categoria de duração de treino para deletar");
		}
	}
      
	/**
	 * atualiza informações 
	 */
	public void atualizar(){
		duracaoTreinoCats = duracaoTreinoCatDAO.buscarTodos();
		duracaoTreinoCat = new DuracaoTreinoCat();
		showDuracaoTreinoCat = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Atualizado");
	}

	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	public DuracaoTreinoCat getDuracaoTreinoCat() {
		return duracaoTreinoCat;
	}

	public void setDuracaoTreinoCat(DuracaoTreinoCat duracaoTreinoCat) {
		this.duracaoTreinoCat = duracaoTreinoCat;
	}

	public List<DuracaoTreinoCat> getDuracaoTreinoCats() {
		return duracaoTreinoCats;
	}

	public boolean getShowDuracaoTreinoCat() {
		return showDuracaoTreinoCat;
	}


	
	
	
}
