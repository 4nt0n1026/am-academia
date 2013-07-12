package br.com.acad.logic;

import java.util.Collection;
import java.util.List;

public class GenericLogic {

	
	/**
	 * Transforma List de String em uma String searada pelo separador passado por parametro
	 * @param lista
	 * @param separator
	 * @return
	 */
	public static String formatList(List<String> lista, String separator){
		
		StringBuilder strFormatada = new StringBuilder();
		
		for (String item : lista) {
			if(strFormatada.length()>0){
				strFormatada.append(separator);
			}
			
			strFormatada.append(item);
		}

		return strFormatada.toString();
	}
	
	/**
	 * Transforma list de Object em uma String de toString() do objeto separada pelo separador passado por parametro
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String formatListOfObjects(Collection objects, String separator){
		
		StringBuilder strFormatada = new StringBuilder();
		
		for (Object object : objects) {
			if(strFormatada.length()>0){
				strFormatada.append(separator);
			}
			
			strFormatada.append(object.toString());
		}

		return strFormatada.toString();
	}
	
	
	
}
