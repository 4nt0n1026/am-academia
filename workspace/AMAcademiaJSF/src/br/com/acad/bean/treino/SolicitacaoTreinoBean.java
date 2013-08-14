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
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.dao.treino.interf.SolicitacaoTreinoDAO;
import br.com.acad.dao.treino.interf.TreinoEspecificoDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.logic.PessoaLogic;
import br.com.acad.model.pessoa.Aluno;
import br.com.acad.model.pessoa.ProfessorFunc;
import br.com.acad.model.treino.SolicitacaoTreino;
import br.com.acad.model.treino.TreinoEspecifico;


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
	@EJB
	private TreinoEspecificoDAO treinoEspecificoDAO;
	@EJB
	private ProfessorFuncDAO professorFuncDAO;
	
	private boolean showTreino;
	private TreinoEspecifico treino;
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		page = 1;
		dao = solicitacaoTreinoDAO;
		staticFields = SolicitacaoTreino.STATIC_FIELDS;
		atualizar();
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
		// Se for nova instancia
		if(entity.getId()==0) {
			entity.setDataSolicitacao(Calendar.getInstance());
			entity.setRespondido(false);
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
	
	/**
	 * Responde a solicitacao criando um treinoEspecico
	 */
	public void responder(){
		if(entity != null){
			if(!entity.isRespondido()){
				showTreino = true;
				treino = new TreinoEspecifico();
				treino.setProfessor(new ProfessorFunc());
			}else{
				MessagesLogic.addErrorMessage("Erro", "Solicitação já respondida");
			}
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione uma solicitação para ser respondida");
		}
	}
	
	/**
	 * Sobreescrita do metodo close forms para fecha o form de treino junto 
	 */
	@Override
	public void closeForms() {
		showTreino = false;
		super.closeForms();
	}
	
	/**
	 * inclui treino especifico no banco referente a solicitacao respondida
	 */
	public void incluirTreinoResposta(){
		treino.setSolicitacao(entity);
		treino.setData(Calendar.getInstance());
		
		// Nome do treino
		Aluno aluno = treino.getSolicitacao().getAluno();
		aluno.incrementNumSolicitacao();

		// Inclui nos treinos do aluno
		aluno.addTreino(treino);
		
		// Seta nome 
		treino.setNomePronto(aluno);
		
		treino = treinoEspecificoDAO.insert(treino);
		closeForms();
		atualizar();
		entity.setRespondido(true);
		incluirGeneric(entity.getId());
		
		// Salva aluno
		aluno = alunoDAO.update(aluno);
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
	
	/**
	 * busca todos ProfessorFunc para preencher o field
	 */
	public List<ProfessorFunc> getProfessorFuncField() {
		return professorFuncDAO.buscarFieldNomeProf();
	}

	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	
	public boolean getShowTreino() {
		return showTreino;
	}

	public TreinoEspecifico getTreino() {
		return treino;
	}

	public void setTreino(TreinoEspecifico treino) {
		this.treino = treino;
	}
	
	
	
}
