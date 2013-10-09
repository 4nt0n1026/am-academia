package br.com.acad.logic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.com.acad.annotation.Show;
import br.com.acad.annotation.View;

public class AnnotationsLogic
{

    /**
     * Gera array de valores de mapeamento de campos de busca para pagina, passando por parametro o(s) tipo(s) da(a)
     * classe(s) referente(s). É ultizado varias classes para caso de herança. Utiliza Annotation @Search para
     * indentificar os valores.
     * 
     * @param clazz
     * @return
     */
    public static String[] getSearchValueFields(Class<?>... clazzs)
    {
        List<String> tempValues = new ArrayList<String>();

        try
        {
            for (Class<?> clazz : clazzs)
            {

                Field[] fields = clazz.getDeclaredFields();

                // percorre filds da classe
                for (Field field : fields)
                {
                    Show showAnnotation = field.getAnnotation(Show.class);

                    if (showAnnotation != null)
                    {
                        if (showAnnotation.search())
                        {
                            if (showAnnotation.mappedName() != null && showAnnotation.mappedName().length() > 0)
                            {
                                tempValues.add(showAnnotation.mappedName());
                            }
                            else
                            {
                                tempValues.add(field.getName());
                            }
                        }
                    }
                }
            }

            if (tempValues.size() == 0)
            {
                return null;
            }

            return tempValues.toArray(new String[tempValues.size()]);

        }
        catch (Exception e)
        {
            MessagesLogic.addErrorMessage("Erro", "Ocorreu um erro! Contate o Administrador. COD:Annotation098");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gera array de valores de mapeamento de campos de ordenacao da pagina, passando por parametro o(s) tipo(s) da(a)
     * classe(s) referente(s). É ultizado varias classes para caso de herança. Utiliza Annotation @Search para
     * indentificar os valores nas classes models.
     * 
     * @param clazz
     * @return
     */
    public static String[] getOrderValueFields(Class<?>... clazzs)
    {
        List<String> tempValues = new ArrayList<String>();

        try
        {
            for (Class<?> clazz : clazzs)
            {

                Field[] fields = clazz.getDeclaredFields();

                // percorre filds da classe
                for (Field field : fields)
                {
                    Show showAnnotation = field.getAnnotation(Show.class);

                    if (showAnnotation != null)
                    {
                        if (showAnnotation.order())
                        {
                            if (showAnnotation.mappedName() != null && showAnnotation.mappedName().length() > 0)
                            {
                                tempValues.add(showAnnotation.mappedName());
                            }
                            else
                            {
                                tempValues.add(field.getName());
                            }
                        }
                    }
                }
            }

            if (tempValues.size() == 0)
            {
                return null;
            }

            return tempValues.toArray(new String[tempValues.size()]);

        }
        catch (Exception e)
        {
            MessagesLogic.addErrorMessage("Erro", "Ocorreu um erro! Contate o Administrador. COD:Annotation098");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gera array de label de campos de ordenacao da pagina, passando por parametro o(s) tipo(s) da(s) classe(s)
     * referente(s). É ultizado varias classes para caso de herança. Utiliza Annotation @Search para indentificar os
     * valores.
     * 
     * @param clazz
     * @return
     */
    public static String[] getOrderLabelFields(Class<?>... clazzs)
    {
        List<String> tempLabels = new ArrayList<String>();

        try
        {
            for (Class<?> clazz : clazzs)
            {

                Field[] fields = clazz.getDeclaredFields();

                // percorre filds da classe
                for (Field field : fields)
                {
                    Show showAnnotation = field.getAnnotation(Show.class);

                    if (showAnnotation != null)
                    {
                        if (showAnnotation.order())
                        {
                            tempLabels.add(showAnnotation.label());
                        }
                    }
                }
            }
            if (tempLabels.size() == 0)
            {
                return null;
            }

            return tempLabels.toArray(new String[tempLabels.size()]);

        }
        catch (Exception e)
        {
            MessagesLogic.addErrorMessage("Erro", "Ocorreu um erro! Contate o Administrador. COD:Annotation098");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gera array de valores de mapeamento de campos de view da pagina, passando por parametro o(s) tipo(s) da(a)
     * classe(s) referente(s). É ultizado varias classes para caso de herança. Utiliza Annotation @Search para
     * indentificar os valores.
     * 
     * @param clazz
     * @return
     */
    public static String[] getViewValueFields(Class<?>... clazzs)
    {
        List<String> tempValues = new ArrayList<String>();

        try
        {
            for (Class<?> clazz : clazzs)
            {

                View viewAnnotatios = clazz.getAnnotation(View.class);

                if (viewAnnotatios != null)
                {
                    for (String label : viewAnnotatios.queries())
                    {
                        tempValues.add(label);
                    }
                }
            }

            if (tempValues.size() == 0)
            {
                return null;
            }

            return tempValues.toArray(new String[tempValues.size()]);

        }
        catch (Exception e)
        {
            MessagesLogic.addErrorMessage("Erro", "Ocorreu um erro! Contate o Administrador. COD:Annotation098");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gera array de label de campos de view da pagina, passando por parametro o(s) tipo(s) da(s) classe(s)
     * referente(s). É ultizado varias classes para caso de herança. Utiliza Annotation @Search para indentificar os
     * valores.
     * 
     * @param clazz
     * @return
     */
    public static String[] getViewLabelFields(Class<?>... clazzs)
    {
        List<String> tempLabels = new ArrayList<String>();

        try
        {
            for (Class<?> clazz : clazzs)
            {

                View viewAnnotatios = clazz.getAnnotation(View.class);

                if (viewAnnotatios != null)
                {
                    for (String label : viewAnnotatios.labels())
                    {
                        tempLabels.add(label);
                    }
                }
            }

            if (tempLabels.size() == 0)
            {
                return null;
            }
            return tempLabels.toArray(new String[tempLabels.size()]);

        }
        catch (Exception e)
        {
            MessagesLogic.addErrorMessage("Erro", "Ocorreu um erro! Contate o Administrador. COD:Annotation098");
            e.printStackTrace();
        }
        return null;
    }
}
