package br.com.acad.bean.treino;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.bean.Bean;
import br.com.acad.dao.catGenerico.interf.DiasTreinoCatDAO;
import br.com.acad.dao.catGenerico.interf.DuracaoTreinoCatDAO;
import br.com.acad.dao.catGenerico.interf.FaixaEtariaCatDAO;
import br.com.acad.dao.catGenerico.interf.ObjetivoCatDAO;
import br.com.acad.dao.catGenerico.interf.SexoCatDAO;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.dao.treino.interf.TreinoFixoDAO;
import br.com.acad.model.cat.DiasTreinoCat;
import br.com.acad.model.cat.DuracaoTreinoCat;
import br.com.acad.model.cat.FaixaEtariaCat;
import br.com.acad.model.cat.ObjetivoCat;
import br.com.acad.model.cat.SexoCat;
import br.com.acad.model.cat.TipoTreinoDieta;
import br.com.acad.model.pessoa.ProfessorFunc;
import br.com.acad.model.treino.DiaTreino;
import br.com.acad.model.treino.ExercicioTreino;
import br.com.acad.model.treino.TreinoFixo;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TreinoFixoBean extends Bean<TreinoFixo> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@EJB
	private TreinoFixoDAO treinoFixoDAO;
	@EJB
	private DiasTreinoCatDAO diasTreinoCatDAO;
	@EJB
	private DuracaoTreinoCatDAO duracaoTreinoCatDAO;
	@EJB
	private FaixaEtariaCatDAO faixaEtariaCatDAO;
	@EJB
	private ObjetivoCatDAO objetivoCatDAO;
	@EJB
	private SexoCatDAO sexoCatDAO;
	@EJB
	private ProfessorFuncDAO professorFuncDAO;
	
	private List<DiaTreino> diasTreino = new ArrayList<DiaTreino>();
	private DiaTreino diaTreino;
	
	
	private ExercicioTreino exercicioTreino;
	private List<ExercicioTreino> exerciciosTreino; 
	
	private String nomeDia = new String();
	private int idDia;
	
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		page = 1;
		dao = treinoFixoDAO;
		staticFields = TreinoFixo.STATIC_FIELDS;
		atualizar();
	}
	
	/**
	 * show form de entity
	 */
	@Override
	public void showNewEntity() {
		showEntity = true;
		entity = new TreinoFixo();
		entity.setProfessor(new ProfessorFunc());
		diasTreino = new ArrayList<DiaTreino>();
	}

	/**
	 * inclui ou edita entity no banco
	 */
	@Override
	public void incluirEntity() {
		if(entity.getId()==0){
			entity.setData(Calendar.getInstance());
			entity.setTipoTreino(TipoTreinoDieta.FIXO);
		}
		incluirGeneric( entity!=null? entity.getId():0);
	}

	/**
	 * deleta entity do banco
	 */
	@Override
	public void deletarEntity() {
		deletarGeneric(entity!=null?entity.getId():0);
	}
	
	// DiaTreino
	/**
	 * show form de novo DiaTreino
	 */
	public void newDiaTreino(){
		nomeDia = new String();
	}
	
	/**
	 * Inclui diaTeino na lista
	 */
	public void incluirDiaTreino(){
		diasTreino.add(diaTreino);
	}
	
	public void showNewComplex1(){
		diaTreino = new DiaTreino();
		showComplex1();
	}
	
	/************************************************************************************************************/
	//GET FIELDS
	/************************************************************************************************************/
	
	/**
	 * busca todos DiasSemanasCat para preencher o field
	 */
	public List<DiasTreinoCat> getDiasTreinoCatField() {
		return diasTreinoCatDAO.buscarTodos();
	}
	
	/**
	 * busca todos DuracaoTreinoCat para preencher o field
	 */
	public List<DuracaoTreinoCat> getDuracaoTreinoCatField() {
		return duracaoTreinoCatDAO.buscarTodos();
	}
	
	/**
	 * busca todos FaixaEtariaCat para preencher o field
	 */
	public List<FaixaEtariaCat> getFaixaEtariaCatField() {
		return faixaEtariaCatDAO.buscarTodos();
	}
	
	/**
	 * busca todos ObjetivoCat para preencher o field
	 */
	public List<ObjetivoCat> getObjetivoCatField() {
		return objetivoCatDAO.buscarTodos();
	}
	
	/**
	 * busca todos SexoCat para preencher o field
	 */
	public List<SexoCat> getSexoCatField() {
		return sexoCatDAO.buscarTodos();
	}
	
	/**
	 * busca todos ProfessorFunc para preencher o field
	 */
	public List<ProfessorFunc> getProfessorFuncField() {
		return professorFuncDAO.buscarFieldNomeProf();
	}

	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	

	public ExercicioTreino getExercicioTreino() {
		return exercicioTreino;
	}

	public void setExercicioTreino(ExercicioTreino exercicioTreino) {
		this.exercicioTreino = exercicioTreino;
	}

	public List<DiaTreino> getDiasTreino() {
		return diasTreino;
	}

	public List<ExercicioTreino> getExerciciosTreino() {
		return exerciciosTreino;
	}

	public String getNomeDia() {
		return nomeDia;
	}

	public void setNomeDia(String nomeDia) {
		this.nomeDia = nomeDia;
	}

	public int getIdDia() {
		return idDia;
	}

	public void setIdDia(int idDia) {
		this.idDia = idDia;
	}

	public DiaTreino getDiaTreino() {
		return diaTreino;
	}

	public void setDiaTreino(DiaTreino diaTreino) {
		this.diaTreino = diaTreino;
	}
	
	

	
	
	
	
	
}
