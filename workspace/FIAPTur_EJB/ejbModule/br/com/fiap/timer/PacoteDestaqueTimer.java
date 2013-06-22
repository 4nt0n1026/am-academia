package br.com.fiap.timer;

import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

import br.com.fiap.pacote.dao.PacoteDAO;
import br.com.fiap.pacote.entity.Pacote;

@Singleton
public class PacoteDestaqueTimer {

	private Pacote pacoteDestaque;
	
	@EJB
	private PacoteDAO pacoteDAO;
	
	@Schedule(hour="*",minute="*",second="10")
	public void alteraPacoteDestaque(){
		//Busca todos os pacotes
		List<Pacote> lista = pacoteDAO.buscarTodos();
		//Cria um random para sortear um número
		Random sorteio = new Random();
		//Sorteia o número de 0 até o total de elementos da lista
		int x = sorteio.nextInt(lista.size());
		//Coloca o pacote sorteado no pacoteDestaque
		pacoteDestaque = lista.get(x);
	}

	public Pacote getPacoteDestaque() {
		return pacoteDestaque;
	}

	public void setPacoteDestaque(Pacote pacoteDestaque) {
		this.pacoteDestaque = pacoteDestaque;
	}
}
