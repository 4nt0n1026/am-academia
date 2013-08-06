package br.com.acad.bean.mobile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.model.mobile.ItemMenu;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class MHomeBean implements Serializable{

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	private List<ItemMenu> itens = new ArrayList<ItemMenu>();

	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	@PostConstruct
	public void init(){
		itens.add(new ItemMenu("Treino", "weight.png", "#treino"));
		itens.add(new ItemMenu("Dieta", "apple.png", "#treino"));
		itens.add(new ItemMenu("Aulas", "gloves.png", "#treino"));
		itens.add(new ItemMenu("Noticias", "news.png", "mNoticias.xhtml"));
		itens.add(new ItemMenu("Configurações", "config.png", "#treino"));
		itens.add(new ItemMenu("Logout", "logout.png", "#treino"));
		
	}
	
	/************************************************************************************************************/
	//GETs e SETs
	/************************************************************************************************************/
	public List<ItemMenu> getItens() {
		return itens;
	}
	
	
}
