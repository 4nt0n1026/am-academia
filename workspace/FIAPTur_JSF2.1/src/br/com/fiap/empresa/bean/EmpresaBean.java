package br.com.fiap.empresa.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
@ViewScoped
public class EmpresaBean implements Serializable{

	private MapModel marcacoes;

	public MapModel getMarcacoes() {
		marcacoes = new DefaultMapModel();
		
		LatLng coord1 = new LatLng(-23.581707167350665, -46.63844347000122);
		LatLng coord2 = new LatLng(-23.581530175457033, -46.64949417114258);
		
		marcacoes.addOverlay(new Marker(coord1,"Agencia A"));
		marcacoes.addOverlay(new Marker(coord2,"Agencia B"));
		return marcacoes;
	}

	public void setMarcacoes(MapModel marcacoes) {
		this.marcacoes = marcacoes;
	}
	
}
