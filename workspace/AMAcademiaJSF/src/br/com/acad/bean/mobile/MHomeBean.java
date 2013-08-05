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

	private List<ItemMenu> itens = new ArrayList<ItemMenu>();

	@PostConstruct
	public void init(){
		itens.add(new ItemMenu("Treino", "/resources/images/semIcone.jpg", "#treino"));
		itens.add(new ItemMenu("Dieta", "/resources/images/semIcone.jpg", "#treino"));
		itens.add(new ItemMenu("Aulas", "/resources/images/semIcone.jpg", "#treino"));
		itens.add(new ItemMenu("Noticias", "/resources/images/semIcone.jpg", "#treino"));
		itens.add(new ItemMenu("Configurações", "/resources/images/semIcone.jpg", "#treino"));
		itens.add(new ItemMenu("Logout", "/resources/images/semIcone.jpg", "#treino"));
		
	}
	
	public List<ItemMenu> getItens() {
		return itens;
	}
	
	
}
