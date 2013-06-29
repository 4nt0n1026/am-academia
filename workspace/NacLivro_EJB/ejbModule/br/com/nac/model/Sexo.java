package br.com.nac.model;

public enum Sexo {
	MASCULINO("Masculino"), FEMININO("Feminino");
	
	public String label;
	
	private Sexo(String label){
		this.label=label;
	}
	
	public String getLabel(){
		return label;
	}
}
