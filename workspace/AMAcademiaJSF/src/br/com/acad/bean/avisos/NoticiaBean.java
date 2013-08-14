package br.com.acad.bean.avisos;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.bean.Bean;
import br.com.acad.dao.avisos.interf.NoticiaCatDAO;
import br.com.acad.dao.avisos.interf.NoticiaDAO;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.model.avisos.Noticia;
import br.com.acad.model.avisos.NoticiaCat;
import br.com.acad.model.pessoa.ProfessorFunc;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class NoticiaBean extends Bean<Noticia> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@EJB
	private NoticiaDAO noticiaDAO;
	@EJB
	private NoticiaCatDAO noticiaCatDAO;
	@EJB
	private ProfessorFuncDAO professorFuncDAO;
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		page = 1;
		dao = noticiaDAO;
		staticFields = Noticia.STATIC_FIELDS;
		staticFieldsOrderLabel = Noticia.STATIC_FIELDS_ORDER_LABEL;
		staticFieldsOrderValue = Noticia.STATIC_FIELDS_ORDER_VALUE;
		order = staticFieldsOrderLabel[0];
		atualizar();
	}
	
	/**
	 * show form de entity
	 * 
	 */
	@Override
	public void showNewEntity() {
		showEntity = true;
		entity = new Noticia();
		entity.setCategoria(new NoticiaCat());
		entity.setProfessorFunc(new ProfessorFunc());
	}

	/**
	 * inclui ou edita entity no banco
	 */
	@Override
	public void incluirEntity() {
		entity.setData(Calendar.getInstance());
		incluirGeneric( entity!=null? entity.getId():0);
	}

	/**
	 * deleta entity do banco
	 */
	@Override
	public void deletarEntity() {
		deletarGeneric(entity!=null?entity.getId():0);
	}
	
	/************************************************************************************************************/
	//GET FIELDS
	/************************************************************************************************************/
	
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
		return professorFuncDAO.buscarFieldNome();
	}

	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	
}
