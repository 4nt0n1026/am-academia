package br.com.acad.logic.model;

public class DataField
{

    private String value;
    private FieldType fieldType;
    private String mask;
    private boolean required;

    private int maxValue;
    private int minValue;

    public DataField(String value, FieldType fieldType)
    {
        super();
        this.value = value;
        this.fieldType = fieldType;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public FieldType getFieldType()
    {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType)
    {
        this.fieldType = fieldType;
    }

    public String getMask()
    {
        return mask;
    }

    public void setMask(String mask)
    {
        this.mask = mask;
    }

    public boolean isRequired()
    {
        return required;
    }

    public void setRequired(boolean required)
    {
        this.required = required;
    }

    public int getMaxValue()
    {
        return maxValue;
    }

    public void setMaxValue(int maxValue)
    {
        this.maxValue = maxValue;
    }

    public int getMinValue()
    {
        return minValue;
    }

    public void setMinValue(int minValue)
    {
        this.minValue = minValue;
    }

}
