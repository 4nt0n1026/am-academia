package br.com.acad.logic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.convert.DateTimeConverter;

import org.primefaces.component.inputmask.InputMask;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;

import br.com.acad.annotation.Show;
import br.com.acad.logic.model.DataField;
import br.com.acad.logic.model.FieldType;

public class FormLogic
{

    /**
     * Pega os valores mapeados para o form de inclusao ou edicao dos atributos classes marcadas com a annotation Show
     * 
     * @param clazzs
     * @return
     */
    public static DataField[] getFormValues(String beanName, Class<?>... clazzs)
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

                    if (showAnnotation != null && showAnnotation.form())
                    {
                        if ((showAnnotation.Type() == FieldType.IMAGE && showAnnotation.pathName() != null && showAnnotation.pathName()
                                .length() > 0)
                                || (showAnnotation.Type() == FieldType.SMALL_IMAGE && showAnnotation.pathName() != null && showAnnotation
                                        .pathName().length() > 0))
                        {

                            tempValues.add(new DataField(showAnnotation.label(), "#{" + beanName + ".entity." + showAnnotation.pathName()
                                    + "}", showAnnotation.Type(), showAnnotation.formFieldType(), showAnnotation.inputMask(),
                                    showAnnotation.required(), showAnnotation.maxLenght(), showAnnotation.minLenght(), showAnnotation
                                            .linkMap()));

                        }
                        else if (showAnnotation.mappedName() != null && showAnnotation.mappedName().length() > 0)
                        {
                            if (showAnnotation.Type() == FieldType.DATE)
                            {
                                tempValues.add(new DataField(showAnnotation.label(), "#{" + beanName + ".entity." + field.getName()
                                        + ".time}", showAnnotation.Type(), showAnnotation.formFieldType(), showAnnotation.inputMask(),
                                        showAnnotation.required(), showAnnotation.maxLenght(), showAnnotation.minLenght(), showAnnotation
                                                .linkMap()));
                            }
                            else
                            {
                                tempValues.add(new DataField(showAnnotation.label(), "#{" + beanName + ".entity."
                                        + showAnnotation.mappedName() + "}", showAnnotation.Type(), showAnnotation.formFieldType(),
                                        showAnnotation.inputMask(), showAnnotation.required(), showAnnotation.maxLenght(), showAnnotation
                                                .minLenght(), showAnnotation.linkMap()));
                            }
                        }
                        else
                        {
                            if (showAnnotation.Type() == FieldType.DATE)
                            {
                                tempValues.add(new DataField(showAnnotation.label(), "#{" + beanName + ".entity." + field.getName()
                                        + ".time}", showAnnotation.Type(), showAnnotation.formFieldType(), showAnnotation.inputMask(),
                                        showAnnotation.required(), showAnnotation.maxLenght(), showAnnotation.minLenght(), showAnnotation
                                                .linkMap()));
                            }
                            else
                            {
                                tempValues.add(new DataField(showAnnotation.label(), "#{" + beanName + ".entity." + field.getName() + "}",
                                        showAnnotation.Type(), showAnnotation.formFieldType(), showAnnotation.inputMask(), showAnnotation
                                                .required(), showAnnotation.maxLenght(), showAnnotation.minLenght(), showAnnotation
                                                .linkMap()));
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
     * Preapra o form a ser criado
     * 
     * @param panel
     * @param labelName
     * @param inputValue
     */
    public static void prepareFormField(HtmlForm panel, DataField inputValue)
    {
        // Label
        HtmlOutputLabel label = new HtmlOutputLabel();
        label.setFor("id" + inputValue.getLabel());
        label.setValueExpression("value", JsfLogic.createValueExpression(inputValue.getLabel(), String.class));
        panel.getChildren().add(label);

        // Value
        switch (inputValue.getFieldType())
        {
            case TEXT:
                if (inputValue.getMask() != null && inputValue.getMask().length() > 0)
                {
                    InputMask inputMask = new InputMask();
                    inputMask.setValueExpression("value", JsfLogic.createValueExpression(inputValue.getValue(), String.class));
                    inputMask.setId("id" + inputValue.getLabel());
                    inputMask.setMask(inputValue.getMask());
                    panel.getChildren().add(inputMask);
                }
                else
                {
                    InputText inputText = new InputText();
                    inputText.setValueExpression("value", JsfLogic.createValueExpression("#{diasTreinoCatBean.entity.nome}", String.class));
                    // inputText.setRequired(inputValue.isRequired());
                    inputText.setId("id" + inputValue.getLabel());
                    panel.getChildren().add(inputText);
                }
                break;

            case LARGE_TEXT:
                InputTextarea inputTextArea = new InputTextarea();
                inputTextArea.setValueExpression("value", JsfLogic.createValueExpression(inputValue.getValue(), String.class));
                inputTextArea.setRequired(inputValue.isRequired());
                inputTextArea.setId("id" + inputValue.getLabel());
                panel.getChildren().add(inputTextArea);
                break;

            case BOOLEAN:
                SelectOneMenu selectOneMenu = new SelectOneMenu();
                selectOneMenu.setValueExpression("value", JsfLogic.createValueExpression(inputValue.getValue(), String.class));
                selectOneMenu.setId("id" + inputValue.getLabel());
                panel.getChildren().add(selectOneMenu);
                break;

            case DATE:
                InputMask inputDateMask = new InputMask();
                inputDateMask.setValueExpression("value", JsfLogic.createValueExpression(inputValue.getValue(), String.class));
                inputDateMask.setId("id" + inputValue.getLabel());
                inputDateMask.setMask(inputValue.getMask());
                // Converter
                DateTimeConverter dtConverter = new DateTimeConverter();
                dtConverter.setPattern("dd/MM/yy");
                inputDateMask.setConverter(dtConverter);
                panel.getChildren().add(inputDateMask);
                break;

            default:
                InputText inputDefault = new InputText();
                inputDefault.setValueExpression("value", JsfLogic.createValueExpression(inputValue.getValue(), String.class));
                inputDefault.setId("id" + inputValue.getLabel());
                panel.getChildren().add(inputDefault);
                break;

        }
    }

}
