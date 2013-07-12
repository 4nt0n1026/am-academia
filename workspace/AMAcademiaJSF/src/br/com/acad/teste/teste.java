package br.com.acad.teste;

import java.util.Calendar;

import br.com.acad.logic.PessoaLogic;



public class teste {
	public static void main(String[] args) {
			Calendar dtNasc = Calendar.getInstance();
			dtNasc.set(1989, 02, 24);
			System.out.println(PessoaLogic.getIdade(dtNasc));
	}
}
