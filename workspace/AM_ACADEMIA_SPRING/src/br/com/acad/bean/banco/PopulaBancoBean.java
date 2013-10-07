package br.com.acad.bean.banco;

import java.io.Serializable;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.dao.avisos.interf.NoticiaCatDAO;
import br.com.acad.dao.avisos.interf.NoticiaDAO;
import br.com.acad.dao.catGenerico.interf.DiasTreinoCatDAO;
import br.com.acad.dao.catGenerico.interf.DuracaoTreinoCatDAO;
import br.com.acad.dao.catGenerico.interf.FaixaEtariaCatDAO;
import br.com.acad.dao.catGenerico.interf.ObjetivoCatDAO;
import br.com.acad.dao.catGenerico.interf.SexoCatDAO;
import br.com.acad.dao.dieta.interf.AlimentoDAO;
import br.com.acad.dao.dieta.interf.UnidadeMedidaDAO;
import br.com.acad.dao.horario.interf.AulaDAO;
import br.com.acad.dao.horario.interf.HorarioAulaDAO;
import br.com.acad.dao.horario.interf.UnidadeDAO;
import br.com.acad.dao.pessoa.interf.AlunoDAO;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.dao.treino.interf.ExercicioDAO;
import br.com.acad.dao.treino.interf.ParteCorpoDAO;
import br.com.acad.logic.CriptografiaLogic;
import br.com.acad.logic.NumberLogic;
import br.com.acad.model.avisos.Noticia;
import br.com.acad.model.avisos.NoticiaCat;
import br.com.acad.model.cat.DiasTreinoCat;
import br.com.acad.model.cat.DuracaoTreinoCat;
import br.com.acad.model.cat.FaixaEtariaCat;
import br.com.acad.model.cat.ObjetivoCat;
import br.com.acad.model.cat.SexoCat;
import br.com.acad.model.dieta.Alimento;
import br.com.acad.model.dieta.UnidadeMedida;
import br.com.acad.model.horario.Aula;
import br.com.acad.model.horario.HorarioAula;
import br.com.acad.model.horario.Unidade;
import br.com.acad.model.pessoa.Aluno;
import br.com.acad.model.pessoa.ProfessorFunc;
import br.com.acad.model.treino.Exercicio;
import br.com.acad.model.treino.ParteCorpo;

@SuppressWarnings("serial")
@Component
@Scope(value="view")
public class PopulaBancoBean implements Serializable {

	@Autowired
	private ParteCorpoDAO parteCorpoDAO;
	@Autowired
	private NoticiaCatDAO noticiaCatDAO;
	@Autowired
	private ProfessorFuncDAO professorFuncDAO;
	@Autowired
	private DiasTreinoCatDAO diasTreinoCatDAO;
	@Autowired
	private DuracaoTreinoCatDAO duracaoTreinoCatDAO;	
	@Autowired
	private ObjetivoCatDAO objetivoCatDAO;	
	@Autowired
	private SexoCatDAO sexoCatDAO;
	@Autowired
	private FaixaEtariaCatDAO faixaEtariaCatDAO;
	@Autowired
	private AlunoDAO alunoDAO;
	@Autowired
	private ExercicioDAO exercicioDAO;
	@Autowired
	private UnidadeDAO unidadeDAO;
	@Autowired
	private AulaDAO aulaDAO;
	@Autowired
	private HorarioAulaDAO horarioAulaDAO;
	@Autowired
	private NoticiaDAO noticiaDAO;
	@Autowired
	private UnidadeMedidaDAO unidadeMedidaDAO;
	@Autowired
	private AlimentoDAO alimentoDAO;
	
	public void popula(){
		System.out.println("populando - ParteCorpo");
		populaParteCorpo();
		System.out.println("populando - NoticiaCat");
		populaNoticiaCat();
		System.out.println("populando - Professor");
		populaProfessor();
		System.out.println("populando - Funcionario");
		populaFuncionario();
		System.out.println("populando - DuracaoTreinoCat");
		populaDuracaoTreinoCat();
		System.out.println("populando - DiasTreinoCat");
		populaDiasTreinoCat();
		System.out.println("populando - ObjetivoCat");
		populaObjetivoCat();
		System.out.println("populando - SexoCat");
		populaSexoCat();
		System.out.println("populando - FaixaEtariaCat");
		populaFaixaEtariaCat();
		System.out.println("populando - Aluno");
		populaAluno();
		System.out.println("populando - Exercicio");
		populaExercicio();
		System.out.println("populando - Unidade");
		populaUnidade();
		System.out.println("populando - Aula");
		populaAula();
		System.out.println("populando - HorarioAula");
		populaHorarioAula();
		System.out.println("populando - Noticia");
		populaNoticia();
		System.out.println("populando - UnidadeMedida");
		populaUnidadeMedida();
		System.out.println("populando - Alimento");
		populaAlimento();
		System.out.println("populando - FIM");
	}
	
