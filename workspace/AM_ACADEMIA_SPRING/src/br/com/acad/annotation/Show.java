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
	
	boolean search() default true;
	boolean order() default false;
}
