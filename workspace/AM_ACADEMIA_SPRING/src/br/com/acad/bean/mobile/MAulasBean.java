package br.com.acad.bean.mobile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.dao.horario.interf.AulaDAO;
import br.com.acad.dao.horario.interf.HorarioAulaDAO;
import br.com.acad.logic.AulaLogic;
import br.com.acad.model.horario.Aula;

@SuppressWarnings("serial")
@Component(value="mAulasBean")
@Scope(value="view")
public class MAulasBean implements Serializable{
	
	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	@Autowired
	private AulaDAO aulaDAO;
	@Autowired
	private HorarioAulaDAO horarioAulaDAO;
	
	private Aula aula; 
	private String horarios;
	
	private List<Aula> aulas = new ArrayList<Aula>();
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	public String init(){
		aulas = aulaDAO.buscarTodos();
		return "pm:aulas";
	}
	
	/**
	 * Ao selecionar uma noticia
	 */
	public String selectAula(){
		horarios = AulaLogic.getHorarios(aula, horarioAulaDAO);
		return "pm:aulaDetalhe?lazyLoad=true";
	}

	
	/************************************************************************************************************/
	//GETs e SETs
	/************************************************************************************************************/
	
	public Aula getAula() {
		return aula;
	}
	
	public void setAula(Aula aula) {
		this.aula = aula;
	}
	
	public List<Aula> getAulas() {
		return aulas;
	}

	public String getHorarios() {
		return horarios;
	}
	
	
	
	
	
}
