package br.com.acad.bean.treino;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.dao.treino.interf.ParteCorpoDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.model.treino.ParteCorpo;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ParteCorpoBean implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	//daos
	@EJB
	private ParteCorpoDAO parteCorpoDAO;
	
	//ParteCorpo
	private ParteCorpo parteCorpo;
	private List<ParteCorpo> partesCorpos;
	private boolean showParteCorpo;

	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	/**
	 * init
	 */
	@PostConstruct
	public void init(){
		partesCorpos = parteCorpoDAO.buscarTodos();
		showParteCorpo = false;
	}
	
	/**
	 * mostra painel de inserção de uma nova parteCorpo 
	 */
	public void showNewParteCorpo(){
		parteCorpo = new ParteCorpo();
		showParteCorpo = true;
	}
	
	/**
	 * mostra painel de edição de uma parteCorpo
	 */
	public void showEditParteCorpo(){
		if(parteCorpo==null){
			MessagesLogic.addWarnMessage("Erro", "Selecione uma parte de corpo para editar");
		}else{
			showParteCorpo = true;
		}
	}
	
	/**
	 * fecha painel de inserção de parteCorpo
	 */
	public void dontShowParteCorpo(){
		parteCorpo = new ParteCorpo();
		showParteCorpo = false;
	}
	
	/**
	 * inclui ou edita parteCorpo no banco
	 */
	public void incluirParteCorpo(){
		if(parteCorpo.getId()==0){
			parteCorpo = parteCorpoDAO.insert(parteCorpo);
			partesCorpos.add(parteCorpo);
		}else{
			parteCorpoDAO.update(parteCorpo);
		}
		parteCorpo = new ParteCorpo();
		showParteCorpo = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Parte de corpo salva com sucesso");
	}
	
	/**
	 * deleta parteCorpo do banco
	 */
	public void deletarParteCorpo(){
		if(parteCorpo != null){
			parteCorpoDAO.removeById(parteCorpo.getId());
			partesCorpos.remove(parteCorpo);
			showParteCorpo = false;
			MessagesLogic.addInfoMessage("Sucesso", "Parte de corpo deletada com sucesso");
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione uma parte de corpo para deletar");
		}
	}
      
	/**
	 * atualiza informações 
	 */
	public void atualizar(){
		partesCorpos = parteCorpoDAO.buscarTodos();
		parteCorpo = new ParteCorpo();
		showParteCorpo = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Atualizado");
	}


	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	public ParteCorpo getParteCorpo() {
		return parteCorpo;
	}

	public void setParteCorpo(ParteCorpo parteCorpo) {
		this.parteCorpo = parteCorpo;
	}

	public List<ParteCorpo> getPartesCorpos() {
		return partesCorpos;
	}

	public boolean getShowParteCorpo() {
		return showParteCorpo;
	}
	
	
}
