package br.com.acad.teste;

import br.com.acad.logic.Filterlogic;
import br.com.acad.logic.model.DataFilter;
import br.com.acad.logic.model.FilterOperator;
import br.com.acad.model.pessoa.Aluno;
import br.com.acad.model.pessoa.Pessoa;

public class teste
{

    public static void main(String[] args)
    {

        DataFilter[] filterValues = Filterlogic.getFilterValues(Aluno.class, Pessoa.class);
        for (DataFilter dataFilter : filterValues)
        {
            System.out.println(dataFilter.getLabel());
            System.out.println(dataFilter.getMappedName());
            for (FilterOperator opr : dataFilter.getPossibleOperators())
            {
                System.out.println(opr.getLabel());
            }
        }

    }

}
