package br.com.acad.teste;

import java.lang.reflect.ParameterizedType;

public class GenericTeste<T> {

	protected Class<T> entityClass;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericTeste(){
		this.entityClass = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void imprime(){
		System.out.println(entityClass.getName());
	}
	
}
