package br.com.acad.bean.banco;

import java.io.Serializable;
import java.util.Calendar;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.dao.avisos.interf.NoticiaCatDAO;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.dao.treino.interf.ParteCorpoDAO;
import br.com.acad.model.avisos.NoticiaCat;
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
	private ProfessorFuncDAO funcDAO;
	
	public void popula(){
		populaParteCorpo();
		populaNoticiaCat();
		populaProfessor();
		populaFuncionario();
		
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
			funcDAO.insert(f);
		}
		
	}
	
	/**
	 * popula infos basicas de ProfessorFunc(Professor)
	 */
	public void populaProfessor(){
		for(int i = 1; i<51; i++){
			ProfessorFunc p = new ProfessorFunc();
			p.setNome("Professor " + i);
			p.setEmail("p" + i + "@gmail.com");
			p.setCpf("33342523501");
			p.setIsProfessor(false);
			p.setSenha("123");
			p.setRg("22233344401");
			funcDAO.insert(p);
		}
		
		
		
	}
	
}
	
	
	
