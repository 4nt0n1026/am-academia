package br.com.acad.bean.banco;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.dao.avisos.interf.NoticiaCatDAO;
import br.com.acad.dao.catGenerico.interf.DiasTreinoCatDAO;
import br.com.acad.dao.catGenerico.interf.DuracaoTreinoCatDAO;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.dao.treino.interf.ParteCorpoDAO;
import br.com.acad.model.avisos.NoticiaCat;
import br.com.acad.model.cat.DiasTreinoCat;
import br.com.acad.model.cat.DuracaoTreinoCat;
import br.com.acad.model.pessoa.ProfessorFunc;
import br.com.acad.model.treino.ParteCorpo;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PopulaBancoBean implements Serializable {

	@EJB
	private ParteCorpoDAO parteCorpoDAO;
	@EJB
	private NoticiaCatDAO noticiaCatDAO;
	@EJB
	private ProfessorFuncDAO professorFuncDAO;
	@EJB
	private DiasTreinoCatDAO diasTreinoCatDAO;
	@EJB
	private DuracaoTreinoCatDAO duracaoTreinoCatDAO;	
	
	public void popula(){
		populaParteCorpo();
		populaNoticiaCat();
		populaProfessor();
		populaFuncionario();
		populaDuracaoTreinoCat();
		populaDiasTreinoCat();
		
	}
	
	/**
	 * popula info basica de DiasTreinoCat
	 */
	public void populaDiasTreinoCat(){
		DiasTreinoCat dias1 = new DiasTreinoCat("1 vez por semana", 1);
		diasTreinoCatDAO.insert(dias1);
		DiasTreinoCat dias2 = new DiasTreinoCat("2 vez por semana", 2);
		diasTreinoCatDAO.insert(dias2);
		DiasTreinoCat dias3 = new DiasTreinoCat("3 vez por semana", 3);
		diasTreinoCatDAO.insert(dias3);
		DiasTreinoCat dias4 = new DiasTreinoCat("4 vez por semana", 4);
		diasTreinoCatDAO.insert(dias4);
		DiasTreinoCat dias5 = new DiasTreinoCat("5 vez por semana", 5);
		diasTreinoCatDAO.insert(dias5);
		DiasTreinoCat dias6 = new DiasTreinoCat("6 vez por semana", 6);
		diasTreinoCatDAO.insert(dias6);
		DiasTreinoCat dias7 = new DiasTreinoCat("7 vez por semana", 7);
		diasTreinoCatDAO.insert(dias7);
		
	}
	
	/**
	 * popula infos basicas de DuracaoTreinoCatDAO
	 */
	public void populaDuracaoTreinoCat(){
		DuracaoTreinoCat duracao = new DuracaoTreinoCat("Até 15 min");
		duracaoTreinoCatDAO.insert(duracao);
		DuracaoTreinoCat duracao2 = new DuracaoTreinoCat("De 15 a 30 min");
		duracaoTreinoCatDAO.insert(duracao2);
		DuracaoTreinoCat duracao3 = new DuracaoTreinoCat("De 30 a 45 min");
		duracaoTreinoCatDAO.insert(duracao3);
		DuracaoTreinoCat duracao4 = new DuracaoTreinoCat("De 45 a 60 min");
		duracaoTreinoCatDAO.insert(duracao4);
		DuracaoTreinoCat duracao5= new DuracaoTreinoCat("De 60 a 75 min");
		duracaoTreinoCatDAO.insert(duracao5);
		DuracaoTreinoCat duracao6 = new DuracaoTreinoCat("De 75 a 90 min");
		duracaoTreinoCatDAO.insert(duracao6);
		DuracaoTreinoCat duracao7 = new DuracaoTreinoCat("De 90 a 120 min");
		duracaoTreinoCatDAO.insert(duracao7);
		DuracaoTreinoCat duracao8 = new DuracaoTreinoCat("Mais de 120 min");
		duracaoTreinoCatDAO.insert(duracao8);
	}
	

	/**
	 * popula infos basicas de ParteCorpo
	 */
	public void populaParteCorpo(){
		ParteCorpo p1 = new ParteCorpo("Biceps");
		parteCorpoDAO.insert(p1);
		ParteCorpo p2 = new ParteCorpo("Triceps");
		parteCorpoDAO.insert(p2);
		ParteCorpo p3 = new ParteCorpo("Costas");
		parteCorpoDAO.insert(p3);
		ParteCorpo p4 = new ParteCorpo("Lombar");
		parteCorpoDAO.insert(p4);
		ParteCorpo p5 = new ParteCorpo("Peito");
		parteCorpoDAO.insert(p5);
		ParteCorpo p6 = new ParteCorpo("Panturrilha");
		parteCorpoDAO.insert(p6);
		ParteCorpo p7 = new ParteCorpo("Coxas");
		parteCorpoDAO.insert(p7);
		ParteCorpo p8 = new ParteCorpo("Gluteos");
		parteCorpoDAO.insert(p8);
		ParteCorpo p9 = new ParteCorpo("Abdomen");
		parteCorpoDAO.insert(p9);
		ParteCorpo p10 = new ParteCorpo("Antebraço");
		parteCorpoDAO.insert(p10);
		ParteCorpo p11 = new ParteCorpo("Trapezio");
		parteCorpoDAO.insert(p11);
	}
	
	/**
	 * popula infos basicas de NoticiaCat
	 */
	public void populaNoticiaCat(){
		NoticiaCat n1 = new NoticiaCat("Avisos");
		noticiaCatDAO.insert(n1);
		NoticiaCat n2 = new NoticiaCat("Noticias");
		noticiaCatDAO.insert(n2);
		NoticiaCat n3 = new NoticiaCat("Dicas");
		noticiaCatDAO.insert(n3);
	}
	
	
	/**
	 * popula infos basicas de ProfessorFunc(Funcionarios)
	 */
	public void populaFuncionario(){
		for(int i = 1; i<51; i++){
			ProfessorFunc f = new ProfessorFunc();
			f.setNome("Funcionario " + i);
			f.setEmail("f" + i + "@gmail.com");
			f.setCpf("33342523501");
			f.setIsProfessor(false);
			f.setSenha("123");
			f.setRg("22233344401");
			professorFuncDAO.insert(f);
		}
		
	}
	
	/**
	 * popula infos basicas de ProfessorFunc(Professor)
	 */
	public void populaProfessor(){
		for(int i = 1; i<200; i++){
			ProfessorFunc p = new ProfessorFunc();
			p.setNome("Professor " + i);
			p.setEmail("p" + i + "@gmail.com");
			p.setCpf("33342523501");
			p.setIsProfessor(true);
			p.setSenha("123");
			p.setRg("22233344401");
			professorFuncDAO.insert(p);
		}
		
		
		
	}
	
}
	
	
	
