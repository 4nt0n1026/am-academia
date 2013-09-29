package br.com.acad.bean.pessoa;

import java.io.Serializable;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.pessoa.interf.AlunoDAO;
import br.com.acad.logic.AnnotationsLogic;
import br.com.acad.logic.CriptografiaLogic;
import br.com.acad.model.pessoa.Aluno;
import br.com.acad.model.pessoa.Pessoa;


@SuppressWarnings("serial")
@Component
@Scope(value="view")
public class AlunoBean extends Bean<Aluno> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@Autowired
	private AlunoDAO alunoDAO;
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@Override
	public void init() {
		dao = alunoDAO;
		staticFields = AnnotationsLogic.getSearchValueFields(Pessoa.class, Aluno.class);
		staticFieldsOrderLabel = AnnotationsLogic.getOrderLabelFields(Pessoa.class, Aluno.class);
		staticFieldsOrderValue = AnnotationsLogic.getOrderValueFields(Pessoa.class, Aluno.class);
		super.init();
	}
	
	/**
	 * show form de entity
	 */
	@Override
	public void showNewEntity() {
		showEntity = true;
		entity = new Aluno();
		entity.setDataNascimento(new GregorianCalendar());
		String senha = CriptografiaLogic.encriptar("123");
		entity.setSenha(senha);
	}

	
	
	/************************************************************************************************************/
	//GET FIELDS
	/************************************************************************************************************/
	
	

	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	
}
