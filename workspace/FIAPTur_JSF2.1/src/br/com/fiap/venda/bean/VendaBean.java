package br.com.fiap.venda.bean;

import java.io.Serializable;
import java.util.List;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.cliente.dao.ClienteDAO;
import br.com.fiap.cliente.entity.Cliente;
import br.com.fiap.pacote.dao.PacoteDAO;
import br.com.fiap.pacote.entity.Pacote;

@ManagedBean
@ViewScoped
public class VendaBean implements Serializable {

	private String nomeClienteBusca;

	private List<Cliente> listaCliente;

	private String descricaoPacoteBusca;

	private List<Pacote> listaPacote;

	private Cliente clienteSelecionado;

	private List<Pacote> listaPacotesSelecionados;

	@EJB
	private ClienteDAO clienteDAO;

	@EJB
	private PacoteDAO pacoteDAO;
	
	//inicializa o cliente selecionado
	@PostConstruct
	private void init(){
		clienteSelecionado = new Cliente();
		listaPacotesSelecionados = new ArrayList<Pacote>() ;
	}

	// Evento do botão confirmar compra
	public void confirmarCompra(){
		//Se ele não selecionou os pacotes ou o cliente
		if (listaPacotesSelecionados.size() > 0 &&
				clienteSelecionado.getId() > 0){
			//Se o cliente possuir lista
			if (clienteSelecionado.getPacotes()!=null){
				clienteSelecionado.getPacotes().addAll(listaPacotesSelecionados);
			}else{
				clienteSelecionado.setPacotes(listaPacotesSelecionados);
			}
			clienteDAO.update(clienteSelecionado);
			FacesContext.getCurrentInstance().
			addMessage(null,new FacesMessage("Pacote Vendido!"));
		}else{
			//Mandar uma mensagem pro usuário
			FacesContext.getCurrentInstance().
			addMessage(null, new FacesMessage("Por favor, selecione os pacotes e cliente"));
		}
	}

	// Evento do botão buscar pacote
	public void buscarPacote() {
		listaPacote = pacoteDAO.buscarPorDescricao(descricaoPacoteBusca);
	}

	// Evento do botão buscar
	public void buscarCliente() {
		setListaCliente(clienteDAO.buscarPorNome(getNomeClienteBusca()));
	}

	public String getNomeClienteBusca() {
		return nomeClienteBusca;
	}

	public void setNomeClienteBusca(String nomeClienteBusca) {
		this.nomeClienteBusca = nomeClienteBusca;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public String getDescricaoPacoteBusca() {
		return descricaoPacoteBusca;
	}

	public void setDescricaoPacoteBusca(String descricaoPacoteBusca) {
		this.descricaoPacoteBusca = descricaoPacoteBusca;
	}

	public List<Pacote> getListaPacote() {
		return listaPacote;
	}

	public void setListaPacote(List<Pacote> listaPacote) {
		this.listaPacote = listaPacote;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public List<Pacote> getListaPacotesSelecionados() {
		return listaPacotesSelecionados;
	}

	public void setListaPacotesSelecionados(
			List<Pacote> listaPacotesSelecionados) {
		this.listaPacotesSelecionados = listaPacotesSelecionados;
	}
}
