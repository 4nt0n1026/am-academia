package br.com.acad.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Show {
	
	String label();
	String mappedName() default "";
	//FieldType Type() default FieldType.TEXT; 
	
	boolean search() default true;
	boolean order() default false;
	boolean table() default true;
	boolean insert() default true;
	boolean edit() default true;
	boolean detail() default true;
	
	
	
}
