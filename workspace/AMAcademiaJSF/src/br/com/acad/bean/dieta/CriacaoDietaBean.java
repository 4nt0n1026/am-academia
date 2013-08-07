/*package br.com.acad.bean.dieta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.acad.dao.dieta.interf.AlimentoDAO;
import br.com.acad.dao.dieta.interf.DietaEspecificaDAO;
import br.com.acad.dao.dieta.interf.DietaFixaDAO;
import br.com.acad.dao.dieta.interf.ItemRefeicaoDAO;
import br.com.acad.dao.dieta.interf.RefeicaoDAO;
import br.com.acad.dao.treino.interf.ExercicioDAO;
import br.com.acad.dao.treino.interf.ExercicioTreinoDAO;
import br.com.acad.dao.treino.interf.TreinoEspecificoDAO;
import br.com.acad.dao.treino.interf.TreinoFixoDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.model.cat.TipoTreinoDieta;
import br.com.acad.model.treino.DiaTreino;
import br.com.acad.model.treino.Exercicio;
import br.com.acad.model.treino.ExercicioTreino;
import br.com.acad.model.treino.Serie;
import br.com.acad.model.treino.Treino;
import br.com.acad.model.treino.TreinoEspecifico;
import br.com.acad.model.treino.TreinoFixo;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CriacaoDietaBean implements Serializable {

	*//************************************************************************************************************//*
	//ATRIBUTOS
	*//************************************************************************************************************//*
	
	@EJB
	private DietaFixaDAO dietaFixaDAO;
	@EJB
	private DietaEspecificaDAO dietaEspecificaDAO;
	@EJB
	private RefeicaoDAO refeicaoDAO;
	@EJB
	private ItemRefeicaoDAO itemRefeicaoDAO;
	@EJB
	private AlimentoDAO alimentoDAO;
	
	// Inject outros beans
	@ManagedProperty(value="#{dietaFixaBean}") 
	private DietaFixaBean dietaFixaBean; 
	@ManagedProperty(value="#{treinoEspecificoBean}") 
	private DietaEspecificaBean treinoEspecificoBean; 
	@ManagedProperty(value="#{solicitacaoTreinoBean}") 
	private SolicitacaoTreinoBean solicitacaoTreinoBean; 
	
	private Treino treino;
	
	private DiaTreino diaTreino;
	private List<DiaTreino> dias;

	private boolean showExercicioTreino;
	private ExercicioTreino exercicioTreino;
	private List<ExercicioTreino> exercicios;
	
	private List<Serie> series = new ArrayList<Serie>();

	
	*//************************************************************************************************************//*
	//METODOS
	*//************************************************************************************************************//*
	
	@PostConstruct
	public void init(){
		showExercicioTreino = false;
		newExercicioTreino();
		dias = new ArrayList<DiaTreino>();
		exercicios = new ArrayList<ExercicioTreino>();
	}
	
	// Treino
	*//**
	 * Criacao de um novo treino fixo
	 *//*
	public void newTreinoFixo(){
		treino = treinoFixoBean.getEntity();
		treino.setTipoTreino(TipoTreinoDieta.FIXO);
		dias = new ArrayList<DiaTreino>(treino.getDiasTreino());
		diaTreino = new DiaTreino();
	}
	
	*//**
	 * Criacao de um novo treino especifico
	 *//*
	public void newTreinoEspecifico(){
		treino = treinoEspecificoBean.getEntity();
		treino.setTipoTreino(TipoTreinoDieta.ESPECIFICO);
		dias = new ArrayList<DiaTreino>(treino.getDiasTreino());
		diaTreino = new DiaTreino();
	}

	*//**
	 * Criacao de um novo treino especifico de resposta
	 *//*
	public void newTreinoEspecificoResposta(){
		treino = solicitacaoTreinoBean.getTreino();
		treino.setTipoTreino(TipoTreinoDieta.ESPECIFICO);
		dias = new ArrayList<DiaTreino>(treino.getDiasTreino());
		diaTreino = new DiaTreino();
	}

	*//**
	 * Salva os dias e os exercicios do treino fixo
	 *//*
	public void salvarTreinoFixo(){
		treino.resetDiasTreino();
		for(DiaTreino dia : dias){
			treino.addDiaTreino(dia);
		}
		treinoFixoBean.setEntity((TreinoFixo) treino);
		treinoFixoBean.incluirEntity();
	}

	*//**
	 * Salva os dias e os exercicios do treino especifico
	 *//*
	public void salvarTreinoEspecifico(){
		treino.resetDiasTreino();
		for(DiaTreino dia : dias){
			treino.addDiaTreino(dia);
		}
		treinoEspecificoBean.setEntity((TreinoEspecifico) treino);
		treinoEspecificoBean.incluirEntity();
	}
	
	*//**
	 * Salva os dias e os exercicios do treino de resposta
	 *//*
	public void salvarTreinoEspecificoResposta(){
		treino.resetDiasTreino();
		for(DiaTreino dia : dias){
			treino.addDiaTreino(dia);
		}
		solicitacaoTreinoBean.setTreino((TreinoEspecifico) treino);
		solicitacaoTreinoBean.incluirTreinoResposta();;
	}
	
	// DiaTreino
	*//**
	 * Abre form de um novo DiaTreino
	 *//*
	public void newDiaTreino(){
		diaTreino = new DiaTreino();
		showExercicioTreino = false;
	}
	
	*//**
	 * Inclui um DiaTreino a lista de dias
	 *//*
	public void incluirDiaTreino(){
		showExercicioTreino = false;
		if(!dias.contains(diaTreino)){
			dias.add(diaTreino);
		}
		diaTreino = new DiaTreino();
	}
	
	*//**
	 * Exclui diaTreino da lista de dias
	 *//*
	public void excluirDiaTreino(){
		if(diaTreino!=null && diaTreino.getNome().length()>1){
			dias.remove(diaTreino);
		}else{
			MessagesLogic.addWarnMessage("Aviso", "Selecione um dia de treino antes de excluir");
		}
		showExercicioTreino = false;
		diaTreino = new DiaTreino();
	}
	
	*//**
	 * ao selecionar diaTreino da lista
	 *//*
	public void onSelectDiaTreino(){
		showExercicioTreino = true;
		refreshExercicioTreino();
		newExercicioTreino();
	}
	
	*//**
	 * ao desselecionar diaTreino da lista
	 *//*
	public void onUnselectDiaTreino(){
		showExercicioTreino = false;
	}
	
	// ExercicioTreino
	*//**
	 * Abre form de um novo exercicioTreino
	 *//*
	public void newExercicioTreino(){
		exercicioTreino = new ExercicioTreino();
		series = new ArrayList<Serie>();
	}
	
	*//**
	 * Atualiza os exercicios ao clicar em um diaTreino
	 *//*
	public void refreshExercicioTreino(){
		exercicios = new ArrayList<ExercicioTreino>(diaTreino.getExerciciosTreino());
	}
	
	*//**
	 * Inclui um ExercicioTreino a lista de exercicios
	 *//*
	public void incluirExercicioTreino(){
		if(exercicios.contains(exercicioTreino)){
			exercicios.remove(exercicioTreino);
			diaTreino.removeExercicioTreino(exercicioTreino);
		}
		exercicioTreino.setSeries(new HashSet<Serie>(series));
		exercicioTreino.setExercicio(exercicioDAO.searchByID(exercicioTreino.getExercicio().getId()));
		diaTreino.addExercicioTreino(exercicioTreino);
		exercicios.add(exercicioTreino);
		newExercicioTreino();
	}
	
	*//**
	 * Exclui ExercicioTreino da lista de exercicios
	 *//*
	public void excluirExercicioTreino(){
		if(exercicioTreino!=null && exercicioTreino.getExercicio()!=null ){
			exercicios.remove(exercicioTreino);
			diaTreino.removeExercicioTreino(exercicioTreino);
		}else{
			MessagesLogic.addWarnMessage("Aviso", "Selecione um exercicio antes de excluir");
		}
		exercicioTreino = new ExercicioTreino();

	}

	*//**
	 * ao selecionar exercicioTreino da lista
	 *//*
	public void onSelectExercicioTreino(){
		series = new ArrayList<Serie>(exercicioTreino.getSeries());
	}

	*//**
	 * ao selecionar exercicioTreino da lista
	 *//*
	public void onUnselectExercicioTreino(){
	}
	
	// Series
	
	*//**
	 * Adciona um serie
	 *//*
	public void addSerie(){
		series.add(new Serie());
	}
	
	*//**
	 * Reseta a lista de series
	 *//*
	public void resetSeries(){ 
		series = new ArrayList<Serie>();
	}
	

	*//************************************************************************************************************//*
	//GET FIELDS
	*//************************************************************************************************************//*
	
	public List<Exercicio> getExerciciosField(){
		return exercicioDAO.buscarFieldNome();
	}
	
	*//************************************************************************************************************//*
	//GETS E SETS
	*//************************************************************************************************************//*
	
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

	public DietaFixaBean getTreinoFixoBean() {
		return treinoFixoBean;
	}

	public void setTreinoFixoBean(DietaFixaBean treinoFixoBean) {
		this.treinoFixoBean = treinoFixoBean;
	}

	public DietaEspecificaBean getTreinoEspecificoBean() {
		return treinoEspecificoBean;
	}

	public void setTreinoEspecificoBean(DietaEspecificaBean treinoEspecificoBean) {
		this.treinoEspecificoBean = treinoEspecificoBean;
	}

	public boolean getShowExercicioTreino() {
		return showExercicioTreino;
	}

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public SolicitacaoTreinoBean getSolicitacaoTreinoBean() {
		return solicitacaoTreinoBean;
	}

	public void setSolicitacaoTreinoBean(SolicitacaoTreinoBean solicitacaoTreinoBean) {
		this.solicitacaoTreinoBean = solicitacaoTreinoBean;
	}

	
	
	
}
*/