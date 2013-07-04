package br.com.acad.bean.pessoa;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.model.pessoa.ProfessorFunc;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProfessorBean implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	//daos
	@EJB
	private ProfessorFuncDAO profDAO;
	
	//prof
	private ProfessorFunc prof;
	private List<ProfessorFunc> professores;
	private boolean showProf;
	
	
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	/**
	 * init
	 */
	@PostConstruct
	public void init(){
		professores = profDAO.buscarTodosProf();
		showProf = false;
	}
	
	/**
	 * mostra painel de inserção de um novo professor
	 */
	public void showNewProfessorFunc(){
		prof = new ProfessorFunc();
		prof.setDataNascimento(Calendar.getInstance());
		showProf = true;
	}
	
	/**
	 * mostra painel de edição de um professor
	 */
	public void showEditProfessorFunc(){
		if(prof==null){
			MessagesLogic.addWarnMessage("Erro", "Selecione um professor para editar");
		}else{
			showProf = true;
		}
	}
	
	/**
	 * fecha painel de inserção de professorFunc
	 */
	public void dontShowProfessorFunc(){
		prof = new ProfessorFunc();
		showProf = false;
	}
	
	/**
	 * inclui ou edita professorFunc no banco
	 */
	public void incluirProfessorFunc(){
		if(prof.getId()==0){
			prof.setIsProfessor(true);
			prof = profDAO.insert(prof);
			professores.add(prof);
		}else{
			profDAO.update(prof);
		}
		prof = new ProfessorFunc();
		showProf = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Professor salvo com sucesso");
	}
	
	/**
	 * deleta professorFunc do banco
	 */
	public void deletarProfessorFunc(){
		if(prof != null){
			profDAO.removeById(prof.getId());
			professores.remove(prof);
			showProf = false;
			MessagesLogic.addInfoMessage("Sucesso", "Professor deletado com sucesso");
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione um Professor para deletar");
		}
	}
      
	/**
	 * atualiza informações 
	 */
	public void atualizar(){
		professores = profDAO.buscarTodosProf();
		prof = new ProfessorFunc();
		showProf = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Atualizado");
	}

	public ProfessorFunc getProf() {
		return prof;
	}

	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/

	public void setProf(ProfessorFunc prof) {
		this.prof = prof;
	}

	public List<ProfessorFunc> getProfessores() {
		return professores;
	}

	public void setProfessores(List<ProfessorFunc> professores) {
		this.professores = professores;
	}

	public boolean getShowProf() {
		return showProf;
	}


	
	
	
}
