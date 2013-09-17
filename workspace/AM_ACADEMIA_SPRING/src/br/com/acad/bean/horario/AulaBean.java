package br.com.acad.bean.horario;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.acad.bean.Bean;
import br.com.acad.dao.horario.interf.AulaDAO;
import br.com.acad.logic.PathLogic;
import br.com.acad.model.horario.Aula;


@SuppressWarnings("serial")
@Component
@Scope(value="view")
public class AulaBean extends Bean<Aula> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@Autowired
	private AulaDAO aulaDAO;
	
	private String fotoAula = new String();
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		dao = aulaDAO;
		super.init();
	}
	
	/**
	 * show form de entity
	 */
	@Override
	public void showNewEntity() {
		showEntity = true;
		entity = new Aula();
	}
	

	/**
	 * sobe foto de upload de Aula
	 * @param event
	 */
	public void sobeFoto(FileUploadEvent event){
		
		fotoAula = event.getFile().getFileName(); // pego o nome do arquivo  
         
        String caminho = FacesContext.getCurrentInstance().getExternalContext()  
                .getRealPath(PathLogic.PATH_AULAS + fotoAula ); // diretorio o qual vou salvar o arquivo do upload, equivale ao nome completamente qualificado  

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
		
		entity.setFotoLocal(fotoAula);
		
	}
	
	
	
	/************************************************************************************************************/
	//GET FIELDS
	/************************************************************************************************************/
	
	

	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	public String getFotoAula() {
		if(entity.getFotoLocal()!=null){
			fotoAula = entity.getFotoLocal();
			if(fotoAula!=null && fotoAula.length()>1){
				return "/" + PathLogic.PATH_AULAS + fotoAula;
			}
			return "/" + PathLogic.PATH_AULAS + "semFoto.jpg";
		}else{
			return "/" + PathLogic.PATH_AULAS + "semFoto.jpg";
		}

	}

	public void setFotoAula(String fotoAula) {
		this.fotoAula = fotoAula;
	}
	
	
}
