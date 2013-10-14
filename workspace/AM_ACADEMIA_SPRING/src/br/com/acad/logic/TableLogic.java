package br.com.acad.logic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIParameter;
import javax.faces.component.html.HtmlColumn;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlOutputText;

import org.primefaces.component.graphicimage.GraphicImage;
import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;

import br.com.acad.annotation.Show;
import br.com.acad.bean.NavigationBean;
import br.com.acad.logic.model.DataField;
import br.com.acad.logic.model.FieldType;
import br.com.acad.logic.model.MyDateTimeConverter;

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
                        tempValues.add(new DataField(showAnnotation.label(), "#{entity."
                                + getMappedValue(showAnnotation, field, showAnnotation.Type()) + "}", showAnnotation.Type(), showAnnotation
                                .inputMask(), showAnnotation.linkMap()));
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
    public static void prepareColumnValue(HtmlColumn column, DataField field)
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
                outputText.setValueExpression("value", JsfLogic.createValueExpression(field.getValue(), String.class));
                column.getChildren().add(outputText);
                break;

            case BOOLEAN:
                SelectBooleanCheckbox checkbox = new SelectBooleanCheckbox();
                checkbox.setValueExpression("value", JsfLogic.createValueExpression(field.getValue(), String.class));
                checkbox.setValueExpression("disabled", JsfLogic.createValueExpression("true", Boolean.class));
                column.getChildren().add(checkbox);
                break;

            case SMALL_IMAGE:
                GraphicImage smallImage = new GraphicImage();
                smallImage.setValueExpression("value", JsfLogic.createValueExpression(field.getValue(), String.class));
                smallImage.setValueExpression("styleClass", JsfLogic.createValueExpression("img-circle", String.class));
                smallImage.setWidth("30");
                column.getChildren().add(smallImage);
                break;

            case IMAGE:
                GraphicImage image = new GraphicImage();
                image.setValueExpression("value", JsfLogic.createValueExpression(field.getValue(), String.class));
                image.setWidth("50");
                column.getChildren().add(image);
                break;

            case DATE:
                HtmlOutputText outputDate = new HtmlOutputText();
                outputDate.setValueExpression("value", JsfLogic.createValueExpression(field.getValue(), Date.class));
                // Converter
                MyDateTimeConverter dtConverter = new MyDateTimeConverter();
                // dtConverter.setPattern("dd/MM/yy");
                outputDate.setConverter(dtConverter);
                // outputDate.getFacets().put("dateTimeConverter", dtConverter);

                column.getChildren().add(outputDate);
                break;

            default:
                HtmlOutputText output = new HtmlOutputText();
                output.setValueExpression("value", JsfLogic.createValueExpression(field.getValue(), String.class));
                column.getChildren().add(output);
                break;
        }
    }

    /**
     * Prepara a coluna com o link de navegacao caso tenha
     * 
     * @param column
     */
    public static void prepareColumnLink(HtmlColumn column, DataField field, NavigationBean navigationBean)
    {
        if (field.getLinkMap() != null && field.getLinkMap().length() > 0)
        {

            HtmlCommandLink navigationButton = new HtmlCommandLink();
            navigationButton.setActionExpression(JsfLogic.createMethodExpression("#{navigationBean.redirect('" + field.getLinkMap()
                    + "?faces-redirect=true' " + ")}", String.class, new Class[] {}));

            UIParameter param = new UIParameter();
            param.setName("id");
            param.setValue(JsfLogic.createValueExpression(prepareValueIdForLink(field.getValue()), String.class));
            navigationButton.getChildren().add(param);

            GraphicImage goIcon = new GraphicImage();
            goIcon.setHeight("20");
            goIcon.setValue("/resources/images/icons/go.png");

            navigationButton.getChildren().add(goIcon);
            column.getChildren().add(navigationButton);
        }
    }

    /**
     * prepara a EL para buscar o id do link escolhido
     */
    public static String prepareValueIdForLink(String mappingValue)
    {
        int index = mappingValue.lastIndexOf(".");
        String substring = mappingValue.substring(0, index + 1);
        String finalStr = substring + "id}";
        return finalStr;
    }

    /**
     * Retorna o valor da mapeação. Caso esteja especificado na annotation Show retorna o mappedName. Caso contrario
     * retorna o nome do field.
     * 
     * @param showAnnotation
     * @param field
     * @return
     */
    public static String getMappedValue(Show showAnnotation, Field field, FieldType type)
    {
        StringBuilder retorno = new StringBuilder();
        if ((showAnnotation.Type() == FieldType.IMAGE && showAnnotation.pathName() != null && showAnnotation.pathName().length() > 0)
                || (showAnnotation.Type() == FieldType.SMALL_IMAGE && showAnnotation.pathName() != null && showAnnotation.pathName()
                        .length() > 0))
        {
            return showAnnotation.pathName();
        }
        if (showAnnotation.mappedName() != null && showAnnotation.mappedName().length() > 0)
        {
            retorno.append(showAnnotation.mappedName());
        }
        else
        {
            retorno.append(field.getName());
        }

        if (type == FieldType.DATE)
        {
            retorno.append(".time");
        }
        return retorno.toString();

    }

}
