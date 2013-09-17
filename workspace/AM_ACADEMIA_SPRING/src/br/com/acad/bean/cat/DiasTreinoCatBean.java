package br.com.acad.bean.cat;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.catGenerico.interf.DiasTreinoCatDAO;
import br.com.acad.model.cat.DiasTreinoCat;


@SuppressWarnings("serial")
@Component
@Scope(value="view")
public class DiasTreinoCatBean extends Bean<DiasTreinoCat> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@Autowired
	private DiasTreinoCatDAO diasTreinoCatDAO;
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		dao = diasTreinoCatDAO;
		super.init();
	}
	
	/**
	 * show form de entity
	 */
	@Override
	public void showNewEntity() {
		showEntity = true;
		entity = new DiasTreinoCat();
	}

	
	/************************************************************************************************************/
	//GET FIELDS
	/************************************************************************************************************/
	
	

	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	
}
