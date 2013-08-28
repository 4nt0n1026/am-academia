package br.com.acad.filter;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class LoginPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		FacesContext context =  event.getFacesContext();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		NavigationHandler navigation =  context.getApplication().getNavigationHandler();
		
		String paginaOrigem = context.getViewRoot().getViewId();
		
		if(paginaOrigem.contains("login") || paginaOrigem.contains("populaBanco") || paginaOrigem.contains("mHome")){
			return;
		}
		
		// Valida a sessap do usuario
		if(session != null && session.getAttribute("usuario") != null){
			return;
		}else{
			navigation.handleNavigation(context, null, "login");
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}
	
	
	
	
}
