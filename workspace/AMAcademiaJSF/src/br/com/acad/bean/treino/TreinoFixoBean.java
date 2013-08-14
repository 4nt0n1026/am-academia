package br.com.acad.bean.treino;

import java.io.Serializable;
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
import br.com.acad.dao.treino.interf.DiaTreinoDAO;
import br.com.acad.dao.treino.interf.ExercicioTreinoDAO;
import br.com.acad.dao.treino.interf.TreinoFixoDAO;
import br.com.acad.logic.TreinoLogic;
import br.com.acad.model.cat.DiasTreinoCat;
import br.com.acad.model.cat.DuracaoTreinoCat;
import br.com.acad.model.cat.FaixaEtariaCat;
import br.com.acad.model.cat.ObjetivoCat;
import br.com.acad.model.cat.SexoCat;
import br.com.acad.model.cat.TipoTreinoDieta;
import br.com.acad.model.pessoa.ProfessorFunc;
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
	@EJB
	private DiaTreinoDAO diaTreinoDAO;
	@EJB
	private ExercicioTreinoDAO exercicioTreinoDAO;
	
	private String textoTreino;
	
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		page = 1;
		dao = treinoFixoDAO;
		staticFields = TreinoFixo.STATIC_FIELDS;
		staticFieldsOrderLabel = TreinoFixo.STATIC_FIELDS_ORDER_LABEL;
		staticFieldsOrderValue = TreinoFixo.STATIC_FIELDS_ORDER_VALUE;
		order = staticFieldsOrderLabel[0];
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
	
	@Override
	public void showFormDetail() {
		textoTreino = TreinoLogic.getTreinoString(entity);
		super.showFormDetail();
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
	
	public String getTextoTreino() {
		return textoTreino;
	}

	
	
	
}
