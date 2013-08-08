package br.com.acad.bean.mobile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.dao.treino.interf.ParteCorpoDAO;
import br.com.acad.model.mobile.ItemMenu;
import br.com.acad.model.treino.ParteCorpo;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class mTreinoBean implements Serializable{

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	@EJB
	private ParteCorpoDAO parteCorpoDAO;
	
	private List<ItemMenu> itens = new ArrayList<ItemMenu>();
	private List<ParteCorpo> partesCorpo;

	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	@PostConstruct
	public void init(){
		itens.add(new ItemMenu("Meus Treinos", "weight", "#treino", "meusTreinos"));
		itens.add(new ItemMenu("Buscar Treinos Prontos", "search", "#treino"));
		itens.add(new ItemMenu("Solicitar Treino", "mail", "#treino"));
		itens.add(new ItemMenu("Minhas Solicitações", "checkList", "#treino"));
		itens.add(new ItemMenu("Exercicios", "chest", "#partesCorpo", "partesCorpo"));
	}
	
	/**
	 * Ao selecionar o menu de partes de corpo
	 * @return caminho a ser direcionado
	 */
	public String selectParteCorpoMenu(){
		partesCorpo = parteCorpoDAO.buscarTodos();
		return "pm:exercicios?lazyLoad=true";
	}
	
	/************************************************************************************************************/
	//GETs e SETs
	/************************************************************************************************************/
	public List<ItemMenu> getItens() {
		return itens;
	}

	public List<ParteCorpo> getPartesCorpo() {
		return partesCorpo;
	}
	
	
}
