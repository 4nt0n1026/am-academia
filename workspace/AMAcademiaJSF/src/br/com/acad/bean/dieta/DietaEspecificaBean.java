package br.com.acad.bean.dieta;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.bean.Bean;
import br.com.acad.dao.dieta.interf.DietaEspecificaDAO;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.logic.DietaLogic;
import br.com.acad.model.dieta.DietaEspecifica;
import br.com.acad.model.pessoa.ProfessorFunc;


@SuppressWarnings("serial")
@ManagedBean(name="dietaEspecificaoBean")
@ViewScoped
public class DietaEspecificaBean extends Bean<DietaEspecifica> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@EJB
	private DietaEspecificaDAO dietaEspecificaDAO;
	@EJB
	private ProfessorFuncDAO professorFuncDAO;
	
	public String textoDieta;
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		page = 1;
		dao = dietaEspecificaDAO;
		staticFields = DietaEspecifica.STATIC_FIELDS;
		atualizar();
	}
	
	/**
	 * show form de entity
	 * Não é possivel incluir um treino especifico. Precisa ser por meio de resposta a uma solicitação. Metodo nao implementado
	 */
	@Override
	public void showNewEntity() {}


	/**
	 * inclui ou edita entity no banco
	 */
	@Override
	public void incluirEntity() {
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
