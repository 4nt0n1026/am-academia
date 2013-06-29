package br.com.nac.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.nac.dao.AutorDAO;
import br.com.nac.model.Autor;
import br.com.nac.model.Sexo;

@ManagedBean
@ViewScoped
public class AutorBean implements Serializable {

	@EJB
	private AutorDAO autorDAO;
	
	private Autor autor;
	
	private List<Autor> autores;
	
	private boolean isIncluir;
	
	@PostConstruct
	private void init(){
		autor = new Autor();
		autor.setDataNascimento(Calendar.getInstance());
		autores = autorDAO.buscarTodos();
		isIncluir=false;
	}
	
	public void atualiza(){
		autores = autorDAO.buscarTodos();
	}
	
	public void inclui(){
		autor = autorDAO.inclui(autor);
		System.out.println(autor.getId());
		autores.add(autor);
		FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Sucesso", "Autor cadastrado com sucesso")); 
        autor = new Autor();
        isIncluir=false;
	}
	
	public Sexo[] getSexos(){
		return Sexo.values();
	}
	
	public void remove(){
		FacesContext context = FacesContext.getCurrentInstance();  
		
			
		try{
			autorDAO.excluiPorId(autor.getId());
			autores.remove(autor);
			
			context.addMessage(null, new FacesMessage("Sucesso", "Autor excluido com sucesso")); 
	        autor = new Autor();
		}catch(NullPointerException e){
			context.addMessage(null, new FacesMessage("Erro", "Selecione um autor para excluir")); 
		}
	}
	
	public void ativaInclusao(){
		isIncluir=true;
		autor=new Autor();
		autor.setDataNascimento(Calendar.getInstance());
	}
	
	public void desativarInclusao(){
		System.out.println("desativando");
		isIncluir=false;
	}
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public boolean getIsIncluir() {
		return isIncluir;
	}

	public void setIsIncluir(boolean isIncluir) {
		this.isIncluir = isIncluir;
	}

	
	
	
	
	
	
	
}
