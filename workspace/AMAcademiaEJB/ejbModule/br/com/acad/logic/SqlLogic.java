package br.com.acad.logic;


public class SqlLogic {

	
	/**
	 * tamanho padrao de todas as tabelas dos xhtml
	 */
	public static int TABLE_SIZE = 4;
	
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
				if(fields.length()>8){
					fields.append(" or ");
				}
				fields.append(field).append(" like '%").append(txtSearch).append("%'");
				
			}
	
			return fields.toString();
		}
		return "";
	}

	/**
	 * gera String de sql com uma lista de atributos e um filtro
	 * @param lista
	 * @param search
	 * @return
	 */
	public static String getSql(String[] lista, String modelName, String search, String order){
		
		StringBuilder sql = new StringBuilder();
		sql.append("from ").append(modelName).append(getWhereSql(lista, search));
		
		if(order != null && order.length()>0){
			sql.append(" order by ").append(order);
		}
		
		System.out.println(sql.toString());
		return sql.toString();
	}
	
	/**
	 * gera String de sql para count com uma lista de atributos e um filtro
	 * @param lista
	 * @param modelName
	 * @param search
	 * @return
	 */
	public static String getCountSql(String[] lista, String modelName, String search){
		StringBuilder sql = new StringBuilder();
		sql.append("select count(id) from ").append(modelName).append(getWhereSql(lista, search));
		
		System.out.println(sql.toString());
		return sql.toString();
	}
	
	
	
	
	
}
