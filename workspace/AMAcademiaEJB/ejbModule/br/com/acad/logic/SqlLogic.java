package br.com.acad.logic;


public class SqlLogic {

	
	/**
	 * Cria clausula where da sql 
	 * @param lista
	 * @param txtSearch
	 * @return
	 */
	public static String getWhereSql(String[] lista, String txtSearch){
		
		if(txtSearch !=null && txtSearch.length()>0){
			StringBuilder fields = new StringBuilder(" where ");
			
			for (String field : lista) {
				if(fields.length()>0){
					fields.append(" or ");
				}
				fields.append(field).append("like %").append(txtSearch).append("%");
				
			}
	
			return fields.toString();
		}
		return "";
	}

	/**
	 * Transforma List de String em uma sql de busca 
	 * @param lista
	 * @param txtSearch
	 * @return
	 */
	public static String getSql(String[] lista, String modelName, String txtSearch, String order){
		
		StringBuilder sql = new StringBuilder();
		sql.append("from ").append(modelName).append(getWhereSql(lista, txtSearch));
		
		if(order != null && order.length()>0){
			sql.append(" order by ").append(order);
		}
		
		return sql.toString();
	}
	
	
	
	
	
}