	/**
	 * popula infos basicas de Alimento
	 */
	private void populaAlimento(){
		Alimento a = new Alimento("Arroz", 100d, 5d, 0.4d, 30d, 100d, new UnidadeMedida(1));
		alimentoDAO.insert(a);
		a = new Alimento("Abacaxi", 96.2d, 1.2d, 2.3d, 6d, 100d, new UnidadeMedida(1));
		alimentoDAO.insert(a);
		a = new Alimento("Carne moida - Acem", 212.4d, 26.7d, 9.8d, 0d, 100, new UnidadeMedida(1));
		alimentoDAO.insert(a);
		a = new Alimento("Pernil Assado", 262.3d, 32.1d, 13.1d, 0, 100, new UnidadeMedida(1));
		alimentoDAO.insert(a);
		a = new Alimento("Pao de forma integral", 253.2d, 9.4d, 2.9d, 49, 100, new UnidadeMedida(1));
		alimentoDAO.insert(a);
	}
	
	
	/**
	 * popula infos basicas de UnidadeMedida
	 */
	private void populaUnidadeMedida(){
		UnidadeMedida u =new UnidadeMedida("Gramas", "g");
		unidadeMedidaDAO.insert(u);
		u =new UnidadeMedida("Quilo", "kg");
		unidadeMedidaDAO.insert(u);
		u=new UnidadeMedida("Quilo", "kg");
		unidadeMedidaDAO.insert(u);
		u=new UnidadeMedida("Unidade", "unidade");
		unidadeMedidaDAO.insert(u);
		u=new UnidadeMedida("Colher de Sopa", "col. sopa");
		unidadeMedidaDAO.insert(u);
		u=new UnidadeMedida("Colher de Sobremesa", "col. sobremesa");
		unidadeMedidaDAO.insert(u);
		u=new UnidadeMedida("Colher de Chá", "col. chá");
		unidadeMedidaDAO.insert(u);
		u=new UnidadeMedida("Copo", "copo");
		unidadeMedidaDAO.insert(u);
		
	}
	
	/**
	 * popula infos basicas de Noticia
	 */
	private void populaNoticia(){
		NoticiaCat nc =new NoticiaCat();
		ProfessorFunc prof = new ProfessorFunc();
		
		prof.setId(1);
		nc.setId(1);
		Noticia n = new Noticia(Calendar.getInstance(), "Titulo 1", "Descricao aqui", nc, prof);
		noticiaDAO.insert(n);
		
		prof.setId(1);
		nc.setId(2);
		n = new Noticia(Calendar.getInstance(), "Titulo 2", "Descricao aqui", nc, prof);
		noticiaDAO.insert(n);
		
		prof.setId(2);
		nc.setId(2);
		n = new Noticia(Calendar.getInstance(), "Titulo 3", "Descricao aqui", nc, prof);
		noticiaDAO.insert(n);
		
		prof.setId(5);
		nc.setId(3);
		n = new Noticia(Calendar.getInstance(), "Titulo 4", "Descricao aqui", nc, prof);
		noticiaDAO.insert(n);
		
		prof.setId(5);
		nc.setId(3);
		n = new Noticia(Calendar.getInstance(), "Titulo 5", "Descricao aqui", nc, prof);
		noticiaDAO.insert(n);
		
		prof.setId(1);
		nc.setId(3);
		n = new Noticia(Calendar.getInstance(), "Titulo 6", "Descricao aqui", nc, prof);
		noticiaDAO.insert(n);
	}
	
