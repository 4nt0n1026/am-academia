package br.com.acad.logic;

import java.util.Calendar;

public class PessoaLogic {

	/**
	 * Retorna a idade da pessoa passando a data de nascimento
	 * @param dataNascimento
	 * @return
	 * testeGit
	 */
	public static int getIdade(Calendar dataNascimento){
		Calendar dataAtual = Calendar.getInstance();
		
		int year1 = dataAtual.get(Calendar.YEAR);
		int year2 = dataNascimento.get(Calendar.YEAR);
		
		int age = year1 - year2;
		
		int month1 = dataAtual.get(Calendar.MONTH);
		int month2 = dataNascimento.get(Calendar.MONTH);
		
		if (month2 > month1) {
			age--;
		} else if (month1 == month2) {
			int day1 = dataAtual.get(Calendar.DAY_OF_MONTH);
			int day2 = dataNascimento.get(Calendar.DAY_OF_MONTH);
			if (day2 > day1) {
				age--;
			}
		}
		return age;
	}
	
}
