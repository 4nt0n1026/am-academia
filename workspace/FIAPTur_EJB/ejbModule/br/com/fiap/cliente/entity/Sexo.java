package br.com.fiap.cliente.entity;

public enum Sexo {

	MASCULINO("Masculino"), FEMININO("Feminino");
	
	private String label;
	
	private Sexo(String label){
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
