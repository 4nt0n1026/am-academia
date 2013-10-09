package br.com.acad.logic;

import javax.el.ValueExpression;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;

import org.primefaces.component.inputmask.InputMask;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;

import br.com.acad.logic.model.DataField;

public class FormLogic
{

    public static void prepareForm(HtmlForm form, String labelName, DataField inputValue)
    {
        // Label
        HtmlOutputLabel label = new HtmlOutputLabel();
        label.setValueExpression("value", createValueExpression(labelName, String.class));
        form.getChildren().add(label);

        // Value
        switch (inputValue.getFieldType())
        {
            case TEXT:
                if (inputValue.getMask() != null)
                {
                    InputMask inputMask = new InputMask();
                    inputMask.setValueExpression("value", createValueExpression(inputValue.getValue(), String.class));
                    form.getChildren().add(inputMask);
                }
                else
                {
                    InputText inputText = new InputText();
                    inputText.setValueExpression("value", createValueExpression(inputValue.getValue(), String.class));
                    inputText.setRequired(inputValue.isRequired());
                    form.getChildren().add(inputText);
                }
                break;

            case LARGE_TEXT:
                InputTextarea inputTextArea = new InputTextarea();
                inputTextArea.setValueExpression("value", createValueExpression(inputValue.getValue(), String.class));
                inputTextArea.setRequired(inputValue.isRequired());
                break;

            default:
                InputText inputDefault = new InputText();
                inputDefault.setValueExpression("value", createValueExpression(inputValue.getValue(), String.class));
                form.getChildren().add(inputDefault);
                break;

        }
    }

    /**
     * Cria uma ValueExpression para a criacao do form
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