	/**
	 * popula infos basicas de HorarioAula
	 */
	private void populaHorarioAula(){
		Calendar hora = Calendar.getInstance();
		hora.set(Calendar.HOUR_OF_DAY, 18);
		hora.set(Calendar.MINUTE, 0);
		HorarioAula h =  new HorarioAula(hora, "Segunda e Quinta", 1, 3, 1);
		horarioAulaDAO.insert(h);
		
		hora.set(Calendar.HOUR_OF_DAY, 5);
		h =  new HorarioAula(hora, "Terca e Sexta", 1, 3, 1);
		horarioAulaDAO.insert(h);

		hora.set(Calendar.HOUR_OF_DAY, 15);
		h =  new HorarioAula(hora, "Terca e Sexta", 2, 5, 3);
		horarioAulaDAO.insert(h);

		hora.set(Calendar.HOUR_OF_DAY, 5);
		h =  new HorarioAula(hora, "Terca e Sexta", 2, 5, 3);
		horarioAulaDAO.insert(h);

		hora.set(Calendar.HOUR_OF_DAY, 10);
		h =  new HorarioAula(hora, "Terca e Sexta", 2, 5, 3);
		horarioAulaDAO.insert(h);

		hora.set(Calendar.HOUR_OF_DAY, 5);
		h =  new HorarioAula(hora, "Quarta e Sexta", 3, 5, 3);
		horarioAulaDAO.insert(h);

		hora.set(Calendar.HOUR_OF_DAY, 5);
		h =  new HorarioAula(hora, "Sexta", 1, 1, 2);
		horarioAulaDAO.insert(h);

		hora.set(Calendar.HOUR_OF_DAY, 19);
		h =  new HorarioAula(hora, "Sexta", 2, 1, 1);
		horarioAulaDAO.insert(h);

		hora.set(Calendar.HOUR_OF_DAY, 5);
		h =  new HorarioAula(hora, "Segunda", 3, 6, 4);
		horarioAulaDAO.insert(h);
		
	}
	
	/**
	 * popula infos basicas de Aula
	 */
	private void populaAula(){
		Aula aula = new Aula("Abdominal", 
				"Aula que tem como objetivo o aumento da força e resistência muscular abdominal," +
				" melhora da postura e diminuição das dores lombares, através de exercícios de resistência " +
				"muscular. Indicada para todos os níveis de condicionamento ΩΩΩ iniciantes, intermedi��rios e " +
				"avan��ados. DURA����O 30'", "ab.jpg");
		aulaDAO.insert(aula);
		
		aula = new Aula("Boxe", "Aula de condicionamento f��sico que utiliza a t��cnica e exerc��cios do boxe. Indicada para todos os n��veis " +
				"de condicionamento ��� iniciantes, intermedi��rios e avan��ados. DURA����O 60'", "boxe.gif");
		aulaDAO.insert(aula);
		
		aula = new Aula("Jiu Jitsu", "Aula com treinamento espec��fico da modalidade", "jiujitsu.gif");
		aulaDAO.insert(aula);
		
		aula = new Aula("Bike", "Aula que tem como objetivo o condicionamento cardiovascular, atrav��s de uma " +
				"periodiza����o de treinamento espec��fica da modalidade. Indicada para todos os n��veis de condicionamento ��� " +
				"iniciantes, intermedi��rios e avan��ados. DURA����O 30', 45' E 60'", "bike.gif");
		aulaDAO.insert(aula);
	}
	
	/**
	 * popula infos basicas de Unidade
	 */
	private void populaUnidade(){
		Unidade unidade = new Unidade("Unidade Santo Amaro", "Horario de funcionamento: 6:00 as 23:00");
		unidadeDAO.insert(unidade);
		unidade = new Unidade("Unidade Aclima����o", "Horario de funcionamento: 7:00 as 22:00");
		unidadeDAO.insert(unidade);
		unidade = new Unidade("Unidade Vinhedo", "Horario de funcionamento: 6:00 as 22:00");
		unidadeDAO.insert(unidade);
	}
	
	/**
	 * popula infos basicas de ParteCorpo
	 */
	private void populaParteCorpo(){
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
		ParteCorpo p12 = new ParteCorpo("Ombro");
		parteCorpoDAO.insert(p12);
	}
	
