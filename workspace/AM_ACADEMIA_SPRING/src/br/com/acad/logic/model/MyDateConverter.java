package br.com.acad.logic.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class MyDateConverter implements Converter
{

    public Object getAsObject(FacesContext arg0, UIComponent arg1, String dateStr)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Date result = null;
        try
        {
            result = sdf.parse(dateStr);
        }
        catch (java.text.ParseException e)
        {
            e.printStackTrace();
            FacesMessage message = new FacesMessage();
            message.setDetail("Date not valid: format 'yyyyMMdd' expected");
            message.setSummary("Date not valid: format 'yyyyMMdd' expected");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(message);
        }
        return result;
    }

    public String getAsString(FacesContext arg0, UIComponent arg1, Object value)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date date = (Date) value;
        String result = null;

        result = sdf.format(date);

        return result;
    }

}