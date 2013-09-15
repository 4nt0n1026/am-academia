package br.com.acad.bean.horario;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.horario.interf.AulaDAO;
import br.com.acad.dao.horario.interf.HorarioAulaDAO;
import br.com.acad.dao.horario.interf.UnidadeDAO;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.model.horario.Aula;
import br.com.acad.model.horario.HorarioAula;
import br.com.acad.model.horario.Unidade;
import br.com.acad.model.pessoa.ProfessorFunc;


@SuppressWarnings("serial")
@Component
@Scope(value="view")
public class HorarioAulaBean extends Bean<HorarioAula> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@Autowired
	private HorarioAulaDAO horarioAulaDAO;
	@Autowired
	private ProfessorFuncDAO professorFuncDAO;
	@Autowired
	private UnidadeDAO unidadeDAO;
	@Autowired
	private AulaDAO aulaDAO;
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		dao = horarioAulaDAO;
		super.init();
	}
	
	/**
	 * show form de entity
	 */
	@Override
	public void showNewEntity() {
		showEntity = true;
		entity = new HorarioAula();
		entity.setUnidade(new Unidade());
		entity.setAula(new Aula());
		entity.setProfessor(new ProfessorFunc());
		Calendar hora = Calendar.getInstance();
		hora.set(Calendar.HOUR_OF_DAY, 3);
		hora.set(Calendar.MINUTE, 0);
		entity.setHora(hora);
	}

	/**
	 * inclui ou edita entity no banco
	 */
	@Override
	public void incluirEntity() {
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
	 * busca todos professores e funcionarios para preencher o field
	 */
	public List<ProfessorFunc> getProfessoresField() {
		return professorFuncDAO.buscarFieldNomeProf();
	}

	/**
	 * busca todas as unidades para preencher o field
	 */
	public List<Unidade> getUnidadesField() {
		return unidadeDAO.buscarTodosField();
	}

	/**
	 * busca todas as aulas para preencher o field
	 */
	public List<Aula> getAulasField() {
		return aulaDAO.buscarTodos();
	}

	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	
}
