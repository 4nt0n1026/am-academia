package br.com.fiap.relatorio.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

@ManagedBean
@ViewScoped
public class RelatorioPizzaBean implements Serializable{
	
	private PieChartModel estatisticaPizza;

	@PostConstruct
	private void init(){
		estatisticaPizza = new PieChartModel();
		estatisticaPizza.set("Natal", 200);
		estatisticaPizza.set("Rio de Janeiro",300);
		estatisticaPizza.set("Salvador", 100);
	}
	
	public PieChartModel getEstatisticaPizza() {
		return estatisticaPizza;
	}

	public void setEstatisticaPizza(PieChartModel estatisticaPizza) {
		this.estatisticaPizza = estatisticaPizza;
	}
}
