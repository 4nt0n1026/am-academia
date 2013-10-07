package br.com.acad.bean.mobile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.dao.treino.interf.TreinoDAO;
import br.com.acad.model.pessoa.Aluno;
import br.com.acad.model.treino.Treino;

@SuppressWarnings("serial")
@Component(value="mMeusTreinosBean")
@Scope(value="view")
public class MMeusTreinosBean implements Serializable{

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	@Autowired
	private TreinoDAO treinoDAO;

	private List<Treino> meusTreinos;
	
	private Treino treino;
	
	private Aluno aluno;
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	public String init(){
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		aluno = (Aluno) sessionMap.get("aluno");
		meusTreinos = new ArrayList<Treino>();
		meusTreinos = treinoDAO.buscarPorAluno(aluno);
		return "pm:meusTreinos";
	}
	
	public String onSelectTreino(){
		
		return "pm:diasTreino";
	}


	
	/************************************************************************************************************/
	//GETs e SETs
	/************************************************************************************************************/

	public List<Treino> getMeusTreinos() {
		return meusTreinos;
	}

	public void setMeusTreinos(List<Treino> meusTreinos) {
		this.meusTreinos = meusTreinos;
	}

	public Treino getTreino() {
		return treino;
	}

	public void setTreino(Treino treino) {
		this.treino = treino;
	}


	
	
	
	
}
