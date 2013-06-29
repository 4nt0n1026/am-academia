package br.com.nac.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.nac.dao.AutorDAO;
import br.com.nac.dao.EditoraDAO;
import br.com.nac.dao.ExemplarDAO;
import br.com.nac.dao.LivroDAO;
import br.com.nac.model.Autor;
import br.com.nac.model.Editora;
import br.com.nac.model.Exemplar;
import br.com.nac.model.Livro;
import br.com.nac.model.Situacao;

@ManagedBean
@ViewScoped
public class LivroBean implements Serializable {

	@EJB
	private LivroDAO livroDAO;
	
	@EJB
	private AutorDAO autorDAO;
	
	@EJB
	private EditoraDAO editoraDAO;
	
	@EJB
	private ExemplarDAO exemplarDAO;
	
	private Livro livro;
	private List<Livro> livros;
	
	private List<Autor> detalheAutores;
	private List<String> idAutoresSelecionados;
	
	private List<Exemplar> detalheExemplares;
	private int detalheTotalExemplares;
	private Exemplar exemplar;

	private boolean isIncluir;
	
	private boolean showAutores;
	
	@PostConstruct
	private void init(){
		livros = livroDAO.buscaTodos();
		detalheTotalExemplares=0;
		isIncluir=false;
		showAutores=false;
	}
	
	public void atualiza(){
		//busca todos os livros atualizados
		livros = livroDAO.buscaTodos();
		//fecha as abas de autores e de incluisao
		showAutores=false;
		isIncluir=false;
	}
	
	public void inclui(){
		//pega lista de ids e coloca em lista de autores para o livro
		List<Autor> autores = new ArrayList<Autor>();
		for(String id : idAutoresSelecionados){
			Autor autor = autorDAO.buscaPorId(Integer.parseInt(id));
			autores.add(autor);
		}
		livro.setAutores(autores);
		//inclui o livro
		livroDAO.inclui(livro);	
		//adciona o livro na lista da tabela
		livros.add(livro);
		 //atualiza o nome da editora para mostrar na tabela
        livro.setEditora(editoraDAO.buscaPorId(livro.getEditora().getId()));
		//joga msg de confimação na tela
		FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Sucesso", "Livro cadastrado com sucesso")); 
        //esconde o formulario de incluir
        isIncluir=false;
        showAutores=false;
	}
	
	public void incluiExemplar(){
		//cria um novo exemplar com a data de hj e a situação disponivel
		exemplar = new Exemplar();
		exemplar.setDtAquisicao(Calendar.getInstance());
		exemplar.setSituacao(Situacao.DISPONIVEL);
		exemplar.setLivro(livro);
		exemplar = exemplarDAO.inclui(exemplar);
		detalheExemplares.add(exemplar);
		//soma total de exemplares do livro
		detalheTotalExemplares += 1;
	}
	
	public void ativarAutores(){
		//abre aba de autores 
		showAutores=true;
		//busca todos os autores do livro selecionado
		detalheAutores = autorDAO.buscarTodosPorLivro(livro);
		//busca exemplares
		detalheExemplares = exemplarDAO.buscarPorLivro(livro);
		//total de exemplares do livro
		detalheTotalExemplares = detalheExemplares.size();
	}
	
	public void remove(){
		FacesContext context = FacesContext.getCurrentInstance();  
		try{
			livroDAO.excluiPorId(livro.getIsbn());
			livros.remove(livro);
			showAutores=false;
			context.addMessage(null, new FacesMessage("Sucesso", "Livro excluido com sucesso")); 
	    
		}catch(NullPointerException e){
			context.addMessage(null, new FacesMessage("Erro", "Selecione um livro para excluir")); 
		}
	}
	
	public void removeExemplar(){
		FacesContext context = FacesContext.getCurrentInstance();
		if(exemplar.getSituacao()==Situacao.ALUGADO){
			context.addMessage(null, new FacesMessage("Erro", "Não é possivel excluir um exemplar alugado")); 
		}else{
			exemplarDAO.excluiPorId(exemplar.getId());
			detalheExemplares.remove(exemplar);
			detalheTotalExemplares -= 1;  
			context.addMessage(null, new FacesMessage("Sucesso", "Exemplar excluido com sucesso")); 
		}
	}
	
	public List<Editora> todasEditoras() {
		return editoraDAO.buscarTodos();
	}
	
	public List<Autor> todosAutores() {
		return autorDAO.buscarTodos();
	}
	
	public void ativaInclusao(){
		isIncluir=true;
		showAutores=false;
		livro=new Livro();
		livro.setEditora(new Editora());
		idAutoresSelecionados = new ArrayList<String>();
		livro.setDataLancamento(Calendar.getInstance());
	}
	
	
	public void desativarInclusao(){
		//fecha aba de inclusao
		isIncluir=false;
	}
	
	public int getDetalheTotalExemplares() {
		return detalheTotalExemplares;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public void setIncluir(boolean isIncluir) {
		this.isIncluir = isIncluir;
	}

	public boolean getIsIncluir() {
		return isIncluir;
	}

	public void setIsIncluir(boolean isIncluir) {
		this.isIncluir = isIncluir;
	}

	public List<String> getIdAutoresSelecionados() {
		return idAutoresSelecionados;
	}

	public void setIdAutoresSelecionados(List<String> idAutoresSelecionados) {
		this.idAutoresSelecionados = idAutoresSelecionados;
	}

	public List<Autor> getDetalheAutores() {
		return detalheAutores;
	}

	public void setDetalheAutores(List<Autor> detalheAutores) {
		this.detalheAutores = detalheAutores;
	}

	public boolean getShowAutores() {
		return showAutores;
	}

	public List<Exemplar> getDetalheExemplares() {
		return detalheExemplares;
	}

	public Exemplar getExemplar() {
		return exemplar;
	}

	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}


	
	

	


	
	
	
	
	
	
	
	
}
