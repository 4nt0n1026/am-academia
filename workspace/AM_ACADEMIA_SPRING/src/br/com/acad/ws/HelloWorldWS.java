package br.com.acad.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.acad.dao.avisos.interf.NoticiaDAO;

@Path("/helloworld") 
public class HelloWorldWS {
	
	@Autowired
	private NoticiaDAO dao;
	
	@GET 
	@Produces("text/plain") 
	public String showHelloWorld() {
		return "teste"; 
	}
	
}
