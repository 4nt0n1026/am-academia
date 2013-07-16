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
import br.com.acad.model.cat.TipoTreinoDieta;
import br.com.acad.model.treino.DiaTreino;
import br.com.acad.model.treino.Exercicio;
import br.com.acad.model.treino.ExercicioTreino;
import br.com.acad.model.treino.Treino;

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
	private boolean showDiaTreino;
	
	private ExercicioTreino exercicioTreino;
	private List<ExercicioTreino> exercicios;
	private boolean showExercicioTreino;

	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	public void init(){
		showDiaTreino = false;
		showExercicioTreino = false;
		dias = new ArrayList<DiaTreino>();
		exercicios = new ArrayList<ExercicioTreino>();
	}
	
	// Treino
	/**
	 * Criacao de um novo treino fixo
	 */
	public void novoTreinoFixo(){
		treino = treinoFixoBean.getEntity();
		treino.setTipoTreino(TipoTreinoDieta.FIXO);
	}
	
	/**
	 * Criacao de um novo treino especifico
	 */
	public void novoTreinoEspecifico(){
		treino = treinoEspecificoBean.getEntity();
		treino.setTipoTreino(TipoTreinoDieta.ESPECIFICO);
	}
	
	// DiaTreino
	/**
	 * Abre form de um novo DiaTreino
	 */
	public void newDiaTreino(){
		showDiaTreino = true;
		diaTreino = new DiaTreino();
	}
	
	/**
	 * Inclui um DiaTreino a lista de dias
	 */
	public void incluirDiaTreino(){
		dias.add(diaTreino);
		showDiaTreino = false;
	}
	
	/**
	 * Salva os dias e os exercicios do treino
	 */
	public void salvarTreino(){
		treino.resetDiasTreino();
		for(DiaTreino dia : dias){
			treino.addDiaTreino(dia);
		}
	}
	
	// ExercicioTreino
	/**
	 * Abre form de um novo exercicioTreino
	 */
	public void newExercicioTreino(){
		showExercicioTreino = true;
		exercicioTreino = new ExercicioTreino();
	}
	
	/**
	 * Atualiza os exercicios ao clicar em um diaTreino
	 */
	public void refreshExercicioTreino(){
		exercicios = diaTreino.getExerciciosTreino(exercicioTreinoDAO);
	}
	
	/**
	 * Inclui um ExercicioTreino a lista de exercicios
	 */
	public void incluirExercicioTreino(){
		diaTreino.addExercicioTreino(exercicioTreino);
		showExercicioTreino = false;
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

	public boolean getShowDiaTreino() {
		return showDiaTreino;
	}

	public List<ExercicioTreino> getExercicios() {
		return exercicios;
	}

	public boolean getShowExercicioTreino() {
		return showExercicioTreino;
	}
	
	
}
