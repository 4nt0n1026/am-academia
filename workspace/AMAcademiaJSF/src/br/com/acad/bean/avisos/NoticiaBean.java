package br.com.acad.bean.avisos;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.dao.avisos.interf.NoticiaCatDAO;
import br.com.acad.dao.avisos.interf.NoticiaDAO;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.model.avisos.Noticia;
import br.com.acad.model.avisos.NoticiaCat;
import br.com.acad.model.pessoa.ProfessorFunc;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class NoticiaBean implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	//daos
	@EJB
	private NoticiaDAO noticiaDAO;
	@EJB
	private NoticiaCatDAO noticiaCatDAO;
	@EJB
	private ProfessorFuncDAO profDAO;
	
	//noticia
	private Noticia noticia;
	private List<Noticia> noticias;
	private boolean showIncluirNoticia;
	
	//noticiaCat
	List<NoticiaCat> noticiasCatsField;
	
	//professor
	List<ProfessorFunc> professoresField;
	
	
	
	/************************************************************************************************************
	METODOS
	************************************************************************************************************/
	
	/**
	 * init
	 */
	@PostConstruct
	public void init(){
		noticias = noticiaDAO.buscarTodos();
		showIncluirNoticia = false;
	}
	
	/**
	 * mostra painel de inserção de uma nova noticia
	 */
	public void showNoticia(){
		noticia = new Noticia();
		noticia.setCategoria(new NoticiaCat());
		noticia.setProfessorFunc(new ProfessorFunc());
		showIncluirNoticia = true;
	}
	
	/**
	 * mostra painel de edição de um noticia
	 */
	public void showEditNoticia(){
		if(noticia == null){
			MessagesLogic.addWarnMessage("Erro", "Selecione uma noticia para editar");
		}else{
			showIncluirNoticia = true;
		}
	}
	
	/**
	 * fecha painel de inserção de noticia
	 */
	public void dontShowNoticia(){
		noticia = new Noticia();
		showIncluirNoticia = false;
	}
	
	/**
	 * inclui ou edita noticia no banco
	 */
	public void incluirNoticia(){
		if(noticia.getId()==0){
			noticia = noticiaDAO.insert(noticia);
			noticias.add(noticia);
		}else{
			noticiaDAO.update(noticia);
		}
		noticia = new Noticia();
		showIncluirNoticia = false;
		
		MessagesLogic.addInfoMessage("Sucesso", "Noticia salva com sucesso");
	}
	
	/**
	 * deleta noticia do banco
	 */
	public void deletarNoticia(){
		if(noticia != null){
			noticiaDAO.removeById(noticia.getId());
			noticias.remove(noticia);
			showIncluirNoticia = false;
			MessagesLogic.addInfoMessage("Sucesso", "Noticia deletada com sucesso");
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione uma noticia para deletar");
		}
	}
      
	/**
	 * atualiza informações
	 */
	public void atualizar(){
		noticias = noticiaDAO.buscarTodos();
		noticia = new Noticia();
		showIncluirNoticia = false;
		profDAO.buscarFieldNome();
		MessagesLogic.addInfoMessage("Sucesso", "Atualizado");
	}

	/**
	 * busca todas NoticiaCat para preencher o field
	 */
	public List<NoticiaCat> getNoticiasCatsField() {
		return noticiaCatDAO.buscarTodos();
	}
	
	/**
	 * busca todos professores e funcionarios para preencher o field
	 */
	public List<ProfessorFunc> getProfessoresField() {
		return profDAO.buscarFieldNome();
	}
	
	/************************************************************************************************************
	*GETS E SETS
	************************************************************************************************************/
	
	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public boolean isShowIncluirNoticia() {
		return showIncluirNoticia;
	}

	public void setShowIncluirNoticia(boolean showIncluirNoticia) {
		this.showIncluirNoticia = showIncluirNoticia;
	}

	
	
	

	
	
	
	
	
	
	
	
	
}
