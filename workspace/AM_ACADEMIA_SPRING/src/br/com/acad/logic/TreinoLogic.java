package br.com.acad.logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		
		for(DiaTreino dia : setToList(treino.getDiasTreino())){
			strTreino.append("<h3>" + dia.getNome() + "</h3>");
			
			for(ExercicioTreino exercicio : dia.getExerciciosTreino()){
				strTreino.append(" - ").append(exercicio.getExercicio().getNome()).append("  ")
				.append(GenericLogic.formatListOfObjects(setToListSerie(exercicio.getSeries()), "/")).append("<br/>");
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
	
	/**
	 * Transforma um list de diaTreino em um set guardando a ordem
	 * @param dias
	 * @return
	 */
	public static Set<DiaTreino> listToSet(List<DiaTreino> dias){
		Set<DiaTreino> diasSet = new HashSet<DiaTreino>();
		for(DiaTreino dia : dias){
			dia.setOrdem(dias.indexOf(dia));
			diasSet.add(dia);
		}
		return diasSet;
	}
	
	/**
	 * Transforma um set de serie em uma lista ordenada pela sua ordem
	 * @param series
	 * @return
	 */
	public static List<Serie> setToListSerie(Set<Serie> series){
		List<Serie> seriesList = new ArrayList<Serie>();
		for(int i = 0; i<series.size(); i++){
			seriesList.add(null);
		}
		for (Serie serie : series) {
			seriesList.set(serie.getOrdem(), serie);
		}
		return seriesList;
	}
	
	/**
	 * Transforma um list de serie em um set guardando a ordem
	 * @param series
	 * @return
	 */
	public static Set<Serie> listToSetSerie(List<Serie> series){
		Set<Serie> seriesList = new HashSet<Serie>();
		for(Serie serie : series){
			serie.setOrdem(series.indexOf(serie));
			seriesList.add(serie);
		}
		return seriesList;
	}
}
