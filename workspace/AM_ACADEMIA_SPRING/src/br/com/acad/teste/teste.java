package br.com.acad.teste;

import br.com.acad.model.treino.ParteCorpo;


public class teste {
	public static void main(String[] args) {
		ParteCorpo parte = new ParteCorpo();
		String className = parte.getClass().getSimpleName();
		System.out.println(className);
	}
}
