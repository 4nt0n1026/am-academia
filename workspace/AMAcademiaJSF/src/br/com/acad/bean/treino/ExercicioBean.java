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
	
	//ParteCorpo
	private ParteCorpo parteCorpo;
	private boolean showParteCorpoPrim;
	private boolean showParteCorpoSec;

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
	}
	
	
	/********************
	//Exercicio
	/********************
	
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
			MessagesLogic.addInfoMessage("Sucesso", "Exercicio deletada com sucesso");
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione um exercicio para deletar");
		}
	}
      
	
	
	
	/********************
	//ParteCorpo Primaria
	/********************
	
	/**
	 * mostra painel de inserção de uma nova parteCorpoPrimaria
	 */
	public void showNewParteCorpoPrimaria(){
		parteCorpo = new ParteCorpo();
		showParteCorpoPrim = true;
	}
	
	/**
	 * mostra painel de edição de parteCorpoPrimaria
	 */
	public void showEditParteCorpoPrimaria(){
		if(parteCorpo==null){
			MessagesLogic.addWarnMessage("Erro", "Selecione uma parte de corpo para editar");
		}else{
			showParteCorpoPrim = true;
		}
	}
	
	/**
	 * fecha painel de inserção de parteCorpoPrimaria
	 */
	public void dontShowParteCorpoPrimaria(){
		exercicio = new Exercicio();
		showParteCorpoPrim = false;
	}
	
	/**
	 * inclui ou edita ParteCorpo primaria no banco
	 */
	public void incluirParteCorpoPrimaria(){
		parteCorpo = parteCorpoDAO.searchByID(parteCorpo.getId());
		exercicio.addParteCorpoPrimaria(parteCorpo);
		exercicioDAO.update(exercicio);
		parteCorpo = new ParteCorpo();
		showParteCorpoPrim = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Parte de corpo salva com sucesso");
	}
	/**
	 * deleta parte do corpo do banco
	 */
	public void deletarParteCorpoPrimaria(){
		/*if(exercicio != null){
			exercicioDAO.removeById(exercicio.getId());
			exercicios.remove(exercicio);
			showExercicio = false;
			MessagesLogic.addInfoMessage("Sucesso", "Exercicio deletada com sucesso");
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione um exercicio para deletar");
		}*/
	}
      
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


	public ParteCorpo getParteCorpo() {
		return parteCorpo;
	}


	public void setParteCorpo(ParteCorpo parteCorpo) {
		this.parteCorpo = parteCorpo;
	}


	public boolean getShowParteCorpoPrim() {
		return showParteCorpoPrim;
	}


	public boolean getShowParteCorpoSec() {
		return showParteCorpoSec;
	}


	

	



	
	
}
