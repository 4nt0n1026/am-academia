package br.com.acad.bean.treino;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.acad.dao.treino.interf.ExercicioDAO;
import br.com.acad.dao.treino.interf.ExercicioTreinoDAO;
import br.com.acad.dao.treino.interf.TreinoEspecificoDAO;
import br.com.acad.dao.treino.interf.TreinoFixoDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.model.cat.TipoTreinoDieta;
import br.com.acad.model.treino.DiaTreino;
import br.com.acad.model.treino.Exercicio;
import br.com.acad.model.treino.ExercicioTreino;
import br.com.acad.model.treino.Treino;
import br.com.acad.model.treino.TreinoFixo;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CriacaoTreinoBean implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@EJB
	private TreinoFixoDAO treinoFixoDAO;
	@EJB
	private TreinoEspecificoDAO treinoEspecificoDAO;
	@EJB
	private ExercicioDAO exercicioDAO;
	@EJB
	private ExercicioTreinoDAO exercicioTreinoDAO;
	
	// Inject outros beans
	@ManagedProperty(value="#{treinoFixoBean}") 
	private TreinoFixoBean treinoFixoBean; 
	@ManagedProperty(value="#{treinoEspecificoBean}") 
	private TreinoEspecificoBean treinoEspecificoBean; 
	
	private Treino treino;
	
	private DiaTreino diaTreino;
	private List<DiaTreino> dias;

	private boolean showExercicioTreino;
	private ExercicioTreino exercicioTreino;
	private List<ExercicioTreino> exercicios;

	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	public void init(){
		showExercicioTreino = false;
		exercicioTreino = new ExercicioTreino();
		dias = new ArrayList<DiaTreino>();
		exercicios = new ArrayList<ExercicioTreino>();
	}
	
	// Treino
	/**
	 * Criacao de um novo treino fixo
	 */
	public void newTreinoFixo(){
		treino = treinoFixoBean.getEntity();
		treino.setTipoTreino(TipoTreinoDieta.FIXO);
		dias = new ArrayList<DiaTreino>(treino.getDiasTreino());
		diaTreino = new DiaTreino();
	}
	
	/**
	 * Criacao de um novo treino especifico
	 */
	public void novoTreinoEspecifico(){
		treino = treinoEspecificoBean.getEntity();
		treino.setTipoTreino(TipoTreinoDieta.ESPECIFICO);
	}

	/**
	 * Salva os dias e os exercicios do treino
	 */
	public void salvarTreino(){
		treino.resetDiasTreino();
		for(DiaTreino dia : dias){
			treino.addDiaTreino(dia);
		}
		treinoFixoBean.setEntity((TreinoFixo) treino);
		treinoFixoBean.incluirEntity();
	}
	
	// DiaTreino
	/**
	 * Abre form de um novo DiaTreino
	 */
	public void newDiaTreino(){
		diaTreino = new DiaTreino();
		showExercicioTreino = false;
	}
	
	/**
	 * Inclui um DiaTreino a lista de dias
	 */
	public void incluirDiaTreino(){
		showExercicioTreino = false;
		if(!dias.contains(diaTreino)){
			dias.add(diaTreino);
		}
		diaTreino = new DiaTreino();
	}
	
	/**
	 * Exclui diaTreino da lista de dias
	 */
	public void excluirDiaTreino(){
		if(diaTreino!=null && diaTreino.getNome().length()>1){
			dias.remove(diaTreino);
		}else{
			MessagesLogic.addWarnMessage("Aviso", "Selecione um dia de treino antes de excluir");
		}
		showExercicioTreino = false;
		diaTreino = new DiaTreino();
	}
	
	/**
	 * ao selecionar diaTreino da lista
	 */
	public void onSelectDiaTreino(){
		showExercicioTreino = true;
		refreshExercicioTreino();
	}
	
	/**
	 * ao desselecionar diaTreino da lista
	 */
	public void onUnselectDiaTreino(){
		showExercicioTreino = false;
	}
	
	// ExercicioTreino
	/**
	 * Abre form de um novo exercicioTreino
	 */
	public void newExercicioTreino(){
		exercicioTreino = new ExercicioTreino();
	}
	
	/**
	 * Atualiza os exercicios ao clicar em um diaTreino
	 */
	public void refreshExercicioTreino(){
		exercicios = diaTreino.getExerciciosTreino(exercicioTreinoDAO);
		exercicios.addAll(diaTreino.getExerciciosTreino());
	}
	
	/**
	 * Inclui um ExercicioTreino a lista de exercicios
	 */
	public void incluirExercicioTreino(){
		diaTreino.addExercicioTreino(exercicioTreino);
		exercicios.add(exercicioTreino);
		exercicioTreino = new ExercicioTreino();
	}
	
	/**
	 * Exclui ExercicioTreino da lista de exercicios
	 */
	public void excluirExercicioTreino(){
		if(exercicioTreino!=null && exercicioTreino.getExercicio()!=null && exercicioTreino.getSeries() !=null){
			exercicios.remove(exercicioTreino);
		}else{
			MessagesLogic.addWarnMessage("Aviso", "Selecione um exercicio antes de excluir");
		}
		exercicioTreino = new ExercicioTreino();
	}
	

	/************************************************************************************************************/
	//GET FIELDS
	/************************************************************************************************************/
	
	public List<Exercicio> getExerciciosField(){
		return exercicioDAO.buscarFieldNome();
	}
	
	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	public Treino getTreino() {
		return treino;
	}

	public void setTreino(Treino treino) {
		this.treino = treino;
	}

	public DiaTreino getDiaTreino() {
		return diaTreino;
	}

	public void setDiaTreino(DiaTreino diaTreino) {
		this.diaTreino = diaTreino;
	}

	public ExercicioTreino getExercicioTreino() {
		return exercicioTreino;
	}

	public void setExercicioTreino(ExercicioTreino exercicioTreino) {
		this.exercicioTreino = exercicioTreino;
	}

	public List<DiaTreino> getDias() {
		return dias;
	}

	public List<ExercicioTreino> getExercicios() {
		return exercicios;
	}

	public TreinoFixoBean getTreinoFixoBean() {
		return treinoFixoBean;
	}

	public void setTreinoFixoBean(TreinoFixoBean treinoFixoBean) {
		this.treinoFixoBean = treinoFixoBean;
	}

	public TreinoEspecificoBean getTreinoEspecificoBean() {
		return treinoEspecificoBean;
	}

	public void setTreinoEspecificoBean(TreinoEspecificoBean treinoEspecificoBean) {
		this.treinoEspecificoBean = treinoEspecificoBean;
	}

	public boolean getShowExercicioTreino() {
		return showExercicioTreino;
	}

	
	
}
