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
public class FuncionarioBean implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	//daos
	@EJB
	private ProfessorFuncDAO funcDAO;
	
	//Funcionario
	private ProfessorFunc funcionario;
	private List<ProfessorFunc> funcionarios;
	private boolean showFunc;
	
	
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	/**
	 * init
	 */
	@PostConstruct
	public void init(){
		funcionarios = funcDAO.buscarTodosFunc();
		showFunc = false;
	}
	
	/**
	 * mostra painel de inserção de um novo professorFunc
	 */
	public void showNewFuncionario(){
		funcionario = new ProfessorFunc();
		funcionario.setDataNascimento(Calendar.getInstance());
		showFunc = true;
	}
	
	/**
	 * mostra painel de edição de um professorFunc
	 */
	public void showEditFuncionario(){
		if(funcionario==null){
			MessagesLogic.addWarnMessage("Erro", "Selecione um funcionario para editar");
		}else{
			showFunc = true;
		}
	}
	
	/**
	 * fecha painel de inserção de professorFunc
	 */
	public void dontShowFuncionario(){
		funcionario = new ProfessorFunc();
		showFunc = false;
	}
	
	/**
	 * inclui ou edita professorFunc no banco
	 */
	public void incluirFuncionario(){
		if(funcionario.getId()==0){
			funcionario.setIsProfessor(false);
			funcionario = funcDAO.insert(funcionario);
			funcionarios.add(funcionario);
		}else{
			funcDAO.update(funcionario);
		}
		funcionario = new ProfessorFunc();
		showFunc = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Funcionario salvo com sucesso");
	}
	
	/**
	 * deleta professorFunc do banco
	 */
	public void deletarFuncionario(){
		if(funcionario != null){
			funcDAO.removeById(funcionario.getId());
			funcionarios.remove(funcionario);
			showFunc = false;
			MessagesLogic.addInfoMessage("Sucesso", "Funcionario deletado com sucesso");
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione um Funcionario para deletar");
		}
	}
      
	/**
	 * atualiza informações 
	 */
	public void atualizar(){
		funcionarios = funcDAO.buscarTodosProf();
		funcionario = new ProfessorFunc();
		showFunc = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Atualizado");
	}

	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	public ProfessorFunc getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(ProfessorFunc funcionario) {
		this.funcionario = funcionario;
	}

	public List<ProfessorFunc> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<ProfessorFunc> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public boolean getShowFunc() {
		return showFunc;
	}


	

	
}
