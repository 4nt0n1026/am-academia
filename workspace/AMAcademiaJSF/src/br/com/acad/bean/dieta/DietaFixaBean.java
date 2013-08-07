package br.com.acad.bean.dieta;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.bean.Bean;
import br.com.acad.dao.catGenerico.interf.FaixaEtariaCatDAO;
import br.com.acad.dao.catGenerico.interf.ObjetivoCatDAO;
import br.com.acad.dao.catGenerico.interf.SexoCatDAO;
import br.com.acad.dao.dieta.interf.DiaDietaDAO;
import br.com.acad.dao.dieta.interf.DietaFixaDAO;
import br.com.acad.dao.dieta.interf.LimitacaoDietaCatDAO;
import br.com.acad.dao.dieta.interf.RefeicaoDAO;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.logic.DietaLogic;
import br.com.acad.model.cat.FaixaEtariaCat;
import br.com.acad.model.cat.ObjetivoCat;
import br.com.acad.model.cat.SexoCat;
import br.com.acad.model.cat.TipoTreinoDieta;
import br.com.acad.model.dieta.DietaFixa;
import br.com.acad.model.dieta.LimitacaoDietaCat;
import br.com.acad.model.pessoa.ProfessorFunc;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class DietaFixaBean extends Bean<DietaFixa> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@EJB
	private DietaFixaDAO dietaFixaDAO;
	@EJB
	private LimitacaoDietaCatDAO limitacaoDietaCatDAO;
	@EJB
	private FaixaEtariaCatDAO faixaEtariaCatDAO;
	@EJB
	private ObjetivoCatDAO objetivoCatDAO;
	@EJB
	private SexoCatDAO sexoCatDAO;
	@EJB
	private ProfessorFuncDAO professorFuncDAO;
	@EJB
	private DiaDietaDAO diaDietaDAO;
	@EJB
	private RefeicaoDAO refeicaoDAO;
	
	private String textoDieta;
	
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		page = 1;
		dao = dietaFixaDAO;
		staticFields = DietaFixa.STATIC_FIELDS;
		atualizar();
	}
	
	/**
	 * show form de entity
	 */
	@Override
	public void showNewEntity() {
		showEntity = true;
		entity = new DietaFixa();
		entity.setProfessor(new ProfessorFunc());
	}

	/**
	 * inclui ou edita entity no banco
	 */
	@Override
	public void incluirEntity() {
		if(entity.getId()==0){
			entity.setData(Calendar.getInstance());
			entity.setTipoDieta(TipoTreinoDieta.FIXO);
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
