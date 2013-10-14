package br.com.acad.logic.model;

public class FilterOperatorsLists
{
    public static FilterOperator[] boolOperators = { FilterOperator.EQUAL };
    public static FilterOperator[] textOperators = { FilterOperator.EQUAL, FilterOperator.LIKE, FilterOperator.NOT_NULL,
            FilterOperator.NULL };
    public static FilterOperator[] dateOperators = { FilterOperator.EQUAL, FilterOperator.GREATER, FilterOperator.GREATER_OR_EQUAL,
            FilterOperator.LESS_OR_EQUAL, FilterOperator.LESS, FilterOperator.NOT_NULL, FilterOperator.NULL, FilterOperator.BETWEEN };
    public static FilterOperator[] numberOperators = { FilterOperator.EQUAL, FilterOperator.GREATER, FilterOperator.GREATER_OR_EQUAL,
            FilterOperator.LESS_OR_EQUAL, FilterOperator.LESS, FilterOperator.NOT_NULL, FilterOperator.NULL, FilterOperator.BETWEEN };

    public static FilterOperator[] getOperators(FieldType type)
    {
        switch (type)
        {
            case BOOLEAN:
                return boolOperators;

            case TEXT:
                return textOperators;

            case DOUBLE:
                return numberOperators;

            case INTEGER:
                return numberOperators;

            case DATE:
                return dateOperators;

            default:
                return textOperators;
        }
    }
}
