package br.com.acad.spring;

import java.sql.Types;

import org.hibernate.dialect.Oracle10gDialect;

	
public class Oracle10gDialectExtended extends Oracle10gDialect {

	 public Oracle10gDialectExtended() {
		 super();
		 registerColumnType(Types.DOUBLE, "float");
	 }
	 
	 
}
