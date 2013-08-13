package br.com.acad.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.com.acad.model.treino.DiaTreino;
import br.com.acad.model.treino.ExercicioTreino;
import br.com.acad.model.treino.Treino;

public class TreinoLogic {

	
	/**
	 * Gera um texto com o treino selecionado para apresentar na tela
	 * @param treino
	 * @return
	 */
	public static String getTreinoString(Treino treino){
		StringBuilder strTreino = new StringBuilder();
		
		for(DiaTreino dia : treino.getDiasTreino()){
			strTreino.append(dia.getNome()).append("<br />");
			
			for(ExercicioTreino exercicio : dia.getExerciciosTreino()){
				strTreino.append(" - ").append(exercicio.getExercicio().getNome()).append("  ")
				.append(GenericLogic.formatListOfObjects(exercicio.getSeries(), "/")).append("<br/>");
			}
		}
		return strTreino.toString();
	}
	
	
	/**
	 * Transforma um set de diaTreino em uma lista ordenada pela sua ordem
	 * @param dias
	 * @return
	 */
	public static List<DiaTreino> setToList(Set<DiaTreino> dias){
		List<DiaTreino> diasList = new ArrayList<DiaTreino>();
		for(int i = 0; i<dias.size(); i++){
			diasList.add(null);
		}
		for (DiaTreino diaTreino : dias) {
			diasList.set(diaTreino.getOrdem(), diaTreino);
		}
		return diasList;
	}
}
