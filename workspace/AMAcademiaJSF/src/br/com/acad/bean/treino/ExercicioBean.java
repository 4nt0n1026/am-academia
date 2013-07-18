package br.com.acad.bean.treino;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.acad.bean.Bean;
import br.com.acad.dao.treino.interf.ExercicioDAO;
import br.com.acad.dao.treino.interf.ParteCorpoDAO;
import br.com.acad.logic.GenericLogic;
import br.com.acad.logic.ParteCorpoLogic;
import br.com.acad.model.treino.Exercicio;
import br.com.acad.model.treino.ParteCorpo;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ExercicioBean extends Bean<Exercicio> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@EJB
	private ExercicioDAO exercicioDAO;
	@EJB
	private ParteCorpoDAO parteCorpoDAO;
	
	private List<String> idsParteCorpoPrimaria;
	private List<String> idsParteCorpoSecundaria;
	
	private String fotoExercicio;
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		page = 1;
		dao = exercicioDAO;
		staticFields = Exercicio.STATIC_FIELDS;
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
	 * Sobe foto
	 * @param event
	 */
	public void sobeFoto(FileUploadEvent event){
		try {
			entity.setFoto(IOUtils.toByteArray(event.getFile().getInputstream()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// TODO - sobe foto e armazena na aplicação
	/**
	 * sobe foto de upload de Exercicio
	 * @param event
	 */
	public void handleFileUpload(FileUploadEvent event) {
		
		try {
			File targetFolder = new File("/home/christian/");
			InputStream inputStream = event.getFile().getInputstream();
			OutputStream out = new FileOutputStream(new File(targetFolder, event.getFile().getFileName()));
			int read = 0;
			byte[] bytes = new byte[1024];
			 
			while ((read = inputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			inputStream.close();
			out.flush();
			out.close();
			entity.setFotoLocal("/images/" + event.getFile().getFileName());
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	/**
	 * transforma a for em StreamedContent
	 * @return
	 */
	public StreamedContent getFoto() {
		FacesContext context = FacesContext.getCurrentInstance();
		 if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
		        // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
		        return new DefaultStreamedContent();
		    }
		    else {
				DefaultStreamedContent content = new DefaultStreamedContent();
				content.setContentType("image/jpg");
				try{
					if (context.getRenderResponse() || entity.getFoto()==null){
						content.setStream(context.getExternalContext().getResourceAsStream("/resources/images/semFoto.jpg"));
					}else{
						content.setStream(new ByteArrayInputStream(entity.getFoto()));
					}
					return content;
				}catch(Exception e){
				}
		    }
		return null;
	}
	
	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
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

	public String getFotoExercicio() {
		return fotoExercicio;
	}

	public void setFotoExercicio(String fotoExercicio) {
		this.fotoExercicio = fotoExercicio;
	}

	
	
	

	
	
	
	
	
}