	private void populaExercicio(){
		Exercicio ex = new Exercicio("Supino", PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.PEITO), 
				PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.TRICEPS, PopulaBancoLogic.OMBRO), 
				"O supino com barra em banco plano ���� o exerc����cio mais conhecido e realizado nos gin����sios. "
						+ "Embora n����o existam m����sculos peitorais �������superiores�������� e �������inferiores��������, o supino plano "
						+ "parece recrutar mais as fibras interm����dias (parte esternocostal).",
				"supino_barra.jpg");
		exercicioDAO.insert(ex);
		
		ex = new Exercicio("Supino Inclinado", PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.PEITO), 
				PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.TRICEPS, PopulaBancoLogic.OMBRO), 
				"Esta varia��������o do supino plano coloca uma maior ����nfase na parte clavicular (superior) do grande peitoral."
				+ " O supino inclinado com um ����ngulo de +45 graus, proporciona uma estimula��������o 69% mais elevada na �������parte "
				+ "superior do peitoral��������.",
				"supino_inclinado_barra.jpg");
		exercicioDAO.insert(ex);
		
		ex = new Exercicio("Supino Declinado", PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.PEITO), 
				PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.TRICEPS, PopulaBancoLogic.OMBRO), 
				" O supino declinado ���� a varia��������o do supino que recruta uma maior percentagem de fibras muscular, muito "
				+ "devido ao fato de tamb����m ser o tipo de supino em que ���� poss����vel utilizar mais peso.",
				"supino_declinado_barra.jpg");
		exercicioDAO.insert(ex);
		
		ex = new Exercicio("Levantamento Terra", PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.COSTAS, PopulaBancoLogic.LOMBAR, PopulaBancoLogic.GLUTEOS, PopulaBancoLogic.TRAPEZIO), 
				PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.ANTEBRACO, PopulaBancoLogic.COXAS, PopulaBancoLogic.ABDOMEN), 
				"Nesta varia��������o do peso morto, a mais conhecida de todas, tudo ���� projetado para a maximiza��������o t����cnica da "
				+ "quantidade de peso levantado. Os quadris come����am mais elevados do que os joelhos (basicamente colocando "
				+ "os joelhos no mesmo ����ngulo que um quarto do agachamento) e os ombros est����o um pouco atr����s da barra na "
				+ "posi��������o de partida. Isto permite-lhe utilizar ao m����ximo a parte inferior das costas, gl����teos, e quadr����ceps.",
				"peso_morto_levantamento_terra.jpg");
		exercicioDAO.insert(ex);
		
		ex = new Exercicio("Puxada Polia Alta (Frente)", PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.COSTAS), 
				PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.BICEPS), 
				"A puxada de dorsais em polia alta (pela frente) tem como alvo principal o grande dorsal. Este ���� um m����sculo "
				+ "grande que ocupa uma grande extens����o das costas.",
				"puxada_dorsais_polia_alta.jpg");
		exercicioDAO.insert(ex);
		
		ex = new Exercicio("Puxada Polia Alta Supinada", PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.COSTAS), 
				PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.BICEPS), 
				" Esta varia��������o da puxada de dorsais em polia alta (pela frente) diferencia-se da varia��������o anterior por recrutar "
				+ "e trabalhar mais os b����ceps.",
				"puxada_dorsais_polia_alta_supina��������o.jpg");
		exercicioDAO.insert(ex);
		
		ex = new Exercicio("Remada com Barra", PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.COSTAS), 
				PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.BICEPS, PopulaBancoLogic.ANTEBRACO), 
				" Esta varia��������o da puxada de dorsais em polia alta (pela frente) diferencia-se da varia��������o anterior por recrutar e trabalhar mais os b����ceps.",
				"remada_com_barra.jpg");
		exercicioDAO.insert(ex);
		
		ex = new Exercicio("Press Militar", PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.OMBRO), 
				PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.TRICEPS, PopulaBancoLogic.TRAPEZIO), 
				" O movimento mais conhecido para trabalhar os delt����ides. Dever���� ter cuidado para n����o usar demasiada carga que possa comprometer a execu��������o "
				+ "correta e flu����da do exerc����cio. A vers����o de press militar ���� nuca ���� na verdade a mais eficiente para trabalhar as tr����s cabe����as dos delt����ides.",
				"press_militar_barra.jpg");
		exercicioDAO.insert(ex);
		
		ex = new Exercicio("Remada Alta", PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.OMBRO, PopulaBancoLogic.TRAPEZIO), 
				PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.BICEPS), 
				"  Este ���� um excelente movimento composto para atingir a parte medial dos delt����ides.",
				"remada_vertical.jpg");
		
		ex = new Exercicio("Desenvolvimento com halteres", PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.OMBRO), 
				PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.TRICEPS, PopulaBancoLogic.TRAPEZIO), 
				" Este ���� muito provavelmente o melhor exerc����cio geral para os delt����ides, pois permite a realiza��������o de um arco de movimento mais natural.",
				"press_militar_halteres1.jpg");
		
		ex = new Exercicio("Curl com barra", PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.BICEPS), 
				PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.OMBRO), 
				"  O curl com barra ���� o movimento mais conhecido, o mais usado e tamb����m um dos mais mal executados do gin����sio. Para aprender a realiz����-lo "
				+ "da forma correta, ���� aconselh����vel que comece por apoiar as costas numa estrutura s����lida como um pilar e usar cargas moderadas.",
				"curl_barra_reta.jpg");
		
		ex = new Exercicio("Concentrada", PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.BICEPS), 
				PopulaBancoLogic.getPartesCorpo(), 
				" Segundo an����lises EMG, este ���� o exerc����cios mais eficiente para os b����ceps quando realizado de forma exc����ntrica + contra��������es de "
				+ "pico/m����ximas. Mais uma vez, utilize pesos que consiga controlar bem e n����o fa����a batota.",
				"curl_concentracao.jpg");
		exercicioDAO.insert(ex);
		
		ex = new Exercicio("Paralela", PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.TRICEPS, PopulaBancoLogic.PEITO), 
				PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.OMBRO), 
				" Um dos melhores exerc����cios para trabalhar os tr����ceps (cabe����a medial, lateral e longa dos tr����ceps), e tamb����m trabalha o grande "
						+ "peitoral e delt����ides. Segundo an����lises EMG, os fundos em barras paralelas, juntamente com os fundos entre bancos, s����o os dois "
						+ "exerc����cios mais eficientes para trabalhar os tr����ceps.",
				"fundos_barras_paralelas.jpg");
		
		ex = new Exercicio("Extens����es de tr����ceps sentado", PopulaBancoLogic.getPartesCorpo(PopulaBancoLogic.TRICEPS), 
				PopulaBancoLogic.getPartesCorpo(), 
				"  Esta varia��������o do exerc����cios extens����es de tr����ceps deitado, encontra-se ao mesmo n����vel em termos de efici����ncia de ativa��������o dos tr����ceps.",
				"extens����o_triceps_sentado.jpg");
		exercicioDAO.insert(ex);
	}
	
	/**
	 * popula info basica de FaixaEtariaCat
	 */
	private void populaFaixaEtariaCat(){
		faixaEtariaCatDAO.insert(new FaixaEtariaCat("Até 15 anos"));
		faixaEtariaCatDAO.insert(new FaixaEtariaCat("De 16 a 19 anos"));
		faixaEtariaCatDAO.insert(new FaixaEtariaCat("De 20 a 30 anos"));
		faixaEtariaCatDAO.insert(new FaixaEtariaCat("De 31 a 45 anos"));
		faixaEtariaCatDAO.insert(new FaixaEtariaCat("De 46 a 60 anos"));
		faixaEtariaCatDAO.insert(new FaixaEtariaCat("Mais de 60 anos"));
		faixaEtariaCatDAO.insert(new FaixaEtariaCat("Todas as idades"));
		
	}
	
	/**
	 * popula info basica de SexoCat
	 */
	private void populaSexoCat(){
		sexoCatDAO.insert(new SexoCat("Masculino"));
		sexoCatDAO.insert(new SexoCat("Feminino"));
		sexoCatDAO.insert(new SexoCat("Todos"));
	}
	
	/**
	 * popula info basica de ObjetivoCat
	 */
	private void populaObjetivoCat(){
		objetivoCatDAO.insert(new ObjetivoCat("Hipertrofia"));
		objetivoCatDAO.insert(new ObjetivoCat("Saude"));
		objetivoCatDAO.insert(new ObjetivoCat("Emagrecer"));
	}
	
	/**
	 * popula info basica de DiasTreinoCat
	 */
	private void populaDiasTreinoCat(){
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
	private void populaDuracaoTreinoCat(){
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
	 * popula infos basicas de NoticiaCat
	 */
	private void populaNoticiaCat(){
		NoticiaCat n1 = new NoticiaCat("Avisos", "Help");
		noticiaCatDAO.insert(n1);
		NoticiaCat n2 = new NoticiaCat("Noticias", "Document Notes");
		noticiaCatDAO.insert(n2);
		NoticiaCat n3 = new NoticiaCat("Dicas", "Tag");
		noticiaCatDAO.insert(n3);
	}
	
	
	/**
	 * popula infos basicas de ProfessorFunc(Funcionarios)
	 */
	private void populaFuncionario(){
		Calendar nasc = Calendar.getInstance();
		
		ProfessorFunc f = new ProfessorFunc();
		nasc.set(Calendar.DAY_OF_MONTH, NumberLogic.randomInteger(1, 28));
		nasc.set(Calendar.MONTH, NumberLogic.randomInteger(1, 12));
		nasc.set(Calendar.YEAR, NumberLogic.randomInteger(1940, 1995));
		f.setDataNascimento(nasc);
		f.setNome("Guilherme");
		f.setEmail(f.getNome() + "@gmail.com");
		f.setCpf(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		f.setIsProfessor(false);
		f.setSenha(CriptografiaLogic.encriptar("123"));
		f.setRg(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		professorFuncDAO.insert(f);
		
		f = new ProfessorFunc();
		nasc.set(Calendar.DAY_OF_MONTH, NumberLogic.randomInteger(1, 28));
		nasc.set(Calendar.MONTH, NumberLogic.randomInteger(1, 12));
		nasc.set(Calendar.YEAR, NumberLogic.randomInteger(1940, 1995));
		f.setDataNascimento(nasc);
		f.setNome("Stefanie");
		f.setEmail(f.getNome() + "@gmail.com");
		f.setCpf(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		f.setIsProfessor(false);
		f.setSenha(CriptografiaLogic.encriptar("123"));
		f.setRg(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		professorFuncDAO.insert(f);
		
		f = new ProfessorFunc();
		nasc.set(Calendar.DAY_OF_MONTH, NumberLogic.randomInteger(1, 28));
		nasc.set(Calendar.MONTH, NumberLogic.randomInteger(1, 12));
		nasc.set(Calendar.YEAR, NumberLogic.randomInteger(1940, 1995));
		f.setDataNascimento(nasc);
		f.setNome("Daniel");
		f.setEmail(f.getNome() + "@gmail.com");
		f.setCpf(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		f.setIsProfessor(false);
		f.setSenha(CriptografiaLogic.encriptar("123"));
		f.setRg(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		professorFuncDAO.insert(f);
		
		f = new ProfessorFunc();
		nasc.set(Calendar.DAY_OF_MONTH, NumberLogic.randomInteger(1, 28));
		nasc.set(Calendar.MONTH, NumberLogic.randomInteger(1, 12));
		nasc.set(Calendar.YEAR, NumberLogic.randomInteger(1940, 1995));
		f.setDataNascimento(nasc);
		f.setNome("Gabriella");
		f.setEmail(f.getNome() + "@gmail.com");
		f.setCpf(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		f.setIsProfessor(false);
		f.setSenha(CriptografiaLogic.encriptar("123"));
		f.setRg(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		professorFuncDAO.insert(f);
		
		f = new ProfessorFunc();
		nasc.set(Calendar.DAY_OF_MONTH, NumberLogic.randomInteger(1, 28));
		nasc.set(Calendar.MONTH, NumberLogic.randomInteger(1, 12));
		nasc.set(Calendar.YEAR, NumberLogic.randomInteger(1940, 1995));
		f.setDataNascimento(nasc);
		f.setNome("Mauricio");
		f.setEmail(f.getNome() + "@gmail.com");
		f.setCpf(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		f.setIsProfessor(false);
		f.setSenha(CriptografiaLogic.encriptar("123"));
		f.setRg(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		professorFuncDAO.insert(f);
		
		f = new ProfessorFunc();
		nasc.set(Calendar.DAY_OF_MONTH, NumberLogic.randomInteger(1, 28));
		nasc.set(Calendar.MONTH, NumberLogic.randomInteger(1, 12));
		nasc.set(Calendar.YEAR, NumberLogic.randomInteger(1940, 1995));
		f.setDataNascimento(nasc);
		f.setNome("Amanda");
		f.setEmail(f.getNome() + "@gmail.com");
		f.setCpf(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		f.setIsProfessor(false);
		f.setSenha(CriptografiaLogic.encriptar("123"));
		f.setRg(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		professorFuncDAO.insert(f);
		
		f = new ProfessorFunc();
		nasc.set(Calendar.DAY_OF_MONTH, NumberLogic.randomInteger(1, 28));
		nasc.set(Calendar.MONTH, NumberLogic.randomInteger(1, 12));
		nasc.set(Calendar.YEAR, NumberLogic.randomInteger(1940, 1995));
		f.setDataNascimento(nasc);
		f.setNome("Tadeu");
		f.setEmail(f.getNome() + "@gmail.com");
		f.setCpf(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		f.setIsProfessor(false);
		f.setSenha(CriptografiaLogic.encriptar("123"));
		f.setRg(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		professorFuncDAO.insert(f);
		
		f = new ProfessorFunc();
		nasc.set(Calendar.DAY_OF_MONTH, NumberLogic.randomInteger(1, 28));
		nasc.set(Calendar.MONTH, NumberLogic.randomInteger(1, 12));
		nasc.set(Calendar.YEAR, NumberLogic.randomInteger(1940, 1995));
		f.setDataNascimento(nasc);
		f.setNome("Luciana");
		f.setEmail(f.getNome() + "@gmail.com");
		f.setCpf(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		f.setIsProfessor(false);
		f.setSenha(CriptografiaLogic.encriptar("123"));
		f.setRg(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		professorFuncDAO.insert(f);
		
		f = new ProfessorFunc();
		nasc.set(Calendar.DAY_OF_MONTH, NumberLogic.randomInteger(1, 28));
		nasc.set(Calendar.MONTH, NumberLogic.randomInteger(1, 12));
		nasc.set(Calendar.YEAR, NumberLogic.randomInteger(1940, 1995));
		f.setDataNascimento(nasc);
		f.setNome("Patricia");
		f.setEmail(f.getNome() + "@gmail.com");
		f.setCpf(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		f.setIsProfessor(false);
		f.setSenha(CriptografiaLogic.encriptar("123"));
		f.setRg(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		professorFuncDAO.insert(f);
	}
	
	/**
	 * popula infos basicas de ProfessorFunc(Professor)
	 */
	private void populaProfessor(){
		Calendar nasc = Calendar.getInstance();
		
		ProfessorFunc p = new ProfessorFunc();
		nasc.set(Calendar.DAY_OF_MONTH, NumberLogic.randomInteger(1, 28));
		nasc.set(Calendar.MONTH, NumberLogic.randomInteger(1, 12));
		nasc.set(Calendar.YEAR, NumberLogic.randomInteger(1940, 1995));
		p.setDataNascimento(nasc);
		p.setNome("Joana");
		p.setEmail(p.getNome() + "@gmail.com");
		p.setCpf(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		p.setIsProfessor(true);
		p.setSenha(CriptografiaLogic.encriptar("123"));
		p.setRg(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		professorFuncDAO.insert(p);
		
		p = new ProfessorFunc();
		nasc.set(Calendar.DAY_OF_MONTH, NumberLogic.randomInteger(1, 28));
		nasc.set(Calendar.MONTH, NumberLogic.randomInteger(1, 12));
		nasc.set(Calendar.YEAR, NumberLogic.randomInteger(1940, 1995));
		p.setDataNascimento(nasc);
		p.setNome("Mario");
		p.setEmail(p.getNome() + "@gmail.com");
		p.setCpf(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		p.setIsProfessor(true);
		p.setSenha(CriptografiaLogic.encriptar("123"));
		p.setRg(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		professorFuncDAO.insert(p);
		
		p = new ProfessorFunc();
		nasc.set(Calendar.DAY_OF_MONTH, NumberLogic.randomInteger(1, 28));
		nasc.set(Calendar.MONTH, NumberLogic.randomInteger(1, 12));
		nasc.set(Calendar.YEAR, NumberLogic.randomInteger(1940, 1995));
		p.setDataNascimento(nasc);
		p.setNome("Marcio");
		p.setEmail(p.getNome() + "@gmail.com");
		p.setCpf(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		p.setIsProfessor(true);
		p.setSenha(CriptografiaLogic.encriptar("123"));
		p.setRg(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		professorFuncDAO.insert(p);
		
		p = new ProfessorFunc();
		nasc.set(Calendar.DAY_OF_MONTH, NumberLogic.randomInteger(1, 28));
		nasc.set(Calendar.MONTH, NumberLogic.randomInteger(1, 12));
		nasc.set(Calendar.YEAR, NumberLogic.randomInteger(1940, 1995));
		p.setDataNascimento(nasc);
		p.setNome("Fabiana");
		p.setEmail(p.getNome() + "@gmail.com");
		p.setCpf(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		p.setIsProfessor(true);
		p.setSenha(CriptografiaLogic.encriptar("123"));
		p.setRg(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		professorFuncDAO.insert(p);
		
		p = new ProfessorFunc();
		nasc.set(Calendar.DAY_OF_MONTH, NumberLogic.randomInteger(1, 28));
		nasc.set(Calendar.MONTH, NumberLogic.randomInteger(1, 12));
		nasc.set(Calendar.YEAR, NumberLogic.randomInteger(1940, 1995));
		p.setDataNascimento(nasc);
		p.setNome("Kleber");
		p.setEmail(p.getNome() + "@gmail.com");
		p.setCpf(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		p.setIsProfessor(true);
		p.setSenha(CriptografiaLogic.encriptar("123"));
		p.setRg(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		professorFuncDAO.insert(p);
		
		p = new ProfessorFunc();
		nasc.set(Calendar.DAY_OF_MONTH, NumberLogic.randomInteger(1, 28));
		nasc.set(Calendar.MONTH, NumberLogic.randomInteger(1, 12));
		nasc.set(Calendar.YEAR, NumberLogic.randomInteger(1940, 1995));
		p.setDataNascimento(nasc);
		p.setNome("Antonio");
		p.setEmail(p.getNome() + "@gmail.com");
		p.setCpf(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		p.setIsProfessor(true);
		p.setSenha(CriptografiaLogic.encriptar("123"));
		p.setRg(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		professorFuncDAO.insert(p);
		
		p = new ProfessorFunc();
		nasc.set(Calendar.DAY_OF_MONTH, NumberLogic.randomInteger(1, 28));
		nasc.set(Calendar.MONTH, NumberLogic.randomInteger(1, 12));
		nasc.set(Calendar.YEAR, NumberLogic.randomInteger(1940, 1995));
		p.setDataNascimento(nasc);
		p.setNome("Paula");
		p.setEmail(p.getNome() + "@gmail.com");
		p.setCpf(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		p.setIsProfessor(true);
		p.setSenha(CriptografiaLogic.encriptar("123"));
		p.setRg(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
		professorFuncDAO.insert(p);
	}
	
	/**
	 * popula infos basicas de Aluno
	 */
	private void populaAluno(){
		Calendar nasc = Calendar.getInstance();
		nasc.set(Calendar.DAY_OF_MONTH, 24);
		nasc.set(Calendar.MONTH, 03);
		nasc.set(Calendar.YEAR, 1989);
		Aluno c = new Aluno();
		c.setNome("Christian ");
		c.setEmail("c@gmail.com");
		c.setCpf("33342523501");
		c.setAltura(1.76);
		c.setPeso(70);
		c.setSenha(CriptografiaLogic.encriptar("r"));
		c.setRg("22233344401");
		c.setDataNascimento(nasc);
		c.setNumSolicitacao(0);
		alunoDAO.insert(c);
		
		for(int i = 1; i<500; i++){
			nasc.set(Calendar.DAY_OF_MONTH, NumberLogic.randomInteger(1, 28));
			nasc.set(Calendar.MONTH, NumberLogic.randomInteger(1, 12));
			nasc.set(Calendar.YEAR, NumberLogic.randomInteger(1940, 1995));
			Aluno a = new Aluno();
			a.setNome("Aluno " + i);
			a.setEmail("aluno" + i + "@gmail.com");
			a.setCpf(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
			a.setAltura(NumberLogic.randomDouble(1.60d, 1.99d));
			a.setPeso(NumberLogic.randomInteger(60, 100));
			a.setSenha(CriptografiaLogic.encriptar("123"));
			a.setRg(String.valueOf(NumberLogic.randomInteger(100000000, 999999999)));
			a.setDataNascimento(nasc);
			a.setNumSolicitacao(0);
			alunoDAO.insert(a);
		}
	}
	
}
	
	
	
