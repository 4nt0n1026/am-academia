package br.com.acad.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import br.com.acad.logic.model.FieldType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Show
{

    String label();

    String mappedName() default "";

    String pathName() default "";

    String inputMask() default "";

    FieldType Type() default FieldType.TEXT;

    int maxLenght() default 0;

    int minLenght() default 0;

    boolean search() default true;

    boolean order() default false;

    boolean table() default true;

    boolean insert() default true;

    boolean edit() default true;

    boolean detail() default true;

}
