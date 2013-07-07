package br.com.acad.bean.cat;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.dao.catGenerico.interf.FaixaEtariaCatDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.model.cat.FaixaEtariaCat;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FaixaEtariaCatBean implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	//daos
	@EJB
	private FaixaEtariaCatDAO faixaEtariaCatDAO;
	
	//FaixaEtariaCat
	private FaixaEtariaCat faixaEtariaCat;
	private List<FaixaEtariaCat> FaixaEtariaCats;
	private boolean showFaixaEtariaCat;

	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	/**
	 * init
	 */
	@PostConstruct
	public void init(){
		FaixaEtariaCats = faixaEtariaCatDAO.buscarTodos();
		showFaixaEtariaCat = false;
	}
	
	/**
	 * mostra painel de inserção de uma nova faixaEtariaCat 
	 */
	public void showNewFaixaEtariaCat(){
		faixaEtariaCat = new FaixaEtariaCat();
		showFaixaEtariaCat = true;
	}
	
	/**
	 * mostra painel de edição de uma faixaEtariaCat
	 */
	public void showEditFaixaEtariaCat(){
		if(faixaEtariaCat==null){
			MessagesLogic.addWarnMessage("Erro", "Selecione um categoria de faixa etaria para editar");
		}else{
			showFaixaEtariaCat = true;
		}
	}
	
	/**
	 * fecha painel de inserção de faixaEtariaCat
	 */
	public void dontShowFaixaEtariaCat(){
		faixaEtariaCat = new FaixaEtariaCat();
		showFaixaEtariaCat = false;
	}
	
	/**
	 * inclui ou edita faixaEtariaCat no banco
	 */
	public void incluirFaixaEtariaCat(){
		if(faixaEtariaCat.getId()==0){
			faixaEtariaCat = faixaEtariaCatDAO.insert(faixaEtariaCat);
			FaixaEtariaCats.add(faixaEtariaCat);
		}else{
			faixaEtariaCatDAO.update(faixaEtariaCat);
		}
		faixaEtariaCat = new FaixaEtariaCat();
		showFaixaEtariaCat = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Categoria de faixa etaria salva com sucesso");
	}
	
	/**
	 * deleta faixaEtariaCat do banco
	 */
	public void deletarFaixaEtariaCat(){
		if(faixaEtariaCat != null){
			faixaEtariaCatDAO.removeById(faixaEtariaCat.getId());
			FaixaEtariaCats.remove(faixaEtariaCat);
			showFaixaEtariaCat = false;
			MessagesLogic.addInfoMessage("Sucesso", "Categoria de faixa etaria deletada com sucesso");
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione um categoria de faixa etaria para deletar");
		}
	}
      
	/**
	 * atualiza informações 
	 */
	public void atualizar(){
		FaixaEtariaCats = faixaEtariaCatDAO.buscarTodos();
		faixaEtariaCat = new FaixaEtariaCat();
		showFaixaEtariaCat = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Atualizado");
	}
	
	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/

	public FaixaEtariaCat getFaixaEtariaCat() {
		return faixaEtariaCat;
	}

	public void setFaixaEtariaCat(FaixaEtariaCat faixaEtariaCat) {
		this.faixaEtariaCat = faixaEtariaCat;
	}

	public List<FaixaEtariaCat> getFaixaEtariaCats() {
		return FaixaEtariaCats;
	}

	public boolean getShowFaixaEtariaCat() {
		return showFaixaEtariaCat;
	}


	
	
	
	
	
}
