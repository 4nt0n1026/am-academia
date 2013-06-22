package br.com.fiap.relatorio.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean
@ViewScoped
public class RelatorioLinhaBean implements Serializable{
	
	private CartesianChartModel estatisticaLinha;

	@PostConstruct
	private void init(){
		estatisticaLinha = new CartesianChartModel();
		
		ChartSeries natal = new ChartSeries();
		natal.setLabel("Natal");
		natal.set("2010", 1100);
		natal.set("2011", 100);
		natal.set("2012", 2000);
		natal.set("2013", 10);
		
		ChartSeries rio = new ChartSeries();
		rio.setLabel("Rio de Janeiro");
		rio.set("2010", 3000);
		rio.set("2011", 1000);
		rio.set("2012", 4000);
		rio.set("2013", 500);
		
		estatisticaLinha.addSeries(rio);
		estatisticaLinha.addSeries(natal);
	}
		
	

	public CartesianChartModel getEstatisticaLinha() {
		return estatisticaLinha;
	}

	public void setEstatisticaLinha(CartesianChartModel estatisticaLinha) {
		this.estatisticaLinha = estatisticaLinha;
	}
}
