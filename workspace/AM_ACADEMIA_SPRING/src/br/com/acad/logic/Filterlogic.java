package br.com.acad.logic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.com.acad.annotation.Show;
import br.com.acad.logic.model.DataFilter;
import br.com.acad.logic.model.FilterOperatorsLists;

public class Filterlogic
{

    /**
     * Pega os valores mapeados para filtro marcados com a annotation Show
     * 
     * @param clazzs
     * @return
     */
    public static DataFilter[] getFilterValues(Class<?>... clazzs)
    {
        List<DataFilter> tempValues = new ArrayList<DataFilter>();

        try
        {
            for (Class<?> clazz : clazzs)
            {

                Field[] fields = clazz.getDeclaredFields();

                // percorre filds da classe
                for (Field field : fields)
                {
                    Show showAnnotation = field.getAnnotation(Show.class);

                    if (showAnnotation != null && showAnnotation.filter())
                    {
                        tempValues.add(new DataFilter(showAnnotation.label(), getMappedValue(showAnnotation, field), showAnnotation.Type(),
                                FilterOperatorsLists.getOperators(showAnnotation.Type())));
                    }
                }
            }

            if (tempValues.size() == 0)
            {
                return null;
            }

            return tempValues.toArray(new DataFilter[tempValues.size()]);

        }
        catch (Exception e)
        {
            MessagesLogic.addErrorMessage("Erro", "Ocorreu um erro! Contate o Administrador. COD:Annotation098");
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Retorna o valor da mapeação. Caso esteja especificado na annotation Show retorna o mappedName. Caso contratio
     * retorna o nome do field.
     * 
     * @param showAnnotation
     * @param field
     * @return
     */
    public static String getMappedValue(Show showAnnotation, Field field)
    {
        if (showAnnotation.mappedName() != null && showAnnotation.mappedName().length() > 0)
        {
            return showAnnotation.mappedName();
        }
        return field.getName();
    }
}
