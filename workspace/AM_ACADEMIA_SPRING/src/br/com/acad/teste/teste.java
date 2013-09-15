package br.com.acad.teste;

import br.com.acad.logic.AnnotationsLogic;


public class teste {
	
	public static void main(String[] args) {
		
		String[] values = null;
		
		values = AnnotationsLogic.getViewValueFields(ClassTeste.class);
	
		if(values!=null){
			for (String string : values) {
				System.out.println(string);
			}
		}
		
	}

}
