package br.com.acad.bean.treino;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.pessoa.interf.AlunoDAO;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.dao.treino.interf.TreinoEspecificoDAO;
import br.com.acad.logic.AnnotationsLogic;
import br.com.acad.logic.TreinoLogic;
import br.com.acad.model.pessoa.Aluno;
import br.com.acad.model.pessoa.ProfessorFunc;
import br.com.acad.model.treino.Treino;
import br.com.acad.model.treino.TreinoEspecifico;


@SuppressWarnings("serial")
@Component
@Scope(value="view")
public class TreinoEspecificoBean extends Bean<TreinoEspecifico> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@Autowired
	private TreinoEspecificoDAO treinoEspecificoDAO;
	@Autowired
	private ProfessorFuncDAO professorFuncDAO;
	@Autowired
	private AlunoDAO alunoDAO;
	
	public String textoTreino;
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		page = 1;
		dao = treinoEspecificoDAO;
		staticFields = AnnotationsLogic.getSearchValueFields(Treino.class, TreinoEspecifico.class);
		staticFieldsOrderLabel = AnnotationsLogic.getOrderLabelFields(Treino.class, TreinoEspecifico.class);
		staticFieldsOrderValue = AnnotationsLogic.getOrderValueFields(Treino.class, TreinoEspecifico.class);
		order = staticFieldsOrderLabel[0];
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
		// incrementa numeracao de solicitacoes
		if(entity!=null && entity.getId()==0){
			Aluno aluno = entity.getSolicitacao().getAluno();
			aluno.incrementNumSolicitacao();
			alunoDAO.update(aluno);
			entity.setNomePronto(aluno);
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
