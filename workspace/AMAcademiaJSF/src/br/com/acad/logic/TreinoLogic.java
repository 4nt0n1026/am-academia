package br.com.acad.logic;

import java.util.List;

import br.com.acad.model.treino.DiaTreino;
import br.com.acad.model.treino.ExercicioTreino;
import br.com.acad.model.treino.Serie;
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
	 * Ordena as series pela posicao da repeticao
	 * @return
	 */
	public List<Serie> ordenarSeries(){
		//TODO
		return null;
	}
	
}
