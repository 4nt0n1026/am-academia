package br.com.acad.bean;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.model.pessoa.Pessoa;

@SuppressWarnings("serial")
@Component
@Scope(value="session")
public class LoginBean implements Serializable{

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@Autowired
	private ProfessorFuncDAO professorFuncDAO;
	
	private String email;
	private String senha;
	
	private Pessoa usuario;
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	public String logar(){
		usuario = professorFuncDAO.logar(email, senha);
		if(usuario!=null){
			// Cria a sessao para o usuario
			 HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			 // cocloca o usuario a sessao
			 session.setAttribute("usuario", usuario);
			 // Mensagem de sucesso
			 MessagesLogic.addInfoMessage("Sucesso", "Logado com sucesso");
			 
			 email = new String();
			 senha = new String();
			 
			return "home";
		}else{
			// Login e senha incorretos
			MessagesLogic.addWarnMessage("Erro", "Email ou senha incorretos");
			return "login";
		}
	}
	
	
	public String logout(){
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		
		usuario = null;
		
		return "login";
	}
	
	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	public Pessoa getUsuario() {
		return usuario;
	}

	public void setUsuario(Pessoa usuario) {
		this.usuario = usuario;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
	
	
}
