package br.com.acad.bean.dieta;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.bean.Bean;
import br.com.acad.dao.dieta.interf.DietaEspecificaDAO;
import br.com.acad.dao.dieta.interf.SolicitacaoDietaDAO;
import br.com.acad.dao.pessoa.interf.AlunoDAO;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.logic.PessoaLogic;
import br.com.acad.model.dieta.DietaEspecifica;
import br.com.acad.model.dieta.SolicitacaoDieta;
import br.com.acad.model.pessoa.Aluno;
import br.com.acad.model.pessoa.ProfessorFunc;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class SolicitacaoDietaBean extends Bean<SolicitacaoDieta> implements Serializable {

	//************************************************************************************************************//*
	//ATRIBUTOS
	//************************************************************************************************************//*
	
	@EJB
	private SolicitacaoDietaDAO solicitacaoDietaDAO;
	@EJB
	private AlunoDAO alunoDAO;
	@EJB
	private DietaEspecificaDAO dietaEspecificaDAO;
	@EJB
	private ProfessorFuncDAO professorFuncDAO;
	
	private boolean showDieta;
	private DietaEspecifica dieta;
	
	//************************************************************************************************************//*
	//METODOS
	//************************************************************************************************************//*
	
	@PostConstruct
	@Override
	public void init() {
		page = 1;
		dao = solicitacaoDietaDAO;
		staticFields = SolicitacaoDieta.STATIC_FIELDS;
		staticFieldsOrderLabel = SolicitacaoDieta.STATIC_FIELDS_ORDER_LABEL;
		staticFieldsOrderValue = SolicitacaoDieta.STATIC_FIELDS_ORDER_VALUE;
		order = staticFieldsOrderLabel[0];
		atualizar();
	}
	
	/**
	 * show form de entity
	 */
	@Override
	public void showNewEntity() {
		showEntity = true;
		entity = new SolicitacaoDieta();
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
	 * Responde a solicitacao criando um dietaEspecico
	 */
	public void responder(){
		if(entity != null){
			showDieta = true;
			dieta = new DietaEspecifica();
			dieta.setProfessor(new ProfessorFunc());
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione uma solicita��o para ser respondida");
		}
	}
	
	/**
	 * Sobreescrita do metodo close forms para fecha o form de dieta junto 
	 */
	@Override
	public void closeForms() {
		showDieta = false;
		super.closeForms();
	}
	
	/**
	 * inclui dieta especifico no banco referente a solicitacao respondida
	 */
	public void incluirDietaResposta(){
		dieta.setSolicitacao(entity);
		dieta.setData(Calendar.getInstance());
		closeForms();
		atualizar();
		entity.setRespondido(true);
		incluirGeneric(entity.getId());
	}
	
	//************************************************************************************************************//*
	//GET FIELDS
	//************************************************************************************************************//*
	
	/**
	 * busca todos alunos para preencher o field
	 */
	public List<Aluno> getAlunosField() {
		return alunoDAO.buscarFieldNome();
	}
	
	/**
	 * Mostra a idade do aluno a partir da data de nascimento
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

	//************************************************************************************************************//*
	//GETS E SETS
	//************************************************************************************************************//*
	
	
	public boolean getShowDieta() {
		return showDieta;
	}

	public DietaEspecifica getDieta() {
		return dieta;
	}

	public void setDieta(DietaEspecifica dieta) {
		this.dieta = dieta;
	}
	
	
	
}
