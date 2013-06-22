package br.com.fiap.utils.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@ApplicationScoped	
public class ImageBean {

	private static final String PATH_IMAGES = "C:\\temp\\";

	public StreamedContent getImage(){
		FacesContext context = FacesContext.getCurrentInstance();
		DefaultStreamedContent content = new DefaultStreamedContent();
		content.setContentType("image/jpg");
		String nome = context.getExternalContext().getRequestParameterMap().get("name");
		if (context.getRenderResponse() || nome == null) {
			return content;
		} else {
			try {
				
				content.setStream(new FileInputStream(PATH_IMAGES + nome));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return content;
		}
	}
}
