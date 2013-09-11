package br.com.acad.logic;

import java.util.Map;


/**
 * @author Christian Storch
 *
 */
public class SqlLogic {

	
	/**
	 * tamanho padrao de todas as tabelas dos xhtml
	 */
	public static int TABLE_SIZE = 20;
	
	/**
	 * Cria clausula where da sql com search basico
	 * @param lista
	 * @param txtSearch
	 * @return
	 */
	public static String getWhereSql(String[] lista, String txtSearch){
		
		if(txtSearch !=null && txtSearch.length()>0){
			StringBuilder fields = new StringBuilder(" where (");
			
			for (String field : lista) {
				if(fields.length()>8){
					fields.append(" or ");
				}
				fields.append("lower(").append(field).append(") like '%").append(txtSearch.toLowerCase()).append("%'");
			}
			fields.append(")");
	
			return fields.toString();
		}
		return "";
	}

	/**
	 * gera String de sql com uma lista de atributos e um search
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
	 * gera String de sql para count com uma lista de atributos e um search
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
	
	/**
	 * gera String de sql para filtrar resultados
	 * @param filtros
	 * @param modelName
	 * @param order
	 * @return
	 */
	public static String getFilterSql(Map<String, String> filtros, String modelName, String order){
		StringBuilder sql = new StringBuilder("from ");
		sql.append(modelName);
		String where = getCountFilterSql(filtros);
		sql.append(where.toString());
		return sql.toString();
	}

	/**
	 * Cria clausula where da sql com search basico
	 * @param filtros
	 * @return
	 */
	private static String getCountFilterSql(Map<String, String> filtros) {
		StringBuilder where = new StringBuilder(" where ");
		for (String column : filtros.keySet()) {
			String filtro = filtros.get(column);
			if(where.length()>6){
				where.append(" and ");
			}
			where.append(column).append(" = ").append(filtro);
		}
		return where.toString();
	}
	
	/**
	 * gera String de sql para count com uma lista de atributos e um filtro
	 * @param lista
	 * @param modelName
	 * @param search
	 * @return
	 */
	public static String getCountFilterSql(String modelName, Map<String, String> filtros){
		StringBuilder sql = new StringBuilder();
		sql.append("select count(id) from ").append(modelName).append(getCountFilterSql(filtros));
		
		System.out.println(sql.toString());
		return sql.toString();
	}
	
	
}
