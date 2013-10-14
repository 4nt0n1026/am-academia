package br.com.acad.logic.model;

public enum FilterOperator
{
    LIKE("Contem"), EQUAL("Igual á"), GREATER("Maior á"), GREATER_OR_EQUAL("Maior igual á"), LESS("Menor á"), LESS_OR_EQUAL("Menor igual á"), NULL(
            "Vazio"), NOT_NULL("Não vazio"), BETWEEN("Entre");

    private String label;

    private FilterOperator(String label)
    {
        this.label = label;
    }

    public String getLabel()
    {
        return this.label;
    }
}
