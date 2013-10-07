package br.com.acad.bean.mobile;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.dao.treino.interf.SolicitacaoTreinoDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.model.pessoa.Aluno;
import br.com.acad.model.treino.SolicitacaoTreino;

@SuppressWarnings("serial")
@Component(value="mSolicitacaoTreinoBean")
@Scope(value="view")
public class MSolicitacaoTreinoBean implements Serializable{

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	@Autowired
	private SolicitacaoTreinoDAO solicitacaoTreinoDAO;
	
	private SolicitacaoTreino solicitacaoTreino = new SolicitacaoTreino();
	
	private List<SolicitacaoTreino> minhasSolicitacoes;
	

	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	public String init(){
		solicitacaoTreino = new SolicitacaoTreino();
		return "pm:solicitacao";
	}
	
	public String enviarSolicitacao(){
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		solicitacaoTreino.setDataSolicitacao(Calendar.getInstance());
		solicitacaoTreino.setRespondido(false);
		solicitacaoTreino.setAluno((Aluno) sessionMap.get("aluno"));
		MessagesLogic.addInfoMessage("Enviada", "Solicitação enviada com sucesso");
		solicitacaoTreinoDAO.insert(solicitacaoTreino);
		return "pm:treino";
	}
	
	public String minhasSolicitacoes(){
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		minhasSolicitacoes = solicitacaoTreinoDAO.buscarPorAluno((Aluno) sessionMap.get("aluno"));
		return "pm:minhasSolicitacoes";
	}
	
	/************************************************************************************************************/
	//GETs e SETs
	/************************************************************************************************************/

	public SolicitacaoTreino getSolicitacaoTreino() {
		return solicitacaoTreino;
	}

	public void setSolicitacaoTreino(SolicitacaoTreino solicitacaoTreino) {
		this.solicitacaoTreino = solicitacaoTreino;
	}

	public List<SolicitacaoTreino> getMinhasSolicitacoes() {
		return minhasSolicitacoes;
	}
	
	
	
}
