package br.com.acad.logic.model;

import java.sql.Date;

public class DataFilter
{
    private boolean disable = true;
    private String label;
    private FieldType type;
    private String mappedName;
    private String value;
    private boolean boolValue;
    private FilterOperator operator;
    private Date dateValue;
    private FilterOperator[] possibleOperators;

    public DataFilter(String label, String mappedName, FieldType type, FilterOperator[] possibleOperators)
    {
        this.label = label;
        this.mappedName = mappedName;
        this.type = type;
        this.possibleOperators = possibleOperators;
    }

    public DataFilter(String label, FilterOperator[] possibleOperators)
    {
        this.label = label;
        this.possibleOperators = possibleOperators;
    }

    public DataFilter(String label, boolean boolValue)
    {
        this.label = label;
        this.boolValue = boolValue;
    }

    public DataFilter(String label, String value)
    {
        this.label = label;
        this.value = value;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public boolean getBoolValue()
    {
        return boolValue;
    }

    public void setBoolValue(boolean boolValue)
    {
        this.boolValue = boolValue;
    }

    public FilterOperator getOperator()
    {
        return operator;
    }

    public void setOperator(FilterOperator operator)
    {
        this.operator = operator;
    }

    public FilterOperator[] getPossibleOperators()
    {
        return possibleOperators;
    }

    public void setPossibleOperators(FilterOperator[] possibleOperators)
    {
        this.possibleOperators = possibleOperators;
    }

    public boolean getDisable()
    {
        return disable;
    }

    public void setDisable(boolean disable)
    {
        this.disable = disable;
    }

    public Date getDateValue()
    {
        return dateValue;
    }

    public void setDateValue(Date dateValue)
    {
        this.dateValue = dateValue;
    }

    public String getMappedName()
    {
        return mappedName;
    }

    public void setMappedName(String mappedName)
    {
        this.mappedName = mappedName;
    }

    public FieldType getType()
    {
        return type;
    }

    public void setType(FieldType type)
    {
        this.type = type;
    }

}
