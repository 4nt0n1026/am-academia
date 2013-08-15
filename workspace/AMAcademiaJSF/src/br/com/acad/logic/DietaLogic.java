package br.com.acad.logic;

import java.util.List;

import br.com.acad.model.dieta.DiaDieta;
import br.com.acad.model.dieta.Dieta;
import br.com.acad.model.dieta.ItemRefeicao;
import br.com.acad.model.dieta.Refeicao;

public class DietaLogic {

	
	/**
	 * Gera um texto com a dieta selecionada para apresentar na tela
	 * @param dieta
	 * @return
	 */
	public static String getDietaString(Dieta dieta){
		StringBuilder strDieta = new StringBuilder();
		
		for(DiaDieta dia : dieta.getDiasDieta()){
			strDieta.append("<h3>" + dia.getNome() + "</h3>");
			
			for(Refeicao refeicao : dia.getRefeicoes()){
				strDieta.append("<h4>" + refeicao.getNome() + "</h4>").append(" --- ")
				.append(GenericLogic.formatListOfObjects(refeicao.getItens(), "<br /> --- ")).append("<br />");
			}
		}
		return strDieta.toString();
	}
	
	
	
	/**
	 * Ordena os itens refeicao pela posicao da repeticao
	 * @return
	 */
	public List<ItemRefeicao> ordenarItemRefeicao(){
		//TODO
		return null;
	}
	
}
