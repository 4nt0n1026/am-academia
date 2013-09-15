package br.com.acad.bean.dieta;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.dieta.interf.DietaEspecificaDAO;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.logic.AnnotationsLogic;
import br.com.acad.logic.DietaLogic;
import br.com.acad.model.dieta.Dieta;
import br.com.acad.model.dieta.DietaEspecifica;
import br.com.acad.model.pessoa.ProfessorFunc;


@SuppressWarnings("serial")
@Component
@Scope(value="view")
public class DietaEspecificaBean extends Bean<DietaEspecifica> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@Autowired
	private DietaEspecificaDAO dietaEspecificaDAO;
	@Autowired
	private ProfessorFuncDAO professorFuncDAO;
	
	public String textoDieta;
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		dao = dietaEspecificaDAO;
		staticFields = AnnotationsLogic.getSearchValueFields(Dieta.class, DietaEspecifica.class);
		staticFieldsOrderLabel = AnnotationsLogic.getOrderLabelFields(Dieta.class, DietaEspecifica.class);
		staticFieldsOrderValue = AnnotationsLogic.getOrderValueFields(Dieta.class, DietaEspecifica.class);
		atualizar();
	}
	
	/**
	 * show form de entity
	 * Não é possivel incluir um dieta especifico. Precisa ser por meio de resposta a uma solicitação. Metodo nao implementado
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
