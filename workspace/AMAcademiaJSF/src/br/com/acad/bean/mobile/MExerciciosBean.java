package br.com.acad.bean.mobile;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.dao.treino.interf.ExercicioDAO;
import br.com.acad.dao.treino.interf.ParteCorpoDAO;
import br.com.acad.logic.GenericLogic;
import br.com.acad.model.treino.Exercicio;
import br.com.acad.model.treino.ParteCorpo;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class MExerciciosBean implements Serializable{

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	@EJB
	private ParteCorpoDAO parteCorpoDAO;
	@EJB
	private ExercicioDAO exercicioDAO;
	
	private List<ParteCorpo> partesCorpo;
	private ParteCorpo parteCorpo;
	
	private List<Exercicio> exercicios;
	private Exercicio exercicio;
	
	private String partesPrimarias;
	private String partesSecundarias;

	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	public String init(){
		partesCorpo = parteCorpoDAO.buscarTodos();
		return "pm:parteCorpo";
	}

	public String selectParteCorpo(){
		exercicios = exercicioDAO.buscarPorParteCorpo(parteCorpo);
		return "pm:exerciciosList";
	}
	
	public String selectExercicio(){
		exercicio = exercicioDAO.searchByID(exercicio.getId());
		partesPrimarias = getPartesCorpoPrimDetail();
		partesSecundarias = getPartesCorpoSecDetail();
		return "pm:exercicioDetalhe";
	}
	
	/************************************************************************************************************/
	//GETs e SETs ESPECIAIS
	/************************************************************************************************************/

	/**
	 * Faz busca e formata String de partes de corpo primaria do exercicio selecionado para mostrar detalhes
	 * @return
	 */
	private String getPartesCorpoPrimDetail() {
		return GenericLogic.formatListOfObjects(exercicio.getParteCorpoPrimaria(parteCorpoDAO), ", ");
	}

	/**
	 * Faz busca e formata String de partes de corpo secundaria do exercicio selecionado para mostrar detalhes
	 * @return
	 */
	private String getPartesCorpoSecDetail() {
		return GenericLogic.formatListOfObjects(exercicio.getParteCorpoSecundaria(parteCorpoDAO), ", ");
	}

	
	/************************************************************************************************************/
	//GETs e SETs
	/************************************************************************************************************/

	public List<ParteCorpo> getPartesCorpo() {
		return partesCorpo;
	}

	public ParteCorpo getParteCorpo() {
		return parteCorpo;
	}

	public void setParteCorpo(ParteCorpo parteCorpo) {
		this.parteCorpo = parteCorpo;
	}

	public Exercicio getExercicio() {
		if(exercicio!=null){
			if(exercicio.getFotoLocal()==null || exercicio.getFotoLocal() == ""){
				exercicio.setFotoLocal("semFoto.jpg");
			}
		}
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}

	public String getPartesPrimarias() {
		return partesPrimarias;
	}

	public String getPartesSecundarias() {
		return partesSecundarias;
	}

	
	
	
	
}
