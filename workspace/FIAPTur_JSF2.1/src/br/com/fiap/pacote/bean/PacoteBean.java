package br.com.fiap.pacote.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.pacote.dao.PacoteDAO;
import br.com.fiap.pacote.entity.Pacote;
import br.com.fiap.pacote.entity.Transporte;
import br.com.fiap.utils.BundleUtils;

@ManagedBean
@ViewScoped
public class PacoteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final String BUNDLE_PAGE = "br.com.fiap.pacote.bundle.pacoteBundle";
	private static final String SUCESS_REGISTER_MESSAGE = "sucessRegister_message";
	private static final String SUCESS_UPDATE_MESSAGE = "sucessUpdate_message";
	private static final String SUCESS_REMOVE_MESSAGE = "sucessRemove_message";
	private static final String SELECT_PACKAGE_MESSAGE = "selectPackage_message";

	private Pacote pacote;
	
	private List<Transporte> listaTransporte;
	
	private List<Pacote> listaPacote;
	
	/**
	 * Atributo que armazena a linha selecionada
	 */
	private Pacote pacoteLinhaTabela;
	
	/**
	 * Atributos para busca
	 */
	private String descricao;
	
	private Calendar dataInicio;
	
	private Calendar dataFim;
	
	@PostConstruct
	private void init(){
		pacote = new Pacote();
		setDataInicio(Calendar.getInstance());
		setDataFim(Calendar.getInstance());
	}
	
	@EJB
	private PacoteDAO pacoteDao;
	
	public void salvar(){
		if (pacote.getId() == 0){
			pacoteDao.insert(pacote);
			adicionaMensagem(SUCESS_REGISTER_MESSAGE);
		}else{
			pacoteDao.update(pacote);
			adicionaMensagem(SUCESS_UPDATE_MESSAGE);
		}
	}
	
	public void remover(){
		if (pacote == null){
			adicionaMensagem(SELECT_PACKAGE_MESSAGE);
		}else{
			listaPacote.remove(pacote);
			pacoteDao.removeById(pacote.getId());
			pacote = new Pacote();
			adicionaMensagem(SUCESS_REMOVE_MESSAGE);
		}
	}
	
	public void buscarPorDescricao(){
		listaPacote = pacoteDao.buscarPorDescricao(descricao);
	}
	
	public void buscaPorPeriodo(){
		listaPacote = pacoteDao.buscarPorPeriodo(getDataInicio(), getDataFim());
	}
	
	public void cadastrarNovo(){
		pacote = new Pacote();
	}
	
	public void alterar(){
		pacote = pacoteLinhaTabela;
	}
	
	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	public List<Transporte> getListaTransporte() {
		return listaTransporte;
	}

	public void setListaTransporte(List<Transporte> listaTransporte) {
		this.listaTransporte = listaTransporte;
	}

	public List<Pacote> getListaPacote() {
		return listaPacote;
	}

	public void setListaPacote(List<Pacote> listaPacote) {
		this.listaPacote = listaPacote;
	}
	
	private void adicionaMensagem(String key){
		String msg = BundleUtils.getMessageResourceString(BUNDLE_PAGE, key, null, FacesContext.getCurrentInstance().getViewRoot().getLocale());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}

	public Pacote getPacoteLinhaTabela() {
		return pacoteLinhaTabela;
	}

	public void setPacoteLinhaTabela(Pacote pacoteLinhaTabela) {
		this.pacoteLinhaTabela = pacoteLinhaTabela;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}
	
}
