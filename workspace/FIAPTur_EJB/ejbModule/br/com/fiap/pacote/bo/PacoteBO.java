package br.com.fiap.pacote.bo;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import br.com.fiap.pacote.dao.PacoteDAO;
import br.com.fiap.pacote.entity.Pacote;

@Stateless
@WebService
public class PacoteBO {

	@EJB
	private PacoteDAO pacoteDAO;
	
	public void inserir(Pacote pacote){
		pacoteDAO.insert(pacote);
	}
	
	public List<Pacote> buscarTodos(){
		return pacoteDAO.buscarTodos();
	}
}
