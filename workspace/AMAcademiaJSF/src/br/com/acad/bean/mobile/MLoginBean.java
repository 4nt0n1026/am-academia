package br.com.acad.bean.mobile;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import br.com.acad.dao.pessoa.interf.AlunoDAO;
import br.com.acad.model.pessoa.Aluno;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class MLoginBean implements Serializable{

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	@EJB
	private AlunoDAO alunoDAO;
	
	private Aluno aluno;
	

	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	@PostConstruct
	public void init(){
		aluno = new Aluno();
	}
	
	public String logar(){
		//TODO - logar
		return "pm:home";
	}
	
	public String logout(){
		//TODO - logoout
		return "mHome.xhtml";
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
