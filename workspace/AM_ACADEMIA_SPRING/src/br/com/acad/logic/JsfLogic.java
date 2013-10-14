package br.com.acad.logic;

import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

public class JsfLogic
{
    /**
     * Cria uma ValueExpression para a criacao da tabela
     * 
     * @param valueExpression
     * @param valueType
     * @return
     */
    public static ValueExpression createValueExpression(String valueExpression, Class<?> valueType)
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return facesContext.getApplication().getExpressionFactory()
                .createValueExpression(facesContext.getELContext(), valueExpression, valueType);
    }

    /**
     * Cria uma MthodExpression para a criacao da tabela
     * 
     * @param valueExpression
     * @param valueType
     * @return
     */
    public static MethodExpression createMethodExpression(String methodExpression, Class<?> valueType, Class<?>[] valueTypeArray)
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return facesContext.getApplication().getExpressionFactory()
                .createMethodExpression(facesContext.getELContext(), methodExpression, valueType, valueTypeArray);
    }
}
