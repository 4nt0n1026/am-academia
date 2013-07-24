package br.com.acad.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import br.com.acad.dao.horario.interf.ModalidadeDAO;
import br.com.acad.model.horario.Modalidade;

@Stateless
@WebService
public class HorarioWS {

	@EJB
	private ModalidadeDAO modalidadeDAO;

	public Modalidade[] buscarTodasModalidades(){
		List<Modalidade> modalidades = modalidadeDAO.buscarTodos();
		return modalidades.toArray(new Modalidade[modalidades.size()]);
	}
	
}
