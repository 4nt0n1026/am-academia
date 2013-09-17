package br.com.acad.bean.avisos;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.avisos.interf.NoticiaCatDAO;
import br.com.acad.dao.avisos.interf.NoticiaDAO;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.model.avisos.Noticia;
import br.com.acad.model.avisos.NoticiaCat;
import br.com.acad.model.pessoa.ProfessorFunc;


@SuppressWarnings("serial")
@Component
@Scope(value="view")
public class NoticiaBean extends Bean<Noticia> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@Autowired
	private NoticiaDAO noticiaDAO;
	@Autowired
	private NoticiaCatDAO noticiaCatDAO;
	@Autowired
	private ProfessorFuncDAO professorFuncDAO;
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		dao = noticiaDAO;
		super.init();
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
		entity.setData(Calendar.getInstance());
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
