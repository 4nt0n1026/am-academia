package br.com.acad.teste;

import br.com.acad.model.dieta.UnidadeMedida;



public class teste {
	public static void main(String[] args) {
			UnidadeMedida u = new UnidadeMedida();
			UnidadeMedida u2 = u;
			u2.setNome("nome da 2");
			System.out.println(u.getNome());
	}
}
