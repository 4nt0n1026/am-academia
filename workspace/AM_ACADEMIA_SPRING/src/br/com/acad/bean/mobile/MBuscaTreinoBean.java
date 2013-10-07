package br.com.acad.bean.mobile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.dao.catGenerico.interf.DiasTreinoCatDAO;
import br.com.acad.dao.catGenerico.interf.DuracaoTreinoCatDAO;
import br.com.acad.dao.catGenerico.interf.FaixaEtariaCatDAO;
import br.com.acad.dao.catGenerico.interf.ObjetivoCatDAO;
import br.com.acad.dao.catGenerico.interf.SexoCatDAO;
import br.com.acad.dao.pessoa.interf.AlunoDAO;
import br.com.acad.dao.treino.interf.TreinoFixoDAO;
import br.com.acad.logic.TreinoLogic;
import br.com.acad.model.cat.DiasTreinoCat;
import br.com.acad.model.cat.DuracaoTreinoCat;
import br.com.acad.model.cat.FaixaEtariaCat;
import br.com.acad.model.cat.ObjetivoCat;
import br.com.acad.model.cat.SexoCat;
import br.com.acad.model.pessoa.Aluno;
import br.com.acad.model.treino.TreinoFixo;

@SuppressWarnings("serial")
@Component(value="mBuscaTreinoBean")
@Scope(value="view")
public class MBuscaTreinoBean implements Serializable{
	
	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	@Autowired
	private FaixaEtariaCatDAO faixaEtariaCatDAO;
	@Autowired
	private SexoCatDAO sexoCatDAO;
	@Autowired
	private ObjetivoCatDAO objetivoCatDAO;
	@Autowired
	private DuracaoTreinoCatDAO duracaoTreinoCatDAO;
	@Autowired
	private DiasTreinoCatDAO diasTreinoCatDAO;
	@Autowired
	private TreinoFixoDAO treinoFixoDAO;
	@Autowired
	private AlunoDAO alunoDAO;
	
	@ManagedProperty(value="#{mMeusTreinosBean}") 
	private MMeusTreinosBean mMeusTreinosBean; 
	
	private FaixaEtariaCat faixaEtariaCat = new FaixaEtariaCat();
	private SexoCat sexoCat = new SexoCat();
	private ObjetivoCat objetivoCat = new ObjetivoCat();
	private DuracaoTreinoCat duracaoTreinoCat = new DuracaoTreinoCat();
	private DiasTreinoCat diasTreinoCat = new DiasTreinoCat();
	
	private List<DiasTreinoCat> diasTreinoCatField;
	private List<ObjetivoCat> objetivoCatField;
	private List<DuracaoTreinoCat> duracaoTreinoCatField;
	private List<FaixaEtariaCat> faixaEtariaCatField;
	private List<SexoCat> sexoCatField;
	
	private List<TreinoFixo> treinos = new ArrayList<TreinoFixo>();
	
	private TreinoFixo treino = new TreinoFixo(); 
	
	private String descricaoTreino;
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	public String init(){
		faixaEtariaCat = new FaixaEtariaCat();
		sexoCat = new SexoCat();
		objetivoCat = new ObjetivoCat();
		duracaoTreinoCat = new DuracaoTreinoCat();
		diasTreinoCat = new DiasTreinoCat();
		
		faixaEtariaCatField = faixaEtariaCatDAO.buscarTodos();
		sexoCatField = sexoCatDAO.buscarTodos();
		objetivoCatField = objetivoCatDAO.buscarTodos();
		duracaoTreinoCatField = duracaoTreinoCatDAO.buscarTodos();
		diasTreinoCatField = diasTreinoCatDAO.buscarTodos();
		
		return "pm:buscaTreino";
	}
	
	public String buscar(){
		//TODO - buscar em relacao aos campos(somente nome)
		treinos = treinoFixoDAO.buscarTodos();
		return "pm:buscaTreinoList";
	}
	
	public String mostrarDetalhe(){
		treino = treinoFixoDAO.searchById(treino.getId());
		descricaoTreino = TreinoLogic.getTreinoString(treino);
		return "pm:treinoDetalhe";
	}
	
	public String incluirTreino(){
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Aluno aluno = (Aluno) sessionMap.get("aluno");
		aluno.addTreino(treino);
		alunoDAO.update(aluno);
		return "pm:treino";
	}
	
	
	/************************************************************************************************************/
	//GET FIELDS
	/************************************************************************************************************/
	
	/**
	 * busca todos DiasSemanasCat para preencher o field
	 */
	public List<DiasTreinoCat> getDiasTreinoCatField() {
		return diasTreinoCatField;
	}
	
	/**
	 * busca todos DuracaoTreinoCat para preencher o field
	 */
	public List<DuracaoTreinoCat> getDuracaoTreinoCatField() {
		return duracaoTreinoCatField;
	}
	
	/**
	 * busca todos FaixaEtariaCat para preencher o field
	 */
	public List<FaixaEtariaCat> getFaixaEtariaCatField() {
		return faixaEtariaCatField;
	}
	
	/**
	 * busca todos ObjetivoCat para preencher o field
	 */
	public List<ObjetivoCat> getObjetivoCatField() {
		return objetivoCatField;
	}
	
	/**
	 * busca todos SexoCat para preencher o field
	 */
	public List<SexoCat> getSexoCatField() {
		return sexoCatField;
	}

	/************************************************************************************************************/
	//GETs e SETs
	/************************************************************************************************************/
	
	public FaixaEtariaCat getFaixaEtariaCat() {
		return faixaEtariaCat;
	}


	public void setFaixaEtariaCat(FaixaEtariaCat faixaEtariaCat) {
		this.faixaEtariaCat = faixaEtariaCat;
	}


	public SexoCat getSexoCat() {
		return sexoCat;
	}


	public void setSexoCat(SexoCat sexoCat) {
		this.sexoCat = sexoCat;
	}


	public ObjetivoCat getObjetivoCat() {
		return objetivoCat;
	}


	public void setObjetivoCat(ObjetivoCat objetivoCat) {
		this.objetivoCat = objetivoCat;
	}


	public DuracaoTreinoCat getDuracaoTreinoCat() {
		return duracaoTreinoCat;
	}


	public void setDuracaoTreinoCat(DuracaoTreinoCat duracaoTreinoCat) {
		this.duracaoTreinoCat = duracaoTreinoCat;
	}


	public DiasTreinoCat getDiasTreinoCat() {
		return diasTreinoCat;
	}


	public void setDiasTreinoCat(DiasTreinoCat diasTreinoCat) {
		this.diasTreinoCat = diasTreinoCat;
	}

	public List<TreinoFixo> getTreinos() {
		return treinos;
	}

	public TreinoFixo getTreino() {
		return treino;
	}

	public void setTreino(TreinoFixo treino) {
		this.treino = treino;
	}

	public String getDescricaoTreino() {
		return descricaoTreino;
	}

	public MMeusTreinosBean getmMeusTreinosBean() {
		return mMeusTreinosBean;
	}

	public void setmMeusTreinosBean(MMeusTreinosBean mMeusTreinosBean) {
		this.mMeusTreinosBean = mMeusTreinosBean;
	}
	

	
	
	
}
