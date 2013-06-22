package br.com.fiap.timer;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

import br.com.fiap.pacote.dao.PacoteDAO;

@Singleton
public class RelatorioTimer {

	@EJB
	private PacoteDAO pacoteDAO;
	
	@Schedule(hour="*",minute="*",second="10")
	public void geraRelatorio(){
		System.out.println("Gerando relatorio....");
		System.out.println("Soma dos preços de todos os pacotes: " +
											pacoteDAO.somaValoresPacotes());
		System.out.println("Total de pacotes cadastrados: " + 
											pacoteDAO.contarQdtPacotes());
	}
}
 