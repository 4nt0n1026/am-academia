package br.com.acad.bean.treino;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.treino.interf.ExercicioDAO;
import br.com.acad.dao.treino.interf.ParteCorpoDAO;
import br.com.acad.logic.GenericLogic;
import br.com.acad.logic.ParteCorpoLogic;
import br.com.acad.logic.PathLogic;
import br.com.acad.model.treino.Exercicio;
import br.com.acad.model.treino.ParteCorpo;


@SuppressWarnings("serial")
@Component
@Scope(value="view")
public class ExercicioBean extends Bean<Exercicio> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@Autowired
	private ExercicioDAO exercicioDAO;
	@Autowired
	private ParteCorpoDAO parteCorpoDAO;
	
	private List<String> idsParteCorpoPrimaria;
	private List<String> idsParteCorpoSecundaria;
	
	private String fotoExercicio = new String();
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		page = 1;
		dao = exercicioDAO;
		staticFields = Exercicio.STATIC_FIELDS;
		order = staticFields[0];
		atualizar();
	}
	
	/**
	 * show form de entity
	 */
	@Override
	public void showNewEntity() {
		showForm1();
		entity = new Exercicio();
		idsParteCorpoPrimaria = new ArrayList<String>();
		idsParteCorpoSecundaria = new ArrayList<String>();
	}
	
	/**
	 * show form de edit buscando as partes de corpo
	 */
	@Override
	public void showEditEntity() {
		idsParteCorpoPrimaria = ParteCorpoLogic.getIds(entity.getParteCorpoPrimaria(parteCorpoDAO));
		idsParteCorpoSecundaria = ParteCorpoLogic.getIds(entity.getParteCorpoSecundaria(parteCorpoDAO));
		super.showEditEntity();
	}

	/**
	 * inclui ou edita entity no banco
	 */
	@Override
	public void incluirEntity() {
		// Apaga as listas de parte corpo para edicao (nao afeta inclusao)
		entity.zeraPartesCorpos();;
		
		// Transforma os ids de parte de corpo em List de Parte Corpo
		for(String id : idsParteCorpoPrimaria){
			entity.addParteCorpoPrimaria(new ParteCorpo(Integer.parseInt(id)));
		}
		for(String id : idsParteCorpoSecundaria){
			entity.addParteCorpoSecundaria(new ParteCorpo(Integer.parseInt(id)));
		}
		
		incluirGeneric( entity!=null? entity.getId():0);
	}

	/**
	 * deleta entity do banco
	 */
	@Override
	public void deletarEntity() {
		deletarGeneric(entity!=null?entity.getId():0);
	}
	
	
	/**
	 * sobe foto de upload de Exercicio
	 * @param event
	 */
	public void sobeFoto(FileUploadEvent event){
		
		fotoExercicio = event.getFile().getFileName(); // pego o nome do arquivo  
         
        String caminho = FacesContext.getCurrentInstance().getExternalContext()  
                .getRealPath(PathLogic.PATH_EXERCICIOS + fotoExercicio ); // diretorio o qual vou salvar o arquivo do upload, equivale ao nome completamente qualificado  

        byte[] conteudo = event.getFile().getContents();  // daqui pra baixo é somente operações de IO.  
        FileOutputStream fos;
		try {
			fos = new FileOutputStream(caminho);
			fos.write(conteudo);  
			fos.close();  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		entity.setFotoLocal(fotoExercicio);
		
	}
	
	
	
	/************************************************************************************************************/
	//GET FIELDS
	/************************************************************************************************************/
	/**
	 * preenche field de partesCorpo
	 * @return
	 */
	public List<ParteCorpo> getPartesCorposField() {
		return parteCorpoDAO.buscarTodos();
	}
	
	/**
	 * Faz busca e formata String de partes de corpo primaria do exercicio selecionado para mostrar detalhes
	 * @return
	 */
	public String getPartesCorpoPrimDetail() {
		return GenericLogic.formatListOfObjects(entity.getParteCorpoPrimaria(parteCorpoDAO), ", ");
	}

	/**
	 * Faz busca e formata String de partes de corpo secundaria do exercicio selecionado para mostrar detalhes
	 * @return
	 */
	public String getPartesCorpoSecDetail() {
		return GenericLogic.formatListOfObjects(entity.getParteCorpoSecundaria(parteCorpoDAO), ", ");
	}

	
	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	public String getFotoExercicio() {
		fotoExercicio = entity.getFotoLocal();
		if(fotoExercicio!=null && fotoExercicio.length()>1){
			return "/" + PathLogic.PATH_EXERCICIOS + fotoExercicio;
		}
		return "/" + PathLogic.PATH_EXERCICIOS + "semFoto.jpg";
	}
	
	public List<String> getIdsParteCorpoPrimaria() {
		return idsParteCorpoPrimaria;
	}

	public List<String> getIdsParteCorpoSecundaria() {
		return idsParteCorpoSecundaria;
	}

	public void setIdsParteCorpoPrimaria(List<String> idsParteCorpoPrimaria) {
		this.idsParteCorpoPrimaria = idsParteCorpoPrimaria;
	}

	public void setIdsParteCorpoSecundaria(List<String> idsParteCorpoSecundaria) {
		this.idsParteCorpoSecundaria = idsParteCorpoSecundaria;
	}

	public void setFotoExercicio(String fotoExercicio) {
		this.fotoExercicio = fotoExercicio;
	}

	
	
}
