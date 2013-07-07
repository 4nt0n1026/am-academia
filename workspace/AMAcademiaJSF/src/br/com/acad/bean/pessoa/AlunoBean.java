package br.com.acad.bean.pessoa;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.dao.pessoa.interf.AlunoDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.model.pessoa.Aluno;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AlunoBean implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	//daos
	@EJB
	private AlunoDAO alunoDAO;
	
	//Aluno
	private Aluno aluno;
	private List<Aluno> alunos;
	private boolean showAluno;

	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	/**
	 * init
	 */
	@PostConstruct
	public void init(){
		alunos = alunoDAO.buscarTodos();
		showAluno = false;
	}
	
	/**
	 * mostra painel de inserção de uma nova Aluno 
	 */
	public void showNewAluno(){
		aluno = new Aluno();
		showAluno = true;
	}
	
	/**
	 * mostra painel de edição de uma Aluno
	 */
	public void showEditAluno(){
		if(aluno==null){
			MessagesLogic.addWarnMessage("Erro", "Selecione um aluno para editar");
		}else{
			showAluno = true;
		}
	}
	
	/**
	 * fecha painel de inserção de Aluno
	 */
	public void dontShowAluno(){
		aluno = new Aluno();
		showAluno = false;
	}
	
	/**
	 * inclui ou edita Aluno no banco
	 */
	public void incluirAluno(){
		if(aluno.getId()==0){
			aluno = alunoDAO.insert(aluno);
			alunos.add(aluno);
		}else{
			alunoDAO.update(aluno);
		}
		aluno = new Aluno();
		showAluno = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Aluno salva com sucesso");
	}
	
	/**
	 * deleta Aluno do banco
	 */
	public void deletarAluno(){
		if(aluno != null){
			alunoDAO.removeById(aluno.getId());
			alunos.remove(aluno);
			showAluno = false;
			MessagesLogic.addInfoMessage("Sucesso", "Aluno deletada com sucesso");
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione um aluno para deletar");
		}
	}
      
	/**
	 * atualiza informações 
	 */
	public void atualizar(){
		alunos = alunoDAO.buscarTodos();
		aluno = new Aluno();
		showAluno = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Atualizado");
	}


	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public boolean getShowAluno() {
		return showAluno;
	}


}
