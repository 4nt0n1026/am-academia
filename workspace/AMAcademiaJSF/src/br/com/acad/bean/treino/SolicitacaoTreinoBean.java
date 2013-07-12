package br.com.acad.bean.treino;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.bean.Bean;
import br.com.acad.dao.pessoa.interf.AlunoDAO;
import br.com.acad.dao.treino.interf.SolicitacaoTreinoDAO;
import br.com.acad.logic.PessoaLogic;
import br.com.acad.model.pessoa.Aluno;
import br.com.acad.model.treino.SolicitacaoTreino;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class SolicitacaoTreinoBean extends Bean<SolicitacaoTreino> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@EJB
	private SolicitacaoTreinoDAO solicitacaoTreinoDAO;
	@EJB
	private AlunoDAO alunoDAO;
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		dao = solicitacaoTreinoDAO;
		entities = solicitacaoTreinoDAO.buscarTodos();
	}
	
	/**
	 * show form de entity
	 */
	@Override
	public void showNewEntity() {
		showEntity = true;
		entity = new SolicitacaoTreino();
		entity.setAluno(new Aluno());
	}

	/**
	 * inclui ou edita entity no banco
	 */
	@Override
	public void incluirEntity() {
		if(entity.getId()==0) {
			entity.setDataSolicitacao(Calendar.getInstance());
		}
		entity.setRespondido(false);
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
	/**
	 * busca todos alunos para preencher o field
	 */
	public List<Aluno> getAlunosField() {
		return alunoDAO.buscarFieldNome();
	}
	
	/**
	 * Mostra a idade do aluno a partir da data de nasciemento
	 * @return
	 */
	public int getIdadeAlunoDetail(){
		if(entity.getAluno().getDataNascimento()!=null){
			return PessoaLogic.getIdade(entity.getAluno().getDataNascimento());
		}else{
			return 0;
		}
	}
	

	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	
}
