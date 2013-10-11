package br.com.acad.logic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.el.ValueExpression;
import javax.faces.component.html.HtmlColumn;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.convert.DateTimeConverter;

import org.primefaces.component.graphicimage.GraphicImage;
import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;

import br.com.acad.annotation.Show;
import br.com.acad.logic.model.DataField;
import br.com.acad.logic.model.FieldType;

public class TableLogic
{

    /**
     * Pega os valores mapeados para tabela marcados com a annotation Show
     * 
     * @param clazzs
     * @return
     */
    public static DataField[] getTableValues(Class<?>... clazzs)
    {
        List<DataField> tempValues = new ArrayList<DataField>();

        try
        {
            for (Class<?> clazz : clazzs)
            {

                Field[] fields = clazz.getDeclaredFields();

                // percorre filds da classe
                for (Field field : fields)
                {
                    Show showAnnotation = field.getAnnotation(Show.class);

                    if (showAnnotation != null && showAnnotation.table())
                    {
                        if ((showAnnotation.Type() == FieldType.IMAGE && showAnnotation.pathName() != null && showAnnotation.pathName()
                                .length() > 0)
                                || (showAnnotation.Type() == FieldType.SMALL_IMAGE && showAnnotation.pathName() != null && showAnnotation
                                        .pathName().length() > 0))
                        {

                            tempValues.add(new DataField(showAnnotation.label(), "#{entity." + showAnnotation.pathName() + "}",
                                    showAnnotation.Type()));

                        }
                        else if (showAnnotation.mappedName() != null && showAnnotation.mappedName().length() > 0)
                        {
                            if (showAnnotation.Type() == FieldType.DATE)
                            {
                                tempValues.add(new DataField(showAnnotation.label(), "#{entity." + showAnnotation.mappedName() + ".time}",
                                        showAnnotation.Type()));
                            }
                            else
                            {
                                tempValues.add(new DataField(showAnnotation.label(), "#{entity." + showAnnotation.mappedName() + "}",
                                        showAnnotation.Type()));
                            }
                        }
                        else
                        {
                            if (showAnnotation.Type() == FieldType.DATE)
                            {
                                tempValues.add(new DataField(showAnnotation.label(), "#{entity." + field.getName() + ".time}",
                                        showAnnotation.Type()));
                            }
                            else
                            {
                                tempValues.add(new DataField(showAnnotation.label(), "#{entity." + field.getName() + "}", showAnnotation
                                        .Type()));
                            }
                        }
                    }
                }
            }

            if (tempValues.size() == 0)
            {
                return null;
            }

            return tempValues.toArray(new DataField[tempValues.size()]);

        }
        catch (Exception e)
        {
            MessagesLogic.addErrorMessage("Erro", "Ocorreu um erro! Contate o Administrador. COD:Annotation098");
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Prepara a coluna com seu determinado tipo, String de header e valor
     * 
     * @param column
     * @param header
     * @param field
     */
    public static void prepareColumn(HtmlColumn column, DataField field)
    {
        // Create <h:outputText value="dynamicHeaders[i]"> for <f:facet name="header"> of column.
        HtmlOutputText header = new HtmlOutputText();
        header.setValue(field.getLabel());
        column.setHeader(header);

        // Create the body of column for the specific type.
        switch (field.getFieldType())
        {
            case TEXT:
                HtmlOutputText outputText = new HtmlOutputText();
                outputText.setValueExpression("value", TableLogic.createValueExpression(field.getValue(), String.class));
                column.getChildren().add(outputText);
                break;

            case BOOLEAN:
                SelectBooleanCheckbox checkbox = new SelectBooleanCheckbox();
                checkbox.setValueExpression("value", TableLogic.createValueExpression(field.getValue(), String.class));
                checkbox.setValueExpression("disabled", TableLogic.createValueExpression("true", Boolean.class));
                column.getChildren().add(checkbox);
                break;

            case SMALL_IMAGE:
                GraphicImage smallImage = new GraphicImage();
                smallImage.setValueExpression("value", TableLogic.createValueExpression(field.getValue(), String.class));
                smallImage.setValueExpression("styleClass", TableLogic.createValueExpression("img-circle", String.class));
                smallImage.setWidth("30");
                column.getChildren().add(smallImage);
                break;

            case IMAGE:
                GraphicImage image = new GraphicImage();
                image.setValueExpression("value", TableLogic.createValueExpression(field.getValue(), String.class));
                image.setWidth("50");
                column.getChildren().add(image);
                break;

            case DATE:
                HtmlOutputText outputDate = new HtmlOutputText();
                outputDate.setValueExpression("value", TableLogic.createValueExpression(field.getValue(), String.class));
                // Converter
                DateTimeConverter dtConverter = new DateTimeConverter();
                dtConverter.setPattern("dd/MM/yy");
                outputDate.setConverter(dtConverter);

                column.getChildren().add(outputDate);
                break;

            default:
                HtmlOutputText output = new HtmlOutputText();
                output.setValueExpression("value", TableLogic.createValueExpression(field.getValue(), String.class));
                column.getChildren().add(output);
                break;
        }
    }

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

}
