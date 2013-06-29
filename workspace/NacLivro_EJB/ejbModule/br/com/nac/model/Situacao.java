package br.com.nac.model;

public enum Situacao {
	DISPONIVEL("Disponivel"), ALUGADO("Alugado");
	
	private String label;
	
	private Situacao(String label){
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	
}
