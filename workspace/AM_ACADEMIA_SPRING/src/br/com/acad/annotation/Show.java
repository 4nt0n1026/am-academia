package br.com.acad.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.acad.logic.model.FieldType;
import br.com.acad.logic.model.FormFieldType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Show
{

    String label();

    String mappedName() default "";

    String pathName() default "";

    String inputMask() default "";

    String linkMap() default "";

    FieldType Type() default FieldType.TEXT;

    boolean required() default false;

    int maxLenght() default 0;

    int minLenght() default 0;

    boolean search() default true;

    boolean order() default false;

    boolean table() default true;

    boolean form() default true;

    boolean filter() default false;

    FormFieldType formFieldType() default FormFieldType.INSERT_EDIT;

    boolean detail() default true;

}
