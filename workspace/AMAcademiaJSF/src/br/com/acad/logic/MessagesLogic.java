package br.com.acad.logic;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 * @author Christian Storch
 * Classe de logicas para mensagens growl
 */
public class MessagesLogic {

	
	/**
	 * adciona msg de info
	 * @param headerMsg
	 * @param msg
	 */
	public static void addInfoMessage(String headerMsg, String msg){
		FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,headerMsg, msg));
	}
	
	/**
	 * adciona msg de warn
	 * @param headerMsg
	 * @param msg
	 */
	public static void addWarnMessage(String headerMsg, String msg){
		FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,headerMsg, msg));
	}
	
	
	
	
}
