package br.com.acad.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class IconeBean implements Serializable{

	private String[] icones = {"Album", "Buddy", "Buddy Chat", "Buddy Group", "Calendar", "Chart Bar",
		"Chart Pie", "Chat", "logout", "config", "news", "gloves", "apple", "weight", "Help", "Document Notes", "Tag"};

	public String[] getIcones() {
		return icones;
	}

	public void setIcones(String[] icones) {
		this.icones = icones;
	}
	
	
	
	
}
