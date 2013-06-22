package br.com.fiap.index.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.pacote.entity.Pacote;
import br.com.fiap.timer.PacoteDestaqueTimer;

@ManagedBean
@RequestScoped
public class IndexBean implements Serializable {

	@EJB
	private PacoteDestaqueTimer pacoteTimer;
	
	public Pacote getPacoteDestaque(){
		return pacoteTimer.getPacoteDestaque();
	}
}
