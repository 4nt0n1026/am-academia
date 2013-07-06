package br.com.acad.bean.treino;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.dao.treino.interf.ExercicioDAO;
import br.com.acad.dao.treino.interf.ParteCorpoDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.model.treino.Exercicio;
import br.com.acad.model.treino.ParteCorpo;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ExercicioBean implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	//daos
	@EJB
	private ExercicioDAO exercicioDAO;
	@EJB
	private ParteCorpoDAO parteCorpoDAO;
	
	//Exercicio
	private Exercicio exercicio;
	private List<Exercicio> exercicios;
	private boolean showExercicio;
	private boolean showExercicioParte2;
	private boolean showExercicioParte3;
	
	//ParteCorpo
	private List<ParteCorpo> partesCorpo;
	

	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	/**
	 * init
	 */
	@PostConstruct
	public void init(){
		exercicios = exercicioDAO.buscarTodos();
		showExercicio = false;
		showExercicioParte2 = false;
		showExercicioParte3 = false;
	}
	
	
	/********************/
	//Exercicio
	/********************/
	
	/**
	 * mostra painel de inserção de uma nova exercicio 
	 */
	public void showNewExercicio(){
		exercicio = new Exercicio();
		showExercicio = true;
	}
	
	/**
	 * mostra painel de edição de um exercicio
	 */
	public void showEditExercicio(){
		if(exercicio==null){
			MessagesLogic.addWarnMessage("Erro", "Selecione um exercicio para editar");
		}else{
			showExercicio = true;
		}
	}
	
	/**
	 * fecha painel de inserção de exercicio
	 */
	public void dontShowExercicio(){
		exercicio = new Exercicio();
		showExercicio = false;
		showExercicioParte2 = false;
		showExercicioParte3 = false;
	}
	
	/**
	 * vai para a parte 2 de inserção de exercicio
	 */
	public void goParte2(){
		showExercicio = false;
		showExercicioParte2 = true;
		showExercicioParte3 = false;
	}
	
	/**
	 * vai para a parte 3 de inserção de exercicio
	 */
	public void goParte3(){
		showExercicio = false;
		showExercicioParte2 = false;
		showExercicioParte3 = true;
	}
	
	/**
	 * inclui ou edita exercicio no banco
	 */
	public void incluirExercicio(){
		if(exercicio.getId()==0){
			exercicio = exercicioDAO.insert(exercicio);
			exercicios.add(exercicio);
		}else{
			exercicioDAO.update(exercicio);
		}
		exercicio = new Exercicio();
		showExercicio = false;
		showExercicioParte2 = false;
		showExercicioParte3 = false;
		MessagesLogic.addInfoMessage("Sucesso", "Exercicio salva com sucesso");
	}
	
	/**
	 * deleta exercicio do banco
	 */
	public void deletarExercicio(){
		if(exercicio != null){
			exercicioDAO.removeById(exercicio.getId());
			exercicios.remove(exercicio);
			showExercicio = false;
			showExercicioParte2 = false;
			showExercicioParte3 = false;
			MessagesLogic.addInfoMessage("Sucesso", "Exercicio deletada com sucesso");
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione um exercicio para deletar");
		}
	}
      
	/********************/
	//ParteCorpo Primaria
	/********************/
	
	/**
	 * preenche field de partesCorpo
	 * @return
	 */
	public List<ParteCorpo> getPartesCorposField() {
		return parteCorpoDAO.buscarTodos();
	}
	
	/**
	 * atualiza informações
	 */
	public void atualizar(){
		exercicios = exercicioDAO.buscarTodos();
		exercicio = new Exercicio();
		showExercicio = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Atualizado");
	}

	
	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}

	public boolean getShowExercicio() {
		return showExercicio;
	}


	public List<ParteCorpo> getPartesCorpo() {
		return partesCorpo;
	}


	public boolean getShowExercicioParte2() {
		return showExercicioParte2;
	}


	public boolean getShowExercicioParte3() {
		return showExercicioParte3;
	}
	
}
