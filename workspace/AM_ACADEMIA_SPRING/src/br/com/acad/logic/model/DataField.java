package br.com.acad.logic.model;

public class DataField
{
    private String label;
    private String value;
    private FieldType fieldType;
    private FormFieldType formFieldType;
    private String mask;

    private boolean required;
    private int maxValue;
    private int minValue;

    public DataField(String label, String value, FieldType fieldType)
    {
        super();
        this.label = label;
        this.value = value;
        this.fieldType = fieldType;
    }

    public DataField(String value, FieldType fieldType)
    {
        super();
        this.value = value;
        this.fieldType = fieldType;
    }

    public DataField(String label, String value, FieldType fieldType, FormFieldType formFieldType, String mask, boolean required,
            int maxValue, int minValue)
    {
        super();
        this.label = label;
        this.value = value;
        this.fieldType = fieldType;
        this.formFieldType = formFieldType;
        this.mask = mask;
        this.required = required;
        this.maxValue = maxValue;
        this.minValue = minValue;
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

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public FormFieldType getFormFieldType()
    {
        return formFieldType;
    }

    public void setFormFieldType(FormFieldType formFieldType)
    {
        this.formFieldType = formFieldType;
    }

}
