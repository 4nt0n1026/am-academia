package br.com.acad.bean.mobile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.dao.avisos.interf.NoticiaCatDAO;
import br.com.acad.dao.avisos.interf.NoticiaDAO;
import br.com.acad.model.avisos.Noticia;
import br.com.acad.model.avisos.NoticiaCat;

@SuppressWarnings("serial")
@Component(value="mNoticiasBean")
@Scope(value="view")
public class MNoticiasBean implements Serializable{
	
	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	@EJB
	private NoticiaDAO noticiaDAO;
	@EJB
	private NoticiaCatDAO noticiaCatDAO;
	
	private Noticia noticia; 
	
	private List<NoticiaCat> noticiaCats = new ArrayList<NoticiaCat>();
	private List<Noticia> noticias = new ArrayList<Noticia>();
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	public String init(){
		noticias = noticiaDAO.buscarTodos();
		return "pm:noticias";
	}
	
	/**
	 * Ao selecionar uma noticia
	 */
	public String selectNoticia(){
		// TODO - implementar o buscar todos para nao trazer a descricao
		return "pm:noticiaDetalhe?lazyLoad=true";
	}
	
	/**
	 * Ao clicar no botao de ajuda
	 */
	public String ajuda(){
		noticiaCats = noticiaCatDAO.buscarTodos();
		return "pm:ajudaNoticias?lazyLoad=true";
	}

	/************************************************************************************************************/
	//GETs e SETs
	/************************************************************************************************************/
	
	public List<Noticia> getNoticias() {
		return noticias;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	
	public List<NoticiaCat> getNoticiaCats() {
		return noticiaCats;
	}
	
	
	
}
