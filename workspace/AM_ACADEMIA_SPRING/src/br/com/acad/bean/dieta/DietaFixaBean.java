package br.com.acad.bean.dieta;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.catGenerico.interf.FaixaEtariaCatDAO;
import br.com.acad.dao.catGenerico.interf.ObjetivoCatDAO;
import br.com.acad.dao.catGenerico.interf.SexoCatDAO;
import br.com.acad.dao.dieta.interf.DietaFixaDAO;
import br.com.acad.dao.dieta.interf.LimitacaoDietaCatDAO;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.logic.AnnotationsLogic;
import br.com.acad.logic.DietaLogic;
import br.com.acad.model.cat.FaixaEtariaCat;
import br.com.acad.model.cat.ObjetivoCat;
import br.com.acad.model.cat.SexoCat;
import br.com.acad.model.cat.TipoTreinoDieta;
import br.com.acad.model.dieta.Dieta;
import br.com.acad.model.dieta.DietaEspecifica;
import br.com.acad.model.dieta.DietaFixa;
import br.com.acad.model.dieta.LimitacaoDietaCat;
import br.com.acad.model.pessoa.ProfessorFunc;


@SuppressWarnings("serial")
@Component
@Scope(value="view")
public class DietaFixaBean extends Bean<DietaFixa> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@Autowired
	private DietaFixaDAO dietaFixaDAO;
	@Autowired
	private LimitacaoDietaCatDAO limitacaoDietaCatDAO;
	@Autowired
	private FaixaEtariaCatDAO faixaEtariaCatDAO;
	@Autowired
	private ObjetivoCatDAO objetivoCatDAO;
	@Autowired
	private SexoCatDAO sexoCatDAO;
	@Autowired
	private ProfessorFuncDAO professorFuncDAO;
	
	private String textoDieta;
	
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		dao = dietaFixaDAO;
		staticFields = AnnotationsLogic.getSearchValueFields(Dieta.class, DietaFixa.class);
		staticFieldsOrderLabel = AnnotationsLogic.getOrderLabelFields(Dieta.class, DietaFixa.class);
		staticFieldsOrderValue = AnnotationsLogic.getOrderValueFields(Dieta.class, DietaFixa.class);
		super.init();
	}
	
	/**
	 * show form de entity
	 */
	@Override
	public void showNewEntity() {
		showEntity = true;
		entity = new DietaFixa();
		entity.setProfessor(new ProfessorFunc());
		entity.setObjetivoCat(new ObjetivoCat());
		entity.setFaixaEtariaCat(new FaixaEtariaCat());
		entity.setSexoCat(new SexoCat());
		entity.setData(Calendar.getInstance());
		entity.setTipoDieta(TipoTreinoDieta.FIXO);
	}

	
	@Override
	public void showFormDetail() {
		textoDieta = DietaLogic.getDietaString(entity); 
		super.showFormDetail();
	}
	
	
	/************************************************************************************************************/
	//GET FIELDS
	/************************************************************************************************************/
	
	/**
	 * busca todos LimitacaoDietaCat para preencher o field
	 */
	public List<LimitacaoDietaCat> getLimitacaoDietaCatField() {
		return limitacaoDietaCatDAO.buscarTodos();
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
	
	public String getTextoDieta() {
		return textoDieta;
	}

	
	
	
}
