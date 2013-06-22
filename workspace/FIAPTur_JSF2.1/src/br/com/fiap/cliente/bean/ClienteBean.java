package br.com.fiap.cliente.bean;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.fiap.cliente.dao.ClienteDAO;
import br.com.fiap.cliente.entity.Cliente;
import br.com.fiap.cliente.entity.Endereco;
import br.com.fiap.utils.BundleUtils;

@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static final String BUNDLE_PAGE = "br.com.fiap.cliente.bundle.clienteBundle";
	private static final String SUCESS_REGISTER_MESSAGE = "sucessRegister_message";
	private static final String SUCESS_UPDATE_MESSAGE = "sucessUpdate_message";
	private static final String SUCESS_REMOVE_MESSAGE = "sucessRemove_message";
	private static final String SELECT_CLIENT_MESSAGE = "selectClient_message";

	@EJB
	private ClienteDAO clienteDAO;

	private Cliente cliente;
	
	private Cliente clienteLinhaTabela;
	
	private List<Cliente> listaCliente;
	
	private String nomeBusca;
	
	private StreamedContent foto;
	
	@PostConstruct
	private void init(){
		cliente = new Cliente();
		cliente.setEndereco(new Endereco());
	}
	
	public void sobeFoto(FileUploadEvent event){
		try {
			cliente.setFoto(IOUtils.toByteArray(event.getFile().getInputstream()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<String> 
					completaNomeCliente(String nome){
		return clienteDAO.buscarPorNomeCliente(nome);
	}

	public void salvar(){
		if (cliente.getId() == 0){
			clienteDAO.insert(cliente);
			adicionaMensagem(SUCESS_REGISTER_MESSAGE);
		}else{
			clienteDAO.update(cliente);
			adicionaMensagem(SUCESS_UPDATE_MESSAGE);
		}
	}
	
	public void remover(){
		if (cliente == null){
			adicionaMensagem(SELECT_CLIENT_MESSAGE);
		}else{
			listaCliente.remove(cliente);
			clienteDAO.removeById(cliente.getId());
			cliente = new Cliente();
			adicionaMensagem(SUCESS_REMOVE_MESSAGE);
		}
	}
	
	public void alterar(){
		cliente = clienteLinhaTabela;
	}
	
	public void cadastrarNovo(){
		cliente = new Cliente();
		cliente.setEndereco(new Endereco());
	}
	
	public void buscar(){
		listaCliente = clienteDAO.buscarPorNome(getNomeBusca());
	}
	
	private void adicionaMensagem(String key){
		String msg = BundleUtils.getMessageResourceString(BUNDLE_PAGE, key, null, FacesContext.getCurrentInstance().getViewRoot().getLocale());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public String getNomeBusca() {
		return nomeBusca;
	}

	public void setNomeBusca(String nomeBusca) {
		this.nomeBusca = nomeBusca;
	}

	public Cliente getClienteLinhaTabela() {
		return clienteLinhaTabela;
	}

	public void setClienteLinhaTabela(Cliente clienteLinhaTabela) {
		this.clienteLinhaTabela = clienteLinhaTabela;
	}

	public StreamedContent getFoto() {
		FacesContext context = 
				FacesContext.getCurrentInstance();
		DefaultStreamedContent content = 
				new DefaultStreamedContent();
		content.setContentType("image/jpg");
		try{
			if (context.getRenderResponse() || 
					cliente.getFoto()==null){
				content.setStream(context.getExternalContext().getResourceAsStream("/resources/img/semFoto.jpg"));
			}else{
				content.setStream(new ByteArrayInputStream(cliente.getFoto()));
			}
		}catch(Exception e){}
		return content;
	}

	public void setFoto(StreamedContent foto) {
		this.foto = foto;
	}

}
