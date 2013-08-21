package br.com.acad.bean.mobile;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.dao.pessoa.interf.AlunoDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.model.pessoa.Aluno;

@SuppressWarnings("serial")
@Component
@Scope(value="view")
public class MLoginBean implements Serializable{

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	@Autowired
	private AlunoDAO alunoDAO;
	
	private Aluno aluno = new Aluno();


	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	@PostConstruct
	public void init(){
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if(sessionMap.get("logado")==null){
			sessionMap.put("logado", false);
		}
		boolean logado = (Boolean) sessionMap.get("logado");
		if(logado){
			aluno = (Aluno) sessionMap.get("aluno");
			return;
		}
		zerarSession(sessionMap);
	}
	
	public String logar(){
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		// Verifica login e senha
		Aluno alunoTemp = alunoDAO.logar(aluno);
		// Se estiverem corretos
		if(alunoTemp != null){
			aluno = alunoTemp;
			incluirSession(sessionMap);
			return "pm:home";
		}
		// Se nao envia msg de erro e zera o input de senha
		aluno.setSenha(new String());
		zerarSession(sessionMap);
		MessagesLogic.addErrorMessage("Erro", "Email e senha invalidos!");
		return null;
		
	}
	
	public String logout(){
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		zerarSession(sessionMap);
		aluno = new Aluno();
		return "pm:login";
	}
	/************************************************************************************************************/
	// METODOS INTERNOS
	/**
	 * @param sessionMap **********************************************************************************************************/
	private void zerarSession(Map<String, Object> sessionMap){
		sessionMap.put("logado", false);
		sessionMap.put("aluno", null);
	}
	
	private void incluirSession(Map<String, Object> sessionMap){
		sessionMap.put("logado", true);
		sessionMap.put("aluno", aluno);
	}
	
	
	/************************************************************************************************************/
	//GETs e SETs
	/************************************************************************************************************/

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
}
