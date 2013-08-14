package br.com.acad.bean.dieta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.acad.dao.dieta.interf.AlimentoDAO;
import br.com.acad.dao.dieta.interf.DietaEspecificaDAO;
import br.com.acad.dao.dieta.interf.DietaFixaDAO;
import br.com.acad.dao.dieta.interf.ItemRefeicaoDAO;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.model.cat.TipoTreinoDieta;
import br.com.acad.model.dieta.Alimento;
import br.com.acad.model.dieta.DiaDieta;
import br.com.acad.model.dieta.Dieta;
import br.com.acad.model.dieta.DietaEspecifica;
import br.com.acad.model.dieta.DietaFixa;
import br.com.acad.model.dieta.ItemRefeicao;
import br.com.acad.model.dieta.Refeicao;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CriacaoDietaBean implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@EJB
	private DietaFixaDAO dietaFixaDAO;
	@EJB
	private DietaEspecificaDAO dietaEspecificaDAO;
	@EJB
	private AlimentoDAO alimentoDAO;
	@EJB
	private ItemRefeicaoDAO itemRefeicaoDAO;
	
	// Inject outros beans
	@ManagedProperty(value="#{dietaFixaBean}") 
	private DietaFixaBean dietaFixaBean; 
	@ManagedProperty(value="#{dietaEspecificaBean}") 
	private DietaEspecificaBean dietaEspecificaBean; 
	@ManagedProperty(value="#{solicitacaoDietaBean}") 
	private SolicitacaoDietaBean solicitacaoDietaBean; 
	
	private Dieta dieta;
	
	private DiaDieta diaDieta;
	private List<DiaDieta> dias;
	
	private boolean showRefeicao;
	private Refeicao refeicao;
	private List<Refeicao> refeicoes;

	private boolean showItemRefeicao;
	private ItemRefeicao itemRefeicao;
	private List<ItemRefeicao> itensRefeicao;
	
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	public void init(){
		showRefeicao = false;
		showItemRefeicao = false;
		newRefeicao();
		clearAll();
	}
	
	/**
	 * Zera todas as listas e entities
	 */
	public void clearAll(){
		dias = new ArrayList<DiaDieta>();
		itensRefeicao = new ArrayList<ItemRefeicao>();
		refeicoes = new ArrayList<Refeicao>();
		diaDieta = new DiaDieta();
		refeicao = new Refeicao();
		itemRefeicao = new ItemRefeicao();
	}
	
	// Dieta
	/**
	 * Criacao de um novo dieta fixo
	 */
	public void newDietaFixa(){
		clearAll();
		dieta = dietaFixaBean.getEntity();
		dieta.setTipoDieta(TipoTreinoDieta.FIXO);
		dias = new ArrayList<DiaDieta>(dieta.getDiasDieta());
		diaDieta = new DiaDieta();
	}
	
	/**
	 * Criacao de um novo dieta especifico
	 */
	public void newDietaEspecifica(){
		clearAll();
		dieta = dietaEspecificaBean.getEntity();
		dieta.setTipoDieta(TipoTreinoDieta.ESPECIFICO);
		dias = new ArrayList<DiaDieta>(dieta.getDiasDieta());
		diaDieta = new DiaDieta();
	}

	/**
	 * Criacao de um novo dieta especifico de resposta
	 */
	public void newDietaEspecificaResposta(){
		clearAll();
		dieta = solicitacaoDietaBean.getDieta();
		dieta.setTipoDieta(TipoTreinoDieta.ESPECIFICO);
		dias = new ArrayList<DiaDieta>(dieta.getDiasDieta());
		diaDieta = new DiaDieta();
	}

	/**
	 * Salva os dias e os exercicios do dieta fixo
	 */
	public void salvarDietaFixa(){
		organizaListasDieta();
		dietaFixaBean.setEntity((DietaFixa) dieta);
		dietaFixaBean.incluirEntity();
	}

	/**
	 * Salva os dias e os exercicios do dieta especifico
	 */
	public void salvarDietaEspecifica(){
		organizaListasDieta();
		dietaEspecificaBean.setEntity((DietaEspecifica) dieta);
		dietaEspecificaBean.incluirEntity();
	}
	
	/**
	 * Salva os dias e os exercicios do dieta de resposta
	 */
	public void salvarDietaEspecificaResposta(){
		organizaListasDieta();
		solicitacaoDietaBean.setDieta((DietaEspecifica) dieta);
		solicitacaoDietaBean.incluirDietaResposta();;
	}
	
	private void organizaListasDieta(){
		dieta.resetDiasDieta();
		for(DiaDieta dia : dias){
			dieta.addDiaDieta(dia);
		}
	}
	
	// DiaDieta
	/**
	 * Abre form de um novo DiaDieta
	 */
	public void newDiaDieta(){
		diaDieta = new DiaDieta();
		showRefeicao = false;
		showItemRefeicao = false;
	}
	
	/**
	 * Inclui um DiaDieta a lista de dias
	 */
	public void incluirDiaDieta(){
		showRefeicao = false;
		showItemRefeicao = false;
		if(!dias.contains(diaDieta)){
			dias.add(diaDieta);
		}
		diaDieta = new DiaDieta();
	}
	
	/**
	 * Exclui diaDieta da lista de dias
	 */
	public void excluirDiaDieta(){
		if(diaDieta!=null && diaDieta.getNome().length()>1){
			dias.remove(diaDieta);
		}else{
			MessagesLogic.addWarnMessage("Aviso", "Selecione um dia de dieta antes de excluir");
		}
		showRefeicao = false;
		showItemRefeicao = false;
		diaDieta = new DiaDieta();
	}
	
	/**
	 * ao selecionar diaDieta da lista
	 */
	public void onSelectDiaDieta(){
		showRefeicao = true;
		showItemRefeicao = false;
		refreshRefeicao();
		newRefeicao();
	}
	
	/**
	 * ao desselecionar diaDieta da lista
	 */
	public void onUnselectDiaDieta(){
		showRefeicao = false;
		showItemRefeicao = false;
	}
	
	// Refeicao
	/**
	 * Abre form de uma nova refeicao
	 */
	public void newRefeicao(){
		refeicao = new Refeicao();
	}
	
	/**
	 * Atualiza as refeicoes ao clicar em um diaDieta
	 */
	public void refreshRefeicao(){
		refeicoes = new ArrayList<Refeicao>(diaDieta.getRefeicoes());
	}
	
	/**
	 * Inclui um Refeicao a lista de refeicoes
	 */
	public void incluirRefeicao(){
		if(refeicoes.contains(refeicao)){
			refeicoes.remove(refeicao);
			diaDieta.removeRefeicao(refeicao);
		}
		diaDieta.addRefeicao(refeicao);
		refeicoes.add(refeicao);
		newRefeicao();
	}
	
	/**
	 * Exclui Refeicao da lista de refeicoes
	 */
	public void excluirRefeicao(){
		if(refeicao!=null){
			refeicoes.remove(refeicao);
			diaDieta.removeRefeicao(refeicao);
		}else{
			MessagesLogic.addWarnMessage("Aviso", "Selecione uma refeicao antes de excluir");
		}
		newRefeicao();

	}

	/**
	 * ao selecionar refeicao da lista
	 */
	public void onSelectRefeicao(){
		showItemRefeicao = true;
		itensRefeicao = new ArrayList<ItemRefeicao>(refeicao.getItens());
	}

	/**
	 * ao selecionar refeicao da lista
	 */
	public void onUnselectRefeicao(){
		showItemRefeicao = false;
	}
	
	
	
	// ItemItemRefeicao
	
	/**
	 * Abre form de um novo ItemRefeicao
	 */
	public void newItemRefeicao(){
		itemRefeicao = new ItemRefeicao();
	}
	
	/**
	 * Atualiza as itensRefeicao ao clicar em uma refeicao
	 */
	public void refreshItemRefeicao(){
		itensRefeicao = new ArrayList<ItemRefeicao>(refeicao.getItens());
	}
	
	/**
	 * Inclui um ItemRefeicao a lista de itensRefeicao
	 */
	public void incluirItemRefeicao(){
		if(itensRefeicao.contains(itemRefeicao)){
			itensRefeicao.remove(itemRefeicao);
			refeicao.removeItem(itemRefeicao);
		}
		Alimento alimento = itemRefeicao.getAlimento();
		alimento = alimentoDAO.searchByID(alimento.getId());
		itemRefeicao.setAlimento(alimento);
		refeicao.addItem(itemRefeicao);
		itensRefeicao.add(itemRefeicao);
		newItemRefeicao();
	}
	
	/**
	 * Exclui ItemRefeicao da lista de itensRefeicao
	 */
	public void excluirItemRefeicao(){
		if(itemRefeicao!=null){
			itensRefeicao.remove(itemRefeicao);
			refeicao.removeItem(itemRefeicao);
		}else{
			MessagesLogic.addWarnMessage("Aviso", "Selecione um item antes de excluir");
		}
		newItemRefeicao();

	}

	/**
	 * ao selecionar refeicao da lista
	 */
	public void onSelectItemRefeicao(){
	}

	/**
	 * ao selecionar refeicao da lista
	 */
	public void onUnselectItemRefeicao(){
	}
	

	/************************************************************************************************************/
	//GET FIELDS
	/************************************************************************************************************/
	
	public List<Alimento> getAlimentosField(){
		return alimentoDAO.buscarTodos();
	}
	
	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	public Dieta getDieta() {
		return dieta;
	}

	public void setDieta(Dieta dieta) {
		this.dieta = dieta;
	}

	public DiaDieta getDiaDieta() {
		return diaDieta;
	}

	public void setDiaDieta(DiaDieta diaDieta) {
		this.diaDieta = diaDieta;
	}

	public Refeicao getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}

	public ItemRefeicao getItemRefeicao() {
		return itemRefeicao;
	}

	public void setItemRefeicao(ItemRefeicao itemRefeicao) {
		this.itemRefeicao = itemRefeicao;
	}

	public DietaFixaBean getDietaFixaBean() {
		return dietaFixaBean;
	}

	public DietaEspecificaBean getDietaEspecificaBean() {
		return dietaEspecificaBean;
	}

	public SolicitacaoDietaBean getSolicitacaoDietaBean() {
		return solicitacaoDietaBean;
	}

	public List<DiaDieta> getDias() {
		return dias;
	}

	public boolean getShowRefeicao() {
		return showRefeicao;
	}

	public List<Refeicao> getRefeicoes() {
		return refeicoes;
	}

	public boolean getShowItemRefeicao() {
		return showItemRefeicao;
	}

	public List<ItemRefeicao> getItensRefeicao() {
		return itensRefeicao;
	}

	public void setDietaFixaBean(DietaFixaBean dietaFixaBean) {
		this.dietaFixaBean = dietaFixaBean;
	}

	public void setDietaEspecificaBean(DietaEspecificaBean dietaEspecificaBean) {
		this.dietaEspecificaBean = dietaEspecificaBean;
	}

	public void setSolicitacaoDietaBean(SolicitacaoDietaBean solicitacaoDietaBean) {
		this.solicitacaoDietaBean = solicitacaoDietaBean;
	}
	
	

	
	
	
}
