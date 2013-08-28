package br.com.acad.bean.pessoa;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.pessoa.interf.AlunoDAO;
import br.com.acad.logic.CriptografiaLogic;
import br.com.acad.model.pessoa.Aluno;


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
	
	@PostConstruct
	@Override
	public void init() {
		page = 1;
		dao = alunoDAO;
		staticFields = Aluno.STATIC_FIELDS;
		staticFieldsOrderLabel = Aluno.STATIC_FIELDS_ORDER_LABEL;
		staticFieldsOrderValue = Aluno.STATIC_FIELDS_ORDER_VALUE;
		order = staticFieldsOrderLabel[0];
		atualizar();
	}
	
	/**
	 * show form de entity
	 */
	@Override
	public void showNewEntity() {
		showEntity = true;
		entity = new Aluno();
		entity.setDataNascimento(new GregorianCalendar());
	}

	/**
	 * inclui ou edita entity no banco
	 */
	@Override
	public void incluirEntity() {
		// Encriptografa senha caso seja uma nova entidade
		if(entity.getId()==0){
			String senha = CriptografiaLogic.encriptar(entity.getSenha());
			entity.setSenha(senha);
		}
		// Inclui no banco
		incluirGeneric( entity!=null? entity.getId():0);
	}

	/**
	 * deleta entity do banco
	 */
	@Override
	public void deletarEntity() {
		deletarGeneric(entity!=null?entity.getId():0);
	}
	
	
	/************************************************************************************************************/
	//GET FIELDS
	/************************************************************************************************************/
	
	

	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	
}
